package com.altsed.springdemo.service;

import com.altsed.springdemo.dao.CustomerDAO;
import com.altsed.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CustomerService {

        public List<Customer> getCustomers();

        public void saveCustomer(Customer theCustomer);

        public Customer getCustomer(int theId);

        public void deleteCustomer(int theId);
}
