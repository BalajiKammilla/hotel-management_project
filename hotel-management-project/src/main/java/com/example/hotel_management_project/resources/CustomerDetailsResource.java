package com.example.hotel_management_project.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_management_project.dto.CustomerDetails;
import com.example.hotel_management_project.entity.CustomerDetailsEntity;
import com.example.hotel_management_project.service.CustomerDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/api/customer")
public class CustomerDetailsResource {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@GetMapping("/check")
	public String getString() {
		return "Customer Resource";
	}
	
	
	@Operation(summary = "Get CustomerDetails By Id")
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

	@PostMapping("/register")
	public ResponseEntity<CustomerDetailsEntity> register(@RequestBody CustomerDetails details) {
	    CustomerDetailsEntity savedEntity = customerDetailsService.saveDetails(details);
	    return ResponseEntity.status(200).body(savedEntity); 
	}
	
	@PostMapping("/login")
	public String customerLogin(@RequestBody CustomerDetails details) {
		return customerDetailsService.VerifyCustomer(details);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerDetailsEntity> upadteDetails(@PathVariable Long id, @RequestBody CustomerDetails details){
		CustomerDetailsEntity updatedEntity = customerDetailsService.updateDetails(id, details);
		return ResponseEntity.ok(updatedEntity);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CustomerDetailsEntity> deleteById(@PathVariable Long id){
		customerDetailsService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/send-otp")
	public ResponseEntity<String> sendOtp(@PathParam(value = "mobileNUmber") String mobileNumber){
		String response = customerDetailsService.sendOtp(mobileNumber);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(
            @RequestParam String mobileNumber,
            @RequestParam String otp,
            @RequestParam String newPassword) {
        String response = customerDetailsService.resetPassword(mobileNumber, otp, newPassword);
        return ResponseEntity.ok(response);
	}
}
