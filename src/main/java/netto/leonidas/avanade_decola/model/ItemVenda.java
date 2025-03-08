package netto.leonidas.avanade_decola.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Itens_venda")
public class ItemVenda {
    @EmbeddedId
    private ItemVendaId id;

    @ManyToOne
    @MapsId("idVenda")
    @JoinColumn(name = "id_venda", nullable = false)
    private Venda venda;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    public ItemVendaId getId() {
        return id;
    }

    public void setId(ItemVendaId id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Embeddable
    public class ItemVendaId implements Serializable {
        @Column(name = "id_venda")
        private int idVenda;

        @Column(name = "id_produto")
        private int idProduto;

        public int getIdVenda() {
            return idVenda;
        }

        public void setIdVenda(int idVenda) {
            this.idVenda = idVenda;
        }

        public int getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(int idProduto) {
            this.idProduto = idProduto;
        }
    }
}
