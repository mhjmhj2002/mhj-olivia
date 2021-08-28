package com.mhj.olivia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhj.olivia.builder.OliviaDataBuilder;
import com.mhj.olivia.dto.OliviaDataDto;
import com.mhj.olivia.entity.OliviaData;
import com.mhj.olivia.mapper.OliviaDataMapper;
import com.mhj.olivia.repository.OliviaDataRepository;

@Service
public class OliviaDataService {
	
	@Autowired
	private OliviaDataRepository repository;
	
	@Autowired
	private OliviaDataMapper mapper;
	
	@Autowired
	private OliviaDataBuilder builder;
	
	public void create(OliviaDataDto dto) {
		OliviaData oliviaData = mapper.toEntity(dto);
		repository.save(oliviaData);
	}

	public List<OliviaDataDto> produces() {
		List<OliviaDataDto> list = builder.buildFile();
		for (OliviaDataDto dto : list) {
			create(dto);
		}
		return list;
	}

}
