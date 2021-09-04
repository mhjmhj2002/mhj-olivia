package com.mhj.olivia.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(uniqueConstraints = 
@UniqueConstraint(name = "UniqueOliviaData", columnNames = { "nomeConta", "data", "descricaoTransacao", "valor" }))
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
