package QueuePriority;

import javax.swing.JOptionPane;

public class TestQueue {
	static Queue fila = new Queue();

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Object op, op2;
		int resp = 0;
		int acumuladorC = 0;
		int acumuladorP = 0;
		int contadorDePrioridade = 0;
		boolean retornaMenu = false;

		// objetos da classe Queue

		do {
			// primeira tela = menu
			String[] options = { "Comum", "Prioridade", "Sair" };
			op = JOptionPane.showOptionDialog(null, "Colete uma senha", "Coleta sanguinia",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			// segunda tela = submenu
			String[] options2 = { "Gerar senha", "Excluir senha", "Opções" };

			switch ((int) op) {
			// executa a propriedade para a 1° opcao (comum)
			case 0:
				do {
					op2 = JOptionPane.showOptionDialog(null, "Escolha um função: ", "Menu de validações",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2,
							options2[0]);

					if ((int) op2 == 0) {
						String senha = "C";
						acumuladorC += 1;
						String concatena = senha + acumuladorC;
						fila.adicionarSenha(senha + acumuladorC);
						JOptionPane.showMessageDialog(null, "Senha gerada: " + concatena, "Senha", 1);
					} else if ((int) op2 == 1) {
						fila.removerSenha(Integer.parseInt(JOptionPane.showInputDialog("Insira uma posição")));

					} else if ((int) op2 == 2) {
						JOptionPane.showMessageDialog(null, "Retornando pro menu!");
						menu2(retornaMenu);
						retornaMenu = true;
					}
				} while (!retornaMenu);
				retornaMenu = false;
				break;

			// executa a propriedade quando é 2° opcao (prioridade)
			case 1:
				do {
					op2 = JOptionPane.showOptionDialog(null, "Escolha um função: ", "Menu de validações",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2,
							options2[0]);

					if ((int) op2 == 0) {
						String senha = "P";
						acumuladorP += 1;
						String concatena = senha + acumuladorP;
						fila.adicionarSenha(concatena);
						contadorDePrioridade++;
						JOptionPane.showMessageDialog(null, "Senha gerada: " + concatena, "Senha", 1);
					} else if ((int) op2 == 1) {
						fila.removerSenha(Integer.parseInt(JOptionPane.showInputDialog("Insira uma posição")));
						
					} else if ((int) op2 == 2) {
						JOptionPane.showMessageDialog(null, "Retornando pro menu!");
						menu2(retornaMenu);
						retornaMenu = true;
					}
				} while (!retornaMenu);
				retornaMenu = false;
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "Encerrando!");
				resp = JOptionPane.NO_OPTION; // Sair
				continue;

			default:
				JOptionPane.showMessageDialog(null, "Encerrando!");
				resp = JOptionPane.NO_OPTION; // Sair
				return;
			}
		} while (resp == JOptionPane.YES_OPTION);
	}

	// terceira tela, fora do switch, submenu

	public static void menu2(boolean retornaMenu) {
		Object op3;
		String[] options3 = { "Listar", "Ver proximo", "Chamar Proximo", "Senhas" };

		do {
			op3 = JOptionPane.showOptionDialog(null, "Escolha um função: ", "Menu de validações",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options3, options3[0]);

			if ((int) op3 == 0) {
				if (fila.estaVazia()) {
					JOptionPane.showMessageDialog(null, "Senhas não geradas");
				} else {
					JOptionPane.showMessageDialog(null, "Senhas: " + fila.toString());
				}
			} else if ((int) op3 == 1) {
				if (fila.estaVazia()) {
					JOptionPane.showMessageDialog(null, "Senhas não geradas");
				} else {
					JOptionPane.showMessageDialog(null, "Proximo da fila é: " + fila.verProximoChamado());
				}
			} else if ((int) op3 == 2) {
				if (!fila.estaVazia()) {
					String proximo = fila.chamarProximo();
					if (proximo != null) {
						JOptionPane.showMessageDialog(null, "Chamando: " + proximo);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhuma senha gerada");
				}
			} else if ((int) op3 == 3) {
				JOptionPane.showMessageDialog(null, "Retornando pro menu!");
				retornaMenu = true;
			}
		} while (!retornaMenu);
	}
}
