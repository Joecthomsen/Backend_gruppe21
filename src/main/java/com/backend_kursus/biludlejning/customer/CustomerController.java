package com.backend_kursus.biludlejning.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
    {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomers()

    {
        List<Customer> findCustomers = customerService.getCustomers();
        if(!findCustomers.isEmpty())
        {
            return new ResponseEntity<>(findCustomers, HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable int id)
    {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/getCustomerByFirstName/{firstName}")
    public ResponseEntity<List<Customer>> getCustomerByFirstName(@PathVariable String firstName)
    {
        List<Customer> findCustomer = customerService.findByFirstName(firstName);
        if(!findCustomer.isEmpty())
        return new ResponseEntity<>(findCustomer, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getCustomerByLastName/{lastName}")
    public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable String lastName)
    {
        List<Customer> findCustomer = customerService.findByLastName(lastName);
        if (!findCustomer.isEmpty())
            return new ResponseEntity<>(findCustomer, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)

    {
        Customer oldCustomer = customerService.getCustomerById(customer.getId());
        Customer updatedCustomer = customerService.updateCustomer(customer);
        if (!oldCustomer.equals(updatedCustomer))
        {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable int id)
    {
        System.out.println(customerService.deleteCustomerById(id));
    }
}
