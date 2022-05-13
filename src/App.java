public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Trabalho TDE Estrutura de dados");

        NoAVL no1 = new NoAVL("Lukas");
        ArvoreAVL arvore = new ArvoreAVL(no1);

        arvore.insere_elemento("Pedro");
        arvore.insere_elemento("Vitor");



    }
}
