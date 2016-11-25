package com.curso.entidades;

import com.curso.entidades.Categoria;
import com.curso.entidades.Locacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-25T20:04:51")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ { 

    public static volatile SingularAttribute<Veiculo, String> marca;
    public static volatile ListAttribute<Veiculo, Locacao> locacaoList;
    public static volatile SingularAttribute<Veiculo, Integer> idVeiculo;
    public static volatile SingularAttribute<Veiculo, Categoria> idCategoria;
    public static volatile SingularAttribute<Veiculo, String> modelo;
    public static volatile SingularAttribute<Veiculo, String> placa;

}