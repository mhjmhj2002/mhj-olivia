package com.mhj.olivia.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhj.olivia.service.ConsolidateDataService;

@RestController
@RequestMapping("/consolidate-data")
public class ConsolidateDataController {
	
	@Autowired
	private ConsolidateDataService service;

    @GetMapping(name = "/all")
    public String getAll() throws ParseException {
        service.consolidateData();
        return "OK";
    }

}
