-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 24/10/2016 às 11:14
-- Versão do servidor: 10.1.13-MariaDB
-- Versão do PHP: 7.0.6

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

-- --------------------------------------------------------

--
-- Estrutura para tabela `Categoria`
--

CREATE TABLE `Categoria` (
  `idCategoria` int(11) NOT NULL,
  `preco` decimal(18,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Cliente`
--

CREATE TABLE `Cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `cpf` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Funcionario`
--

CREATE TABLE `Funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `senha` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Locacao`
--

CREATE TABLE `Locacao` (
  `idLocacao` int(11) NOT NULL,
  `idVeiculo` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idFuncionario_cad` int(11) NOT NULL,
  `idFuncionario_rec` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Veiculo`
--

CREATE TABLE `Veiculo` (
  `idVeiculo` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD PRIMARY KEY (`idMulta`);

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
  MODIFY `idAvaria` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `Categoria`
--
ALTER TABLE `Categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `Funcionario`
--
ALTER TABLE `Funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `Locacao`
--
ALTER TABLE `Locacao`
  MODIFY `idLocacao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `Multa`
--
ALTER TABLE `Multa`
  MODIFY `idMulta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `Veiculo`
--
ALTER TABLE `Veiculo`
  MODIFY `idVeiculo` int(11) NOT NULL AUTO_INCREMENT;
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
-- Restrições para tabelas `Veiculo`
--
ALTER TABLE `Veiculo`
  ADD CONSTRAINT `fk_Veiculo_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `Categoria` (`idCategoria`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
