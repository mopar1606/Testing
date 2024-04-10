package com.fonyou.evaluator.evaluatormodels.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "respuesta")
public class RespuestaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRespuesta")
	private Long idRespuesta;
	
	@NotNull(message = "El registro Examen no puede ser nulo.")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idExamen")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ExamenEntity examen;
	
	@NotNull(message = "El registro Estudiante no puede ser nulo.")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstudiante")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private EstudianteEntity estudiante;
	
	@NotNull(message = "El registro Pregunta no puede ser nulo.")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPregunta")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private PreguntaEntity pregunta;
	
	@NotNull(message = "El campo respuestaEstudiante no puede ser nulo.")
	@Column(name = "respuestaEstudiante", nullable = false)
	private String respuestaEstudiante;
	
	@NotNull(message = "El campo puntajeRespuesta no puede ser cero o nulo .")
	@Column(name = "puntajeRespuesta", nullable = false)
	private int puntajeRespuesta;
}
