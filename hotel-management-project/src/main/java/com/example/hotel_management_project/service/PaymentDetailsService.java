package com.example.hotel_management_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_management_project.entity.PaymentDetailsEntity;
import com.example.hotel_management_project.repositoryPl.PaymentRepository;

@Service
public class PaymentDetailsService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Optional<PaymentDetailsEntity> getPaymentDetailsById(Long id) {
		return paymentRepository.findById(id);
	}
	
	public List<PaymentDetailsEntity> getAllPaymentDetails() {
		return paymentRepository.findAll();
	}
	
	public List<PaymentDetailsEntity> getPaymentDetailsByPaymentMethod(String paymentMethod) {
		return paymentRepository.getPaymentDetailsByPaymentMethod(paymentMethod);
	}
}
