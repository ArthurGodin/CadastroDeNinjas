package com.example.CadastroDeNinjas.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // create
    public ClienteModel criarCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    // ler
    public List<ClienteModel> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    // ler por ID
    public Optional<ClienteModel> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // atualizar
    public ClienteModel atualizarCliente(Long id, ClienteModel clienteDetails) {
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o id: " + id));

        cliente.setNome(clienteDetails.getNome());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setIdade(clienteDetails.getIdade());
        cliente.setCarro(clienteDetails.getCarro()); // atualiza o carro

        return clienteRepository.save(cliente);
    }

    // deletar
    public void deletarCliente(Long id) {
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o id: " + id));

        clienteRepository.delete(cliente);
    }
}