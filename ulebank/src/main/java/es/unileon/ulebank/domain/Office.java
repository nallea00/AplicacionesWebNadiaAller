/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.domain;

import java.util.ArrayList;
import java.util.List;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.OfficeHandler;

public class Office {

	private String name;
	private String street;
	private int zip;
	private int phone;
    private Handler id;
    private List<Employee> employeeList;

    public Office(String name, String street, int zip, int phone, ArrayList<Employee> employeeList, Handler id) {
    	this.name = name;
    	this.street = street;
    	this.zip = zip;
    	this.phone = phone;
        this.employeeList = employeeList;
    	this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Handler getId() {
		return id;
	}

	public void setId(Handler id) {
		this.id = id;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
    
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Name: " + name + ";");
		buffer.append("Street: " + name + ";");
		buffer.append("Zip: " + name + ";");
		buffer.append("Phone: " + name + ";");
		return buffer.toString();
	}

	public void addEmployee(Employee employee) {
		if(!seekEmployee(employee.getIdEmployee())) {
			this.employeeList.add(employee);
		}
	}
	
	public boolean seekEmployee(Handler idEmployee) {
		int count = 0;
		boolean found = false;
		while(count < this.employeeList.size() && !this.employeeList.isEmpty() && !found) {
			if(this.employeeList.get(count).getIdEmployee().compareTo(idEmployee) == 0) {
				found = true;
			}
			count++;
		}
		return found;
	}
	
}
