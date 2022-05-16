import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FuncoesApp {

    /**
     * 
     * @param f File/Pasta do arquivo
     * @return Retorna a arvore instanciada e com os elementos do txts
     * @throws FileNotFoundException Se não achar o arquivo ele lança uma exeception
     */
    public ArvoreAVL inicializarArvore(File f) throws FileNotFoundException {
        // Vai criar um array de arquivos listando todos os arquivos
        File[] listaDeArquivos = f.listFiles();
        
        // Criação da arvore
        ArvoreAVL arvoreAVL = new ArvoreAVL(); 
        arvoreAVL.raiz = new NoAVL(); 

        for(int i = 0; i < listaDeArquivos.length;i++) {
            Scanner scanner = new Scanner(listaDeArquivos[i]);
            var nomeArquivo = listaDeArquivos[i].getName();

            while(scanner.hasNext()) {  
                String texto = scanner.next();
                NoAVL p = arvoreAVL.raiz;
                if(verifica(arvoreAVL.raiz,texto)) {
                    // precorrer a ArvoreAVL dependendo se der positivo ou negativo
                    while(p != null) { 
                        if(texto.compareTo(p.lista.primeiro.texto) == 0) {
                            break;
                        }
                        else if(texto.compareTo(p.lista.primeiro.texto) >= 0) {
                            p = p.direito;
                        }
                        else if(texto.compareTo(p.lista.primeiro.texto) < 0) {
                            p = p.esquerdo;
                        }
                    }

                    // Recebe a lista da posição 
                    No q = p.lista.primeiro;
                    while (q != null) {
                        if (q.nomeArquivo.equals(nomeArquivo)) {
                            q.frequencia++;
                            break;
                        }
                        // Percorre a lista
                        q = q.proximo;
                    }
                    if(q == null) {
                        p.lista.insereOrdenado(texto, 1, nomeArquivo);
                    }

                } else {
                    arvoreAVL.insere_elemento(arvoreAVL, texto, 1, nomeArquivo);
                }
            }
            scanner.close();
        }
        // Retorna a arvore instanciada com os elementos do txts
        return arvoreAVL; 
    }

    /**
     * 
     * @param no No da Arvore
     * @param texto Conteudo a ser inserido
     * @return Retorna um valor boleano
     */
    public boolean verifica(NoAVL no, String texto) {
        if (no == null || no.lista.primeiro == null) {
            return false;
        }
        if(texto.compareTo(no.lista.primeiro.texto) == 0) {
            return true;
        }
        if(texto.compareTo(no.lista.primeiro.texto) >= 0) {
            return verifica(no.direito,texto);
        }
        if(texto.compareTo(no.lista.primeiro.texto) < 0) {
            return verifica(no.esquerdo,texto);
        }
        return false;
    }

    /**
     * 
     * @param arvoreAVL Arvore do projeto, onde estão os elementos do txt
     * @param texto Conteúdo a ser pesquisado na arvore de elementos(Texto)
     */
    public void pesquisa(ArvoreAVL arvoreAVL, String texto) {
        // Verificar se a palavre que esta sendo pesquisada existe na ArvoreAVL
        if (!verifica(arvoreAVL.raiz, texto)) {
            System.out.println("Essa texto não foi encontrada.");
        }
        else {
            NoAVL p = arvoreAVL.raiz; // passar a raiz

            while(texto.compareTo(p.lista.primeiro.texto) != 0) { // enquanto for diferente de 0 ele vai andar pela ArvoreAVL
                if (texto.compareTo(p.lista.primeiro.texto) >= 0) {
                    p = p.direito;
                } else if (texto.compareTo(p.lista.primeiro.texto) < 0) {
                    p = p.esquerdo;
                }
            }

            System.out.println("texto: " + p.lista.primeiro.texto);
            No no = p.lista.primeiro;

            int q;
            for(q = 0; no != null; no = no.proximo) {
                System.out.println("Nome do Arquivo: " + no.nomeArquivo + "' e a Frequencia: " + no.frequencia);
                q += no.frequencia;
            }

            System.out.println("Frequencia total = " + q +  " do texto " + texto);
        }
    }
}
