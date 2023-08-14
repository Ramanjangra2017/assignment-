package com.assignment.assignment.service;

import com.assignment.assignment.entity.Customer;
import com.assignment.assignment.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public Customer saveCust(Customer customer){
        return repo.save(customer);
    }

    public List<Customer> getAll(){
        List<Customer> all = repo.findAll();
        return all;
    }

    public String updateCust(Customer customer, long id) {
        Optional<Customer> byId = repo.findById(id);
        if (byId.isPresent()) {
            customer.setId(id);
            Customer save = repo.save(customer);
        }
        return "id is not found";
    }

    public void deleteByid(long id){
        repo.deleteById(id);
    }
}
