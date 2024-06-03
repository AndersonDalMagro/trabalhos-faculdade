import java.util.ArrayList;

public class ArvoreTAD {
    private Nodo raiz;

    //Inicialização da árvore
    public ArvoreTAD() {
        raiz = null;
    }

    //Verifica se a arvore esta vazia
    public boolean estaVazia() {

        return raiz == null;
    }

    // Calcula o tamanho da árvore
    public int tamanho() {
        return tamanhoRec(raiz);
    }

    // Método recursivo para calcular o tamanho da árvore
    private int tamanhoRec(Nodo n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + tamanhoRec(n.esq) + tamanhoRec(n.dir);
        }
    }

    // Limpa a estrutura, removendo todos os elementos
    public void limpa() {
        raiz = null;
    }

    //insere elementos na arvore
    public void insere(int elem) {
        if (estaVazia()){
            raiz = new Nodo(elem);
        }else {
            insereRec(elem, raiz);
        }
    }

    // inserele elemento na arvore ( recursivo)
    private void insereRec(int elem, Nodo n) {
        if (elem == n.elem){
            System.out.println("Elemento repetido!!!");
            return;
        }else {
            if (elem > n.elem){
                if (n.dir == null){
                    n.dir = new Nodo(elem);
                }else { // n.dir != null
                    insereRec(elem, n.dir);
                }

            }else {
                if (n.esq == null){
                    n.esq = new Nodo(elem);
                }else {
                    insereRec(elem, n.esq);
                }
            }
        }
    }

    //pesquisa o elemento
    public boolean pesquisa(int elem) {
       return pesquisaRec(elem, raiz);
    }

    //Pesquisa recursiva do elemento
    private boolean pesquisaRec(int elem, Nodo n) {
        if (n == null){
            return false;
        }else {
            if (elem == n.elem){
                return true;
            }else {
                if (elem < n.elem){
                    return pesquisaRec(elem, n.esq);
                }else {
                    return pesquisaRec(elem, n.dir);
                }
            }
        }
    }

    // Imprime os elementos em ordem
    public void imprimeEmOrdem() {
        imprimeEmOrdemRec(raiz);
        System.out.println();
    }

    // Método recursivo para imprimir os elementos em ordem
    private void imprimeEmOrdemRec(Nodo n) {
        if (n != null) {
            imprimeEmOrdemRec(n.esq);
            System.out.print(n.elem + " ");
            imprimeEmOrdemRec(n.dir);
        }
    }

    // Imprime os elementos em pós-ordem
    public void imprimePosOrdem() {
        imprimePosOrdemRec(raiz);
        System.out.println();
    }

    // Método recursivo para imprimir os elementos em pós-ordem
    private void imprimePosOrdemRec(Nodo n) {
        if (n != null) {
            imprimePosOrdemRec(n.esq);
            imprimePosOrdemRec(n.dir);
            System.out.print(n.elem + " ");
        }
    }

    // Imprime os elementos em pré-ordem
    public void imprimePreOrdem() {
        imprimePreOrdemRec(raiz);
        System.out.println();
    }

    // Método recursivo para imprimir os elementos em pré-ordem
    private void imprimePreOrdemRec(Nodo n) {
        if (n != null) {
            System.out.print(n.elem + " ");
            imprimePreOrdemRec(n.esq);
            imprimePreOrdemRec(n.dir);
        }
    }

    // Acessa o maior elemento da árvore
    public int acessaMaior() {
        return acessaMaiorRec(raiz);
    }

    // Método recursivo para acessar o maior elemento da árvore
    private int acessaMaiorRec(Nodo n) {
        if (n == null) {
            // Caso a árvore esteja vazia
            return Integer.MIN_VALUE;
        }
        if (n.dir == null) {
            // Se não há subárvore direita, então este é o maior elemento
            return n.elem;
        }
        // Percorre recursivamente pela subárvore direita
        return acessaMaiorRec(n.dir);
    }

    // Acessa o menor elemento da árvore
    public int acessaMenor() {
        return acessaMenorRec(raiz);
    }

    // Método recursivo para acessar o menor elemento da árvore
    private int acessaMenorRec(Nodo n) {
        if (n == null) {
            // Caso a árvore esteja vazia
            return Integer.MAX_VALUE;
        }
        if (n.esq == null) {
            // Se não há subárvore esquerda, então este é o menor elemento
            return n.elem;
        }
        // Percorre recursivamente pela subárvore esquerda
        return acessaMenorRec(n.esq);
    }

    // Cria e retorna um vetor contendo os elementos da árvore em ordem crescente
    public ArrayList<Integer> criaVetorEmOrdem() {
        ArrayList<Integer> vetor = new ArrayList<>();
        criaVetorEmOrdem(raiz, vetor);
        return vetor;
    }

    // Método auxiliar recursivo para criar o vetor em ordem crescente
    private void criaVetorEmOrdem(Nodo n, ArrayList<Integer> vetor) {
        if (n != null) {
            criaVetorEmOrdem(n.esq, vetor);
            vetor.add(n.elem);
            criaVetorEmOrdem(n.dir, vetor);
        }
    }

    // Realiza o balanceamento estático da árvore
    public void balanceamentoEstatico() {
        // Cria um vetor em ordem crescente dos elementos da árvore
        ArrayList<Integer> vetorEmOrdem = criaVetorEmOrdem();

        // Limpa a árvore atual
        limpa();

        // Preenche a árvore binária balanceada com os elementos do vetor
        preencheArvoreBinaria(vetorEmOrdem, 0, vetorEmOrdem.size() - 1);
    }

    // Preenche a árvore binária balanceada com os elementos do vetor
    private void preencheArvoreBinaria(ArrayList<Integer> vetorEmOrdem, int inicio, int fim) {
        if (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            // Insere o elemento do meio na árvore
            insere(vetorEmOrdem.get(meio));

            // Preenche recursivamente a subárvore esquerda com os elementos anteriores ao meio
            preencheArvoreBinaria(vetorEmOrdem, inicio, meio - 1);

            // Preenche recursivamente a subárvore direita com os elementos posteriores ao meio
            preencheArvoreBinaria(vetorEmOrdem, meio + 1, fim);
        }
    }

    public void imprimeArvore() {
        this.imprimeArvoreRec(this.raiz, 0);
    }

    private void imprimeArvoreRec(Nodo n, int depth) {
        if (n == null) {
            return;
        }
        this.imprimeArvoreRec(n.dir, depth + 1);
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(n.elem);
        this.imprimeArvoreRec(n.esq, depth + 1);
    }

    public void remove(int elem) {
        this.raiz = this.removeRec(elem, this.raiz);
    }

    private Nodo removeRec(int elem, Nodo n) {
        if (n == null) {
            return null;
        } else if (elem == n.elem) {
            if (n.esq == null && n.dir == null) {
                return null;
            } else if (n.esq == null) {
                return n.dir;
            } else if (n.dir == null) {
                return n.esq;
            } else {
                Nodo aux = n.dir;
                while (aux.esq != null) {
                    aux = aux.esq;
                }
                n.elem = aux.elem;
                n.dir = this.removeRec(aux.elem, n.dir);
            }
        } else if (elem < n.elem) {
            n.esq = removeRec(elem, n.esq);
        } else {
            n.dir = removeRec(elem, n.dir);
        }
        return n;
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(Nodo n) {
        if (n == null) {
            return -1; // Retorna -1 para indicar que a altura de uma árvore vazia é -1
        } else {
            // Calcula a altura de cada subárvore recursivamente
            int alturaEsq = alturaRec(n.esq);
            int alturaDir = alturaRec(n.dir);

            // A altura da árvore é o máximo entre as alturas das subárvores mais a altura da raiz
            return 1 + Math.max(alturaEsq, alturaDir);
        }
    }
}