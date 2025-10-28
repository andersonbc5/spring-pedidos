package com.backdevanderson.pedidos.service;

import com.backdevanderson.pedidos.entity.Pedido;
import com.backdevanderson.pedidos.entity.Produto;
import com.backdevanderson.pedidos.exceptions.RecursoNaoEncontradoException;
import com.backdevanderson.pedidos.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public Pedido insertPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findALl(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id){
        return pedidoRepository.findById(id).
                orElseThrow(()-> new RecursoNaoEncontradoException("id não encontrado " + id));
    }

    public void deletePedido(Long id){
        if (!pedidoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Não foi possível excluir. Pedido com ID " + id +
                    " não encontrado");
        }
    }


}
