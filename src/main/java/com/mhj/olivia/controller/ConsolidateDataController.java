package com.mhj.olivia.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhj.olivia.service.ConsolidateDataService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/consolidate-data")
@Slf4j
public class ConsolidateDataController {
	
	@Autowired
	private ConsolidateDataService service;

    @GetMapping(name = "/all")
    public String getAll() throws ParseException {
    	log.info("Inicio");
        service.consolidateData();
        log.info("Fim");
        return "OK";
    }

}
