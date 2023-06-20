package poo_trabalho;

public class Main {

	/*public static void main(String[] args) {
	Canção teste = new Canção(0, "Love of My life", new Duração(10, 2), "Freddie", new Data(22,02,2003), "Rock", "C:\\Users\\estev\\OneDrive\\\u00C1rea de Trabalho\\POO\\Poo\\src\\poo_trabalho\\letra.txt");
			System.out.println(teste.getLetra());
			System.out.println(teste.getTítulo());

}*/
	
	public static void main(String[] args) {


			MusicaInstrumental m1 = new MusicaInstrumental(1111, "O Bater de Asas da Borboleta", new Duração(23, 4), "Mc Leozin", new Data(12, 4, 2007), "Funk", "partitura01");
			Musica m2 = new Canção(2222, "Quando Surgirem as Estrelas", new Duração(25, 3), "Estevasso", new Data(18, 7, 2009), "Rock", "C:\\Users\\estev\\OneDrive\\\u00C1rea de Trabalho\\POO\\Poo\\src\\poo_trabalho\\letra.txt");
			Musica m3 = new MusicaInstrumental(3333, "Para Sempre Te Amarei", new Duração(57, 4), "Mozart II", new Data(1, 6, 1967), "Música Clássica", "partitura02");

			ColeçãoMusicas.cadastra(m1);
			ColeçãoMusicas.cadastra(m2);
			ColeçãoMusicas.cadastra(m3);
			
			UsuarioComum uc1 = new UsuarioComum();
			UsuarioComum uc2 = new UsuarioComum();
			
			uc1.setLogin("abcd");
			uc2.setLogin("efgh");
			
			uc1.seCadastrar();
			uc2.seCadastrar();
			
			uc1.criarPlaylist();
			
			uc1.adicionar("O Bater de Asas da Borboleta");
			uc1.adicionar("Quando Surgirem as Estrelas");
			
			uc2.seRemover();
			
			uc1.vizualizar("Quando Surgirem as Estrelas");
			System.out.println(m1.toByte());

			ColeçãoMusicas.escrever();

			
			/*Usuario u = ColeçãoUsuarios.buscar(uc2.getLogin());
			if (u != null) System.out.println(u.getLogin());
			else System.out.println("usuário não existe");*/

	}
}