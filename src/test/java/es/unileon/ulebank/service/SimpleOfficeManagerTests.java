package es.unileon.ulebank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.OfficeHandler;

public class SimpleOfficeManagerTests {

  	private SimpleOfficeManager officeManager;
    
    private Office office;
    
	private List<Employee> employees;
	
	private static int EMPLOYEES_COUNT = 2;
     
    private static String nameOffice;
	private static String streetOffice;
	private static int zipOffice;
	private static int phoneOffice;
    private static Handler idOffice;
    private static ArrayList<Employee> employeeListOffice;
    
    private static String JUAN_NAME;
    private static String JUAN_SURNAME;
    private static String JUAN_ADDRESS;
    private static float JUAN_SALARY;
    private static Office JUAN_OFFICE;
    private static Handler JUAN_DNI;
    
    private static String PEPE_NAME;
    private static String PEPE_SURNAME ;
    private static String PEPE_ADDRESS;
    private static float PEPE_SALARY;
    private static Office PEPE_OFFICE;
    private static Handler PEPE_DNI;
    
    private static Employee EMPLOYEE;
    private static Handler SILVIA_DNI;
    
    @Before
    public void setUp() throws Exception {
    	
    	nameOffice = "NombreOficina";
    	streetOffice = "CalleOficina";
    	zipOffice = 24121;
    	phoneOffice = 666666666;
    	employeeListOffice = new ArrayList<Employee>();
    	idOffice = new OfficeHandler(1234);
    	office = new Office(nameOffice,streetOffice,zipOffice,phoneOffice,employeeListOffice,idOffice);	
    			
        JUAN_NAME = "Juan";
        JUAN_SURNAME = "Perez";
        JUAN_ADDRESS = "Leon";
        JUAN_SALARY = 5000;
        JUAN_DNI = new DNIHandler("71463395A");
        JUAN_OFFICE = office;
      
        PEPE_NAME = "Pepe";
        PEPE_SURNAME = "Lopez";
        PEPE_ADDRESS = "Valencia";
        PEPE_SALARY = 6030;
        PEPE_DNI = new DNIHandler("36167364W");
        PEPE_OFFICE = office;
    
        officeManager = new SimpleOfficeManager();
        employees = new ArrayList<Employee>();
        
        Employee employeeJuan = new Employee("Juan","Perez","Leon",5000,office,JUAN_DNI);
        employees.add(employeeJuan);
        
        Employee employeePepe = new Employee("Pepe","Lopez","Valencia",6030,office,PEPE_DNI);
        employees.add(employeePepe);
                
        officeManager.setOffice(office);
        office.setEmployeeList(employees);
        
        SILVIA_DNI = new DNIHandler("71461175Z");
        EMPLOYEE = new Employee("Silvia","Garcia","Canarias",4022,office,SILVIA_DNI);

    }

    @Test
    public void testGetEmployeesWithNoEmployees() {
    	officeManager = new SimpleOfficeManager();
    	employees = new ArrayList<Employee>();
    	officeManager.setOffice(office);
        office.setEmployeeList(employees);
        assertEquals(officeManager.getEmployees().size(), 0);
    }

	@Test
    public void testGetEmployees() {
        List<Employee> employees = officeManager.getEmployees();
        assertNotNull(employees);        
        assertEquals(EMPLOYEES_COUNT, officeManager.getEmployees().size());
    
        Employee employee = employees.get(0);
        assertEquals(JUAN_NAME, employee.getName());
        assertEquals(JUAN_SURNAME, employee.getSurname());
        assertEquals(JUAN_ADDRESS, employee.getAddress());
        assertEquals(JUAN_SALARY, employee.getSalary(), 0);
        assertEquals(JUAN_OFFICE, employee.getOffice());
        assertEquals(JUAN_DNI, employee.getIdEmployee());
        
        employee = employees.get(1);  
        assertEquals(PEPE_NAME, employee.getName());
        assertEquals(PEPE_SURNAME, employee.getSurname());
        assertEquals(PEPE_ADDRESS, employee.getAddress());
        assertEquals(PEPE_SALARY, employee.getSalary(), 0);
        assertEquals(PEPE_OFFICE, employee.getOffice());
        assertEquals(PEPE_DNI, employee.getIdEmployee());
        
	}
	
	@Test(expected = AssertionError.class)
    public void testAddEmployeeWithNullListOfEmployees() {
        try {
            officeManager = new SimpleOfficeManager();
            officeManager.addEmployee(EMPLOYEE);
        }
        catch(NullPointerException ex) {
            fail("Employees list is null.");
        }
    }

    @Test
    public void testAddEmployee() {
    	assertNotNull(officeManager.getEmployees());
    	assertEquals(2, officeManager.getEmployees().size());
    	officeManager.addEmployee(EMPLOYEE);
		assertEquals(officeManager.getEmployees().size(), 3);
		Employee employee = officeManager.getEmployees().get(2);
		Handler id = new DNIHandler("71461175Z");
		assertEquals(id.compareTo(employee.getIdEmployee()), 0);
    	       
    }
    
}
