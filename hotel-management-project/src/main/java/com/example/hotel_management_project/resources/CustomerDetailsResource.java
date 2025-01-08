package com.example.hotel_management_project.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_management_project.dto.CustomerDetails;
import com.example.hotel_management_project.entity.CustomerDetailsEntity;
import com.example.hotel_management_project.service.CustomerDetailsService;


@RestController
@RequestMapping("/customer")
public class CustomerDetailsResource {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@GetMapping("/details/{id}")
	public Optional<CustomerDetailsEntity> findDetailsById(@PathVariable Long id) {
		return customerDetailsService.getCustomerDetailsById(id);
	}
	
	@GetMapping("/{customerName}")
	public List<CustomerDetailsEntity> findDetailsByCustomerName(@PathVariable String customerName) {
		return customerDetailsService.getCustomersByName(customerName);
	}
	@GetMapping
	public ResponseEntity<List<CustomerDetailsEntity>> findAllDetails() {
		List<CustomerDetailsEntity> customers = customerDetailsService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}

	@PostMapping("/save")
	public ResponseEntity<CustomerDetailsEntity> saveDetails(@RequestBody CustomerDetails details) {
	    CustomerDetailsEntity savedEntity = customerDetailsService.saveDetails(details);
	    return ResponseEntity.status(200).body(savedEntity); 
	}
}
