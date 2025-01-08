package com.example.hotel_management_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_management_project.dto.CustomerDetails;
import com.example.hotel_management_project.entity.CustomerDetailsEntity;
import com.example.hotel_management_project.repositoryPl.CustomerRepository;

@Service
public class CustomerDetailsService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Optional<CustomerDetailsEntity> getCustomerDetailsById(Long id) {
		return customerRepository.findById(id);
	}
	
	public List<CustomerDetailsEntity> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	
	public List<CustomerDetailsEntity> getCustomersByName(String customerName) {
		return customerRepository.getCustomerDetailsByCustomerName(customerName);
	}
	
	
	public CustomerDetailsEntity saveDetails(CustomerDetails custDetails) {
 
        CustomerDetailsEntity entity = new CustomerDetailsEntity();
        entity.setCustomerName(custDetails.getCustomerName());
        entity.setAge(custDetails.getAge());
        entity.setAddress(custDetails.getAddress());
        entity.setCountryCode(custDetails.getCountryCode());
        entity.setIdProof(custDetails.getIdProof());
        entity.setMobileNumber(custDetails.getMobileNumber());
     
        return customerRepository.save(entity);
    }
	

}
