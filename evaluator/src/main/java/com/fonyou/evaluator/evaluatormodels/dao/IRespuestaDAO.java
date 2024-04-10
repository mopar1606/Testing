package com.fonyou.evaluator.evaluatormodels.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fonyou.evaluator.evaluatormodels.entity.RespuestaEntity;

public interface IRespuestaDAO extends JpaRepository<RespuestaEntity, Long> {
	
	public List<RespuestaEntity> findByExamenIdExamen(Long examenId);
	
	public List<RespuestaEntity> findByEstudianteIdEstudiante(Long estudianteId);
	
	public List<RespuestaEntity> findByPreguntaIdPregunta(Long preguntaId);
}
