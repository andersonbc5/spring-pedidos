package com.backdevanderson.pedidos.service;


import com.backdevanderson.pedidos.entity.Cliente;
import com.backdevanderson.pedidos.exceptions.RecursoNaoEncontradoException;
import com.backdevanderson.pedidos.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente insertCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id).
                orElseThrow(()->  new RecursoNaoEncontradoException("ID não encontrado " + id));
    }

    public void deleteCliente(Long id){
        if (!clienteRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Não foi possível excluir. Cliente com ID " + id + " não encontrado");
        }
    }

    public Cliente updateCliente(Long id, Cliente cliente){
        Cliente update = clienteRepository.getReferenceById(id);

        update.setNome(cliente.getNome());
        update.setEmail(cliente.getEmail());
        update.setCpf(cliente.getCpf());

        return clienteRepository.save(update);
    }
}
