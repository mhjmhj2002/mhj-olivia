package com.mhj.olivia.entity;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class OliviaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String instituicaoFinanceira;
	private String tipoConta;
	private String nomeConta;
	private Date data;
	private String descricaoTransacao;
	private BigDecimal valor;
	private String categoriaOlivia;
	private Boolean pendente;

}
