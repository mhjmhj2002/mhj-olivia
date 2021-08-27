package com.mhj.olivia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhj.olivia.dto.OliviaDataDto;
import com.mhj.olivia.service.OliviaDataService;

@RestController
@RequestMapping("/olivia-data")
public class OliviaDataController {
	
	@Autowired
	private OliviaDataService service;

    @GetMapping(name = "/all")
    public List<OliviaDataDto> getAll() {
        return service.produces();
    }

}
