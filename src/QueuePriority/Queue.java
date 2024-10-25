package QueuePriority;

import javax.swing.JOptionPane;

public class Queue extends StaticEstructure {

    private int contadorDePrioridade = 0;

    public Queue() {
        super();
    }

    public void adicionarSenha(String elemento) {
        this.gerarSenha(elemento);
    }

    public void removerSenha(int posicao) {
        this.remove(posicao);
     
    }

    public String verProximoChamado() {
        if (this.estaVazia()) {
            return null;
        }
        return this.vetSenha[0];
    }

    public String chamarProximo() {
        if (this.estaVazia()) {
            return null;
        }

        String elementoASerRemovido = null;

        if (contadorDePrioridade < 3) {
            for (int i = 0; i < getContador(); i++) {
                if (this.vetSenha[i].charAt(0) == 'P') {
                    elementoASerRemovido = this.vetSenha[i];
                    this.remove(i);
                    contadorDePrioridade++;
                    break;
                }
            }
        }

        if (elementoASerRemovido == null) {
            for (int i = 0; i < getContador(); i++) {
                if (this.vetSenha[i].charAt(0) == 'C') {
                    elementoASerRemovido = this.vetSenha[i];
                    this.remove(i);
                    contadorDePrioridade = 0; // Reseta o contador após chamar um elemento comum
                    break;
                }
            }
        }

        return elementoASerRemovido;
    }
}