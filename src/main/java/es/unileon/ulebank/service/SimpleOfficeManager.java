package es.unileon.ulebank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.repository.EmployeeDao;
import es.unileon.ulebank.repository.OfficeDao;

@Component
public class SimpleOfficeManager implements OfficeManager {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private OfficeDao officeDao;
    
    @Autowired
    private EmployeeDao employeeDao;
    
    public void setOfficeDao(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

	public List<Office> getOffices() {
		return officeDao.getOfficeList();
	}
	
	 public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

	public List<Employee> getEmployees() {
		return officeDao.getEmployeeList();
	}    
	
	public void addEmployee(Employee employee, Office office) {
		
		employee.setOffice(office);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(employee);
		
		office.setEmployees(employees);
		
		officeDao.saveOffice(office);
		
	}

}