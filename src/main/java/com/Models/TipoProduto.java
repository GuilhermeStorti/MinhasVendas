/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeando;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "tipo_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProduto.findAll", query = "SELECT t FROM TipoProduto t"),
    @NamedQuery(name = "TipoProduto.findByIdTipoProduto", query = "SELECT t FROM TipoProduto t WHERE t.idTipoProduto = :idTipoProduto"),
    @NamedQuery(name = "TipoProduto.findByDescricao", query = "SELECT t FROM TipoProduto t WHERE t.descricao = :descricao")})
public class TipoProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_produto")
    private Long idTipoProduto;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idTipoProduto")
    private Collection<Produto> produtoCollection;

    public TipoProduto() {
    }

    public TipoProduto(Long idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public TipoProduto(Long idTipoProduto, String descricao) {
        this.idTipoProduto = idTipoProduto;
        this.descricao = descricao;
    }

    public Long getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Long idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProduto != null ? idTipoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProduto)) {
            return false;
        }
        TipoProduto other = (TipoProduto) object;
        if ((this.idTipoProduto == null && other.idTipoProduto != null) || (this.idTipoProduto != null && !this.idTipoProduto.equals(other.idTipoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeando.TipoProduto[ idTipoProduto=" + idTipoProduto + " ]";
    }
    
}
