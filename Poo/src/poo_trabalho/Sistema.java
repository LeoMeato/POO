package poo_trabalho;

import java.util.Scanner;

public class Sistema {
	
	Usuario user;
	
	public int tratarResposta(int max, Scanner s) { //pede uma escolha do usuário até que digite um inteiro entre 1 e max
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
		s.nextLine(); //não sei se precisa
		while(true) {
			System.out.println("\n\nLogin: ");
			login = s.nextLine();
			System.out.println("\nSenha: ");
			senha = s.nextLine();
			u = ColeçãoUsuarios.buscar(login);
			if (u.getLogin() == login && u.getSenha() == senha) {
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
		System.out.println("\nInsira um login: ");
		login = s.nextLine();
		System.out.println("\nInsira um nome: ");
		nome = s.nextLine();
		System.out.println("\nInsira uma senha: ");
		senha = s.nextLine();
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
			if (escolha == 1) u.criarPlaylist();
			else if (escolha == 2) {
				System.out.println("\nQue música gostaria de adicionar? ");
				titulo = s.nextLine();
				if (u.adicionar(titulo)) System.out.println("\nMúsica adicionada na playlist com sucesso!");
				else System.out.println("\nMúsica não existe.");
			}
		}
		
	}
	
	public void páginaOperaçõesAdm() {
		
	}
	
	public void executar() {
		int escolha1;
		while (true) {
			escolha1 = páginaInicial();
			if (escolha1 == 1) if(páginaLogIn());
			else if (escolha1 == 2) páginaSignUp();
			else if (escolha1 == 3) break;
		}
	}

}
