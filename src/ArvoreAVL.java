public class ArvoreAVL {
    public NoAVL raiz;

    public ArvoreAVL() {

        this.raiz = null;
    }

    public void insere_elemento(ArvoreAVL n, String texto, int frequencia, String nomeArquivo) {
        if(n.raiz.lista.primeiro == null) {
            n.raiz = new NoAVL();
            n.raiz.lista.inserePrimeiro(texto, frequencia, nomeArquivo);
        } else {
            Pilha p = new Pilha(n.altura(n, n.raiz) + 1);
            NoAVL no = n.raiz;
            NoAVL q = null;
            while(no != null) {
                if(texto.compareTo(no.lista.primeiro.texto) >= 0) {
                    q = no;
                    p.empilhar(no);
                    no = no.direito;
                } else if(texto.compareTo(no.lista.primeiro.texto) < 0) {
                    q = no;
                    p.empilhar(no);
                    no = no.esquerdo;
                } else {
                    break;
                }
            }
            if (no == null) {
                no = new NoAVL();
            }
            no.lista.inserePrimeiro(texto, frequencia, nomeArquivo);
            if(no.lista.primeiro.texto.compareTo(q.lista.primeiro.texto) >= 0) {
                q.direito = no;
            }else if(no.lista.primeiro.texto.compareTo(q.lista.primeiro.texto) < 0) {
                q.esquerdo = no;
            }

            while(!p.vazio()) {
                n.balanceamento(n, p.topo());
                p.desempilhar();
            }
        }
    }

    public boolean remove_elemento(ArvoreAVL n, String texto) {
        NoAVL p = n.raiz;
        NoAVL q = null;
        if (p == null) {
            return false;
        } else {
            while (p != null) {
                if (texto.compareTo(p.lista.primeiro.texto) == 0) {
                    if(q.esquerdo == p) {
                        if(p.esquerdo == null && p.direito == null) {
                            q.esquerdo = null;
                        }else if(p.direito != null) {
                            NoAVL x = menor(p.direito);
                            remove_elemento(n,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                            q.esquerdo = x;
                        }else if(p.esquerdo != null) {
                            NoAVL x = maior(p.esquerdo);
                            remove_elemento(n,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                            q.esquerdo = x;
                        }
                    }else if(q.direito == p) {
                        if(p.esquerdo == null && p.direito == null) {
                            q.direito = null;
                        }else if(p.direito != null) {
                            NoAVL x = menor(p.direito);
                            remove_elemento(n,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                            q.direito = x;
                        }else if(p.esquerdo != null) {
                            NoAVL x = maior(p.esquerdo);
                            remove_elemento(n,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                            q.direito = x;
                        }
                    } else if(p == n.raiz) {
                        if(p.esquerdo == null && p.direito == null) {
                            p = null;
                        }else if(p.direito != null) {
                            NoAVL x = menor(p.direito);
                            remove_elemento(n,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                        }else if(p.esquerdo != null) {
                            NoAVL x = maior(p.esquerdo);
                            remove_elemento(n,x.lista.primeiro.texto);
                            x.direito = p.direito;
                            x.esquerdo = p.esquerdo;
                        }
                    }
                    return true;
                }
                q = p;
                if(texto.compareTo(p.lista.primeiro.texto) >= 0) {
                    p = p.direito;
                } else if(texto.compareTo(p.lista.primeiro.texto) < 0) {
                    p = p.esquerdo;
                }
            }
            return false;
        }
    }

    public boolean existe_elemento(ArvoreAVL n,String texto) {
        NoAVL p = n.raiz;
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
                } else {
                    p = p.direito;
                }
            }
            System.out.println("Nao exite o texto " + texto);
            return false;
        }
    }

    public void imprime_preordem(NoAVL no) {
        if (no != null) {
            no.lista.imprime();
            System.out.println("");
            imprime_preordem(no.esquerdo);
            imprime_preordem(no.direito);
        }
    }

    public void imprime_inordem(NoAVL no) {
        if (no != null) {
            imprime_inordem(no.esquerdo);
            no.lista.imprime();
            System.out.println("");
            imprime_inordem(no.direito);
        }
    }

    public void imprime_posordem(NoAVL no) {
        if (no != null) {
            imprime_posordem(no.esquerdo);
            imprime_posordem(no.direito);
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

    public int altura (ArvoreAVL n,NoAVL no) {
        int altura_esquerdo = 0;
        int altura_direito = 0;
        if (no == null) {
            return -1;
        }else {
            altura_esquerdo = altura(n,no.esquerdo);
            altura_direito = altura(n,no.direito);
            if (altura_esquerdo < altura_direito) {
                return altura_direito + 1;
            }
        }
        return altura_esquerdo + 1;
    }

    public void rot_esquerdo(ArvoreAVL n, NoAVL no) {
        NoAVL p = n.raiz;
        NoAVL q = null;

        while (p != no) {
            q = p;
            if(no.lista.primeiro.texto.compareTo(p.lista.primeiro.texto) > 0) {
                p = p.direito;
            }else if(no.lista.primeiro.texto.compareTo(p.lista.primeiro.texto) < 0) {
                p = p.esquerdo;
            }
        }

        if (p == n.raiz) {
            if(p.direito.esquerdo != null) {
                n.raiz = p.direito.esquerdo;
                p.direito.esquerdo = null;
                n.raiz.direito = p.direito;
                p.direito = null;
            }else {
                n.raiz = p.direito;
                p.direito = null;
            }
            n.raiz.esquerdo = p;
        }else if(q.esquerdo == p) {
            if(p.direito.esquerdo != null) {
                q.esquerdo = p.direito.esquerdo;
                p.direito.esquerdo = null;
                q.esquerdo.direito = p.direito;
                p.direito = null;
            }else {
                q.esquerdo = p.direito;
                p.direito = null;
            }
            q.esquerdo.esquerdo = p;
        }else if(q.direito == p) {
            if(p.direito.esquerdo != null) {
                q.direito = p.direito.esquerdo;
                p.direito.esquerdo = null;
                q.direito.direito = p.direito;
                p.direito = null;
            }else {
                q.direito = p.direito;
                p.direito = null;
            }
            q.direito.esquerdo = p;
        }
    }

    public void rot_direito(ArvoreAVL n, NoAVL no) {
        NoAVL p = n.raiz;
        NoAVL q = null;

        while (p != no) {
            q = p;
            if(no.lista.primeiro.texto.compareTo(p.lista.primeiro.texto) >= 0) {
                p = p.direito;
            }else if(no.lista.primeiro.texto.compareTo(p.lista.primeiro.texto) < 0) {
                p = p.esquerdo;
            }
        }

        if (p == n.raiz) {
            if(p.esquerdo.direito != null) {
                n.raiz = p.esquerdo.direito;
                p.esquerdo.direito = null;
                n.raiz.esquerdo = p.esquerdo;
                p.esquerdo = null;
            }else {
                n.raiz = p.esquerdo;
                p.esquerdo = null;
            }
            n.raiz.direito = p;
        }else if(q.esquerdo == p) {
            if(p.esquerdo.direito != null) {
                q.esquerdo = p.esquerdo.direito;
                p.esquerdo.direito = null;
                q.esquerdo.esquerdo = p.esquerdo;
                p.esquerdo = null;
            }else {
                q.esquerdo = p.esquerdo;
                p.esquerdo = null;
            }
            q.esquerdo.direito = p;
        }else if(q.direito == p) {
            if(p.esquerdo.direito != null) {
                q.direito = p.esquerdo.direito;
                p.esquerdo.direito = null;
                q.direito.esquerdo = p.esquerdo;
                p.esquerdo = null;
            }else {
                q.direito = p.esquerdo;
                p.esquerdo = null;
            }
            q.direito.direito = p;
        }
    }

    public void balanceamento(ArvoreAVL n, NoAVL no) {
        if((n.altura(n, no.esquerdo) - n.altura(n, no.direito)) < -1) {
            n.rot_esquerdo(n, no);
        }else if((n.altura(n, no.esquerdo) - n.altura(n, no.direito)) >= 1) {
            n.rot_direito(n, no);
        }
    }

}