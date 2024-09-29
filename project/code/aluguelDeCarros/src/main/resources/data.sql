INSERT INTO AGENTE (id, nome, cnpj, login, senha, tipo)
VALUES (1, 'Banco do Brasil', '12345678000100', 'bancobrasil', '1234', 'BANCO'),
       (2, 'Caixa Econômica', '98765432000100', 'caixaeconomica', 'abcd', 'BANCO'),
       (3, 'Santander', '11111111000101', 'santander', 'pass123', 'BANCO'),
       (4, 'Itaú', '22222222000102', 'itau', 'itaupass', 'BANCO'),
       (5, 'Bradesco', '33333333000103', 'bradesco', 'secure456', 'BANCO'),
       (6, 'Nubank', '44444444000104', 'nubank', 'nupass789', 'BANCO'),
       (7, 'Banco Inter', '55555555000105', 'bancointer', 'intlogin', 'BANCO'),
       (8, 'PagSeguro', '66666666000106', 'pagseguro', 'pagpass321', 'BANCO'),
       (9, 'Mercado Pago', '77777777000107', 'mercadopago', 'mpago123', 'BANCO'),
       (10, 'Original', '88888888000108', 'original', 'origpass555', 'BANCO'),
       (11, 'Loan Prime', '12345000100001', 'loanprime', 'prime123', 'EMPRESA'),
       (12, 'Credit Easy', '23456000200002', 'crediteasy', 'easyloan', 'EMPRESA'),
       (13, 'FinanCorp', '34567000300003', 'financorp', 'finsecure', 'EMPRESA'),
       (14, 'Credit Ágil', '45678000400004', 'creditagil', 'agilloan', 'EMPRESA'),
       (15, 'SoluCred', '56789000500005', 'solucred', 'solucredpass', 'EMPRESA'),
       (16, 'Emprê Rápido', '67890000600006', 'emprerapido', 'raploan', 'EMPRESA'),
       (17, 'Loan Master', '78901000700007', 'loanmaster', 'masterloan', 'EMPRESA'),
       (18, 'FinanCred', '89012000800008', 'financred', 'finpass2024', 'EMPRESA'),
       (19, 'Quick Cash', '90123000900009', 'quickcash', 'quickloan', 'EMPRESA'),
       (20, 'Cred Rápido', '11234000100010', 'credrapido', 'credrapido123', 'EMPRESA');

INSERT INTO AUTOMOVEL (ano, id, marca, matricula, modelo, placa)
VALUES
    (2024, 1, 'Volkswagen', '11222333444', 'Gol', 'QQQ-5512'),
    (2023, 2, 'Chevrolet', '22333444555', 'Onix', 'ABC-1234'),
    (2022, 3, 'Ford', '33444555666', 'Fiesta', 'XYZ-5678'),
    (2021, 4, 'Fiat', '44555666777', 'Uno', 'LMN-9087'),
    (2020, 5, 'Hyundai', '55666777888', 'HB20', 'JKL-4321'),
    (2019, 6, 'Toyota', '66777888999', 'Corolla', 'RTY-3456'),
    (2023, 7, 'Honda', '77888999000', 'Civic', 'POI-9876'),
    (2024, 8, 'Renault', '88999000111', 'Duster', 'WER-7654'),
    (2022, 9, 'Nissan', '99000111222', 'Kicks', 'BNM-2468'),
    (2021, 10, 'Jeep', '00111222333', 'Renegade', 'TRE-8523'),
    (2020, 11, 'Peugeot', '11222333444', '208', 'GHJ-1597'),
    (2019, 12, 'Citroen', '22333444555', 'C3', 'VBN-7531'),
    (2023, 13, 'BMW', '33444555666', '320i', 'UIO-9875'),
    (2024, 14, 'Mercedes-Benz', '44555666777', 'C180', 'OPA-3692'),
    (2022, 15, 'Audi', '55666777888', 'A3', 'DFG-7412'),
    (2021, 16, 'Mitsubishi', '66777888999', 'Outlander', 'ERT-9513'),
    (2020, 17, 'Kia', '77888999000', 'Sportage', 'QWE-7539'),
    (2019, 18, 'Subaru', '88999000111', 'Impreza', 'UYT-2584'),
    (2023, 19, 'Tesla', '99000111222', 'Model 3', 'ASD-9638'),
    (2024, 20, 'Land Rover', '00111222333', 'Defender', 'FGH-4562');

