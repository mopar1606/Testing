package com.fonyou.evaluator.services.impl;

import com.fonyou.evaluator.evaluatormodels.dao.IExamenDAO;
import com.fonyou.evaluator.evaluatormodels.entity.ExamenEntity;
import com.fonyou.evaluator.services.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl implements IExamenService {

    @Autowired
    private IExamenDAO examenDAO;

    @Override
    public List<ExamenEntity> findAll() {
        return examenDAO.findAll();
    }

    @Override
    public ExamenEntity findById(Long idExamen) {
        return examenDAO.findById(idExamen).orElse(null);
    }

    @Override
    public ExamenEntity save(ExamenEntity objeto) {
        return examenDAO.save(objeto);
    }
}
