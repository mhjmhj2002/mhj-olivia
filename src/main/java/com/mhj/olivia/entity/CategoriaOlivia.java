package com.mhj.olivia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = 
@UniqueConstraint(name = "UniqueCategoriaOlivia", columnNames = { "descricao" }))
public class CategoriaOlivia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	/**
	 * F-Fixo
	 * V-Variavel
	 * E-Entrada
	 * D-Desconhecido
	 * I-Investimento
	 */
	private Character tipoGasto;
	
}
