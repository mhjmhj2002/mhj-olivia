package com.mhj.olivia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OliviaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String instituicaoFinanceira;
	private String tipoConta;
	private String nomeConta;
	private String data;
	private String descricaoTransacao;
	private String valor;
	private String categoriaOlivia;
	private String pendente;

}
