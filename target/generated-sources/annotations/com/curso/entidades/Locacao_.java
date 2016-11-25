package com.curso.entidades;

import com.curso.entidades.Avaria;
import com.curso.entidades.Cliente;
import com.curso.entidades.Funcionario;
import com.curso.entidades.Multa;
import com.curso.entidades.Veiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-25T20:04:51")
@StaticMetamodel(Locacao.class)
public class Locacao_ { 

    public static volatile SingularAttribute<Locacao, Funcionario> idFuncionariocad;
    public static volatile ListAttribute<Locacao, Avaria> avariaList;
    public static volatile SingularAttribute<Locacao, Date> dataLocacao;
    public static volatile SingularAttribute<Locacao, Cliente> idCliente;
    public static volatile SingularAttribute<Locacao, Funcionario> idFuncionariorec;
    public static volatile ListAttribute<Locacao, Multa> multaList;
    public static volatile SingularAttribute<Locacao, Veiculo> idVeiculo;
    public static volatile SingularAttribute<Locacao, Integer> idLocacao;

}