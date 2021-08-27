package com.mhj.olivia.builder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.mhj.olivia.dto.OliviaDataDto;
import com.opencsv.bean.CsvToBeanBuilder;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Builder
@Slf4j
public class OliviaDataBuilder {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<OliviaDataDto> buildFile() {
		
		List<OliviaDataDto> dtos = new ArrayList<>();
		try {
			dtos = new CsvToBeanBuilder(new FileReader("src/main/resources/data/oliviaData.csv"))
			        .withType(OliviaDataDto.class)
			        .build()
			        .parse();
		} catch (IllegalStateException | FileNotFoundException e) {
			log.error("Erro: ", e);
		}
		return dtos;
	}

}
