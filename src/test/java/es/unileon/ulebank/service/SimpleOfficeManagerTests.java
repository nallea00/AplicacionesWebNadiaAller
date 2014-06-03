package es.unileon.ulebank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.repository.EmployeeDao;
import es.unileon.ulebank.repository.InMemoryEmployeeDao;
import es.unileon.ulebank.repository.InMemoryOfficeDao;
import es.unileon.ulebank.repository.OfficeDao;

public class SimpleOfficeManagerTests {

  	private SimpleOfficeManager officeManager;
    
    private List<Office> offices;
    private List<Employee> employees;
	
	private static int OFFICES_COUNT = 1;
	private static int EMPLOYEES_COUNT = 2;
     
    private static String NAME = "nameOffice1";
	private static String STREET = "streetOffice1";
	private static int ZIP = 24080;
	private static int PHONE = 987987987;
    private static String ID = "0001";

    private static String EMPLOYEE1_NAME = "nameEmployee1";
    private static String EMPLOYEE1_SURNAME = "surnameEmployee1";
    private static String EMPLOYEE1_ADDRESS = "addressEmployee1";
    private static float EMPLOYEE1_SALARY = 1000.10f;
    private static String EMPLOYEE1_OFFICE = "0001";
    private static String EMPLOYEE1_ID = "71461175Z";
    
    private static String EMPLOYEE2_NAME = "nameEmployee2";
    private static String EMPLOYEE2_SURNAME = "surnameEmployee2" ;
    private static String EMPLOYEE2_ADDRESS = "addressEmployee2";
    private static float EMPLOYEE2_SALARY = 2000.20f;
    private static String EMPLOYEE2_OFFICE = "0001";
    private static String EMPLOYEE2_ID = "70876871W";
    
    Employee EMPLOYEE3;
    
    private Office office;
    
    @Before
    public void setUp() throws Exception {
 		
        officeManager = new SimpleOfficeManager();
        offices = new ArrayList<Office>();
        employees = new ArrayList<Employee>();
    	
        office = new Office(NAME, STREET, ZIP, PHONE, ID);
        offices.add(office);
        
        Employee employee1 = new Employee("nameEmployee1","surnameEmployee1","addressEmployee1",1000.10f,office,"71461175Z");
        employees.add(employee1);
        Employee employee2 = new Employee("nameEmployee2","surnameEmployee2","addressEmployee2",2000.20f,office,"70876871W");
        employees.add(employee2);
        
        EMPLOYEE3 = new Employee("nameEmployee3","surnameEmployee3","addressEmployee3",3000.30f,office,"71463171D");
             
        OfficeDao officeDao = new InMemoryOfficeDao(offices,employees);
        EmployeeDao employeeDao = new InMemoryEmployeeDao(employees);
        officeManager.setOfficeDao(officeDao);
        officeManager.setEmployeeDao(employeeDao);
              
    }

    @Test
    public void testGetOfficesWithEmptyListOfOffices() {
    	officeManager = new SimpleOfficeManager();
    	officeManager.setOfficeDao(new InMemoryOfficeDao(new ArrayList<Office>(), null));
    	assertEquals(officeManager.getOffices().size(), 0);
    }

	@Test
    public void testGetOffices() {
		List<Office> offices = officeManager.getOffices();
        assertNotNull(offices);        
        assertEquals(OFFICES_COUNT, officeManager.getOffices().size());
    
        Office office = offices.get(0);
        assertEquals(ID, office.getId());
        assertEquals(NAME, office.getName());
        assertEquals(STREET, office.getStreet());
        assertEquals(ZIP, office.getZip(), 0);
        assertEquals(PHONE, office.getPhone(), 0);    
	}
	
	@Test
    public void testAddEmployeeWithNullListOfEmployees() {
        try {
            officeManager = new SimpleOfficeManager();
            officeManager.setOfficeDao(new InMemoryOfficeDao(null, null));
            officeManager.addEmployee(EMPLOYEE3, office);
        }
        catch(NullPointerException ex) {
            fail("Employees list is null.");
        }
    }

    @Test
    public void testGetEmployeessWithEmptyListOfEmployees() {
    	officeManager = new SimpleOfficeManager();
    	officeManager.setOfficeDao(new InMemoryOfficeDao(null, new ArrayList<Employee>()));
    	assertEquals(officeManager.getEmployees().size(), 0);
    }

	
	@Test
    public void testGetEmployees() {
		List<Employee> employees = officeManager.getEmployees();
        assertNotNull(employees);        
        assertEquals(EMPLOYEES_COUNT, officeManager.getEmployees().size());
     
        Employee employee = employees.get(0);
        assertEquals(EMPLOYEE1_NAME, employee.getName());
        assertEquals(EMPLOYEE1_SURNAME, employee.getSurname());
        assertEquals(EMPLOYEE1_ADDRESS, employee.getAddress());
        assertEquals(EMPLOYEE1_SALARY, employee.getSalary(), 0);
        assertEquals(EMPLOYEE1_OFFICE, employee.getOffice().getId());
        assertEquals(EMPLOYEE1_ID, employee.getId());
        
        employee = employees.get(1);  
        assertEquals(EMPLOYEE2_NAME, employee.getName());
        assertEquals(EMPLOYEE2_SURNAME, employee.getSurname());
        assertEquals(EMPLOYEE2_ADDRESS, employee.getAddress());
        assertEquals(EMPLOYEE2_SALARY, employee.getSalary(), 0);
        assertEquals(EMPLOYEE2_OFFICE, employee.getOffice().getId());
        assertEquals(EMPLOYEE2_ID, employee.getId());
	}

    @Test
    public void testAddEmployee() {
    	assertNotNull(officeManager.getEmployees());
    	assertEquals(officeManager.getEmployees().size(), 2);
    	
    	officeManager.addEmployee(EMPLOYEE3, office);
    	
    	List<Employee> employees = officeManager.getEmployees();
		assertEquals(employees.size(), 3);
		
		Employee employee = employees.get(0);
		Handler id = new DNIHandler("71461175Z");
		assertEquals(id.toString().compareTo(employee.getId()), 0);
		
		employee = employees.get(1);
		id = new DNIHandler("70876871W");
		assertEquals(id.toString().compareTo(employee.getId()), 0);
		
		employee = employees.get(2);
		id = new DNIHandler("71463171D");
		assertEquals(id.toString().compareTo(employee.getId()), 0);
    }
    
}
