package com.fonyou.evaluator.evaluatormodels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fonyou.evaluator.evaluatormodels.entity.ExamenEntity;

public interface IExamenDAO extends JpaRepository<ExamenEntity, Long> {
	
	//public ExamenEntity findFirstByEstudianteIdEstudiante(Long idEstudiante);

}
