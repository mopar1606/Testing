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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pregunta")
public class PreguntaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPregunta")
	private Long idPregunta;
	
	@NotNull(message = "El campo textoPregunta no puede ser nulo.")
	@Column(name = "textoPregunta", nullable = false)
	private String textoPregunta;
	
	@NotNull(message = "El campo respuestaA no puede ser nulo.")
	@Column(name = "respuestaA", nullable = false)
	private String respuestaA;
	
	@NotNull(message = "El campo respuestaB no puede ser nulo.")
	@Column(name = "respuestaB", nullable = false)
	private String respuestaB;
	
	@NotNull(message = "El campo respuestaC no puede ser nulo.")
	@Column(name = "respuestaC", nullable = false)
	private String respuestaC;
	
	@NotNull(message = "El campo respuestaD no puede ser nulo.")
	@Column(name = "respuestaD", nullable = false)
	private String respuestaD;
	
	@NotNull(message = "El campo respuestaOk no puede ser nulo.")
	@Column(name = "respuestaOk", nullable = false)
	private String respuestaOk;
	
	@NotNull(message = "El campo puntaje no puede ser cero o nulo .")
	@Column(name = "puntaje", nullable = false)
	private int puntaje;

	@NotNull(message = "El registro Examen no puede ser nulo.")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idExamen")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ExamenEntity examen;
}
