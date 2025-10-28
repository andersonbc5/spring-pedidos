package com.backdevanderson.pedidos.config;


import com.backdevanderson.pedidos.entity.Cliente;
import com.backdevanderson.pedidos.entity.ItemPedido;
import com.backdevanderson.pedidos.entity.Pedido;
import com.backdevanderson.pedidos.entity.Produto;
import com.backdevanderson.pedidos.repository.ClienteRepository;
import com.backdevanderson.pedidos.repository.ItemPedidoRepository;
import com.backdevanderson.pedidos.repository.PedidoRepository;
import com.backdevanderson.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    @Override
    public void run(String... args) throws Exception {


        Produto produto1 = new Produto(null,"Monitor",2000.0);
        Produto produto2 = new Produto(null,"Notebook",5000.0);
        Produto produto3 = new Produto(null,"PS5",3500.0);
        produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));


        Cliente cliente1 = Cliente.builder().nome("Anderson Costa").email("anderson@gmail.com").cpf("47233289808").build();
        Cliente cliente2 = Cliente.builder().nome("Joice Mileni").email("joicelima@gmail.com").cpf("50063420805").build();
        clienteRepository.saveAll(Arrays.asList(cliente1,cliente2));

        Pedido pedido1 = Pedido.builder()
                .data_pedido(Instant.parse("2019-06-20T19:53:07Z"))
                .cliente(cliente1)
                .build();

        Pedido pedido2 = Pedido.builder()
                .data_pedido(Instant.parse("2020-07-21T10:30:00Z"))
                .cliente(cliente2)
                .build();
        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));


        ItemPedido itemPedido1 = ItemPedido.builder()
                .pedido(pedido1)
                .produto(produto1)
                .quantidade(2)
                .precoUnitario(produto1.getPreco())
                .build();

        ItemPedido itemPedido2 = ItemPedido.builder()
                .pedido(pedido2)
                .produto(produto2)
                .quantidade(2)
                .precoUnitario(produto2.getPreco())
                .build();

        itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2));
    }


    }

