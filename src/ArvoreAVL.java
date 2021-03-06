//Utilizamos interface para organizar os metodos.
public class ArvoreAVL implements IArvoreAVL {
    public NoAVL raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    /**
     * Insere elemento na nossa arvore.
     * @param arvoreAVL Arvore Avl.
     * @param texto Texto a ser inserido na arvore.
     * @param frequencia Frequecia da palavra a ser inserida.
     * @param nomeArquivo Nome do arquivo txt analisado.
     */
    public void insere_elemento(ArvoreAVL arvoreAVL, String texto, int frequencia, String nomeArquivo) {
        if(arvoreAVL.raiz.lista.primeiro == null) {
            arvoreAVL.raiz = new NoAVL();
            arvoreAVL.raiz.lista.inserePrimeiro(texto, frequencia, nomeArquivo);
        }
        else {
            Pilha pilha = new Pilha(25);
            NoAVL p = arvoreAVL.raiz;
            NoAVL q = null;
            while(p != null) {
                if(texto.compareTo(p.lista.primeiro.texto) >= 0) {
                    q = p;
                    pilha.empilhar(p);
                    p = p.direito;
                }
                else if(texto.compareTo(p.lista.primeiro.texto) < 0) {
                    q = p;
                    pilha.empilhar(p);
                    p = p.esquerdo;
                }
                else {
                    break;
                }
            }
            if (p == null) {
                p = new NoAVL();
            }
            p.lista.inserePrimeiro(texto, frequencia, nomeArquivo);
            if(p.lista.primeiro.texto.compareTo(q.lista.primeiro.texto) >= 0) {
                q.direito = p;
            }
            else if(p.lista.primeiro.texto.compareTo(q.lista.primeiro.texto) < 0) {
                q.esquerdo = p;
            }
            
            //logo apos inserir efetua o banceamento.
            while(!pilha.vazio()) {
                arvoreAVL.balanceamento(arvoreAVL, pilha.topo());
                pilha.desempilhar();
            }
        }
    }

    /**
     * Metodo para remover elemento(Texto) da arvore
     * @param arvoreAVL Arvore AVL
     * @param texto Texto/elemento a ser removido da arvore
     */
    public boolean remove_elemento(ArvoreAVL arvoreAVL, String texto) {
        NoAVL p = arvoreAVL.raiz;
        NoAVL q = null;
        if (p == null) {
            return false;
        }
        else {
            while (p != null) {
                if (texto.compareTo(p.lista.primeiro.texto) == 0) {
                    if(q.esquerdo == p) {
                        if(p.esquerdo == null && p.direito == null) {
                            q.esquerdo = null;
                        }
                        else if(p.direito != null) {
                            NoAVL no = menor(p.direito);
                            remove_elemento(arvoreAVL,no.lista.primeiro.texto);
                            no.direito = p.direito;
                            no.esquerdo = p.esquerdo;
                            q.esquerdo = no;
                        }
                        else if(p.esquerdo != null) {
                            NoAVL no = maior(p.esquerdo);
                            remove_elemento(arvoreAVL,no.lista.primeiro.texto);
                            no.direito = p.direito;
                            no.esquerdo = p.esquerdo;
                            q.esquerdo = no;
                        }
                    }
                    else if(q.direito == p) {
                        if(p.esquerdo == null && p.direito == null) {
                            q.direito = null;
                        }
                        else if(p.direito != null) {
                            NoAVL no = menor(p.direito);
                            remove_elemento(arvoreAVL,no.lista.primeiro.texto);
                            no.direito = p.direito;
                            no.esquerdo = p.esquerdo;
                            q.direito = no;
                        }
                        else if(p.esquerdo != null) {
                            NoAVL no = maior(p.esquerdo);
                            remove_elemento(arvoreAVL,no.lista.primeiro.texto);
                            no.direito = p.direito;
                            no.esquerdo = p.esquerdo;
                            q.direito = no;
                        }
                    }
                    else if(p == arvoreAVL.raiz) {
                        if(p.esquerdo == null && p.direito == null) {
                            arvoreAVL.raiz = null; //p = null;
                        }
                        else if(p.direito != null) {
                            NoAVL no = menor(p.direito);
                            remove_elemento(arvoreAVL,no.lista.primeiro.texto);
                            no.direito = p.direito;
                            no.esquerdo = p.esquerdo;
                        }
                        else if(p.esquerdo != null) {
                            NoAVL no = maior(p.esquerdo);
                            remove_elemento(arvoreAVL,no.lista.primeiro.texto);
                            no.direito = p.direito;
                            no.esquerdo = p.esquerdo;
                        }
                    }
                    return true;
                }
                q = p;
                if(texto.compareTo(p.lista.primeiro.texto) >= 0) {
                    p = p.direito;
                }
                else if(texto.compareTo(p.lista.primeiro.texto) < 0) {
                    p = p.esquerdo;
                }
            }
            return false;
        }
    }

