public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Trabalho TDE Estrutura de dados");

        NoAVL no1 = new NoAVL("Lukas");
        ArvoreAVL arvore = new ArvoreAVL(no1);

        System.out.println(arvore.raiz.texto);

        arvore.insere_elemento("Júlia");
        System.out.println(arvore.raiz.esquerdo.texto);
        arvore.insere_elemento("Pedro");
        System.out.println(arvore.raiz.direito.texto);
        arvore.insere_elemento("Vitor");
        System.out.println(arvore.raiz.direito.texto);
        
        arvore.imprime_inOrdem(no1);

        //arvore.existeElemento(no1, "Pedro");
        //arvore.remove_elemento("Pedro");
        
    }
}
