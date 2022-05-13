import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class App {
    public ArvoreAVL teste(File f) throws FileNotFoundException {
        File[] listaDeArquivos = f.listFiles();
        ArvoreAVL a = new ArvoreAVL();
        a.raiz = new NoAVL();

        for(int i = 0; i < listaDeArquivos.length;i++) {
            Scanner sc = new Scanner(listaDeArquivos[i]);
            String nomeArquivo = listaDeArquivos[i].getName();

            while(sc.hasNext()) {
                String texto = sc.next();
                NoAVL no = a.raiz;
                if(verifica(a.raiz,texto)) {
                    while(no != null) {
                        if(texto.compareTo(no.lista.primeiro.texto) == 0) {
                            break;
                        }else if(texto.compareTo(no.lista.primeiro.texto) > 0) {
                            no = no.direita;
                        }else if(texto.compareTo(no.lista.primeiro.texto) < 0) {
                            no = no.esquerda;
                        }
                    }

                    No x = no.lista.primeiro;
                    while (x != null) {
                        if (x.nomeArquivo.equals(nomeArquivo)) {
                            x.freq++;
                            break;
                        }
                        x = x.proximo;
                    }
                    if(x == null) {
                        no.lista.insereOrdenado(texto, 1, nomeArquivo);
                    }
                }else {
                    a.insere_elemento(a, texto, 1, nomeArquivo);
                }
            }
            sc.close();
        }
        return a;
    }

    public boolean verifica(NoAVL no, String texto) throws FileNotFoundException{
        if (no == null || no.lista.primeiro == null) {
            return false;
        }else if(texto.compareTo(no.lista.primeiro.texto) == 0) {
            return true;
        }else if(texto.compareTo(no.lista.primeiro.texto) > 0) {
            return verifica(no.direita,texto);
        }else if(texto.compareTo(no.lista.primeiro.texto) < 0) {
            return verifica(no.esquerda,texto);
        }
        return false;
    }

    public void pesquisa(ArvoreAVL a, String texto) throws FileNotFoundException {
        if (!this.verifica(a.raiz, texto)) {
            System.out.println("Essa texto não foi encontrada.");
        } else {
            NoAVL x = a.raiz;

            while(texto.compareTo(x.lista.primeiro.texto) != 0) {
                if (texto.compareTo(x.lista.primeiro.texto) > 0) {
                    x = x.direita;
                } else if (texto.compareTo(x.lista.primeiro.texto) < 0) {
                    x = x.esquerda;
                }
            }

            System.out.println("texto: " + x.lista.primeiro.texto);
            No no = x.lista.primeiro;

            int y;
            for(y = 0; no != null; no = no.proximo) {
                System.out.println("Nome do Arquivo: '" + no.nomeArquivo + "' || Frequência: " + no.freq);
                y += no.freq;
            }

            System.out.println("Frequência total = " + y);
        }

    }

    public static void main(String[] args) throws FileNotFoundException{
        App cp = new App();
        ArvoreAVL a = cp.teste(new File("C:\\Users\\lukas\\IdeaProjects\\ArvoreAVLProjetoColaborativo\\txt`s"));
        a.imprime_preOrdem(a.raiz);
        System.out.println(a.altura(a, a.raiz.esquerda));
        System.out.println(a.altura(a, a.raiz.direita));
    }
}