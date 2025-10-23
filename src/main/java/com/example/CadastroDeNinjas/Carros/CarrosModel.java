package com.example.CadastroDeNinjas.Carros;

import com.example.CadastroDeNinjas.Cliente.ClienteModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_carros")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;


    @OneToMany(mappedBy = "carro")
    @JsonIgnoreProperties("carro") // Evita um loop infinito ao buscar os dados
    private List<ClienteModel> clientes;
}