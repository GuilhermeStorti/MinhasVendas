/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MinhasVendas.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author guilherme
 */
@Embeddable
public class ProdutoPedidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_produto")
    private long idProduto;
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private long idPedido;

    public ProdutoPedidoPK() {
    }

    public ProdutoPedidoPK(long idProduto, long idPedido) {
        this.idProduto = idProduto;
        this.idPedido = idPedido;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduto;
        hash += (int) idPedido;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoPedidoPK)) {
            return false;
        }
        ProdutoPedidoPK other = (ProdutoPedidoPK) object;
        if (this.idProduto != other.idProduto) {
            return false;
        }
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeando.ProdutoPedidoPK[ idProduto=" + idProduto + ", idPedido=" + idPedido + " ]";
    }
    
}
