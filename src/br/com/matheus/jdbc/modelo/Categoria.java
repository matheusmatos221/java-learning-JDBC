package br.com.matheus.jdbc.modelo;

import br.com.matheus.jdbc.dao.CategoriaDAO;

public class Categoria {

    private Integer id;
    private String nome;

    public Categoria(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Integer getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString(){
        return String.format("Categoria: ID:%d |Nome: %s", this.id, this.nome);
    }
}
