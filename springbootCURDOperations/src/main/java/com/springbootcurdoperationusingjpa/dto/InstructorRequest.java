package com.springbootcurdoperationusingjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InstructorRequest {
	private long id;
	private String first_name;
	private String last_name;
	private String email;

}
