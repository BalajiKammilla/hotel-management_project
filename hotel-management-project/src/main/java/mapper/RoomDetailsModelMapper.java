package mapper;

import org.modelmapper.ModelMapper;

import dto.RoomDetails;
import entity.RoomDetailsEntity;

public class RoomDetailsModelMapper {
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	public RoomDetails convertToDto(RoomDetailsEntity entity) {
		return modelMapper.map(entity, RoomDetails.class);
	}
	
	public RoomDetailsEntity convertToEntity(RoomDetails dto) {
		return modelMapper.map(dto, RoomDetailsEntity.class);
	}

}
