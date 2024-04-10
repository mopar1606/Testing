package com.fonyou.evaluator.evaluatormodels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fonyou.evaluator.evaluatormodels.entity.EstudianteEntity;

public interface IEstudianteDAO extends JpaRepository<EstudianteEntity, Long> {}
