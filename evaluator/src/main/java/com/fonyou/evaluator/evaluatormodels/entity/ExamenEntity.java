package com.fonyou.evaluator.evaluatormodels.entity;

import java.util.Date;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "examen")
public class ExamenEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idExamen")
	private Long idExamen;
	
	@Temporal(TemporalType.DATE)
	private Date  fechaPresentacion;
	
	@NotNull(message = "El registro Estudiante no puede ser nulo.")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstudiante")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private EstudianteEntity estudiante;
}
