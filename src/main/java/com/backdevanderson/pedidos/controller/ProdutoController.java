package com.backdevanderson.pedidos.controller;


import com.backdevanderson.pedidos.entity.Produto;
import com.backdevanderson.pedidos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findALl(){
        List<Produto> list = produtoService.findALl();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto produto){
        produtoService.insertProduto(produto);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        produto = produtoService.updateProduto(id, produto);
        return ResponseEntity.ok().body(produto);
    }
}
