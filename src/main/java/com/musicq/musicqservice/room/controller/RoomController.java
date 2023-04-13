package com.musicq.musicqservice.room.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicq.musicqservice.room.dto.RoomCreateDto;
import com.musicq.musicqservice.room.service.RoomService;

import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rooms")
public class RoomController {

	private final RoomService roomService;

	// 방 생성(POST)
	@CrossOrigin("*")
	@PostMapping("/create")
	public ResponseEntity<String> createSession(
		@Valid @RequestBody(required = false) Map<String, Object> params,
		@Valid HttpServletRequest request
	) throws OpenViduHttpException, OpenViduJavaClientException {
		return roomService.createSession(params, request);
	}

	@PostMapping("/create/{sessionId}")
	public ResponseEntity<String> createRoom(
		@Valid @PathVariable String sessionId,
		@Valid @RequestBody RoomCreateDto roomCreateDto
	) {
		return roomService.createRoom(sessionId, roomCreateDto);
	}

	// 방 입장(POST)
	@CrossOrigin("*")
	@PostMapping("/sessions/{sessionId}")
	public ResponseEntity<String> createConnection(
		@Valid @PathVariable("sessionId") String sessionId,
		@Valid @RequestBody(required = false) Map<String, Object> params
	) throws OpenViduJavaClientException, OpenViduHttpException {
		return roomService.createConnection(sessionId, params);
	}

	// 방 입장(GET)
	// TODO - 병주 : 아직 오픈비두 라이브러리와 검증 로직은 사용하지 않았음.
	// TODO : 방이 존재하는지 조회 후, 방이 존재한다면 그 방에 데이터를 꺼내주어 입장할 수 있도록 한다.
	@GetMapping("/enter/{roomId}")
	public ResponseEntity<String> enter(
		@Valid @PathVariable("roomId") String roomId
	) {
		return roomService.enter(roomId);
	}

	// 방 삭제(DELETE)
	@DeleteMapping("/delete/{roomId}")
	public ResponseEntity<String> deleteRoom(
		@Valid @PathVariable("roomId") String roomId
	) {
		return roomService.deleteRoom(roomId);
	}
}