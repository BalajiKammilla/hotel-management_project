package com.example.hotel_management_project.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_management_project.entity.PaymentDetailsEntity;
import com.example.hotel_management_project.service.PaymentDetailsService;

@RestController
@RequestMapping("/payment")
public class PaymentDetailsResource {
	
	@Autowired
	private PaymentDetailsService paymentDetailsService;
	
	@GetMapping("/details/{id}")
	public Optional<PaymentDetailsEntity> getpaymentDetialsById(@PathVariable Long id) {
		return paymentDetailsService.getPaymentDetailsById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<PaymentDetailsEntity>> allPaymentDetails() {
		List<PaymentDetailsEntity> list = paymentDetailsService.getAllPaymentDetails();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/details/{paymentMethod}")
	public List<PaymentDetailsEntity> findByPaymentMethod(@PathVariable String paymentMethod){
		return paymentDetailsService.getPaymentDetailsByPaymentMethod(paymentMethod);
	}

	//save $ update $ delete need to be added
}
