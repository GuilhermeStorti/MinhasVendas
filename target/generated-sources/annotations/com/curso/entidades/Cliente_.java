package com.curso.entidades;

import com.curso.entidades.Locacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-25T20:04:51")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> telefone;
    public static volatile SingularAttribute<Cliente, Character> situacao;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile ListAttribute<Cliente, Locacao> locacaoList;
    public static volatile SingularAttribute<Cliente, String> cpf;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile SingularAttribute<Cliente, String> cnh;

}