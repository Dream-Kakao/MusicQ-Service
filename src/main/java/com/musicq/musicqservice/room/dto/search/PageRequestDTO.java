package com.musicq.musicqservice.room.dto.search;

import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

	@Builder.Default
	private int page = 1;
}
