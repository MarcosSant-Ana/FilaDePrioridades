//Solicitar nova senha (Comum ou Prioridade), Excluir uma senha, Listar todas as senhas, 
//Visualizar que é o próximo a ser atendido, chamar o próximo a ser atendido, respeitando as regras de prioridade;

package QueuePriority;

import java.util.Objects;

import javax.swing.JOptionPane;

public class StaticEstructure {
	public String[] vetSenha;
	private int contador;
	

	// contrutores
	public StaticEstructure(int capacidade) {
		this.vetSenha = new String[capacidade];
		this.contador = 0;
	}

	public StaticEstructure() {
		this(2);
	}

	// esta sendo passado um elemento pelo parametro, nao o vetor
	public boolean gerarSenha(String vetSenha) {
		this.aumentaCapacidade();

		if (this.contador < this.vetSenha.length) {
			this.vetSenha[this.contador] = vetSenha;
			this.contador++;
			return true;
		} else {
			return false;
		}
	}

	public void remove(int posicao) {
		if (!(posicao >= 0 && posicao < contador)) {
			JOptionPane.showMessageDialog(null, "Posição não encontrada");
		} else {
			for (int i = posicao; i < contador - 1; i++) {
				vetSenha[i] = vetSenha[i + 1];
				
			}
			contador--;
		}
	}

	public void aumentaCapacidade() {
		if (this.contador == this.vetSenha.length) {
			String[] elementosNovos = new String [this.vetSenha.length * 2];
			for (int i = 0; i < this.vetSenha.length; i++) {
				elementosNovos[i] = this.vetSenha[i];
			}
			this.vetSenha = elementosNovos;
		}
	}

	public boolean estaVazia() {
		return this.contador == 0;
	}

	// ===============================================================================\\
	// getters e setters

	public int getContador() {
		return contador;
	}

	// toString
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");

		for (int i = 0; i < this.contador - 1; i++) {
			s.append(this.vetSenha[i]);
			s.append(", ");
		}

		if (this.contador > 0) {
			s.append(this.vetSenha[this.contador - 1]);
		}

		s.append("]");

		return s.toString();
	}
}
