package com.mhj.olivia.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhj.olivia.dto.OliviaDataDto;
import com.mhj.olivia.entity.OliviaData;
import com.mhj.olivia.mapper.OliviaDataMapper;
import com.mhj.olivia.repository.OliviaDataRepository;

public class OliviaDataService {
	
	@Autowired
	private OliviaDataRepository repository;
	
	@Autowired
	private OliviaDataMapper mapper;
	
	public void create(OliviaDataDto dto) {
		OliviaData oliviaData = mapper.toEntity(dto);
		repository.save(oliviaData);
	}

}
