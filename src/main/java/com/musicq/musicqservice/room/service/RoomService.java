package com.musicq.musicqservice.room.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.musicq.musicqservice.common.ResponseDto;
import com.musicq.musicqservice.room.dto.RoomCreateDto;

import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface RoomService {
	ResponseEntity<String> createSession(Map<String, Object> params, HttpServletRequest request) throws
		OpenViduJavaClientException,
		OpenViduHttpException;

	ResponseEntity<ResponseDto> createRoom(String sessionId, RoomCreateDto roomCreateDto);

	ResponseEntity<ResponseDto> enterRoom(String sessionId, Map<String, Object> params) throws
		OpenViduJavaClientException,
		OpenViduHttpException;

	ResponseEntity<String> deleteRoom(String roomId, HttpServletResponse cookieRes);

	ResponseEntity<Object> searchAll(Integer page, HttpServletRequest request, HttpServletResponse cookieRes);

	void destroyCookieToken(HttpServletResponse cookieRes);

	void chkAndDestroyTokenInCookie(HttpServletRequest request, HttpServletResponse cookieRes);
}
