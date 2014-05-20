package es.unileon.ulebank.service;

import java.util.List;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;

public class SimpleOfficeManager implements OfficeManager {

    private static final long serialVersionUID = 1L;
    
    private Office office;
    
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

    public List<Employee> getEmployees() {
       return office.getEmployeeList();
    }
    
    public void setEmployees(List<Employee> employees) {
    	office.setEmployeeList(employees);
    }
    
    public void addEmployee(Employee employee) {
    	office.addEmployee(employee);
    }

}