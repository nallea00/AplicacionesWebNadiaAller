package es.unileon.ulebank.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.OfficeHandler;

@Entity
@Table(name="office")
public class Office {

	@Id
    @Column(name = "idOffice")
    private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "zip")
	private int zip;
	
	@Column(name = "phone")
	private int phone;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idOffice", nullable = false)
	List<Employee> employees;
	
	public Office() {
		
	}

    public Office(String name, String street, int zip, int phone, String id) {
    	this.name = name;
    	this.street = street;
    	this.zip = zip;
    	this.phone = phone;
    	Handler idHandler = new OfficeHandler(id);
    	this.id = idHandler.toString();
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
    
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Id: " + id + ";");
		buffer.append("Name: " + name + ";");
		buffer.append("Street: " + name + ";");
		buffer.append("Zip: " + name + ";");
		buffer.append("Phone: " + name + ";");
		return buffer.toString();
	}
	
}
