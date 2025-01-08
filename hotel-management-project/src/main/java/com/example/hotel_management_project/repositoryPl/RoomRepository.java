package com.example.hotel_management_project.repositoryPl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.hotel_management_project.entity.RoomDetailsEntity;

@EnableJpaRepositories
public interface RoomRepository extends JpaRepository<RoomDetailsEntity, Long> {

}
