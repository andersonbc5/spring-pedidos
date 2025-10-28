package com.backdevanderson.pedidos.service;


import com.backdevanderson.pedidos.entity.ItemPedido;
import com.backdevanderson.pedidos.repository.ItemPedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemPedidoService {

    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido insert(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public List<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido findById(Long id) {
        return itemPedidoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("ID não encontrado"));
    }

    public void deletar(Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public ItemPedido update(Long id, ItemPedido itemPedido) {
        ItemPedido itemExistente = itemPedidoRepository.getReferenceById(id);

        itemExistente.setQuantidade(itemPedido.getQuantidade());
        itemExistente.setPrecoUnitario(itemPedido.getPrecoUnitario());
        itemExistente.setProduto(itemPedido.getProduto());
        itemExistente.setPedido(itemPedido.getPedido());

        return itemPedidoRepository.save(itemExistente);


    }
}
