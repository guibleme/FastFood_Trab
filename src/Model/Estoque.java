package Model;

/**
 *
 * @author Eduardo
 */
public class Estoque {
    private int cod_Item_Estoque;
    private String descricao;
    private int quantidade;
    private String tipo_Quantidade; 

    public int getCod_Item_Estoque() {
        return cod_Item_Estoque;
    }

    public void setCod_Item_Estoque(int cod_Item_Estoque) {
        this.cod_Item_Estoque = cod_Item_Estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo_Quantidade() {
        return tipo_Quantidade;
    }

    public void setTipo_Quantidade(String tipo_Quantidade) {
        this.tipo_Quantidade = tipo_Quantidade;
    }
}
