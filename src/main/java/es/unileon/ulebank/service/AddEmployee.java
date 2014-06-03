package es.unileon.ulebank.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AddEmployee {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private String name;
    private String surname;
    private String address;
    private float salary;
    private String idenOffice;
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float f) {
		this.salary = f;
		logger.info("Salary set to " + f);
	}
	
	public String getIdenOffice() {
		return idenOffice;
	}

	public void setIdenOffice(String idenOffice) {
		this.idenOffice = idenOffice;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}