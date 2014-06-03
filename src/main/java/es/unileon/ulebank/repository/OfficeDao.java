package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;

public interface OfficeDao {

    public List<Office> getOfficeList();

    public List<Employee> getEmployeeList();

    public void saveOffice(Office office);

}