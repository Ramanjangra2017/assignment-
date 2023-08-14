package com.assignment.assignment.controller;

import com.assignment.assignment.entity.Customer;
import com.assignment.assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        Customer customer1 = customerService.saveCust(customer);
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCust(){
        List<Customer> all = customerService.getAll();
        return all;
    }


    @PutMapping("/update/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        customerService.updateCust(customer, id);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable long id){
        customerService.deleteByid(id);
        return "deleted Sucessfully";
    }
}
