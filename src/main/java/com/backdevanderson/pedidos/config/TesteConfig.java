package com.backdevanderson.pedidos.config;


import com.backdevanderson.pedidos.entity.Cliente;
import com.backdevanderson.pedidos.entity.Produto;
import com.backdevanderson.pedidos.repository.ClienteRepository;
import com.backdevanderson.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public void run(String... args) throws Exception {

        Cliente cliente1 = new Cliente(null, "Anderson Costa", "anderson@gmail.com", "47233289809");
        Cliente cliente2 = new Cliente(null, "Joice Mileni", "joice@gmail.com", "50063420805");

        Produto produto1 = new Produto(null,"Monitor",2000.0);
        Produto produto2 = new Produto(null,"Notebook",5000.0);
        Produto produto3 = new Produto(null,"PS5",3500.0);

        clienteRepository.saveAll(Arrays.asList(cliente1,cliente2));
        produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
    }
}
