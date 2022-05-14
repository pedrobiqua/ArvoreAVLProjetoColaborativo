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
/* Anotações:
Da para criar um arquivo com a interface para manter o padrão dos outos trabalhos
Jogar as funções q o Lukas fez no app em um outro arquivo sendo estatico;
Na leitura do arquivo da para selecionar a pasta do projeto ao inves do caminho, pois isso varia de pc pra pc.
 */