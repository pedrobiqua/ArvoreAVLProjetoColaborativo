public class No {
    public String texto;
    public String nomeArquivo;
    public int freq;
    public No proximo;

    public No(String texto, int freq, String nomeArquivo) {
        this.texto = texto;
        this.nomeArquivo = nomeArquivo;
        this.proximo = null;
        this.freq = freq;
    }
}