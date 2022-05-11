public class ArvoreAVL {
    NoAVL raiz;

    public ArvoreAVL(NoAVL raiz) {//Falta fazer
        this.raiz = raiz;
    }
    
    public void insere_elemento( String texto ){//Falta fazer
        NoAVL novo = new NoAVL(texto);
        NoAVL p = this.raiz;

        if(verefica_ArvoreVazia()){
            this.raiz = novo;
            System.out.println("Criei a raiz");
        } else {
            NoAVL q = null;
            while (p != null) {
                q = p;
                if (texto.compareTo(raiz.texto) >= 0) {
                    p = p.direito; 
                    System.out.println("Direitaaa");
                    
                } else {
                    p = p.esquerdo;
                    System.out.println("Esquerdaaaa");
                }
            }
            if (q.texto.compareTo(texto) <= 0) {
                q.direito = novo;
                raiz.direito = q.direito;
                System.out.println("Direitaaa");
            } else {
                q.esquerdo = novo;
                raiz.esquerdo = q.esquerdo;
                System.out.println("Esquerdaaa");
            }
        }
    }
    // A jeitar e terminar amanhã/ coverter para string/ testar
    public void remove_elemento(String texto){
        NoAVL atual = this.raiz;
        NoAVL paiAtual = null;
        while(atual != null){
            if (atual.texto == texto) {
                break;
            } else if (atual.texto.compareTo(texto) <= -1){  //atual.texto < texto
                paiAtual = atual;
                atual = atual.esquerdo;
            } else {
                paiAtual = atual;
                atual = atual.direito;
            }
        }

        if (atual != null) {
            if (atual.direito != null) {
                NoAVL substituto = atual.direito;
                NoAVL paiSubstituto = null;
                while(substituto.esquerdo != null){
                    paiSubstituto = substituto;
                    substituto = substituto.esquerdo;
                }
                substituto = atual.esquerdo;
                if (paiAtual != null){
                    if (substituto.texto.compareTo(paiSubstituto.texto) >= 0) { //substituto.texto > paiSubstituto.texto
                        paiSubstituto.direito = substituto;
                    } else {
                        paiSubstituto.esquerdo = substituto;
                    }
                } else {
                    this.raiz = substituto;
                }
                if (substituto.texto.compareTo(paiSubstituto.texto) >=0) { // substituto.valor > paiSubstituto.valor
                    paiAtual.esquerdo = null;
                } else {
                    paiAtual.direito = null;
                }
                
            } else if (atual.esquerdo != null) {
                NoAVL substituto = atual.esquerdo;
                NoAVL paiSubstituto = null;
                while(substituto.direito != null){
                    paiSubstituto = substituto;
                    substituto = substituto.direito;
                }
                if (paiAtual != null){
                    if (substituto.texto.compareTo(paiSubstituto.texto) >= 0 ) { // substituto.valor > paiSubstituto.valor
                        paiSubstituto.direito = substituto;
                    } else {
                        paiSubstituto.esquerdo = substituto;
                    }
                } else {
                    this.raiz = substituto;
                }

                if (substituto.texto.compareTo(paiSubstituto.texto) >= 0) { //substituto.valor > paiSubstituto.valor
                    paiAtual.esquerdo = null;
                } else {
                    paiAtual.direito = null;
                }

            } else {
                if (paiAtual != null){
                    if (atual.texto.compareTo(paiAtual.texto) >= 0) { //atual.valor > paiAtual.valor
                        paiAtual.direito = null;
                    } else {
                        paiAtual.esquerdo = null;
                    }
                }else{
                    this.raiz = null; 
                }
            }
        }
    }

    public void existe_elemento( String texto ){//Falta fazer

    }

    public void imprime_preOrdem( NoAVL no ){
        if ( no != null ) {
            System.out.print(no.texto + " ");
            imprime_preOrdem(no.esquerdo);
            imprime_preOrdem(no.direito);
        }
    }

    public void imprime_inOrdem( NoAVL no ){
        if( no != null ){
            imprime_inOrdem(no.esquerdo);
            System.out.print(no.texto + " ");
            imprime_inOrdem(no.direito);
        }
    }

    public void imprime_posOrdem( NoAVL no ){
        if( no != null ){
            imprime_posOrdem(no.esquerdo);
            imprime_posOrdem(no.direito);
            System.out.print(no.texto + " ");
        }
    }

    public int altura( NoAVL no ){//Falta fazer
        
        return -1;//Temporário
    }

    private Boolean verefica_ArvoreVazia(){//verefica arvore.
        return raiz == null ? true : false;

    }
}
