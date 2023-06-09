package com.musicq.musicqservice.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class LoginDto {
	@NotNull
	@NotBlank(message = "아이디는 필수 입력 값입니다.")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{6,20}$", message = "아이디는 알파벳과 숫자를 반드시 포함한 6~20자리여야 합니다.")
	private String id;

	@NotNull
	@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
	private String password;
}
