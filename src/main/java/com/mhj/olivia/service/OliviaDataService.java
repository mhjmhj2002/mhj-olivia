package com.mhj.olivia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mhj.olivia.dto.CategoriaOliviaDto;
import com.mhj.olivia.dto.OliviaDataDto;
import com.mhj.olivia.entity.CategoriaOlivia;
import com.mhj.olivia.entity.OliviaData;
import com.mhj.olivia.exception.DuplicateException;
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
	private CategoriaOliviaService categoriaOliviaService;

	public OliviaDataDto criar(OliviaDataDto dto) throws DuplicateException {
		log.info("Incluir olivia data: {}", dto.toString());
		
		OliviaData entity = mapper.toEntity(dto);
		
		CategoriaOlivia categoriaOlivia = categoriaOliviaService.getByDescricao(dto.getCategoriaOlivia().getDescricao()).orElse(incluirCategoria(dto.getCategoriaOlivia()));
		
		entity.setCategoriaOlivia(categoriaOlivia);
		
		try {
			OliviaData save = repository.save(entity);
			log.info("Incluido olivia data: {}", save.toString());
			return mapper.toDto(save);
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateException("registro duplicado");
		}
	}

	private CategoriaOlivia incluirCategoria(CategoriaOliviaDto dto) {
		try {
			return categoriaOliviaService.criar(dto);
		} catch (DataIntegrityViolationException e) {
			log.info("categoria ja incluida.");
		}
		return categoriaOliviaService.getByDescricao(dto.getDescricao()).get();
	}

}
