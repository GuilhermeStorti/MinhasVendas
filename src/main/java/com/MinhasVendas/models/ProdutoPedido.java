/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MinhasVendas.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "produto_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoPedido.findAll", query = "SELECT p FROM ProdutoPedido p"),
    @NamedQuery(name = "ProdutoPedido.findByIdProduto", query = "SELECT p FROM ProdutoPedido p WHERE p.produtoPedidoPK.idProduto = :idProduto"),
    @NamedQuery(name = "ProdutoPedido.findByIdPedido", query = "SELECT p FROM ProdutoPedido p WHERE p.produtoPedidoPK.idPedido = :idPedido"),
    @NamedQuery(name = "ProdutoPedido.findByQuantidade", query = "SELECT p FROM ProdutoPedido p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "ProdutoPedido.findByValorParcial", query = "SELECT p FROM ProdutoPedido p WHERE p.valorParcial = :valorParcial")})
public class ProdutoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutoPedidoPK produtoPedidoPK;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_parcial")
    private Float valorParcial;

    public ProdutoPedido() {
    }

    public ProdutoPedido(ProdutoPedidoPK produtoPedidoPK) {
        this.produtoPedidoPK = produtoPedidoPK;
    }

    public ProdutoPedido(long idProduto, long idPedido) {
        this.produtoPedidoPK = new ProdutoPedidoPK(idProduto, idPedido);
    }

    public ProdutoPedidoPK getProdutoPedidoPK() {
        return produtoPedidoPK;
    }

    public void setProdutoPedidoPK(ProdutoPedidoPK produtoPedidoPK) {
        this.produtoPedidoPK = produtoPedidoPK;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(Float valorParcial) {
        this.valorParcial = valorParcial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoPedidoPK != null ? produtoPedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoPedido)) {
            return false;
        }
        ProdutoPedido other = (ProdutoPedido) object;
        if ((this.produtoPedidoPK == null && other.produtoPedidoPK != null) || (this.produtoPedidoPK != null && !this.produtoPedidoPK.equals(other.produtoPedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeando.ProdutoPedido[ produtoPedidoPK=" + produtoPedidoPK + " ]";
    }
    
}
