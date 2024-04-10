package com.fonyou.evaluator.evaluatormodels.outputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaDTO {

    private Long idPregunta;
    private String textoPregunta;
    private String respuestaA;
    private String respuestaB;
    private String respuestaC;
    private String respuestaD;
    private String respuestaOk;
    private int puntaje;
}
