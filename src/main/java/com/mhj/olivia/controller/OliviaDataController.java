package com.mhj.olivia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhj.olivia.dto.OliviaDataDto;
import com.mhj.olivia.service.OliviaDataService;

@RestController
@RequestMapping(value = "/v1/olivia-data", produces = MediaType.APPLICATION_JSON_VALUE)
//@Api
public class OliviaDataController {
	
	@Autowired
	private OliviaDataService service;

    @GetMapping
    public List<OliviaDataDto> getAll() {
    	ArrayList<OliviaDataDto> list = new ArrayList<OliviaDataDto>();
    	OliviaDataDto dto = new OliviaDataDto();
    	dto.setCategoriaOlivia("categoriaOlivia");
    	list.add(dto);
        return list;
    }
    
    @PostMapping
    public ResponseEntity<OliviaDataDto> incluir(@RequestBody final OliviaDataDto dto) {
    	final OliviaDataDto retorno = service.criar(dto);
    	return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

}
