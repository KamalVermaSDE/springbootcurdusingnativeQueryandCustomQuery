package com.springbootcurdoperationusingjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PagingRequest {
	private Integer size;
	private Integer page;
	private String orderBy;
	private String sort;

}
