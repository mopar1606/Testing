package com.fonyou.evaluator.services;

import java.util.List;

import com.fonyou.evaluator.evaluatormodels.entity.ExamenEntity;
import com.fonyou.evaluator.evaluatormodels.entity.PreguntaEntity;

public interface IPreguntaService {
	
	public List<PreguntaEntity> findAll();
	
	public List<PreguntaEntity> findByExamen(ExamenEntity examen);
	
	public PreguntaEntity save(PreguntaEntity objeto);
	
	public PreguntaEntity findById(Long idPregunta);
}
