package com.musicq.musicqservice.room.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.musicq.musicqservice.room.dto.RoomEnterDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Service
public class RoomServiceImpl implements RoomService{
	private final RestTemplate restTemplate;

	// 방 정보 조회
	@Override
	public ResponseEntity<String> enter(String roomId) {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:81/v1/rooms/enter/{roomId}",
			String.class, roomId);
		log.info(response.getStatusCode());
		log.info(response.getHeaders());
		log.info(response.getBody());

		return response;
	}
}
