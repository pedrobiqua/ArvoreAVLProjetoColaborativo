//Utilizamos interface para organizar os metodos.
public class LSE implements ILSE{ 
    public No primeiro;
    public No ultimo;

    //Utilizamos a lista simplismente encadeada implementada em outros trabalhos
    //Fizemos melhorias e corrigimos alguns erros
    public LSE() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean vazio() {
        return(this.primeiro == null);
    }

    /**
     * Insere dado apartir da primeira posição da fila
     * @param texto Texto a ser inserido na Lista
     * @param frequencia Frequencia q ocorre.
     * @param nomeArquivo Nome do arquivo txt analisado.
     */
    public void inserePrimeiro(String texto, int frequencia, String nomeArquivo) {
        No p = new No(texto,frequencia,nomeArquivo);
        if(vazio()) {
            this.primeiro = p;
            this.ultimo = p;
        }
        else {
            p.proximo = this.primeiro;
            this.primeiro = p;
        }
    }

    /**
     * Insere dado apartir da ultima posição da fila
     * @param texto Texto a ser inserido na Lista
     * @param frequencia Frequencia q ocorre.
     * @param nomeArquivo Nome do arquivo txt analisado.
     */
    public void insereUltimo(String texto, int frequencia, String nomeArquivo) {
        if(vazio()) {
            inserePrimeiro(texto, frequencia, nomeArquivo);
        }
        else {
            No p = new No(texto, frequencia, nomeArquivo);
            this.ultimo.proximo = p;
            this.ultimo = p;
        }
    }


    /**
     * Insere dados na lista de forma ordenada
     * @param texto Texto a ser inserido na Lista
     * @param frequencia Frequencia q ocorre.
     * @param nomeArquivo Nome do arquivo txt analisado.
     */
    public void insereOrdenado(String texto, int frequencia, String nomeArquivo) {
        if(vazio() || frequencia <= primeiro.frequencia) { // se a frequencia eh menor que a frequencia no primeiro texto
            inserePrimeiro(texto, frequencia, nomeArquivo);
        }
        else if(frequencia >= ultimo.frequencia) {
            insereUltimo(texto, frequencia, nomeArquivo);
        }
        else {
            No p = primeiro;
            No q = null;
            while(frequencia > p.frequencia) {
                q = p;
                p = p.proximo;
            }
            No pn = new No(texto,frequencia, nomeArquivo);
            p.proximo = p;
            q.proximo = pn;
        }
    }

    /**
     * Imprime dados da LSE
     */
    public boolean imprime() {
        if (vazio()) {
            return false;
        }
        No no = primeiro;
        System.out.println("texto: "+ primeiro.texto);
        while (no != null) {
            System.out.print("Nome do Arquivo: '" + no.nomeArquivo);
            System.out.println(" e a Frequencia " + no.frequencia);
            no = no.proximo;
        }
        return true;
    }
}