package com.example.CadastroDeNinjas.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    // save() -> (Cria e Atualiza)
    // findAll() -> (Lê todos)
    // findById() -> (Lê um por ID)
    // deleteById() -> (Deleta)
}