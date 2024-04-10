package com.fonyou.evaluator.evaluatormodels.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "timeZones")
public class timeZones {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTimeZone")
	private Long idTimeZone;
	
	@NotNull(message = "El campo textoTimeZone no puede ser nulo.")
	@Column(name = "textoTimeZone", nullable = false)
	private String textoTimeZone;

	public Long getIdTimeZone() {
		return idTimeZone;
	}

	public void setIdTimeZone(Long idTimeZone) {
		this.idTimeZone = idTimeZone;
	}

	public String getTextoTimeZone() {
		return textoTimeZone;
	}

	public void setTextoTimeZone(String textoTimeZone) {
		this.textoTimeZone = textoTimeZone;
	}	
}
