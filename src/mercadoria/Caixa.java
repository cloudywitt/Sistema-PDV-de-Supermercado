package mercadoria;

import utilitarios.TipoDeProduto;
import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private List<Produto> carrinho = new ArrayList<>();
    private boolean temItemRestrito;
    private double totalDaCompra;

    /**
     * Adiciona um produto no carrinho, soma o preço ao totalDaCompra e
     * verifica se um item de venda somente para adultos foi adicionado
     * para modificar a variável temItemRestrito.
     *
     * @param p Produto que vai ser adicionado.
     */
    public void adicionarProduto(Produto p) {
        if (p.getTipo() == TipoDeProduto.ADULTO) {
            this.temItemRestrito = true;
        }

        this.totalDaCompra += p.getPreco();

        this.carrinho.add(p);
    }
}
