package com.example.CadastroDeNinjas.Cliente;

import com.example.CadastroDeNinjas.Carros.CarrosModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_clientes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    @JsonIgnoreProperties("carro") // Evita um loop infinito ao buscar os dados
    private CarrosModel carro;

}