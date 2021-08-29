package com.mhj.olivia.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.mhj.olivia.entity.ConsolidateData;
import com.mhj.olivia.entity.OliviaData;
import com.mhj.olivia.enums.EnumSimNao;
import com.mhj.olivia.repository.ConsolidateDataRepository;

@Service
public class ConsolidateDataService {
	
	@Autowired
	private ConsolidateDataRepository repository;
	
	@Autowired
	private OliviaDataService oliviaDataService;
	
	public void consolidateData() throws ParseException {
		List<OliviaData> list = oliviaDataService.getAll();
		
		for (OliviaData oliviaData : list) {
			consolidateData(oliviaData);
		}
	}

	private void consolidateData(OliviaData oliviaData) throws ParseException {
		ConsolidateData consolidateData = new ConsolidateData();
		consolidateData.setCategoriaOlivia(oliviaData.getCategoriaOlivia());
		consolidateData.setDescricaoTransacao(oliviaData.getDescricaoTransacao());
		consolidateData.setInstituicaoFinanceira(oliviaData.getInstituicaoFinanceira());
		consolidateData.setNomeConta(oliviaData.getNomeConta());
		consolidateData.setTipoConta(oliviaData.getTipoConta());
		
		if (EnumSimNao.NAO.getDescricao().equals(oliviaData.getPendente())) {
			consolidateData.setPendente(EnumSimNao.NAO.isBoleano());
		} else {
			consolidateData.setPendente(EnumSimNao.SIM.isBoleano());
		}
		
		consolidateData.setData(oliviaData.getDataDate());
		consolidateData.setValor(oliviaData.getValorDecimal());
		
		if (findByFilter(consolidateData) == null) {
			repository.save(consolidateData);
		}
		
		oliviaDataService.delete(oliviaData);
		
	}

	public ConsolidateData findByFilter(ConsolidateData consolidateData) {
		return repository.findOne(Example.of(consolidateData)).orElse(null);
	}

}
