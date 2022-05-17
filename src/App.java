import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException{
        //Para não poluir o codigo resolvemos criar uma classe para as funcionalidades extras
        var arquivo = new FuncoesApp();

        //Obtem o path da pasta onde esta os txts
        Path path = Paths.get("");
        String nomeDir = path.toAbsolutePath().normalize().toString();
        System.out.println(nomeDir + "\\txt\\");

        //Instancia da arvore e inicializando com os valores dos txts
        ArvoreAVL arvoreAVL = arquivo.inicializarArvore(new File(nomeDir + "\\txt\\"));
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
                case 1:
                    System.out.println("------------------------------------------------------------");
                    arvoreAVL.insere_elemento(arvoreAVL, "rapaz", 5, "livro.txt");
                    System.out.println("Insere em IN ORDEM");
                    arvoreAVL.imprime_inOrdem(arvoreAVL.raiz);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Tamanho da arvore do lado esquerdo: " + arvoreAVL.altura(arvoreAVL, arvoreAVL.raiz.esquerdo)); //talvez é a quantidade de nos no lado esquerdo
                    System.out.println("Tamanho da arvore do lado direito: " + arvoreAVL.altura(arvoreAVL, arvoreAVL.raiz.direito)); //talvez é a quantidade de nos no lado direito
                    System.out.println("------------------------------------------------------------");
                    arvoreAVL.existe_elemento(arvoreAVL, "luffy");
                    arvoreAVL.existe_elemento(arvoreAVL, "caminhao");
                    System.out.println("------------------------------------------------------------");
                    arquivo.pesquisa(arvoreAVL, "computador");
                    System.out.println("------------------------------------------------------------");
                    break;
                
                case 2:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Insere em POS ORDEM");
                    arvoreAVL.imprime_posOrdem(arvoreAVL.raiz);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Tamanho da arvore do lado esquerdo: " + arvoreAVL.altura(arvoreAVL, arvoreAVL.raiz.esquerdo)); //talvez é a quantidade de nos no lado esquerdo
                    System.out.println("Tamanho da arvore do lado direito: " + arvoreAVL.altura(arvoreAVL, arvoreAVL.raiz.direito)); //talvez é a quantidade de nos no lado direito
                    System.out.println("------------------------------------------------------------");
                    arvoreAVL.existe_elemento(arvoreAVL, "luffy");
                    arvoreAVL.existe_elemento(arvoreAVL, "caminhao");
                    System.out.println("------------------------------------------------------------");
                    arquivo.pesquisa(arvoreAVL, "computador");
                    System.out.println("------------------------------------------------------------");
                    break;
                
                case 3: 
                    System.out.println("------------------------------------------------------------");
                    arvoreAVL.remove_elemento(arvoreAVL, "zeus");
                    System.out.println("Insere em PRE ORDEM");
                    arvoreAVL.imprime_preOrdem(arvoreAVL.raiz);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Tamanho da arvore do lado esquerdo: " + arvoreAVL.altura(arvoreAVL, arvoreAVL.raiz.esquerdo)); //talvez é a quantidade de nos no lado esquerdo
                    System.out.println("Tamanho da arvore do lado direito: " + arvoreAVL.altura(arvoreAVL, arvoreAVL.raiz.direito)); //talvez é a quantidade de nos no lado direito
                    System.out.println("------------------------------------------------------------");
                    arvoreAVL.existe_elemento(arvoreAVL, "luffy");
                    arvoreAVL.existe_elemento(arvoreAVL, "caminhao");
                    System.out.println("------------------------------------------------------------");
                    arquivo.pesquisa(arvoreAVL, "computador");
                    System.out.println("------------------------------------------------------------");
                    break;
                
                case 4:
                    System.out.println("Saindo do projeto. . . ");
                    menu.close();
                    running = false;
                    break;
                
                default:
                     System.out.println("\nNao existe essa opcao de escolha.");
            }
            
        }
    }
}