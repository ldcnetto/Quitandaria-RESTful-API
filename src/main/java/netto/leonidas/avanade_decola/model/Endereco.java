package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Enderecos")
public class Endereco {
    @Id
    @Column(name = "cep", nullable = false)
    private int cep;

    @Column(name = "logradouro", nullable = false, length = 50)
    private String logradouro;

    @Column(name = "bairro", nullable = false, length = 50)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 20)
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoEndereco tipo;

    @OneToMany(mappedBy = "endereco")
    private Set<Cliente> clientes;

    @OneToMany(mappedBy = "endereco")
    private Set<Funcionario> funcionarios;

    @OneToMany(mappedBy = "endereco")
    private Set<Fornecedor> fornecedores;

    @OneToMany(mappedBy = "endereco")
    private Set<Transportadora> transportadoras;

    // Enum para o tipo de endereço
    public enum TipoEndereco {
        Cliente, Funcionario, Fornecedor, Transportadora
    }

    public Set<Transportadora> getTransportadoras() {
        return transportadoras;
    }

    public void setTransportadoras(Set<Transportadora> transportadoras) {
        this.transportadoras = transportadoras;
    }

    public Set<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Set<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
}
