package com.mhj.olivia.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OliviaDataDto {

	private String instituicaoFinanceira;
	private String tipoConta;
	private String nomeConta;
	private Date data;
	private String descricaoTransacao;
	private BigDecimal valor;
	private CategoriaOliviaDto categoriaOlivia;
	private Boolean pendente;

}
