package es.unileon.ulebank.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;

public class JPAOfficeDaoTests {

	private ApplicationContext context;
    private OfficeDao officeDao;
    private EmployeeDao employeeDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        officeDao = (OfficeDao) context.getBean("officeDao");
        employeeDao = (EmployeeDao) context.getBean("employeeDao");
    }

    @Test
    public void testGetOfficeList() {
        List<Office> offices = officeDao.getOfficeList();
        assertEquals(offices.size(), 1, 0);	   
    }

    @Test
    public void testSaveOffice() {
    	
        List<Office> offices = officeDao.getOfficeList();

        Office o = offices.get(0);
        String name = o.getName();
        o.setName("Oficina dos");
        String street = o.getStreet();
        o.setStreet("C/ Ancha, 145");
        int zip = o.getZip();
        o.setZip(24000);
        int phone = o.getPhone();
        o.setPhone(111222333);
        
        officeDao.saveOffice(o);

        List<Office> updatedOffices = officeDao.getOfficeList();
        Office e2 = updatedOffices.get(0);
        assertEquals(e2.getName(),"Oficina dos");
        assertEquals(e2.getStreet(),"C/ Ancha, 145");
        assertEquals(e2.getZip(),24000);
        assertEquals(e2.getPhone(), 111222333);

        e2.setName(name);
        e2.setStreet(street);
        e2.setZip(zip);
        e2.setPhone(phone);
        officeDao.saveOffice(e2);
        
    }
    
    @Test
    public void testSaveEmployee() {
    	
    	Office o = new Office();
    	o.setId("0001");
        o.setName("nameOffice");
        o.setStreet("streetOffice");
        o.setZip(24080);
        o.setPhone(987987987);
    	
    	Employee e = new Employee();
    	e.setId("71519821X");
        e.setName("nameEmployee3");
        e.setSurname("surnameEmployee3");
        e.setAddress("streetEmployee3");
        e.setSalary(3000.30f);
        e.setOffice(o);
        
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e);
        o.setEmployees(employees);
        
        officeDao.saveOffice(o);
        
        List<Employee> employeesUpdated = employeeDao.getEmployeeList();
        assertEquals(employeesUpdated.size(), 3);
        
    }
    
}

