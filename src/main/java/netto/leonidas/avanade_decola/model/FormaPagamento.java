package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Formas_pagamento")
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "descricao", nullable = false, length = 20)
    private String descricao;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "formaPagamento")
    private Set<Venda> vendas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }
}
