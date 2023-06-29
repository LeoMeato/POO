package poo_trabalho;

import java.util.Scanner;

public class Sistema {
	
	Usuario user;
	
	public static int tratarResposta(int max, Scanner s) { //pede uma escolha do usuário até que digite um inteiro entre 1 e max
		int escolha;
		while (true) {
			escolha = s.nextInt();
			for (int i = 1; i <= max; i++) {
				if (escolha == i) {
					return escolha;
				}
			}
			System.out.println("\nOpção inválida, tente novamente: ");
		}
	}
	
	public int páginaInicial() {
		int escolha;
		Scanner s = new Scanner(System.in);
		System.out.println("ESPOT FAY\n\n(1) Log In\n(2) Sign Up\n(3) Encerrar\n\nComo deseja prosseguir? ");
		escolha = tratarResposta(3, s);
		return escolha;
	}
	
	public boolean páginaLogIn() {
		String login;
		String senha;
		Usuario u;
		int escolha;
		Scanner s = new Scanner(System.in);
		//s.nextLine(); //não sei se precisa
		while(true) {
			System.out.println("\n\nLogin: ");
			login = s.nextLine().strip();
			System.out.println("\nSenha: ");
			senha = s.nextLine().strip();
			u = ColeçãoUsuarios.buscar(login);
			if (u != null && u.getLogin().compareTo(login) == 0 && u.getSenha().compareTo(senha) == 0) {
				this.user = u;
				return true;
			}
			System.out.println("\n\nSenha ou login errados, digite 1 para tentar novamente e 2 para voltar ");
			escolha = s.nextInt();
			if (escolha == 2) break;
		}
		return false;
	}
	
	public void páginaSignUp() {
		Usuario u;
		int escolha;
		int id;
		String login;
		String nome;
		String senha;
		Scanner s = new Scanner(System.in);
		System.out.println("Que tipo de conta quer criar?\n\n(1) Usuário Comum\n(2) Administrador\n");
		escolha = tratarResposta(2, s);
		System.out.println("\nInsira um identificador: ");
		id = s.nextInt();
		s.nextLine();
		System.out.println("\nInsira um login: ");
		login = s.nextLine().strip();
		System.out.println("\nInsira um nome: ");
		nome = s.nextLine().strip();
		System.out.println("\nInsira uma senha: ");
		senha = s.nextLine().strip();
		if (escolha == 1) u = new UsuarioComum(nome, id, login, senha);
		else u = new Administrador(nome, id, login, senha);
		ColeçãoUsuarios.adicionar(u);
		System.out.println("Conta criada com sucesso!");
	}
	
	public void páginaOperações() {
		if (user.getTipo().compareTo("comum") == 0) páginaOperaçõesComum();
		else if (user.getTipo().compareTo("adm") == 0) páginaOperaçõesAdm();
	}
	
	public void páginaOperaçõesComum() {
		
		UsuarioComum u = (UsuarioComum) user;
		int escolha;
		Scanner s = new Scanner(System.in);
		String titulo;
		while (true) {
			System.out.println("O que deseja fazer?\n\n"
					+ "(1) Criar/Resetar a playlist\n"
					+ "(2) Adicionar música na playlist\n"
					+ "(3) Remover música da playlist\n"
					+ "(4) Vizualizar música\n"
					+ "(5) Apagar a conta\n"
					+ "(6) Sair\n");
			escolha = tratarResposta(6, s);
			s.nextLine();
			if (escolha == 1) u.criarPlaylist();
			else if (escolha == 2) {
				System.out.println("\nQue música gostaria de adicionar? ");
				titulo = s.nextLine();
				if (u.adicionar(titulo)) System.out.println("\nMúsica adicionada na playlist com sucesso!");
				else System.out.println("\nMúsica não existe ou já está na playlist.");
			}
			else if (escolha == 3) {
				System.out.println("\nQue música gostaria de remover? ");
				titulo = s.nextLine();
				if (u.remover(titulo)) System.out.println("\nMúsica removida da playlist com sucesso!");
				else System.out.println("\nMúsica não existe.");
			}
			else if (escolha == 4) {
				System.out.println("\nQue música gostaria de vizualizar? ");
				titulo = s.nextLine();
				u.vizualizar(titulo);
			}
			else if (escolha == 5) {
				u.seRemover();
				System.out.println("Conta excluída com sucesso!");
				this.user = null;
				break;
			}
			else if (escolha == 6) {
				this.user = null;
				break;
			}
		}
		
	}
	
