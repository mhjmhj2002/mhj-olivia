package com.mhj.olivia.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.mhj.olivia.dto.OliviaDataDto;
import com.mhj.olivia.entity.OliviaData;

@Mapper
public interface OliviaDataMapper {
	
	OliviaData toEntity(OliviaDataDto dto);
	
	@InheritInverseConfiguration
	OliviaDataDto toDto(OliviaData entity);

}
