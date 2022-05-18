public class Pilha {
    public NoAVL[] nos;
    private int topo;
    public int maximo;

    public Pilha(int tamanho) {
        this.maximo = tamanho;
        this.nos = new NoAVL[tamanho];
        this.topo = -1;
    }

    public boolean cheia() {
        return (topo == maximo-1);
    }
    public boolean vazio() {
        return (topo == -1);
    }

    public boolean empilhar(NoAVL p) {
        if (cheia()) {
            return false;
        }
        topo ++;
        nos[topo] = p;
        return true;
    }

    public void desempilhar() {
        if (!vazio()) {
            topo --;
        }
    }

    public NoAVL topo() {
        if (vazio()) {
            return null;
        }
        return nos[topo];
    }
}