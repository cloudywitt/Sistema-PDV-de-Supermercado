package mercadoria;

import utilitarios.TipoDeProduto;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Caixa {
    public Map<Long, Produto> BancoDeProdutos = new HashMap<>();

    private List<Produto> carrinho = new ArrayList<>();
    private boolean temItemRestrito;
    private double totalDaCompra;

    /**
     * Lê todos os arquivos de um dado caminho contendo objetos de produtos e armazena em BancoDeProdutos.
     * @param CAMINHO_PARA_PRODUTOS Lugar de onde será lido os arquivos dos produtos.
     * @throws IOException Pode não conseguir abrir o arquivo
     * @throws ClassNotFoundException Pode não achar o objeto ou ele não ser compatível.
     */
    public void carregarProdutos(final Path CAMINHO_PARA_PRODUTOS) throws IOException, ClassNotFoundException {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(CAMINHO_PARA_PRODUTOS)) {
            for (Path file : directoryStream) {
                Produto produto = this.lerProduto(file.toString());
                BancoDeProdutos.put(produto.getCodigoDeBarras(), produto);
            }
        }
    }

    /**
     * Adiciona um produto no carrinho, soma o preço ao totalDaCompra e
     * verifica se um item de venda somente para adultos foi adicionado
     * para modificar a variável temItemRestrito.
     *
     * @param produto Produto que vai ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        if (produto.getTipo() == TipoDeProduto.ADULTO) {
            this.temItemRestrito = true;
        }

        this.totalDaCompra += produto.getPreco();

        this.carrinho.add(produto);
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
        final String CAMINHO_DOS_PRODUTOS = CAMINHO_DO_DIRETORIO + produto.getCodigoDeBarras() + ".txt";

        System.out.println(CAMINHO_DOS_PRODUTOS);

        Files.createFile(Paths.get(CAMINHO_DOS_PRODUTOS));

        try (
            FileOutputStream arquivoDoProduto = new FileOutputStream(CAMINHO_DOS_PRODUTOS);
            ObjectOutputStream oos = new ObjectOutputStream(arquivoDoProduto);
        ) {
            oos.writeObject(produto);
        }
    }

    /**
     *
     * @param caminho Caminho para o arquivo do produto.
     * @return Retorna uma classe do tipo Produto com as informações do produto.
     * @throws IOException Pode não encontrar o arquivo/classe ou não conseguir abri-lo.
     */
    public Produto lerProduto(final String CAMINHO_DO_PRODUTO) throws IOException, ClassNotFoundException {
        FileInputStream arquivoProduto = new FileInputStream(CAMINHO_DO_PRODUTO);
        ObjectInputStream objectStream = new ObjectInputStream(arquivoProduto);

        return (Produto) objectStream.readObject();
    }

    public void fecharCompra(double valorRecebido) {
        // tem que limpar a lista de compra, validar as formas de pagamento etc.

        gerarNotaFiscal();
        carrinho.clear();
        totalDaCompra = 0.0;
    }

    public void gerarNotaFiscal() {
        final String CAMINHO_DA_NOTA = "dados/nota.txt";

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(CAMINHO_DA_NOTA))) {
            writer.write("|--------------- ANGELO SUPERMERCADOS --------------|\n");
            writer.write("|---------------------------------------------------|\n");
            writer.write("|-------------------- NOTA FISCAL ------------------|\n");
            // writer.write("| CAIXA: " + this.funcionario.id + "              DATA: " |\n");
            writer.write("| CAIXA:                                  DATA:     |\n");
            writer.write("| UNIDADE             PRODUTO                   R$  |\n");

            for (Produto produto : this.carrinho) {
                writer.write("| " + produto.getDescricao() + "\n");
            }

            writer.write("|                                   TOTAL: R$" + this.totalDaCompra + "|\n");
            writer.write("|                                   TROCO: R$       |\n");
            writer.write("| FORMA DE PAGAMENTO:                               |\n");
            writer.write("| ATENDENTE:                                        |\n");
            writer.write("|---------------------------------------------------|\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