    /**
     * Verifica se existe elemento e printa na tela se existe ou n??o.
     * @param arvoreAVL Arvore AVL
     * @param texto Texto/elemento a ser removido da arvore.
     */
    public boolean existe_elemento(ArvoreAVL arvoreAVL,String texto) {
        NoAVL p = arvoreAVL.raiz;
        if (raiz == null) {
            return false;
        }
        else {
            while (p != null) {
                if (texto.compareTo(p.lista.primeiro.texto) == 0) {
                    System.out.println("Existe o texto " + texto);
                    return true;
                }
                else if (texto.compareTo(p.lista.primeiro.texto) < 0) {
                    p = p.esquerdo;
                }
                else {
                    p = p.direito;
                }
            }
            System.out.println("Nao exite o texto " + texto);
            return false;
        }
    }

    /**
     * Imprime a arvore no sistema pre ordem|raiz -> esquerda -> direita|
     * @param no Raiz da arvore
     */
    public void imprime_preOrdem(NoAVL no) {
        if (no != null) {
            no.lista.imprime();
            System.out.println();
            imprime_preOrdem(no.esquerdo);
            imprime_preOrdem(no.direito);
        }
    }

    /**
     * Imprime a arvore no sistema in ordem|esquerda -> raiz -> direita|
     * @param no Raiz da arvore
     */
    public void imprime_inOrdem(NoAVL no) {
        if (no != null) {
            imprime_inOrdem(no.esquerdo);
            no.lista.imprime();
            System.out.println();
            imprime_inOrdem(no.direito);
        }
    }

    /**
     * Imprime a arvore no sistema pos ordem|esquerda -> direita -> raiz|
     * @param no Raiz da arvore
     */
    public void imprime_posOrdem(NoAVL no) {
        if (no != null) {
            imprime_posOrdem(no.esquerdo);
            imprime_posOrdem(no.direito);
            no.lista.imprime();
            System.out.println();
        }
    }

    /**
     * Retorna o no Maior
     * @param no No de refer??ncia
     */
    public NoAVL maior(NoAVL no) {
        if (no == null) {
            return null;
        }
        NoAVL p = no;
        while (p.direito != null) {
            p = p.direito;
        }
        return p;
    }

    /**
     * Retorna o no Menor
     * @param no No de refer??ncia
     */
    public NoAVL menor(NoAVL no) {
        if (no == null) {
            return null;
        }
        NoAVL p = no;
        while (p.esquerdo != null) {
            p = p.esquerdo;
        }
        return p;
    }

    /**
     * Retorna altura
     * @param arvoreAVL Arvore AVL
     * @param no Parametro a ser an??lisado
     */
    public int altura (ArvoreAVL arvoreAVL,NoAVL no) {
        int altura_esquerdo;
        int altura_direito;
        if (no == null) {
            return -1;
        }
        else {
            altura_esquerdo = altura(arvoreAVL,no.esquerdo);
            altura_direito = altura(arvoreAVL,no.direito);
            if (altura_esquerdo < altura_direito) {
                return altura_direito + 1;
            }
        }
        return altura_esquerdo + 1;
    }

