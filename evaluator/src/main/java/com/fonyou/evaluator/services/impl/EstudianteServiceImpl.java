package com.fonyou.evaluator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fonyou.evaluator.evaluatormodels.dao.IEstudianteDAO;
import com.fonyou.evaluator.evaluatormodels.entity.EstudianteEntity;
import com.fonyou.evaluator.services.IEstudianteService;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	
	@Autowired
	private IEstudianteDAO estudianteDAO;

	@Override
	@Transactional(readOnly = true)
	public List<EstudianteEntity> findAll() {
		return estudianteDAO.findAll();
	}

	@Override
	public EstudianteEntity findById(Long idEstudiante) {
		return estudianteDAO.findById(idEstudiante).orElse(null);
	}

	@Override
	@Transactional
	public EstudianteEntity save(EstudianteEntity objeto) {
		return estudianteDAO.save(objeto);
	}

}
