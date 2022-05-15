import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException{
        var cp = new FuncoesApp();
        Path path = Paths.get("");
        String nomeDir = path.toAbsolutePath().normalize().toString();
        System.out.println(nomeDir + "\\txt\\");
        ArvoreAVL a = cp.teste(new File(nomeDir + "\\txt\\"));
        boolean running = true;

        while (running) {

            Scanner menu = new Scanner(System.in);
            System.out.println("____________________________________________________________");
            System.out.println("Digite 1 para imprimir a lista in ordem.");
            System.out.println("Digite 2 para imprimir a lista pos ordem. ");
            System.out.println("Digite 3 para imprimir a lista pre ordem. ");
            System.out.println("Digite 4 para fechar o projeto. ");
            System.out.print("Digite o numero de uma das opcao: ");
            int opcao = menu.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("------------------------------------------------------------");
                    a.insere_elemento(a, "rapaz", 5, "livro.txt");
                    System.out.println("Insere em IN ORDEM");
                    a.imprime_inOrdem(a.raiz);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Tamanho da arvore do lado esquerdo: " + a.altura(a, a.raiz.esquerdo)); //talvez é a quantidade de nos no lado esquerdo
                    System.out.println("Tamanho da arvore do lado direito: " + a.altura(a, a.raiz.direito)); //talvez é a quantidade de nos no lado direito
                    System.out.println("------------------------------------------------------------");
                    a.existe_elemento(a, "luffy");
                    a.existe_elemento(a, "caminhao");
                    System.out.println("------------------------------------------------------------");
                    FuncoesApp.pesquisa(a, "computador");
                    System.out.println("------------------------------------------------------------");
                }
                case 2 -> {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Insere em POS ORDEM");
                    a.imprime_posOrdem(a.raiz);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Tamanho da arvore do lado esquerdo: " + a.altura(a, a.raiz.esquerdo)); //talvez é a quantidade de nos no lado esquerdo
                    System.out.println("Tamanho da arvore do lado direito: " + a.altura(a, a.raiz.direito)); //talvez é a quantidade de nos no lado direito
                    System.out.println("------------------------------------------------------------");
                    a.existe_elemento(a, "luffy");
                    a.existe_elemento(a, "caminhao");
                    System.out.println("------------------------------------------------------------");
                    FuncoesApp.pesquisa(a, "computador");
                    System.out.println("------------------------------------------------------------");
                }
                case 3 -> {
                    System.out.println("------------------------------------------------------------");
                    a.remove_elemento(a, "zeus");
                    System.out.println("Insere em PRE ORDEM");
                    a.imprime_preOrdem(a.raiz);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Tamanho da arvore do lado esquerdo: " + a.altura(a, a.raiz.esquerdo)); //talvez é a quantidade de nos no lado esquerdo
                    System.out.println("Tamanho da arvore do lado direito: " + a.altura(a, a.raiz.direito)); //talvez é a quantidade de nos no lado direito
                    System.out.println("------------------------------------------------------------");
                    a.existe_elemento(a, "luffy");
                    a.existe_elemento(a, "caminhao");
                    System.out.println("------------------------------------------------------------");
                    FuncoesApp.pesquisa(a, "computador");
                    System.out.println("------------------------------------------------------------");
                }
                case 4 -> {
                    System.out.println("Saindo do projeto. . . ");
                    menu.close();
                    running = false;
                }
                default -> System.out.println("\nNao existe essa opcao de escolha.");
            }
        }
    }
}