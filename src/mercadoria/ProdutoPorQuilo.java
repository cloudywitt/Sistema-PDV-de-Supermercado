package mercadoria;

import utilitarios.TipoDeProduto;

public class ProdutoPorQuilo extends Produto {
    private final double precoPorQuilo;
    private final double peso;

    public ProdutoPorQuilo(
            String descricao,
            long codigoDeBarras,
            double preco,
            TipoDeProduto tipo,
            double precoPorQuilo,
            double peso
    ) {
        super(descricao + peso, codigoDeBarras, preco, tipo);
        this.precoPorQuilo = precoPorQuilo;
        this.peso = peso;
    }

    @Override
    public double getPreco() {
        return precoPorQuilo * peso;
    }
}
