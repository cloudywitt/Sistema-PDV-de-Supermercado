package mercadoria;

import utilitarios.TipoDeProduto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    /**
     * Salva o estado de um produto na base de dados.
     * @param produto Objeto que será salvo em dados/produtos
     * @throws IOException Pode dar erro de diretório não existente.
     */
    public void registrarNovoProduto(Produto produto) throws IOException {
        // precisa verificar se o usuário tem permissão antes
        // leva em conta que o produto não existe no banco

        final String CAMINHO_DO_DIRETORIO = "dados/produtos/";
        final String PATH = CAMINHO_DO_DIRETORIO + produto.getCodigoDeBarras() + ".txt";

        System.out.println(PATH);

        Files.createFile(Paths.get(PATH));

        try (
            FileOutputStream arquivoDoProduto = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(arquivoDoProduto);
        ) {
            oos.writeObject(produto);
        }
    }
}
