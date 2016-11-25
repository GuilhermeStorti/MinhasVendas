package com.curso.entidades;

import com.curso.entidades.Veiculo;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-25T20:04:51")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, BigDecimal> preco;
    public static volatile ListAttribute<Categoria, Veiculo> veiculoList;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile SingularAttribute<Categoria, String> descricao;

}