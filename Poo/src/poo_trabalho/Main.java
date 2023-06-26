package poo_trabalho;

public class Main {

	/*public static void main(String[] args) {
	Canção teste = new Canção(0, "Love of My life", new Duração(10, 2), "Freddie", new Data(22,02,2003), "Rock", "C:\\Users\\estev\\OneDrive\\\u00C1rea de Trabalho\\POO\\Poo\\src\\poo_trabalho\\letra.txt");
			System.out.println(teste.getLetra());
			System.out.println(teste.getTítulo());

}*/
	
	public static void main(String[] args) {


			MusicaInstrumental m1 = new MusicaInstrumental(1111, "O Bater de Asas da Borboleta", new Duração(23, 4), "Mc Leozin", new Data(12, 4, 2007), "Funk", "partitura01");
			Canção m2 = new Canção(2222, "Quando Surgirem as Estrelas", new Duração(25, 3), "Estevasso", new Data(18, 7, 2009), "Rock", "Poo\\src\\poo_trabalho\\letra.txt");
			Musica m3 = new MusicaInstrumental(3333, "Para Sempre Te Amarei", new Duração(57, 4), "Mozart II", new Data(1, 6, 1967), "Música Clássica", "partitura02");

			ColeçãoMusicas.cadastra(m1);
			ColeçãoMusicas.cadastra(m2);
			ColeçãoMusicas.cadastra(m3);
			
			UsuarioComum uc1 = new UsuarioComum("a", 0, "a", "a");
			UsuarioComum uc2 = new UsuarioComum("b", 1, "b", "b");
			
			Administrador adm1 = new Administrador("c", 2, "c", "c");
			
			uc1.seCadastrar();
			uc2.seCadastrar();
			
			ColeçãoUsuarios.adicionar(adm1);
			
			Sistema s = new Sistema();
			s.executar();
			

	}
}