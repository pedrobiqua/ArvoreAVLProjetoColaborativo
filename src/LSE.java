public class LSE {
    public No primeiro;
    public No ultimo;

    public LSE() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean vazia() {
        return(this.primeiro == null);
    }

    public void inserePrimeiro(String palavra, int freq, String nomeArquivo) {
        No p = new No(palavra,freq,nomeArquivo);
        if(vazia()) {
            this.primeiro = p;
            this.ultimo = p;
        } else {
            p.proximo = this.primeiro;
            this.primeiro = p;
        }
    }

    public void insereUltimo(String palavra, int freq, String nomeArquivo) {
        if(vazia()) {
            inserePrimeiro(palavra, freq, nomeArquivo);
        } else {
            No p = new No(palavra, freq, nomeArquivo);
            this.ultimo.proximo = p;
            this.ultimo = p;
        }
    }

    public void insereOrdenado(String palavra, int freq, String nomeArquivo) {
        if(vazia() || freq <= primeiro.freq) {
            inserePrimeiro(palavra, freq, nomeArquivo);
        } else if(freq >= ultimo.freq) {
            insereUltimo(palavra, freq, nomeArquivo);
        } else {
            No x = primeiro;
            No y = null;
            while(freq > x.freq) {
                y = x;
                x = x.proximo;
            }
            No p = new No(palavra,freq, nomeArquivo);
            p.proximo = x;
            y.proximo = p;
        }
    }

    public boolean imprime() {
        if (vazia()) {
            return false;
        }
        No no = primeiro;
        System.out.println("Palavra:"+primeiro.texto);
        while (no != null) {
            System.out.println("Nome do Arquivo: '"+no.nomeArquivo+"' || Frequência: "+no.freq);
            no = no.proximo;
        }
        return true;
    }
}