import java.util.ArrayList;
import java.util.Scanner;

public class CadastroProdutos {

    ArrayList<Produto> produtos = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);

    public void cadastrarProduto() {

        System.out.println("Digite o codigo do produto:");
        int codigo = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Digite o nome do produto:");
        String nome = entrada.nextLine();

        System.out.println("Digite o preco do produto:");
        double preco = entrada.nextDouble();

        System.out.println("Digite a quantidade em estoque:");
        int quantidade = entrada.nextInt();

        Produto produto = new Produto(codigo, nome, preco, quantidade);

        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarProdutos() {

        System.out.println("\n--- PRODUTOS CADASTRADOS ---");

        for (Produto produto : produtos) {
            System.out.println("Codigo: " + produto.codigo);
            System.out.println("Nome: " + produto.nome);
            System.out.println("Preco: R$ " + produto.preco);
            System.out.println("Quantidade: " + produto.quantidade);
            System.out.println("--------------------------");
        }
    }
}