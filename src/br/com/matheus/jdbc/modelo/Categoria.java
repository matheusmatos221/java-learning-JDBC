package br.com.matheus.jdbc.modelo;

import br.com.matheus.jdbc.dao.CategoriaDAO;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Integer id;
    private String nome;
    private List<Produto> produtos = new ArrayList<Produto>();

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

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
