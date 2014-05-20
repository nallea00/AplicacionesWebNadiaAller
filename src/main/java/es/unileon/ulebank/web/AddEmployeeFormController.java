package es.unileon.ulebank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.service.AddEmployee;
import es.unileon.ulebank.service.OfficeManager;

@Controller
@RequestMapping(value="/addemployee.htm")
public class AddEmployeeFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private OfficeManager officeManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid AddEmployee addEmployee, BindingResult result)
    {
        if (result.hasErrors()) {
            return "addemployee";
        }
		
        String name = addEmployee.getName();
        String surname = addEmployee.getSurname();
        String address = addEmployee.getSurname();
        int salary = addEmployee.getSalary();
        String dni = addEmployee.getDni();
        Handler idEmployee = new DNIHandler(dni);
        
        Employee employee = new Employee(name, surname, address, salary, idEmployee);
        
        officeManager.addEmployee(employee);
        logger.info("Adding employee " + idEmployee + ".");
        
        return "redirect:/hello.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected AddEmployee formBackingObject(HttpServletRequest request) throws ServletException {
    	AddEmployee addEmployee = new AddEmployee();
    	addEmployee.setName("Nadia");
    	addEmployee.setSurname("Aller");
    	addEmployee.setAddress("Sariegos");
    	addEmployee.setSalary(1563);
    	addEmployee.setDni("71461175Z");
        return addEmployee;
    }

    public void setProductManager(OfficeManager officeManager) {
        this.officeManager = officeManager;
    }

    public OfficeManager getProductManager() {
        return officeManager;
    }

}