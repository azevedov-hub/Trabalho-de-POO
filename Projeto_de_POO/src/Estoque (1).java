import java.util.ArrayList;
import java.util.Scanner;

/**
 * Modulo de Estoque - Responsavel: Jose Isac
 * Trabalha sobre a MESMA lista de produtos criada em CadastroProdutos.
 */
public class Estoque {

    // Produtos com quantidade menor ou igual a este valor sao "estoque baixo"
    public static final int LIMITE_ESTOQUE_BAIXO = 5;

    private ArrayList<Produto> produtos;
    private Scanner entrada;

    public Estoque(ArrayList<Produto> produtos, Scanner entrada) {
        this.produtos = produtos;
        this.entrada = entrada;
    }

    // Busca um produto pelo codigo (retorna null se nao encontrar)
    public Produto buscarPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.codigo == codigo) {
                return produto;
            }
        }
        return null;
    }

    // 1) Consultar estoque: todos os produtos ou um produto especifico
    public void consultarEstoque() {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n--- CONSULTA DE ESTOQUE ---");
        System.out.println("1 - Ver todos os produtos");
        System.out.println("2 - Consultar por codigo");
        System.out.println("Escolha uma opcao:");
        int opcao = entrada.nextInt();

        if (opcao == 1) {
            for (Produto produto : produtos) {
                exibirLinhaEstoque(produto);
            }
        } else if (opcao == 2) {
            System.out.println("Digite o codigo do produto:");
            int codigo = entrada.nextInt();
            Produto produto = buscarPorCodigo(codigo);

            if (produto == null) {
                System.out.println("Produto nao encontrado!");
            } else {
                exibirLinhaEstoque(produto);
            }
        } else {
            System.out.println("Opcao invalida!");
        }
    }

    // 2) Registrar reposicao: soma unidades ao estoque de um produto
    public void registrarReposicao() {

        System.out.println("\n--- REPOSICAO DE ESTOQUE ---");
        System.out.println("Digite o codigo do produto:");
        int codigo = entrada.nextInt();

        Produto produto = buscarPorCodigo(codigo);

        if (produto == null) {
            System.out.println("Produto nao encontrado!");
            return;
        }

        System.out.println("Produto: " + produto.nome + " (estoque atual: " + produto.quantidade + ")");
        System.out.println("Digite a quantidade a repor:");
        int quantidadeRepor = entrada.nextInt();

        if (quantidadeRepor <= 0) {
            System.out.println("Quantidade invalida! Informe um valor maior que zero.");
            return;
        }

        produto.quantidade += quantidadeRepor;

        System.out.println("Reposicao registrada! Novo estoque de " + produto.nome + ": " + produto.quantidade);
    }

    // 3) Identificar produtos com poucas unidades
    public void listarEstoqueBaixo() {

        System.out.println("\n--- PRODUTOS COM ESTOQUE BAIXO (ate " + LIMITE_ESTOQUE_BAIXO + " unidades) ---");

        ArrayList<Produto> baixos = getProdutosEstoqueBaixo();

        if (baixos.isEmpty()) {
            System.out.println("Nenhum produto com estoque baixo.");
            return;
        }

        for (Produto produto : baixos) {
            exibirLinhaEstoque(produto);
        }
    }

    // Retorna a lista (util para o Integrante 4 usar nos relatorios)
    public ArrayList<Produto> getProdutosEstoqueBaixo() {
        ArrayList<Produto> baixos = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.quantidade <= LIMITE_ESTOQUE_BAIXO) {
                baixos.add(produto);
            }
        }
        return baixos;
    }

    // Verifica se ha unidades suficientes (util para o Integrante 2 nas vendas)
    public boolean temEstoqueSuficiente(Produto produto, int quantidade) {
        return produto.quantidade >= quantidade;
    }

    // Exibe uma linha de estoque com alerta quando estiver baixo
    private void exibirLinhaEstoque(Produto produto) {
        String alerta = (produto.quantidade <= LIMITE_ESTOQUE_BAIXO) ? "  [ESTOQUE BAIXO]" : "";
        System.out.println("Codigo: " + produto.codigo
                + " | Nome: " + produto.nome
                + " | Quantidade: " + produto.quantidade + alerta);
    }
}
