package com.curso.entidades;

import com.curso.entidades.Locacao;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-25T20:04:51")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, String> senha;
    public static volatile SingularAttribute<Funcionario, Integer> idfuncionario;
    public static volatile ListAttribute<Funcionario, Locacao> locacaoList;
    public static volatile SingularAttribute<Funcionario, String> matricula;
    public static volatile SingularAttribute<Funcionario, String> cpf;
    public static volatile ListAttribute<Funcionario, Locacao> locacaoList1;
    public static volatile SingularAttribute<Funcionario, String> nome;
    public static volatile SingularAttribute<Funcionario, String> usuario;
    public static volatile SingularAttribute<Funcionario, Date> dataNascimento;

}