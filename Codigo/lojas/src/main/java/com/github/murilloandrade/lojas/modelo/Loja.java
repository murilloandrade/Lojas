package com.github.murilloandrade.lojas.modelo;

import javax.persistence.*;
import java.util.*;

@Entity
public class Loja extends ObjetoPadrao {
    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY)
    private List<Produto> produtosList = new ArrayList<>();

    private String nome;
    private String estado;
    private String cidade;
    private String bairro;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(List<Produto> produtosList) {
        this.produtosList = produtosList;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "id=" + this.getId() +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", produtosList=" + produtosList +
                '}';
    }
}
