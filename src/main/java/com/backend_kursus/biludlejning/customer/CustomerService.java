package com.backend_kursus.biludlejning.customer;

import okhttp3.OkHttpClient;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer)
    {
        return repository.save(customer);
    }

    public Customer getCustomerById(int id) {return repository.findById(id).orElse(null);}

    public List<Customer> getCustomers()
    {
        return repository.findAll();
    }

    public List<Customer> findByFirstName(String firstName) {return repository.findByFirstName(firstName);}

    public List<Customer> findByLastName(String lastName){return  repository.findByLastName(lastName);}

    public Customer updateCustomer(Customer customer)
    {
        Customer existingCustomer = repository.getById(customer.getId());
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setDob(customer.getDob());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setId(customer.getId());
        existingCustomer.setPass(customer.getPass());
        existingCustomer.setPoints(customer.getPoints());
        return repository.save(existingCustomer);
    }

    public String deleteCustomerById(int id)
    {
        repository.deleteById(id);
        return "Customer with ID : " + id + " was deleted";
    }

//    public String DkkToUsd()
//    {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://currency-converter5.p.rapidapi.com/currency/convert?format=json&from=USD&to=DKK&amount=1")
//                .get()
//                .addHeader("x-rapidapi-host", "currency-converter5.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "a605bf0275mshdfd8e76db13dfdep1059fcjsn56748aefed54")
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//
}
