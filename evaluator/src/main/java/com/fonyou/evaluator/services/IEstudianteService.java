package com.fonyou.evaluator.services;

import java.util.List;

import com.fonyou.evaluator.evaluatormodels.entity.EstudianteEntity;

public interface IEstudianteService {
	
	public List<EstudianteEntity> findAll();
	
	public EstudianteEntity findById(Long idEstudiante);
	
	public EstudianteEntity save(EstudianteEntity objeto);

}
