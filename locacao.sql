-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 25-Nov-2016 às 23:32
-- Versão do servidor: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `locacao`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaria`
--

CREATE TABLE `avaria` (
  `idAvaria` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `preco` decimal(18,2) DEFAULT NULL,
  `descricao` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `preco`, `descricao`) VALUES
(24, '12.50', 'SedÃ£'),
(25, '10.00', 'Hatch'),
(26, '15.00', 'SUV'),
(27, '20.00', 'Caminhonete');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `cpf` varchar(12) DEFAULT NULL,
  `cnh` varchar(15) DEFAULT NULL,
  `situacao` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nome`, `telefone`, `cpf`, `cnh`, `situacao`) VALUES
(1, 'Jorge', '1122', '1222', '2212', 'I'),
(2, 'asdas', '1122', '1222', '2212', 'I'),
(3, 'Guilherme', '1234', '12345', '123456', 'A'),
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
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `senha` varchar(6) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `data_nascimento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idfuncionario`, `matricula`, `nome`, `usuario`, `senha`, `cpf`, `data_nascimento`) VALUES
(1, '123', 'Guilherme', 'gui', '123', '0', '2015-04-01'),
(2, '111', 'kadkakdk', 'k', '1111', '191.919.919-11', '2016-11-03');

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacao`
--

CREATE TABLE `locacao` (
  `idLocacao` int(11) NOT NULL,
  `idVeiculo` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idFuncionario_cad` int(11) NOT NULL,
  `idFuncionario_rec` int(11) DEFAULT NULL,
  `data_locacao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `locacao`
--

INSERT INTO `locacao` (`idLocacao`, `idVeiculo`, `idCliente`, `idFuncionario_cad`, `idFuncionario_rec`, `data_locacao`) VALUES
(1, 6, 3, 1, NULL, NULL),
(2, 5, 3, 1, NULL, '2016-11-23'),
(3, 7, 3, 1, NULL, '2016-11-23'),
(4, 6, 3, 1, NULL, '2016-11-23'),
(5, 6, 3, 1, NULL, '2016-11-25'),
(6, 6, 3, 1, NULL, '2016-11-25'),
(7, 9, 3, 1, NULL, '2016-11-04');

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacao_avaria`
--

CREATE TABLE `locacao_avaria` (
  `idAvaria` int(11) NOT NULL,
  `idLocacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacao_multa`
--

CREATE TABLE `locacao_multa` (
  `idLocacao` int(11) NOT NULL,
  `idMulta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `multa`
--

CREATE TABLE `multa` (
  `idMulta` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculo`
--

CREATE TABLE `veiculo` (
  `idVeiculo` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `modelo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `veiculo`
--

INSERT INTO `veiculo` (`idVeiculo`, `idCategoria`, `marca`, `placa`, `modelo`) VALUES
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
(23, 27, 'Chevrolet', 'ccc4737', 's10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `avaria`
--
ALTER TABLE `avaria`
  ADD PRIMARY KEY (`idAvaria`);

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- Indexes for table `locacao`
--
ALTER TABLE `locacao`
  ADD PRIMARY KEY (`idLocacao`),
  ADD KEY `fk_Locacao_Veiculo1_idx` (`idVeiculo`),
  ADD KEY `fk_Locacao_Cliente1_idx` (`idCliente`),
  ADD KEY `fk_Locacao_Funcionario1_idx` (`idFuncionario_cad`),
  ADD KEY `fk_Locacao_Funcionario2_idx` (`idFuncionario_rec`);

--
-- Indexes for table `locacao_avaria`
--
ALTER TABLE `locacao_avaria`
  ADD PRIMARY KEY (`idAvaria`,`idLocacao`),
  ADD KEY `fk_Avaria_has_Locacao_Locacao1_idx` (`idLocacao`),
  ADD KEY `fk_Avaria_has_Locacao_Avaria1_idx` (`idAvaria`);

--
-- Indexes for table `locacao_multa`
--
ALTER TABLE `locacao_multa`
  ADD PRIMARY KEY (`idLocacao`,`idMulta`),
  ADD KEY `fk_Locacao_has_Multa_Multa1_idx` (`idMulta`),
  ADD KEY `fk_Locacao_has_Multa_Locacao1_idx` (`idLocacao`);

--
-- Indexes for table `multa`
--
ALTER TABLE `multa`
  ADD PRIMARY KEY (`idMulta`);

--
-- Indexes for table `veiculo`
--
ALTER TABLE `veiculo`
  ADD PRIMARY KEY (`idVeiculo`),
  ADD KEY `fk_Veiculo_Categoria_idx` (`idCategoria`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `avaria`
--
ALTER TABLE `avaria`
  MODIFY `idAvaria` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `locacao`
--
ALTER TABLE `locacao`
  MODIFY `idLocacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `multa`
--
ALTER TABLE `multa`
  MODIFY `idMulta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `veiculo`
--
ALTER TABLE `veiculo`
  MODIFY `idVeiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `locacao`
--
ALTER TABLE `locacao`
  ADD CONSTRAINT `fk_Locacao_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Funcionario1` FOREIGN KEY (`idFuncionario_cad`) REFERENCES `funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Funcionario2` FOREIGN KEY (`idFuncionario_rec`) REFERENCES `funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Veiculo1` FOREIGN KEY (`idVeiculo`) REFERENCES `veiculo` (`idVeiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `locacao_avaria`
--
ALTER TABLE `locacao_avaria`
  ADD CONSTRAINT `fk_Avaria_has_Locacao_Avaria1` FOREIGN KEY (`idAvaria`) REFERENCES `avaria` (`idAvaria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Avaria_has_Locacao_Locacao1` FOREIGN KEY (`idLocacao`) REFERENCES `locacao` (`idLocacao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `locacao_multa`
--
ALTER TABLE `locacao_multa`
  ADD CONSTRAINT `fk_Locacao_has_Multa_Locacao1` FOREIGN KEY (`idLocacao`) REFERENCES `locacao` (`idLocacao`),
  ADD CONSTRAINT `fk_Locacao_has_Multa_Multa1` FOREIGN KEY (`idMulta`) REFERENCES `multa` (`idMulta`);

--
-- Limitadores para a tabela `veiculo`
--
ALTER TABLE `veiculo`
  ADD CONSTRAINT `fk_Veiculo_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
