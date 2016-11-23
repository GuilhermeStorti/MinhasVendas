package com.curso.entidades;

/**
 * Created by guilherme on 22/11/16.
 */
public class Graficos {

    public Graficos() {
    }

    public Graficos(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    private String descricao;
    private int quantidade;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
