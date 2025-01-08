package mapper;

import org.modelmapper.ModelMapper;

import dto.PaymentDetails;
import entity.PaymentDetailsEntity;


public class PaymentDetailsModelMapper {
	
private final ModelMapper modelMapper = new ModelMapper();
	
	public PaymentDetails convertToDto(PaymentDetailsEntity entity) {
		return modelMapper.map(entity, PaymentDetails.class);
	}
	
	public PaymentDetailsEntity convertToEntity(PaymentDetails dto) {
		return modelMapper.map(dto, PaymentDetailsEntity.class);
	}

}
