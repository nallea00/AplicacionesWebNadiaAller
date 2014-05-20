package es.unileon.ulebank.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.domain.Employee;

public interface OfficeManager extends Serializable {

    public void addEmployee(Employee employee);
    
    public List<Employee> getEmployees();

}