package com.fonyou.evaluator.evaluatormodels.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fonyou.evaluator.evaluatormodels.entity.ExamenEntity;
import com.fonyou.evaluator.evaluatormodels.entity.PreguntaEntity;

public interface IPreguntaDAO extends JpaRepository<PreguntaEntity, Long> {
	
	public List<PreguntaEntity> findByExamen(ExamenEntity examen);
}
