package com.mhj.olivia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.mhj.olivia.dto.CategoriaOliviaDto;
import com.mhj.olivia.entity.CategoriaOlivia;
import com.mhj.olivia.mapper.CategoriaOliviaMapper;
import com.mhj.olivia.repository.CategoriaOliviaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoriaOliviaService {

	@Autowired
	private CategoriaOliviaRepository repository;
	
	@Autowired
	private CategoriaOliviaMapper mapper;
	
	public CategoriaOlivia criar(CategoriaOliviaDto dto) {
		log.info("Incluir categoria olivia: {}", dto.toString());
		CategoriaOlivia entity = mapper.toEntity(dto);
		CategoriaOlivia save = repository.save(entity);
		log.info("Incluido categoria olivia: {}", dto.toString());
		return save;
	}
	
	public Optional<CategoriaOlivia> getByDescricao(String descricao) {
		CategoriaOlivia categoriaOlivia = new CategoriaOlivia();
		categoriaOlivia.setDescricao(descricao);
		Example<CategoriaOlivia> example = Example.of(categoriaOlivia);
		return repository.findOne(example);
	}
	
	public boolean categoriaExists(String descricao) {
		CategoriaOlivia categoriaOlivia = new CategoriaOlivia();
		categoriaOlivia.setDescricao(descricao);
		Example<CategoriaOlivia> example = Example.of(categoriaOlivia);
		return repository.exists(example);
	}

}
