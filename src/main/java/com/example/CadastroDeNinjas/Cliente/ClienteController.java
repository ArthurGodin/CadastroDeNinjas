package com.example.CadastroDeNinjas.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes") // URL base para os clientes
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // CREATE - POST /api/clientes
    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel cliente) {
        ClienteModel novoCliente = clienteService.criarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    // READ (Todos) - GET /api/clientes
    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarClientes() {
        List<ClienteModel> clientes = clienteService.listarTodosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // READ (Por ID) - GET /api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE - PUT /api/clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel clienteDetails) {
        try {
            ClienteModel clienteAtualizado = clienteService.atualizarCliente(id, clienteDetails);
            return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - DELETE /api/clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        try {
            clienteService.deletarCliente(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}