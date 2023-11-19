package mercadoria;

import utilitarios.TipoDeProduto;

import java.io.Serializable;

public class Produto implements Serializable {
    private final String descricao;
    private final long codigoDeBarras;
    private final double preco;
    private final TipoDeProduto tipo;
    private int quantidade = 1;

    public Produto(String descricao, long codigoDeBarras, double preco, TipoDeProduto tipo) {
        this.descricao = descricao;
        this.codigoDeBarras = codigoDeBarras;
        this.preco = preco;
        this.tipo = tipo;
    }

    public long getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public double getPreco() {
        return preco;
    }

    public TipoDeProduto getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return  quantidade + "x " +
                "Descrição: " + descricao + " " +
                "Código: " + codigoDeBarras + " " +
                "Tipo: " + tipo + " " +
                "Preço: R$" + preco;
    }
}
