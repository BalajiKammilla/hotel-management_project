package mapper;

import org.modelmapper.ModelMapper;

import dto.CustomerDetails;
import dto.RoomDetails;
import entity.CustomerDetailsEntity;
import entity.RoomDetailsEntity;

public class CustomerDetailsModelMapper {
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	public CustomerDetails convertToDto(CustomerDetailsEntity entity) {
		return modelMapper.map(entity, CustomerDetails.class);
	}
	
	public CustomerDetailsEntity convertToEntity(CustomerDetails dto) {
		return modelMapper.map(dto, CustomerDetailsEntity.class);
	}
 
}
