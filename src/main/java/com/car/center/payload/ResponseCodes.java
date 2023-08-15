package com.car.center.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseCodes {

	private String code;
	private String message;
	
}
