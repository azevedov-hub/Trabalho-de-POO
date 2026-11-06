import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        CadastroProdutos cadastro = new CadastroProdutos();

        int opcao = 0;

        while (opcao != 3) {

            System.out.println("\n=== CONSTRUFORTE ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Sair");
            System.out.println("Escolha uma opcao:");

            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:
                    cadastro.cadastrarProduto();
                    break;

                case 2:
                    cadastro.listarProdutos();
                    break;

                case 3:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }

        entrada.close();
    }
}