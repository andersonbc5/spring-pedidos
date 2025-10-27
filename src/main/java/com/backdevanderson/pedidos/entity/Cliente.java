package com.backdevanderson.pedidos.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "tb_cliente")
@Entity
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos")
    @Column(unique = true, length = 11, nullable = false)
    private String cpf;
}
