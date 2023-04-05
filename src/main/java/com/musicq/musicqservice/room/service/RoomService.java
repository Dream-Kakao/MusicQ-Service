package com.musicq.musicqservice.room.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicq.musicqservice.room.dto.RoomEnterDto;


public interface RoomService {
	public ResponseEntity<String> enter(String roomId);
}
