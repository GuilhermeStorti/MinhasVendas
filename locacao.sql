-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 21, 2016 at 11:25 
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

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
-- Table structure for table `Avaria`
--

CREATE TABLE `Avaria` (
  `idAvaria` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Categoria`
--

CREATE TABLE `Categoria` (
  `idCategoria` int(11) NOT NULL,
  `preco` decimal(18,2) DEFAULT NULL,
  `descricao` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Categoria`
--

INSERT INTO `Categoria` (`idCategoria`, `preco`, `descricao`) VALUES
(8, '12.60', 'teste'),
(23, '12.00', 'teste2');

-- --------------------------------------------------------

--
-- Table structure for table `Cliente`
--

CREATE TABLE `Cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `cpf` int(12) DEFAULT NULL,
  `cnh` varchar(15) DEFAULT NULL,
  `situacao` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cliente`
--

INSERT INTO `Cliente` (`idCliente`, `nome`, `telefone`, `cpf`, `cnh`, `situacao`) VALUES
(1, 'Jorde', '1122', 1222, '2212', 'I'),
(2, 'asdas', '1122', 1222, '2212', 'I'),
(3, 'Guilherme', '1234', 12345, '123456', 'A'),
(4, 'Rodolfo', '124578', 1245789, '1245786', 'I'),
(5, 'Testando', '1234', 564654, '6484', 'I'),
(6, 'asdas', '12423', 12312, '1231', 'A'),
(7, 'Guilherme Lindo', '32172480', 101361, '', 'A'),
(8, 'Guilherme', '', 12345, '', 'A'),
(9, 'Eduarda', '1234', 12345, '123456', 'A'),
(10, 'teste', '1', 12, '123', 'A'),
(11, 'Eduarda', '11112222', 1111111, '2222222', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `Funcionario`
--

CREATE TABLE `Funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `senha` varchar(6) NOT NULL,
  `cpf` int(11) NOT NULL,
  `data_nascimento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Funcionario`
--

INSERT INTO `Funcionario` (`idfuncionario`, `matricula`, `nome`, `usuario`, `senha`, `cpf`, `data_nascimento`) VALUES
(1, '123', 'Guilherme', 'gui', '123', 0, '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `Locacao`
--

CREATE TABLE `Locacao` (
  `idLocacao` int(11) NOT NULL,
  `idVeiculo` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idFuncionario_cad` int(11) NOT NULL,
  `idFuncionario_rec` int(11) DEFAULT NULL,
  `data_locacao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Locacao_Avaria`
--

CREATE TABLE `Locacao_Avaria` (
  `idAvaria` int(11) NOT NULL,
  `idLocacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Locacao_Multa`
--

CREATE TABLE `Locacao_Multa` (
  `idLocacao` int(11) NOT NULL,
  `idMulta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Multa`
--

CREATE TABLE `Multa` (
  `idMulta` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Veiculo`
--

CREATE TABLE `Veiculo` (
  `idVeiculo` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `modelo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Avaria`
--
ALTER TABLE `Avaria`
  ADD PRIMARY KEY (`idAvaria`);

--
-- Indexes for table `Categoria`
--
ALTER TABLE `Categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indexes for table `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indexes for table `Funcionario`
--
ALTER TABLE `Funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- Indexes for table `Locacao`
--
ALTER TABLE `Locacao`
  ADD PRIMARY KEY (`idLocacao`),
  ADD KEY `fk_Locacao_Veiculo1_idx` (`idVeiculo`),
  ADD KEY `fk_Locacao_Cliente1_idx` (`idCliente`),
  ADD KEY `fk_Locacao_Funcionario1_idx` (`idFuncionario_cad`),
  ADD KEY `fk_Locacao_Funcionario2_idx` (`idFuncionario_rec`);

--
-- Indexes for table `Locacao_Avaria`
--
ALTER TABLE `Locacao_Avaria`
  ADD PRIMARY KEY (`idAvaria`,`idLocacao`),
  ADD KEY `fk_Avaria_has_Locacao_Locacao1_idx` (`idLocacao`),
  ADD KEY `fk_Avaria_has_Locacao_Avaria1_idx` (`idAvaria`);

--
-- Indexes for table `Locacao_Multa`
--
ALTER TABLE `Locacao_Multa`
  ADD PRIMARY KEY (`idLocacao`,`idMulta`),
  ADD KEY `fk_Locacao_has_Multa_Multa1_idx` (`idMulta`),
  ADD KEY `fk_Locacao_has_Multa_Locacao1_idx` (`idLocacao`);

--
-- Indexes for table `Multa`
--
ALTER TABLE `Multa`
  ADD PRIMARY KEY (`idMulta`);

--
-- Indexes for table `Veiculo`
--
ALTER TABLE `Veiculo`
  ADD PRIMARY KEY (`idVeiculo`),
  ADD KEY `fk_Veiculo_Categoria_idx` (`idCategoria`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Avaria`
--
ALTER TABLE `Avaria`
  MODIFY `idAvaria` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Categoria`
--
ALTER TABLE `Categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `Funcionario`
--
ALTER TABLE `Funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Locacao`
--
ALTER TABLE `Locacao`
  MODIFY `idLocacao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Multa`
--
ALTER TABLE `Multa`
  MODIFY `idMulta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Veiculo`
--
ALTER TABLE `Veiculo`
  MODIFY `idVeiculo` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Locacao`
--
ALTER TABLE `Locacao`
  ADD CONSTRAINT `fk_Locacao_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Funcionario1` FOREIGN KEY (`idFuncionario_cad`) REFERENCES `Funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Funcionario2` FOREIGN KEY (`idFuncionario_rec`) REFERENCES `Funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Veiculo1` FOREIGN KEY (`idVeiculo`) REFERENCES `Veiculo` (`idVeiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Locacao_Avaria`
--
ALTER TABLE `Locacao_Avaria`
  ADD CONSTRAINT `fk_Avaria_has_Locacao_Avaria1` FOREIGN KEY (`idAvaria`) REFERENCES `Avaria` (`idAvaria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Avaria_has_Locacao_Locacao1` FOREIGN KEY (`idLocacao`) REFERENCES `Locacao` (`idLocacao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Locacao_Multa`
--
ALTER TABLE `Locacao_Multa`
  ADD CONSTRAINT `fk_Locacao_has_Multa_Locacao1` FOREIGN KEY (`idLocacao`) REFERENCES `Locacao` (`idLocacao`),
  ADD CONSTRAINT `fk_Locacao_has_Multa_Multa1` FOREIGN KEY (`idMulta`) REFERENCES `Multa` (`idMulta`);

--
-- Constraints for table `Veiculo`
--
ALTER TABLE `Veiculo`
  ADD CONSTRAINT `fk_Veiculo_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `Categoria` (`idCategoria`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
