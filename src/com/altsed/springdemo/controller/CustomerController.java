package com.altsed.springdemo.controller;

import com.altsed.springdemo.dao.CustomerDAO;
import com.altsed.springdemo.entity.Customer;
import com.altsed.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject Customer Service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers (Model theModel) {

        //get customers from service
        List<Customer> theCustomers = customerService.getCustomers();

        //add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //create model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer")Customer theCustomer){
        //save customer using our service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,  Model theModel){
        //get the customer from our service
        Customer theCustomer = customerService.getCustomer(theId);
        //set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);
        //send over to our form
        return "customer-form";
    }
    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("customerId") int theId,  Model theModel){
        //get the customer from our service
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

}
