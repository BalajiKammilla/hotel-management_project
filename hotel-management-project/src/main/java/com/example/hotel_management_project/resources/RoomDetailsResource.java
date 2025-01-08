package com.example.hotel_management_project.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_management_project.entity.RoomDetailsEntity;
import com.example.hotel_management_project.service.RoomDetailsService;

@RestController
@RequestMapping("room")
public class RoomDetailsResource {
	
	@Autowired
	private RoomDetailsService roomDetailsService;
	
	@GetMapping("/{id}")
	public Optional<RoomDetailsEntity> findById(@PathVariable Long id) {
		return roomDetailsService.getRoomDetailsById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<RoomDetailsEntity>> findAllDetails() {
		List<RoomDetailsEntity> list = roomDetailsService.getAllRoomDetials();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{roomType}")
	public List<RoomDetailsEntity> findByRoomType(@PathVariable String roomType) {
		return roomDetailsService.getRoomByroomType(roomType);
	}
	
	//save $ update $ delete need to be added

}
