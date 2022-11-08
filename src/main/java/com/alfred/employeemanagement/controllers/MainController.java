package com.alfred.employeemanagement.controllers;

import com.alfred.employeemanagement.entities.Employee;
import com.alfred.employeemanagement.services.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private MainService employeeService;

    public MainController(MainService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // handler for home
    @GetMapping("/home")
    public String home(Model model){
        listEmployees(model);
        return "index";
    }

    // login handler
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * handler method to return a view of the list of Entities
     * @param model
     * @return view of the home page
     */
    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees.html";
    }

    @GetMapping("/employees/new")
    public String createNewEmployee(Model model) {

        // create obj to hold the form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee.html";
    }

    // handler for the POST of new students
    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }


    // handler to return the edit form
    @GetMapping("/employees/edit/{ID}")
    public String editEmployeeForm(@PathVariable Long ID, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(ID));
        return "edit_employee";
    }

    // handler for the edit update
    @PostMapping("/employees/{ID}")
    public String updateEmployee(@PathVariable Long ID,
                                 @ModelAttribute("employee") Employee employee,
                                 Model model){

        Employee existing = employeeService.getEmployeeById(ID);
        existing.setID(ID);
        existing.setDepartment(employee.getDepartment());
        existing.setEmail(employee.getEmail());
        existing.setName(employee.getName());
        existing.setSurname(employee.getSurname());

        employeeService.editEmployee(employee);

        return "redirect:/employees";
    }

    // delete handler
    @GetMapping("/employees/{ID}")
    public String deleteEmployee(@PathVariable Long ID){

        employeeService.deleteEmployee(ID);
        return "redirect:/employees";
    }



}
