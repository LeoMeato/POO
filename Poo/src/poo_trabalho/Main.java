package poo_trabalho;

public class Main {
	
	public static void main(String[] args) {
		
		/*Administrador adm = new Administrador("c", 1, "c", "c");
		UsuarioComum uc1 = new UsuarioComum("a", 2, "a", "a");
		UsuarioComum uc2 = new UsuarioComum("b", 3, "b", "b");
		
		uc1.seCadastrar();
		uc2.seCadastrar();
		
		ColeçãoUsuarios.adicionar(adm);
		
		Musica m1, m2, m3;
		m1 = new MusicaInstrumental(1111, "abc", new Duração(23, 4), "abc", new Data(2, 3, 2002), "abc", "partitura01");
		m2 = new Canção(2222, "def", new Duração(18, 6), "def", new Data(25, 12, 1999), "def", "letra.txt");
		m3 = new MusicaInstrumental(3333, "ghi", new Duração(20, 2), "ghi", new Data(18, 7, 2009), "ghi", "partitura02");
		
		ColeçãoMusicas.cadastra(m1);
		ColeçãoMusicas.cadastra(m2);
		ColeçãoMusicas.cadastra(m3);*/
			
		Sistema s = new Sistema();
			
		s.recuperarPersistência();
		s.executar();
		s.guardarPersistência();

	}
}