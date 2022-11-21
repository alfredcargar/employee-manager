package com.alfred.employeemanagement.controllers;

import com.alfred.employeemanagement.models.Employee;
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
    @GetMapping("/")
    public String home(Model model){
        return "index.html";
    }

    /* ****************************************************************************************************************
                                                    ADMIN HANDLERS
     * ****************************************************************************************************************/

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "/admin/admin_login";
    }

    @GetMapping("/admin/employees")
    public String adminHome(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "/admin/employees";
    }

    @GetMapping("/employees/new")
    public String createNewEmployee(Model model) {

        // create obj to hold the form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/admin/create_employee";
    }

    // handler for the POST of new entities
    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/admin/employees";
    }

    // handler to return the edit form
    @GetMapping("/employees/edit/id={ID}")
    public String editEmployeeForm(@PathVariable Long ID, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(ID));
        return "/admin/edit_employee";
    }

    // handler for the edit update
    @PostMapping("/employees/id={ID}")
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

        return "redirect:/admin/employees";
    }

    // delete handler
    @GetMapping("/employees/{ID}")
    public String deleteEmployee(@PathVariable Long ID){

        employeeService.deleteEmployee(ID);
        return "redirect:/employees";
    }

    /* ****************************************************************************************************************
                                                    USER HANDLERS
     * ****************************************************************************************************************/


    @GetMapping("/user/login")
    public String userLogin() {
        return "/user/user_login";
    }

    @GetMapping("/user/employees")
    public String userHome(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "user/employees";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index.html";
    }



}
