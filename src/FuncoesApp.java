import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FuncoesApp {
    public ArvoreAVL teste(File f) throws FileNotFoundException { // caso nao tenha nenhum arquivo
        File[] listaDeArquivos = f.listFiles();  // vai criar um array de arquivos, listar todos os arquivos dentro da pasta
        ArvoreAVL a = new ArvoreAVL(); // instanciar a ArvoreAVL
        a.raiz = new NoAVL(); // iniciando a raiz da ArvoreAVL

        for(int i = 0; i < listaDeArquivos.length;i++) { // passamos por todas as textos de todos os arquivos e por todos os arquivos
            Scanner sc = new Scanner(listaDeArquivos[i]); // escanenando as textos dentro do arquivo
            String nomeArquivo = listaDeArquivos[i].getName(); // guardar o nome do arquivo, pra printar depois

            while(sc.hasNext()) {  // enquanto nao chegou no final do arquivo ele vai lendo as textos
                String texto = sc.next(); // texto que ele esta no momento
                NoAVL no = a.raiz; // vai puxar a raiz
                if(verifica(a.raiz,texto)) { // verificar se a texto ja existe na ArvoreAVL
                    while(no != null) { // precorrer a ArvoreAVL dependendo se der positivo ou negativo
                        if(texto.compareTo(no.lista.primeiro.texto) == 0) {
                            break; // achou a texto
                        }
                        else if(texto.compareTo(no.lista.primeiro.texto) >= 0) {
                            no = no.direito;  // andar pra direito
                        }
                        else if(texto.compareTo(no.lista.primeiro.texto) < 0) {
                            no = no.esquerdo; // andar esquerdo
                        }
                    }

                    No x = no.lista.primeiro; // recebe a lista da posicao X
                    while (x != null) { // enquanto ele nao for nulo
                        if (x.nomeArquivo.equals(nomeArquivo)) { // se estiver no mesmo arquivo vai somar a frequencia da texto
                            x.frequencia++;
                            break;
                        }
                        x = x.proximo; // passando pela lista
                    }
                    if(x == null) {
                        no.lista.insereOrdenado(texto, 1, nomeArquivo); // caso nao ache a texto ele vai inserir um novo No na lista da texto
                    }
                }
                else {
                    a.insere_elemento(a, texto, 1, nomeArquivo); //se nao tiver nenhuma texto que estamos verificando dentro da ArvoreAVL
                    // vai ser criado um No na ArvoreAVL com a texto
                }
            }
            sc.close(); // fecha o arquivo que tinha aberto
        }
        return a; // retorna a ArvoreAVL
    }

    public static boolean verifica(NoAVL no, String texto) throws FileNotFoundException{ // verificar se existe uma texto em uma ArvoreAVL (recursivo)
        if (no == null || no.lista.primeiro == null) {
            return false;
        }
        else if(texto.compareTo(no.lista.primeiro.texto) == 0) {
            return true;
        }
        else if(texto.compareTo(no.lista.primeiro.texto) >= 0) {
            return verifica(no.direito,texto);
        }
        else if(texto.compareTo(no.lista.primeiro.texto) < 0) {
            return verifica(no.esquerdo,texto);
        }
        return false;
    }

    public static void pesquisa(ArvoreAVL a, String texto) throws FileNotFoundException {
        if (!verifica(a.raiz, texto)) { // verificar se a palavre que esta sendo pesquisada existe na ArvoreAVL
            System.out.println("Essa texto não foi encontrada.");
        }
        else {
            NoAVL x = a.raiz; // passar a raiz

            while(texto.compareTo(x.lista.primeiro.texto) != 0) { // enquanto for diferente de 0 ele vai andar pela ArvoreAVL
                if (texto.compareTo(x.lista.primeiro.texto) >= 0) {
                    x = x.direito;
                } else if (texto.compareTo(x.lista.primeiro.texto) < 0) {
                    x = x.esquerdo;
                }
            }

            System.out.println("texto: " + x.lista.primeiro.texto);
            No no = x.lista.primeiro;

            int y;
            for(y = 0; no != null; no = no.proximo) {
                System.out.println("Nome do Arquivo: " + no.nomeArquivo + "' e a Frequencia: " + no.frequencia);
                y += no.frequencia;
            }

            System.out.println("Frequencia total = " + y +  " do texto " + texto);
        }
    }
}
