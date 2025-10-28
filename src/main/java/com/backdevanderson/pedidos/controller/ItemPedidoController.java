package com.backdevanderson.pedidos.controller;


import com.backdevanderson.pedidos.entity.ItemPedido;
import com.backdevanderson.pedidos.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/itens")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll(){
        List<ItemPedido> list = itemPedidoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemPedido> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(itemPedidoService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        itemPedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
