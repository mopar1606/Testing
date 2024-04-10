package com.fonyou.evaluator.evaluatormodels.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "estudiante")
public class EstudianteEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEstudiante")
	private Long idEstudiante;
	
	@NotNull(message = "El campo nombreEstudiante no puede ser nulo.")
	@Column(name = "nombreEstudiante", nullable = false)
	private String nombreEstudiante;
	
	@NotNull(message = "El campo edadEstudiante no puede ser nulo.")
	@Column(name = "edadEstudiante", nullable = false)
	private Integer edadEstudiante;
	
	@NotNull(message = "El campo ciudadEstudiante no puede ser nulo.")
	@Column(name = "ciudadEstudiante", nullable = false)
	private String ciudadEstudiante;
	
	@NotNull(message = "El campo timeZoneEstudiante no puede ser nulo.")
	@Column(name = "timeZoneEstudiante", nullable = false)
	private String timeZoneEstudiante;
}
