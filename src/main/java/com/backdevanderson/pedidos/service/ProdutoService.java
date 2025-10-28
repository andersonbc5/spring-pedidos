package com.backdevanderson.pedidos.service;

import com.backdevanderson.pedidos.entity.Produto;
import com.backdevanderson.pedidos.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto insertProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> findALl(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).
                orElseThrow(()-> new RuntimeException("id não encontrado"));
    }

    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto updateProduto(Long id, Produto produto){
        Produto update = produtoRepository.getReferenceById(id);

        update.setNome(produto.getNome());
        update.setPreco(produto.getPreco());

        return produtoRepository.save(update);
    }
}
