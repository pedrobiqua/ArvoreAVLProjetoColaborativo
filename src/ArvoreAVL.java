public class ArvoreAVL {
    public NoAVL raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public void insere_elemento(ArvoreAVL a, String texto, int frequencia, String nomeArquivo) {
        if(a.raiz.lista.primeiro == null) {
            a.raiz = new NoAVL();
            a.raiz.lista.inserePrimeiro(texto, frequencia, nomeArquivo);
        }
        else {
            Pilha p = new Pilha(a.altura(a, a.raiz) + 1);
            NoAVL no = a.raiz;
            NoAVL q = null;
            while(no != null) {
                if(texto.compareTo(no.lista.primeiro.texto) >= 0) {
                    q = no;
                    p.empilhar(no);
                    no = no.direito;
                }
                else if(texto.compareTo(no.lista.primeiro.texto) < 0) {
                    q = no;
                    p.empilhar(no);
                    no = no.esquerdo;
                }
                else {
                    break;
                }
            }
            if (no == null) {
                no = new NoAVL();
            }
            no.lista.inserePrimeiro(texto, frequencia, nomeArquivo);
            if(no.lista.primeiro.texto.compareTo(q.lista.primeiro.texto) >= 0) {
                q.direito = no;
            }
            else if(no.lista.primeiro.texto.compareTo(q.lista.primeiro.texto) < 0) {
                q.esquerdo = no;
            }

            while(!p.vazio()) {
                a.balanceamento(a, p.topo());
                p.desempilhar();
            }
        }
    }

    public boolean remove_elemento(ArvoreAVL a, String texto) {
        NoAVL p = a.raiz;
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
                            NoAVL x = menor(p.direito);
                            remove_elemento(a,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                            q.esquerdo = x;
                        }
                        else if(p.esquerdo != null) {
                            NoAVL x = maior(p.esquerdo);
                            remove_elemento(a,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                            q.esquerdo = x;
                        }
                    }
                    else if(q.direito == p) {
                        if(p.esquerdo == null && p.direito == null) {
                            q.direito = null;
                        }
                        else if(p.direito != null) {
                            NoAVL x = menor(p.direito);
                            remove_elemento(a,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                            q.direito = x;
                        }
                        else if(p.esquerdo != null) {
                            NoAVL x = maior(p.esquerdo);
                            remove_elemento(a,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                            q.direito = x;
                        }
                    }
                    else if(p == a.raiz) {
                        if(p.esquerdo == null && p.direito == null) {
                            p = null;
                        }
                        else if(p.direito != null) {
                            NoAVL x = menor(p.direito);
                            remove_elemento(a,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                        }
                        else if(p.esquerdo != null) {
                            NoAVL x = maior(p.esquerdo);
                            remove_elemento(a,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
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

    public boolean existe_elemento(ArvoreAVL a,String texto) {
        NoAVL p = a.raiz;
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

    public void imprime_preOrdem(NoAVL no) {
        if (no != null) {
            no.lista.imprime();
            System.out.println("");
            imprime_preOrdem(no.esquerdo);
            imprime_preOrdem(no.direito);
        }
    }

    public void imprime_inOrdem(NoAVL no) {
        if (no != null) {
            imprime_inOrdem(no.esquerdo);
            no.lista.imprime();
            System.out.println("");
            imprime_inOrdem(no.direito);
        }
    }

    public void imprime_posOrdem(NoAVL no) {
        if (no != null) {
            imprime_posOrdem(no.esquerdo);
            imprime_posOrdem(no.direito);
            no.lista.imprime();
            System.out.println("");
        }
    }

    public NoAVL maior(NoAVL no) {
        if (no == null) {
            return null;
        }
        NoAVL n = no;
        while (n.direito != null) {
            n = n.direito;
        }
        return n;
    }

    public NoAVL menor(NoAVL no) {
        if (no == null) {
            return null;
        }
        NoAVL n = no;
        while (n.esquerdo != null) {
            n = n.esquerdo;
        }
        return n;
    }

    public int altura (ArvoreAVL a,NoAVL no) {
        int altura_esquerdo = -1;
        int altura_direito = -1;
        if (no == null) {
            return -1;
        }
        else {
            altura_esquerdo = altura(a,no.esquerdo);
            altura_direito = altura(a,no.direito);
            if (altura_esquerdo < altura_direito) {
                return altura_direito + 1;
            }
        }
        return altura_esquerdo + 1;
    }

    public void rot_esquerdo(ArvoreAVL a, NoAVL no) {
        NoAVL p = a.raiz;
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

        if (p == a.raiz) {
            if(p.direito.esquerdo != null) {
                a.raiz = p.direito.esquerdo;
                p.direito.esquerdo = null;
                a.raiz.direito = p.direito;
                p.direito = null;
            }
            else {
                a.raiz = p.direito;
                p.direito = null;
            }
            a.raiz.esquerdo = p;
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

    public void rot_direito(ArvoreAVL a, NoAVL no) {
        NoAVL p = a.raiz;
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

        if (p == a.raiz) {
            if(p.esquerdo.direito != null) {
                a.raiz = p.esquerdo.direito;
                p.esquerdo.direito = null;
                a.raiz.esquerdo = p.esquerdo;
                p.esquerdo = null;
            }
            else {
                a.raiz = p.esquerdo;
                p.esquerdo = null;
            }
            a.raiz.direito = p;
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

    public void balanceamento(ArvoreAVL a, NoAVL no) {
        if((a.altura(a, no.esquerdo) - a.altura(a, no.direito)) < -1) {
            a.rot_esquerdo(a, no);
        }
        else if((a.altura(a, no.esquerdo) - a.altura(a, no.direito)) > 1) {
            a.rot_direito(a, no);
        }
    }
}