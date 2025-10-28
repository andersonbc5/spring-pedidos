package com.backdevanderson.pedidos.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErroResposta {

    private Instant timestamp;
    private Integer status;
    private String erro;
    private String msg;
    private String caminho;
}
