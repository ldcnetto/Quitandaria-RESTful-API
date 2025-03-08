package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Produtos_fornecedores")
public class ProdutoFornecedor {
    @EmbeddedId
    private ProdutoFornecedorId id;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @ManyToOne
    @MapsId("idFornecedor")
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    public ProdutoFornecedorId getId() {
        return id;
    }

    public void setId(ProdutoFornecedorId id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Embeddable
    public class ProdutoFornecedorId implements Serializable {
        @Column(name = "id_produto")
        private int idProduto;

        @Column(name = "id_fornecedor")
        private int idFornecedor;

        public int getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(int idProduto) {
            this.idProduto = idProduto;
        }

        public int getIdFornecedor() {
            return idFornecedor;
        }

        public void setIdFornecedor(int idFornecedor) {
            this.idFornecedor = idFornecedor;
        }
    }
}


