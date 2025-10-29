INSERT INTO tb_cliente (nome, email, cpf) VALUES
('Ana Silva', 'ana.silva@email.com', '12345678900'),
('João Pereira', 'joao.pereira@email.com', '98765432100'),
('Anderson Costa', 'anderson@gmail.com', '47233289808');

INSERT INTO tb_produto (nome, preco) VALUES
('Monitor', 2000.00),
('Notebook', 5000.00),
('Teclado Mecânico', 400.00),
('Mouse Gamer', 250.00);

INSERT INTO tb_pedido (data_pedido, cliente_id) VALUES
('2019-06-20 19:53:07', 1),
('2020-07-21 10:30:00', 2),
('2025-07-23 22:22:00', 3);


INSERT INTO tb_item_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES
(1, 1, 2, 2000.00),
(2, 2, 1, 5000.00),
(2, 4, 3, 250.00),
(3, 1, 10, 2000.00);

