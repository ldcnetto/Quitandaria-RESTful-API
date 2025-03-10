package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "produto")
    private Set<ProdutoFornecedor> produtosFornecedores;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "produto")
    private Set<ItemVenda> itensVenda;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "produto", cascade = CascadeType.ALL)
    private Estoque estoque;

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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Set<ProdutoFornecedor> getProdutosFornecedores() {
        return produtosFornecedores;
    }

    public void setProdutosFornecedores(Set<ProdutoFornecedor> produtosFornecedores) {
        this.produtosFornecedores = produtosFornecedores;
    }

    public Set<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(Set<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
