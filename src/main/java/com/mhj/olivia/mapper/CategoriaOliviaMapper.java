package com.mhj.olivia.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.mhj.olivia.dto.CategoriaOliviaDto;
import com.mhj.olivia.entity.CategoriaOlivia;

@Mapper
public interface CategoriaOliviaMapper {
	
	CategoriaOlivia toEntity(CategoriaOliviaDto dto);
	
	@InheritInverseConfiguration
	CategoriaOliviaDto toDto(CategoriaOlivia entity);

}
