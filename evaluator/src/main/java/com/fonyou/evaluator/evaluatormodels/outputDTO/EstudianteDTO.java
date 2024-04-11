package com.fonyou.evaluator.evaluatormodels.outputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {

    private Long idEstudiante;
    private String nombreEstudiante;
    private Integer edadEstudiante;
    private String ciudadEstudiante;
    private String timeZoneEstudiante;
}
