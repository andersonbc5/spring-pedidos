package com.backdevanderson.pedidos.config;


import com.backdevanderson.pedidos.entity.Cliente;
import com.backdevanderson.pedidos.repository.ClienteRepository;
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


    @Override
    public void run(String... args) throws Exception {

        Cliente cliente1 = new Cliente(null, "Anderson Costa", "anderson@gmail.com", "47233289809");
        Cliente cliente2 = new Cliente(null, "Joice Mileni", "joice@gmail.com", "50063420805");

        clienteRepository.saveAll(Arrays.asList(cliente1,cliente2));
    }
}
