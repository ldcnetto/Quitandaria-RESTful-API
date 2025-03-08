package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Fornecedor_PF")
public class FornecedorPF {
    @Id
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "razao_social", length = 60)
    private String razaoSocial;

    @OneToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
