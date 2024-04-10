package com.fonyou.evaluator.controller;

import com.fonyou.evaluator.evaluatormodels.entity.ExamenEntity;
import com.fonyou.evaluator.services.IExamenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ExamenRestController {

    @Autowired
    private IExamenService examenService;

    @GetMapping("/examenes")
    public List<ExamenEntity> index() {
        return examenService.findAll();
    }

    @GetMapping("/examenes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        ExamenEntity objeto = null;

        try {
            objeto = examenService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (objeto == null) {
            response.put("mensaje", "El examen con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put("objeto", objeto);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/examenes")
    public ResponseEntity<?> create(@Valid @RequestBody ExamenEntity objeto, BindingResult result) {

        ExamenEntity objetoNew = null;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objetoNew = examenService.save(objeto);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al insertar examen en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Examen creado con éxito!");
        response.put("objeto", objetoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
