/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "Locacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l")
    , @NamedQuery(name = "Locacao.findByIdLocacao", query = "SELECT l FROM Locacao l WHERE l.idLocacao = :idLocacao")
    , @NamedQuery(name = "Locacao.findByData_inicio", query = "SELECT l FROM Locacao l WHERE l.data_inicio = :data_inicio")
    , @NamedQuery(name = "Locacao.findByData_fim", query = "SELECT l FROM Locacao l WHERE l.data_fim = :data_fim")})
public class Locacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLocacao")
    private Integer idLocacao;
    @ManyToMany(mappedBy = "locacaoList")
    private List<Avaria> avariaList;
    @JoinTable(name = "Locacao_Multa", joinColumns = {
        @JoinColumn(name = "idLocacao", referencedColumnName = "idLocacao")}, inverseJoinColumns = {
        @JoinColumn(name = "idMulta", referencedColumnName = "idMulta")})
    @ManyToMany
    private List<Multa> multaList;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idFuncionario_cad", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionariocad;
    @JoinColumn(name = "idFuncionario_rec", referencedColumnName = "idfuncionario")
    @ManyToOne
    private Funcionario idFuncionariorec;
    @JoinColumn(name = "idVeiculo", referencedColumnName = "idVeiculo")
    @ManyToOne(optional = false)
    private Veiculo idVeiculo;
    @Column(name = "data_inicio")
    private Date data_inicio;
    @Column(name = "data_fim")
    private Date data_fim;

    public Locacao() {
    }

    public Locacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Integer getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    @XmlTransient
    public List<Avaria> getAvariaList() {
        return avariaList;
    }

    public void setAvariaList(List<Avaria> avariaList) {
        this.avariaList = avariaList;
    }

    @XmlTransient
    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Funcionario getIdFuncionariocad() {
        return idFuncionariocad;
    }

    public void setIdFuncionariocad(Funcionario idFuncionariocad) {
        this.idFuncionariocad = idFuncionariocad;
    }

    public Funcionario getIdFuncionariorec() {
        return idFuncionariorec;
    }

    public void setIdFuncionariorec(Funcionario idFuncionariorec) {
        this.idFuncionariorec = idFuncionariorec;
    }

    public Veiculo getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Veiculo idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocacao != null ? idLocacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locacao)) {
            return false;
        }
        Locacao other = (Locacao) object;
        if ((this.idLocacao == null && other.idLocacao != null) || (this.idLocacao != null && !this.idLocacao.equals(other.idLocacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.entidades.Locacao[ idLocacao=" + idLocacao + " ]";
    }
    
}
