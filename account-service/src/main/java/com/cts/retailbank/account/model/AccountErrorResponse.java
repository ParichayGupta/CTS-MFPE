package com.cts.retailbank.account.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountErrorResponse {

	private LocalDateTime time;
	private HttpStatus status;
	private String errorMsg;
	private String message;
}
