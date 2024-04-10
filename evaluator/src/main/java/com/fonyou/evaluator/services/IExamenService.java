package com.fonyou.evaluator.services;

import java.util.List;

import com.fonyou.evaluator.evaluatormodels.entity.ExamenEntity;

public interface IExamenService {

	public List<ExamenEntity> findAll();

	public ExamenEntity findById(Long idExamen);
	
	public ExamenEntity save(ExamenEntity objeto);
}
