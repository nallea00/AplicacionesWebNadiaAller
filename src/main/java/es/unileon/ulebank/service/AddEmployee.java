package es.unileon.ulebank.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.handler.Handler;

public class AddEmployee {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private String name;
    private String surname;
    private String address;
    private Office office;
    private int salary;
    private Handler idEmployee;
    private String dni;
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		logger.info("Name set to " + name);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
		logger.info("Surname set to " + name);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		logger.info("Address set to " + address);
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
		logger.info("Office set to " + office.getName());
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
		logger.info("Salary set to " + salary);
	}

	public Handler getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Handler idEmployee) {
		this.idEmployee = idEmployee;
		logger.info("idEmployee set to " + idEmployee);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}