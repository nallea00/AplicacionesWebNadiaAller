package es.unileon.ulebank.domain;

import javax.persistence.Column;import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.Handler;

@Entity
@Table(name="employee")
public class Employee {

	@Id
    @Column(name = "idEmployee")
	private String id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "address")
	private String address;

	@Column(name = "salary")
	private float salary;

	@ManyToOne
	@JoinColumn(name = "idOffice", insertable = false, updatable = false)
	private Office office;

	public Employee() {
		
	}
	
	public Employee(String name, String surname, String address, float salary,
			Office office, String id) {
		Handler idHandler = new DNIHandler(id);
		this.id = idHandler.toString();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.salary = salary;
		this.office = office;
	}
	
	public Employee(String name, String surname, String address, float salary,
			String id) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.salary = salary;
		Handler idHandler = new DNIHandler(id);
		this.id = idHandler.toString();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		if (id != null) {
			if (id.length() > 0) {
				Handler idHandler = new DNIHandler(id);
				this.id = idHandler.toString();
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			if (name.length() > 0) {
				this.name = name;
			}
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname != null) {
			if (surname.length() > 0) {
				this.surname = surname;
			}
		}
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		if (salary > 0) {
			this.salary = salary;
		}
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

}
