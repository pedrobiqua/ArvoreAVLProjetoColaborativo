public class NoAVL{ //No da arvore
    public LSE lista;
    public NoAVL esquerdo;
    public NoAVL direito;

    public NoAVL() {
        this.lista = new LSE();
        this.esquerdo = null;
        this.direito = null;
    }
}