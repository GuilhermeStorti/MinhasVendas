-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 27/11/2016 às 18:57
-- Versão do servidor: 10.1.16-MariaDB
-- Versão do PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `locacao`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Avaria`
--

CREATE TABLE `Avaria` (
  `idAvaria` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Avaria`
--

INSERT INTO `Avaria` (`idAvaria`, `descricao`) VALUES
(2, 'Batida');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Categoria`
--

CREATE TABLE `Categoria` (
  `idCategoria` int(11) NOT NULL,
  `preco` decimal(18,2) DEFAULT NULL,
  `descricao` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Categoria`
--

INSERT INTO `Categoria` (`idCategoria`, `preco`, `descricao`) VALUES
(24, '12.50', 'Sedã'),
(25, '10.00', 'Hatch'),
(26, '15.00', 'SUV'),
(27, '20.00', 'Caminhonete');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Cliente`
--

CREATE TABLE `Cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `cpf` varchar(12) DEFAULT NULL,
  `cnh` varchar(15) DEFAULT NULL,
  `situacao` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Cliente`
--

INSERT INTO `Cliente` (`idCliente`, `nome`, `telefone`, `cpf`, `cnh`, `situacao`) VALUES
(1, 'Jorge', '1122', '1222', '2212', 'I'),
(2, 'asdas', '1122', '1222', '2212', 'I'),
(3, 'Guilherme', '1234', '12345', '123456', 'I'),
(4, 'Rodolfo', '124578', '1245789', '1245786', 'I'),
(5, 'Testando', '1234', '564654', '6484', 'I'),
(6, 'asdas', '12423', '12312', '1231', 'A'),
(7, 'Guilherme Lindo', '32172480', '101361', '', 'A'),
(8, 'Guilherme', '', '12345', '', 'A'),
(9, 'Eduarda', '1234', '12345', '123456', 'I'),
(10, 'teste', '1', '12', '123', 'A'),
(11, 'Eduarda', '11112222', '1111111', '2222222', 'A'),
(12, 'asdas', '12', '212', '21', 'A'),
(13, 'e24123', '21312', '121', '1221', 'I'),
(14, 'e24123', '21312', '121', '1221', 'I');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Funcionario`
--

CREATE TABLE `Funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `senha` varchar(6) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `data_nascimento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Funcionario`
--

INSERT INTO `Funcionario` (`idfuncionario`, `matricula`, `nome`, `usuario`, `senha`, `cpf`, `data_nascimento`) VALUES
(1, '123', 'Guilherme', 'gui', '123', '123.456.789-10', '2015-04-01'),
(2, '321', 'Gaucho', 'gauchin', '123', '111.111.111-11', '2016-11-02');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Locacao`
--

