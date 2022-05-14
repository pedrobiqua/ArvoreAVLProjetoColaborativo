public class LSE {
    public No primeiro;
    public No ultimo;

    public LSE() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean vazio() {
        return(this.primeiro == null);
    }

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

    public void insereOrdenado(String texto, int frequencia, String nomeArquivo) {
        if(vazio() || frequencia <= primeiro.frequencia) { // se a frequencia eh menor que a frequencia no primeiro texto
            inserePrimeiro(texto, frequencia, nomeArquivo);
        }
        else if(frequencia >= ultimo.frequencia) {
            insereUltimo(texto, frequencia, nomeArquivo);
        }
        else {
            No x = primeiro;
            No y = null;
            while(frequencia > x.frequencia) {
                y = x;
                x = x.proximo;
            }
            No p = new No(texto,frequencia, nomeArquivo);
            p.proximo = x;
            y.proximo = p;
        }
    }

    public boolean imprime() {
        if (vazio()) {
            return false;
        }
        No no = primeiro;
        System.out.println("texto:"+primeiro.texto);
        while (no != null) {
            System.out.println("Nome do Arquivo: '"+no.nomeArquivo+"' || Frequencia: "+no.frequencia);
            no = no.proximo;
        }
        return true;
    }
}