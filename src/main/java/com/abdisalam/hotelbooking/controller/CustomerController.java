package com.abdisalam.hotelbooking.controller;

import com.abdisalam.hotelbooking.model.Customer;
import com.abdisalam.hotelbooking.repository.CustomerRepository;
import com.abdisalam.hotelbooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    @GetMapping
    public String listCustomer(Model model){
       List<Customer> customer = customerService.getAllCustomers();
       model.addAttribute("customer", customer);

       return "rooms";
    }





}
