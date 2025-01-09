package com.example.hotel_management_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_management_project.dto.PaymentDetails;
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
	
	public List<PaymentDetailsEntity> findPaymentDetailsByPaymentMethod(String paymentMethod) {
		return paymentRepository.getPaymentDetailsByPaymentMethod(paymentMethod);
	}
	
	public PaymentDetailsEntity saveDetails(PaymentDetails payDetails) {
		
		PaymentDetailsEntity entity = new PaymentDetailsEntity();
		entity.setId(payDetails.getId());
		entity.setStayDays(payDetails.getStayDays());
		entity.setTotalPrice(payDetails.getTotalPrice());
		
		return paymentRepository.save(entity);
	}
	
	public PaymentDetailsEntity updateDetails(Long id, PaymentDetails payDetails) {
		
		PaymentDetailsEntity existingEntity = paymentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Payment details not found with id"+id));
		
		existingEntity.setStayDays(payDetails.getStayDays());
		existingEntity.setTotalPrice(payDetails.getTotalPrice());
		
		return paymentRepository.save(existingEntity);
	}
	
	public void deleteByPayment(Long id) {
		if(!paymentRepository.existsById(id)) {
			throw new RuntimeException("Payment details By Id not found"+id);
		}
		paymentRepository.deleteById(id); 
	}
}
