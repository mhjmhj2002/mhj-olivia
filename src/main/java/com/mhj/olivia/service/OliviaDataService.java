package com.mhj.olivia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhj.olivia.dto.OliviaDataDto;
import com.mhj.olivia.entity.OliviaData;
import com.mhj.olivia.mapper.OliviaDataMapper;
import com.mhj.olivia.repository.OliviaDataRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OliviaDataService {

	@Autowired
	private OliviaDataRepository repository;

	@Autowired
	private OliviaDataMapper mapper;

	public OliviaDataDto criar(OliviaDataDto dto) {
		log.info("Incluir olivia data: {}", dto.toString());
		OliviaData entity = mapper.toEntity(dto);
		OliviaData save = repository.save(entity);
		log.info("Incluido olivia data: {}", save.toString());
		return mapper.toDto(save);
	}

}
