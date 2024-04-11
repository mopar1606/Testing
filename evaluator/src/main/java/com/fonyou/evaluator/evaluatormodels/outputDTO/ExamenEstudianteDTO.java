package com.fonyou.evaluator.evaluatormodels.outputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamenEstudianteDTO {

    private Long idExamen;
    private Date fechaPresentacion;
    private  EstudianteDTO estudiante;
}
