public class ArvoreAVL {
    NoAVL raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public void insere_elemento(ArvoreAVL p, String texto, int freq, String nomeArquivo) {
        if(p.raiz.lista.primeiro == null) {
            p.raiz = new NoAVL();
            p.raiz.lista.insereOrdenado(texto, freq, nomeArquivo);
        }
        else {
            NoAVL no = p.raiz;
            NoAVL q = null;
            while(no != null) {
                if(texto.compareTo(no.lista.primeiro.texto) > 0) {
                    q = no;
                    no = no.direita;
                } else if(texto.compareTo(no.lista.primeiro.texto) < 0) {
                    q = no;
                    no = no.esquerda;
                } else {
                    break;
                }
            }
            if (no == null) {
                no = new NoAVL();
            }
            no.lista.insereOrdenado(texto, freq, nomeArquivo);
            if(no.lista.primeiro.texto.compareTo(q.lista.primeiro.texto) >= 0) {
                q.direita = no;
            }
            else if(no.lista.primeiro.texto.compareTo(q.lista.primeiro.texto) < 0) {
                q.esquerda = no;
            }
        }
    }

    public boolean remove_elemento(ArvoreAVL l, String texto) {
        NoAVL p = l.raiz;
        NoAVL q = null;
        if (p == null) {
            return false;
        } else {
            while (p != null) {
                if (texto.compareTo(p.lista.primeiro.texto) == 0) {
                    if(q.esquerda == p) {
                        if(p.esquerda == null && p.direita == null) {
                            q.esquerda = null;
                        }else if(p.direita != null) {
                            NoAVL x = menor(p.direita);
                            remove_elemento(l,x.lista.primeiro.texto);
                            x.direita = p.direita;
                            x.esquerda = p.esquerda;
                            q.esquerda = x;
                        }else if(p.esquerda != null) {
                            NoAVL x = maior(p.esquerda);
                            remove_elemento(l,x.lista.primeiro.texto);
                            x.direita = p.direita;
                            x.esquerda = p.esquerda;
                            q.esquerda = x;
                        }
                    }else if(q.direita == p) {
                        if(p.esquerda == null && p.direita == null) {
                            q.direita = null;
                        }else if(p.direita != null) {
                            NoAVL x = menor(p.direita);
                            remove_elemento(l,x.lista.primeiro.texto);
                            x.direita = p.direita;
                            x.esquerda = p.esquerda;
                            q.direita = x;
                        }else if(p.esquerda != null) {
                            NoAVL x = maior(p.esquerda);
                            remove_elemento(l,x.lista.primeiro.texto);
                            x.direita = p.direita;
                            x.esquerda = p.esquerda;
                            q.direita = x;
                        }
                    } else if(p == l.raiz) {
                        if(p.esquerda == null && p.direita == null) {
                            p = null;
                        }else if(p.direita != null) {
                            NoAVL x = menor(p.direita);
                            remove_elemento(l,x.lista.primeiro.texto);
                            x.direita = p.direita;
                            x.esquerda = p.esquerda;
                        }else if(p.esquerda != null) {
                            NoAVL x = maior(p.esquerda);
                            remove_elemento(l,x.lista.primeiro.texto);
                            x.direita = p.direita;
                            x.esquerda = p.esquerda;
                        }
                    }
                    return true;
                }
                q = p;
                if(texto.compareTo(p.lista.primeiro.texto) > 0) {
                    p = p.direita;
                } else if(texto.compareTo(p.lista.primeiro.texto) < 0) {
                    p = p.esquerda;
                }
            }
            return false;
        }
    }

    public boolean existe_elemento(String texto) {
        NoAVL p = raiz;
        if (raiz == null) {
            return false;
        }
        else {
            while (p != null) {
                if (texto.compareTo(p.lista.primeiro.texto) == 0) {
                    return true;
                }
                else if (texto.compareTo(p.lista.primeiro.texto) < 0) {
                    p = p.esquerda;
                }
                else {
                    p = p.direita;
                }
            }
            return false;
        }
    }



    public void imprime_preOrdem( NoAVL no ){
        if ( no != null ) {
            no.lista.imprime();
            System.out.println("");
            imprime_preOrdem(no.esquerda);
            imprime_preOrdem(no.direita);
        }
    }

    public void imprime_inOrdem( NoAVL no ){
        if( no != null ){
            imprime_inOrdem(no.esquerda);
            no.lista.imprime();
            System.out.println("");
            imprime_inOrdem(no.direita);
        }
    }

    public void imprime_posOrdem( NoAVL no ){
        if( no != null ){
            imprime_posOrdem(no.esquerda);
            imprime_posOrdem(no.direita);
            no.lista.imprime();
            System.out.println("");
        }
    }


    public NoAVL maior(NoAVL no) {
        if (no == null) {
            return null;
        }
        NoAVL n = no;
        while (n.direita != null) {
            n = n.direita;
        }
        return n;
    }

    public NoAVL menor(NoAVL no) {
        if (no == null) {
            return null;
        }
        NoAVL n = no;
        while (n.esquerda != null) {
            n = n.esquerda;
        }
        return n;
    }

    public int altura( NoAVL no ){//Falta fazer

        return -1;//Temporário
    }

    public int altura (ArvoreAVL a,NoAVL n) {
        int altura_esquerda = -1;
        int altura_direita = -1;
        if (n == null) {
            return -1;
        }else {
            altura_esquerda = altura(a,n.esquerda);
            altura_direita = altura(a,n.direita);
            if (altura_esquerda < altura_direita) {
                return altura_direita + 1;
            }
        }
        return altura_esquerda + 1;
    }
}
