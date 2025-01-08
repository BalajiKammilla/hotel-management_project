package com.example.hotel_management_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_management_project.entity.RoomDetailsEntity;
import com.example.hotel_management_project.repositoryPl.RoomRepository;

@Service
public class RoomDetailsService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	
	public Optional<RoomDetailsEntity> getRoomDetailsById(Long id) {
		return roomRepository.findById(id);
	}
	
	public List<RoomDetailsEntity> getAllRoomDetials() {
		return roomRepository.findAll();
	}
	
	public List<RoomDetailsEntity> getRoomByroomType(String roomType){
		return roomRepository.getRoomDetailsByRoomType(roomType);
	}
}