INSERT INTO CLIENTE (id, cpf, empregador, endereco, login, nome, profissao, rendimentos, rg, senha)
VALUES
    (21, '12345678900', 'Lojas Renner', 'Rua Marte 123 - Santa Lúcia', 'ana', 'Ana Clara Matos', 'Arquiteta', 3500.00, '12345678', '1234'),
    (22, '23456789011', 'Banco do Brasil', 'Avenida Sol 45 - Centro', 'mario', 'Mario Santos Silva', 'Gerente', 4500.00, '23456789', '5678'),
    (23, '34567890122', 'Magazine Luiza', 'Rua Júpiter 67 - São José', 'julia', 'Julia Almeida Costa', 'Designer', 4000.00, '34567890', '9101'),
    (24, '45678901233', 'Caixa Econômica', 'Rua Terra 89 - Vila Nova', 'rodrigo', 'Rodrigo Pereira Lima', 'Analista', 5200.00, '45678901', '1121'),
    (25, '56789012344', 'Petrobras', 'Avenida Lua 102 - Jardim América', 'mariana', 'Mariana Fernandes Lopes', 'Engenheira', 6000.00, '56789012', '3141'),
    (26, '67890123455', 'Correios', 'Rua Estrela 56 - Santo Antônio', 'lucas', 'Lucas Henrique Souza', 'Atendente', 3000.00, '67890123', '5161'),
    (27, '78901234566', 'Vivo', 'Rua Saturno 12 - Centro', 'isabella', 'Isabella Nogueira Rocha', 'Consultora', 4500.00, '78901234', '7181'),
    (28, '89012345677', 'Bradesco', 'Avenida Plutão 34 - São Pedro', 'carlos', 'Carlos Eduardo Alves', 'Gerente', 5200.00, '89012345', '9202'),
    (29, '90123456788', 'Gerdau', 'Rua Mercúrio 78 - Bela Vista', 'camila', 'Camila Oliveira Souza', 'Engenheira', 7000.00, '90123456', '1323'),
    (30, '01234567899', 'Oi Telecom', 'Rua Vênus 23 - Nova Lima', 'ricardo', 'Ricardo Moreira Farias', 'Técnico', 3200.00, '01234567', '3443'),
    (31, '10987654321', 'Coca-Cola', 'Avenida Marte 56 - Parque Industrial', 'beatriz', 'Beatriz Lima Mendes', 'Administradora', 4700.00, '10987654', '5464'),
    (32, '29876543210', 'Santander', 'Rua Netuno 89 - Jardim Europa', 'fernando', 'Fernando Gonçalves Pinto', 'Consultor', 4100.00, '29876543', '7485'),
    (33, '38765432109', 'Riachuelo', 'Rua Mercúrio 77 - Centro', 'luiza', 'Luiza Martins Cardoso', 'Vendedora', 2800.00, '38765432', '9506'),
    (34, '47654321098', 'Gol Linhas Aéreas', 'Avenida Terra 55 - Aeroporto', 'joao', 'João Paulo Ribeiro', 'Piloto', 8500.00, '47654321', '1626'),
    (35, '56543210987', 'Azul Linhas Aéreas', 'Rua Estrela 34 - Bairro Alto', 'daniel', 'Daniel Barbosa Leite', 'Comissário de Bordo', 5000.00, '56543210', '3747'),
    (36, '65432109876', 'Embraer', 'Rua Lua 99 - Centro', 'raquel', 'Raquel Teixeira Nunes', 'Engenheira', 8200.00, '65432109', '5868'),
    (37, '74321098765', 'Ambev', 'Avenida Júpiter 11 - Parque das Flores', 'victor', 'Victor Mendes Araújo', 'Analista', 5300.00, '74321098', '7989'),
    (38, '83210987654', 'Vale', 'Rua Sol 12 - Vila Real', 'sara', 'Sara Vieira Sousa', 'Geóloga', 7800.00, '83210987', '9009'),
    (39, '92109876543', 'Boticário', 'Avenida Plutão 44 - São Miguel', 'marcos', 'Marcos Vinícius Silva', 'Supervisor', 5500.00, '92109876', '1021'),
    (40, '10987654322', 'Lojas Americanas', 'Rua Marte 101 - Bela Vista', 'paula', 'Paula Cristina Oliveira', 'Gerente', 6300.00, '10987654', '1232');

INSERT INTO PEDIDO (id, cliente_id, agente_id, automovel_id, confirmado, contrato)
VALUES
    (1, 21, 1, 1, false, null),
    (2, 22, 2, 2, false, null),
    (3, 23, 3, 3, false, null),
    (4, 24, 4, 4, false, null),
    (5, 25, 5, 5, false, null),
    (6, 26, 6, 6, false, null),
    (7, 27, 7, 7, false, null),
    (8, 28, 8, 8, false, null),
    (9, 29, 9, 9, false, null),
    (10, 30, 10, 10, false, null),
    (11, 31, 11, 11, false, null),
    (12, 32, 12, 12, false, null),
    (13, 33, 13, 13, false, null),
    (14, 34, 14, 14, false, null),
    (15, 35, 15, 15, false, null),
    (16, 36, 16, 16, false, null),
    (17, 37, 17, 17, false, null),
    (18, 38, 18, 18, false, null),
    (19, 39, 19, 19, false, null),
    (20, 40, 20, 20, false, null);