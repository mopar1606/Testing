package com.fonyou.evaluator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fonyou.evaluator.evaluatormodels.outputDTO.PreguntaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fonyou.evaluator.evaluatormodels.entity.ExamenEntity;
import com.fonyou.evaluator.evaluatormodels.entity.PreguntaEntity;
import com.fonyou.evaluator.services.IPreguntaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PreguntaRestController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IPreguntaService preguntaService;
	
	@GetMapping("/preguntas")
	public List<PreguntaDTO> index() {
		return preguntaService.findAll()
				.stream()
				.map(outDTO -> modelMapper.map(outDTO, PreguntaDTO.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/preguntas/{idExamen}")
    public List<PreguntaDTO> obtenerPreguntasPorExamen(@PathVariable Long idExamen) {
		ExamenEntity examenEntity = ExamenEntity.builder().idExamen(idExamen).build();
		return preguntaService.findByExamen(examenEntity)
				.stream()
				.map(outDTO -> modelMapper.map(outDTO, PreguntaDTO.class))
				.collect(Collectors.toList());
    }
	
	@PostMapping("/preguntas")
	public ResponseEntity<?> create(@Valid @RequestBody PreguntaEntity objeto, BindingResult result) {
		
		PreguntaDTO outDTO;
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
			outDTO = modelMapper.map(preguntaService.save(objeto),PreguntaDTO.class);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al insertar pregunta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Pregunta creada con éxito!");
		response.put("objeto", outDTO);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