CREATE TABLE `Locacao` (
  `idLocacao` int(11) NOT NULL,
  `idVeiculo` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idFuncionario_cad` int(11) NOT NULL,
  `idFuncionario_rec` int(11) DEFAULT NULL,
  `data_locacao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Locacao`
--

INSERT INTO `Locacao` (`idLocacao`, `idVeiculo`, `idCliente`, `idFuncionario_cad`, `idFuncionario_rec`, `data_locacao`) VALUES
(1, 6, 3, 1, NULL, NULL),
(2, 5, 3, 1, NULL, '2016-11-23'),
(3, 7, 3, 1, NULL, '2016-11-23'),
(4, 6, 3, 1, NULL, '2016-11-23'),
(5, 6, 3, 1, NULL, '2016-11-25'),
(6, 6, 3, 1, NULL, '2016-11-25'),
(7, 9, 3, 1, NULL, '2016-11-04');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Locacao_Avaria`
--

CREATE TABLE `Locacao_Avaria` (
  `idAvaria` int(11) NOT NULL,
  `idLocacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Locacao_Multa`
--

CREATE TABLE `Locacao_Multa` (
  `idLocacao` int(11) NOT NULL,
  `idMulta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Multa`
--

CREATE TABLE `Multa` (
  `idMulta` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `valor` double(10,0) NOT NULL,
  `idVeiculo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Multa`
--

INSERT INTO `Multa` (`idMulta`, `descricao`, `valor`, `idVeiculo`) VALUES
(3, 'Teste', 100, 8);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Veiculo`
--

CREATE TABLE `Veiculo` (
  `idVeiculo` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `modelo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Veiculo`
--

INSERT INTO `Veiculo` (`idVeiculo`, `idCategoria`, `marca`, `placa`, `modelo`) VALUES
(5, 24, 'Chevrolet', 'ccc1111', 'Prisma'),
(6, 24, 'Fiat', 'fff1111', 'Siena'),
(7, 24, 'Fiat', 'fff222', 'Gran Siena'),
(8, 24, 'Chevrolet', 'ccc222', 'Cruze'),
(9, 24, 'VolksWagen', 'vvv1111', 'Voyage'),
(10, 24, 'VolksWagen', 'vvv2222', 'Jetta'),
(11, 25, 'VolksWagen', 'vvv3333', 'Gol'),
(12, 25, 'VolksWagen', 'vvv4444', 'Fox'),
(13, 25, 'Peugeot', 'ppp1111', '208'),
(14, 25, 'Citroen', 'cit1111', 'c3'),
(15, 25, 'Renault', 'ren1111', 'Clio'),
(16, 25, 'Renault', 'ren2222', 'Sandero'),
(17, 26, 'Renault', 'ren3333', 'Duster'),
(18, 26, 'Honda', 'hon1111', 'HRV'),
(19, 26, 'Nissan', 'nis1111', 'Kicks'),
(20, 26, 'Ford', 'for1111', 'EcoSport'),
(21, 27, 'Ford', 'for2222', 'Ranger'),
(22, 27, 'VolksWagen', 'vvv1234', 'Amarok'),
(23, 27, 'Chevrolet', 'ccc4737', 's10'),
(24, 25, 'Hyundai', 'hyu2020', 'HB20'),
(25, 27, 'Dodge', 'dod1500', 'Ram'),
(26, 25, 'VolksWagen', 'fus0001', 'Fusca');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `Avaria`
--
ALTER TABLE `Avaria`
  ADD PRIMARY KEY (`idAvaria`);

--
-- Índices de tabela `Categoria`
--
ALTER TABLE `Categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Índices de tabela `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Índices de tabela `Funcionario`
--
ALTER TABLE `Funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- Índices de tabela `Locacao`
--
ALTER TABLE `Locacao`
  ADD PRIMARY KEY (`idLocacao`),
  ADD KEY `fk_Locacao_Veiculo1_idx` (`idVeiculo`),
  ADD KEY `fk_Locacao_Cliente1_idx` (`idCliente`),
  ADD KEY `fk_Locacao_Funcionario1_idx` (`idFuncionario_cad`),
  ADD KEY `fk_Locacao_Funcionario2_idx` (`idFuncionario_rec`);

--
-- Índices de tabela `Locacao_Avaria`
--
ALTER TABLE `Locacao_Avaria`
  ADD PRIMARY KEY (`idAvaria`,`idLocacao`),
  ADD KEY `fk_Avaria_has_Locacao_Locacao1_idx` (`idLocacao`),
  ADD KEY `fk_Avaria_has_Locacao_Avaria1_idx` (`idAvaria`);

--
-- Índices de tabela `Locacao_Multa`
--
ALTER TABLE `Locacao_Multa`
  ADD PRIMARY KEY (`idLocacao`,`idMulta`),
  ADD KEY `fk_Locacao_has_Multa_Multa1_idx` (`idMulta`),
  ADD KEY `fk_Locacao_has_Multa_Locacao1_idx` (`idLocacao`);

--
-- Índices de tabela `Multa`
--
ALTER TABLE `Multa`
  ADD PRIMARY KEY (`idMulta`),
  ADD KEY `idVeiculo` (`idVeiculo`);

--
-- Índices de tabela `Veiculo`
--
ALTER TABLE `Veiculo`
  ADD PRIMARY KEY (`idVeiculo`),
  ADD KEY `fk_Veiculo_Categoria_idx` (`idCategoria`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `Avaria`
--
ALTER TABLE `Avaria`
  MODIFY `idAvaria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `Categoria`
--
ALTER TABLE `Categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT de tabela `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de tabela `Funcionario`
--
ALTER TABLE `Funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `Locacao`
--
ALTER TABLE `Locacao`
  MODIFY `idLocacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de tabela `Multa`
--
ALTER TABLE `Multa`
  MODIFY `idMulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de tabela `Veiculo`
--
ALTER TABLE `Veiculo`
  MODIFY `idVeiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `Locacao`
--
ALTER TABLE `Locacao`
  ADD CONSTRAINT `fk_Locacao_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Funcionario1` FOREIGN KEY (`idFuncionario_cad`) REFERENCES `Funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Funcionario2` FOREIGN KEY (`idFuncionario_rec`) REFERENCES `Funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Veiculo1` FOREIGN KEY (`idVeiculo`) REFERENCES `Veiculo` (`idVeiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `Locacao_Avaria`
--
ALTER TABLE `Locacao_Avaria`
  ADD CONSTRAINT `fk_Avaria_has_Locacao_Avaria1` FOREIGN KEY (`idAvaria`) REFERENCES `Avaria` (`idAvaria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Avaria_has_Locacao_Locacao1` FOREIGN KEY (`idLocacao`) REFERENCES `Locacao` (`idLocacao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `Locacao_Multa`
--
ALTER TABLE `Locacao_Multa`
  ADD CONSTRAINT `fk_Locacao_has_Multa_Locacao1` FOREIGN KEY (`idLocacao`) REFERENCES `Locacao` (`idLocacao`),
  ADD CONSTRAINT `fk_Locacao_has_Multa_Multa1` FOREIGN KEY (`idMulta`) REFERENCES `Multa` (`idMulta`);

--
-- Restrições para tabelas `Multa`
--
ALTER TABLE `Multa`
  ADD CONSTRAINT `Multa_ibfk_1` FOREIGN KEY (`idVeiculo`) REFERENCES `Veiculo` (`idVeiculo`);

--
-- Restrições para tabelas `Veiculo`
--
ALTER TABLE `Veiculo`
  ADD CONSTRAINT `fk_Veiculo_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `Categoria` (`idCategoria`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
