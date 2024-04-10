package com.fonyou.evaluator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fonyou.evaluator.evaluatormodels.dao.IPreguntaDAO;
import com.fonyou.evaluator.evaluatormodels.entity.ExamenEntity;
import com.fonyou.evaluator.evaluatormodels.entity.PreguntaEntity;
import com.fonyou.evaluator.services.IPreguntaService;

@Service
public class PreguntaServiceImpl implements IPreguntaService{
	
	@Autowired
	private IPreguntaDAO preguntaDAO;

	@Override
	public List<PreguntaEntity> findAll() {
		return preguntaDAO.findAll();
	}

	@Override
	public List<PreguntaEntity> findByExamen(ExamenEntity examen) {
		return preguntaDAO.findByExamen(examen);
	}

	@Override
	public PreguntaEntity save(PreguntaEntity objeto) {
		return preguntaDAO.save(objeto);
	}

	@Override
	public PreguntaEntity findById(Long idPregunta) {
		return preguntaDAO.findById(idPregunta).orElse(null);
	}

}
