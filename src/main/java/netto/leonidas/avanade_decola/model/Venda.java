package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario funcionario;

    @Column(name = "data_hora", nullable = false)
    private String dataHora;

    @ManyToOne
    @JoinColumn(name = "id_pagamento", nullable = false)
    private FormaPagamento formaPagamento;

    @OneToMany(mappedBy = "venda")
    private Set<ItemVenda> itensVenda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Set<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(Set<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
}