    /**
     * Rota????o para organizar a arvore.
     * @param arvoreAVL Arvore AVL
     * @param no No da arvore.
     */
    public void rotacao_esquerdo(ArvoreAVL arvoreAVL, NoAVL no) {
        NoAVL p = arvoreAVL.raiz;
        NoAVL q = null;

        while (p != no) {
            q = p;
            if(no.lista.primeiro.texto.compareTo(p.lista.primeiro.texto) >= 0) {
                p = p.direito;
            }
            else if(no.lista.primeiro.texto.compareTo(p.lista.primeiro.texto) < 0) {
                p = p.esquerdo;
            }
        }

        if (p == arvoreAVL.raiz) {
            if(p.direito.esquerdo != null) {
                arvoreAVL.raiz = p.direito.esquerdo;
                p.direito.esquerdo = null;
                arvoreAVL.raiz.direito = p.direito;
                p.direito = null;
            }
            else {
                arvoreAVL.raiz = p.direito;
                p.direito = null;
            }
            arvoreAVL.raiz.esquerdo = p;
        }
        else if(q.esquerdo == p) {
            if(p.direito.esquerdo != null) {
                q.esquerdo = p.direito.esquerdo;
                p.direito.esquerdo = null;
                q.esquerdo.direito = p.direito;
                p.direito = null;
            }
            else {
                q.esquerdo = p.direito;
                p.direito = null;
            }
            q.esquerdo.esquerdo = p;
        }
        else if(q.direito == p) {
            if(p.direito.esquerdo != null) {
                q.direito = p.direito.esquerdo;
                p.direito.esquerdo = null;
                q.direito.direito = p.direito;
                p.direito = null;
            }
            else {
                q.direito = p.direito;
                p.direito = null;
            }
            q.direito.esquerdo = p;
        }
    }

    /**
     * Rota????o para organizar a arvore.
     * @param arvoreAVL Arvore AVL
     * @param no No da arvore.
     */
    public void rotacao_direito(ArvoreAVL arvoreAVL, NoAVL no) {
        NoAVL p = arvoreAVL.raiz;
        NoAVL q = null;

        while (p != no) {
            q = p;
            if(no.lista.primeiro.texto.compareTo(p.lista.primeiro.texto) >= 0) {
                p = p.direito;
            }
            else if(no.lista.primeiro.texto.compareTo(p.lista.primeiro.texto) < 0) {
                p = p.esquerdo;
            }
        }

        if (p == arvoreAVL.raiz) {
            if(p.esquerdo.direito != null) {
                arvoreAVL.raiz = p.esquerdo.direito;
                p.esquerdo.direito = null;
                arvoreAVL.raiz.esquerdo = p.esquerdo;
                p.esquerdo = null;
            }
            else {
                arvoreAVL.raiz = p.esquerdo;
                p.esquerdo = null;
            }
            arvoreAVL.raiz.direito = p;
        }
        else if(q.esquerdo == p) {
            if(p.esquerdo.direito != null) {
                q.esquerdo = p.esquerdo.direito;
                p.esquerdo.direito = null;
                q.esquerdo.esquerdo = p.esquerdo;
                p.esquerdo = null;
            }
            else {
                q.esquerdo = p.esquerdo;
                p.esquerdo = null;
            }
            q.esquerdo.direito = p;
        }
        else if(q.direito == p) {
            if(p.esquerdo.direito != null) {
                q.direito = p.esquerdo.direito;
                p.esquerdo.direito = null;
                q.direito.esquerdo = p.esquerdo;
                p.esquerdo = null;
            }
            else {
                q.direito = p.esquerdo;
                p.esquerdo = null;
            }
            q.direito.direito = p;
        }
    }

    /**
     * Balanceamento utilizado para balancear a arvore.
     * No balanceamento conseguimos ver se est?? pendendo para um lado.
     * @param arvoreAVL Arvore AVL
     * @param no No da arvore.
     */
    public void balanceamento(ArvoreAVL arvoreAVL, NoAVL no) {
        if((arvoreAVL.altura(arvoreAVL, no.esquerdo) - arvoreAVL.altura(arvoreAVL, no.direito)) < -1) {
            arvoreAVL.rotacao_esquerdo(arvoreAVL, no);
        }
        else if((arvoreAVL.altura(arvoreAVL, no.esquerdo) - arvoreAVL.altura(arvoreAVL, no.direito)) > 1) {
            arvoreAVL.rotacao_direito(arvoreAVL, no);
        }
    }
}