package com.mhj.olivia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.mhj.olivia.builder.OliviaDataBuilder;
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
	
	@Autowired
	private OliviaDataBuilder builder;
	
	public void create(OliviaDataDto dto) {
		OliviaData oliviaData = mapper.toEntity(dto);
		repository.save(oliviaData);
	}
	
	public void saveAll(List<OliviaDataDto> dtos) {
		List<OliviaData> entities = new ArrayList<>();
		for (OliviaDataDto dto : dtos) {
			entities.add(mapper.toEntity(dto));
		}
		log.info("salvar");
		repository.saveAll(entities);
		log.info("salvo");
	}

	public List<OliviaDataDto> produces() {
		List<OliviaDataDto> list = builder.buildFile();
		saveAll(list);
//		for (OliviaDataDto dto : list) {
//			create(dto);
//		}
		return list;
	}

	public List<OliviaData> getAll() {
		return repository.findAll();
	}

	public void delete(OliviaData oliviaData) {
		repository.delete(oliviaData);
	}

	public OliviaData findByFilter(OliviaData oliviaData) {
		return repository.findOne(Example.of(oliviaData)).orElse(null);
	}

}
