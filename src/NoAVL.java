public class NoAVL {
    
    public NoAVL direito;
    public NoAVL esquerdo;
    public int altura;

    public int valor;
    public String texto;

    public NoAVL(String texto) {
        this.altura = -1;
        this.texto = texto;

        this.esquerdo = null;
        this.direito = null;
    }

}
