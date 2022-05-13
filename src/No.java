public class No {
    public String texto;
    public String nomeArquivo;
    public int frequencia;
    public No proximo;

    public No(String texto, int frequencia, String nomeArquivo) {
        this.texto = texto;
        this.nomeArquivo = nomeArquivo;
        this.proximo = null;
        this.frequencia = frequencia;
    }
}