	public void páginaOperaçõesAdm() {
		
		Administrador u = (Administrador) user;
		int escolha;
		String busca;
		Scanner s = new Scanner(System.in);
		String titulo;
		while (true) {
			System.out.println("O que deseja fazer?\n\n"
					+ "(1) Cadastrar música\n"
					+ "(2) Vizualizar música\n"
					+ "(3) Atualizar música\n"
					+ "(4) Remover música\n"
					+ "(5) Adicionar usuário\n"
					+ "(6) Buscar usuário\n"
					+ "(7) Remover usuário\n"
					+ "(8) Sair\n");
			escolha = tratarResposta(8, s);
			s.nextLine();
			if (escolha == 1) ColeçãoMusicas.novaMusica();
			else if (escolha == 2) {System.out.println("\nQue música quer vizualizar? "); ColeçãoMusicas.vizualizar(s.nextLine());}
			else if (escolha == 3) atualizar();
			else if (escolha == 4) {System.out.println("\nQue música quer remover? "); if (ColeçãoMusicas.remover(ColeçãoMusicas.recuperar(s.nextLine()))) System.out.println("\n\nMúsica removida com sucesso!\n");}
			else if (escolha == 5) páginaSignUp();
			else if (escolha == 6) {System.out.println("\nQue usuário quer buscar? (login) "); ColeçãoUsuarios.buscar(s.nextLine()).toString();}
			else if (escolha == 7) {System.out.println("\nQue usuário quer remover? (login) "); ColeçãoUsuarios.remover(ColeçãoUsuarios.buscar(s.nextLine()));}
			else if (escolha == 8) {this.user = null; break;}
		}
			
	}
	
	public void atualizar() {
		
		Scanner s = new Scanner(System.in);
		String titulo;
		int escolha;
		System.out.println("\nQual música gostaria de atualizar?\n");
		titulo = s.nextLine();
		Musica m = ColeçãoMusicas.recuperar(titulo);
		if (m != null) {
			System.out.println("Qual parte da música gostaria de atualizar?\n\n"
					+ "(1) Título\n"
					+ "(2) Identificador\n"
					+ "(3) Duração\n"
					+ "(4) Autores\n"
					+ "(5) Data\n"
					+ "(6) Gênero Musical\n"
					+ "(7) Nome do arquivo\n");
			escolha = tratarResposta(7, s);
			
			if (escolha == 1) {
				System.out.println("\nQual o novo título? ");
				String t = s.nextLine();
				m.setTítulo(t);
				System.out.println("\nTítulo alterado para " + t + " com sucesso!");
			}
			else if (escolha == 2) {
				System.out.println("\nQual o novo identificador? ");
				int i = s.nextInt();
				m.setIdentificador(i);
				System.out.println("\nIdentificador alterado para " + i + " com sucesso!");
			}
			else if (escolha == 3) {
				System.out.println("\nQual a nova duração? (segundos) ");
				int seg = s.nextInt();
				Duração d = new Duração(seg % 60, (seg - (seg % 60)) / 60);
				m.setDuração(d);
				System.out.println("\nDuração alterada para " + d.getMinutos() + "min" + d.getSegundos() + "seg" + " com sucesso!");
			}
			else if (escolha == 4) {
				System.out.println("\nQuais os novos autores? ");
				String a = s.nextLine();
				m.setAutores(a);
				System.out.println("\nAutores alterados para " + a + " com sucesso!");
			}
			else if (escolha == 5) {
				int dia, mes, ano;
				System.out.println("\nNovo dia: ");
				dia = s.nextInt();
				System.out.println("\nNovo mes: ");
				mes = s.nextInt();
				System.out.println("\nNovo ano: ");
				ano = s.nextInt();
				Data d = new Data(dia, mes, ano);
				m.setData(d);
				System.out.println("\nData alterada para " + d.getDia() + "/" + d.getMês() + "/" + d.getAno() + " com sucesso!");
			}
			else if (escolha == 6) {
				System.out.println("\nQual o novo gênero musical? ");
				String g = s.nextLine();
				m.setGênero_musical(g);
				System.out.println("\nGênero alterado para " + g + " com sucesso!");
			}
			else if (escolha == 7) {
				System.out.println("\nQual o novo nome do arquivo? ");
				String a = s.nextLine();
				m.setNomeArquivo(a);
				System.out.println("\nNome do arquivo alterado para " + a + " com sucesso!");
			}
			
		} else System.out.println("\nMúsica não encontrada.");
		
	}
	
	public void executar() {
		int escolha1;
		while (true) {
			escolha1 = páginaInicial();
			if (escolha1 == 1) {if(páginaLogIn()) páginaOperações();}
			else if (escolha1 == 2) páginaSignUp();
			else if (escolha1 == 3) break;
		}
	}

}
