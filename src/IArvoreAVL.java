//Implementação dos metodos necessaios da atividade.
public interface IArvoreAVL { 
    public void insere_elemento(ArvoreAVL a, String texto, int frequencia, String nomeArquivo);
    public boolean remove_elemento(ArvoreAVL a, String texto);
    public boolean existe_elemento(ArvoreAVL a,String texto);
    public void imprime_preOrdem(NoAVL no);
    public void imprime_inOrdem(NoAVL no);
    public void imprime_posOrdem(NoAVL no);
    public NoAVL maior(NoAVL no);
    public NoAVL menor(NoAVL no);
    public int altura (ArvoreAVL a,NoAVL no);
    public void rotacao_esquerdo(ArvoreAVL a, NoAVL no);
    public void rotacao_direito(ArvoreAVL a, NoAVL no);
    public void balanceamento(ArvoreAVL a, NoAVL no);
}
