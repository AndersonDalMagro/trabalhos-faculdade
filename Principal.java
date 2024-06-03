import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArvoreTAD arv = new ArvoreTAD();
        Scanner scan = new Scanner(System.in);

        int op = 0;

        while(op != 16) {
            System.out.println(" |---------------------------------------------------|");
            System.out.println(" |                 MENU DE OPERAÇÕES:                |");
            System.out.println(" |---------------------------------------------------|");
            System.out.println(" | 1 -  Calcular tamanho da árvore                   |");
            System.out.println(" | 2 -  Calcular altura da árvore                    |");
            System.out.println(" | 3 -  Verificar se a árvore está vazia             |");
            System.out.println(" | 4 -  Inserir elemento na árvore                   |");
            System.out.println(" | 5 -  Imprimir elementos da árvore (em pré-ordem)  |");
            System.out.println(" | 6 -  Imprimir elementos da árvore (em pós-ordem)  |");
            System.out.println(" | 7 -  Imprimir elementos da árvore (em ordem)      |");
            System.out.println(" | 8 -  Imprimir formato da árvore                   |");
            System.out.println(" | 9 -  Remover elemento da árvore                   |");
            System.out.println(" | 10 - Pesquisar por um elemento na árvor           |");
            System.out.println(" | 11 - Acessar o menor elemento da árvore           |");
            System.out.println(" | 12 - Acessar o maior elemento da árvore           |");
            System.out.println(" | 13 - Limpar a árvore (remover todos os elementos) |");
            System.out.println(" | 14 - Criar vetor com elementos em ordem           |");
            System.out.println(" | 15 - Balanceamento estático da árvore             |");
            System.out.println(" | 16 - Sair                                         |");
            System.out.println(" |---------------------------------------------------|");
            System.out.println(" | ESCOLHA UMA OPÇÃO:                                |");
            System.out.print(" |---------------------------------------------------|");
            op = scan.nextInt();

            switch(op) {
                case 1:
                    System.out.println("Tamanho da árvore: " + arv.tamanho());
                    break;
                case 2:
                    System.out.println("Altura da árvore: " + arv.altura());
                    break;
                case 3:
                    if (arv.estaVazia()) {
                        System.out.println("A árvore está vazia.");
                    } else {
                        System.out.println("A árvore não está vazia.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o elemento a ser inserido: ");
                    int elemInserir = scan.nextInt();
                    arv.insere(elemInserir);
                    System.out.println("Elemento inserido com sucesso!");
                    break;
                case 5:
                    System.out.println("Elementos da árvore (em pré-ordem):");
                    arv.imprimePreOrdem();
                    break;
                case 6:
                    System.out.println("Elementos da árvore (em pós-ordem):");
                    arv.imprimePosOrdem();
                    break;
                case 7:
                    System.out.println("Elementos da árvore (em ordem):");
                    arv.imprimeEmOrdem();
                    break;
                case 8:
                    System.out.println("Formato da árvore:");
                    arv.imprimeArvore();
                    break;
                case 9:
                    System.out.print("Digite o elemento a ser removido: ");
                    int elemRemover = scan.nextInt();
                    arv.remove(elemRemover);
                    System.out.println("Elemento removido com sucesso!");
                    break;
                case 10:
                    System.out.print("Digite o elemento a ser pesquisado: ");
                    int elemPesquisar = scan.nextInt();
                    if (arv.pesquisa(elemPesquisar)) {
                        System.out.println("Elemento encontrado na árvore!");
                    } else {
                        System.out.println("Elemento não encontrado na árvore.");
                    }
                    break;
                case 11:
                    System.out.println("Menor elemento da árvore: " + arv.acessaMenor());
                    break;
                case 12:
                    System.out.println("Maior elemento da árvore: " + arv.acessaMaior());
                    break;
                case 13:
                    arv.limpa();
                    System.out.println("Árvore limpa com sucesso!");
                    break;
                case 14:
                    ArrayList<Integer> vetorEmOrdem = arv.criaVetorEmOrdem();
                    System.out.println("Vetor com elementos em ordem:");
                    System.out.println(vetorEmOrdem);
                    break;
                case 15:
                    arv.balanceamentoEstatico();
                    System.out.println("Árvore balanceada com sucesso!");
                    break;
                case 16:
                    System.out.println("Encerrando o programa.");
                    scan.close();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
