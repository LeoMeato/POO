// Por enquanto, usando a Main como ambiente de testes.


package poo_trabalho;

public class Main {

	public static void main(String[] args) {
		
		ColeçãoMusicas c = new ColeçãoMusicas();
		
		Musica m1 = new MusicaInstrumental();
		Musica m2 = new Canção();
		Musica m3 = new MusicaInstrumental();
		
		m1.setTítulo("O Bater de Asas da Borboleta");
		m2.setTítulo("Quando Surgirem as Estrelas");
		m3.setTítulo("Para Sempre Te Amarei");
		
		c.cadastra(m1);
		c.cadastra(m2);
		c.cadastra(m3);
		
		Musica m = c.recuperar("Quando Surgirem as Estrelas");
		String n = null;
		if (m != null) n = m.getTítulo();
		
		if (n != null) System.out.println(n);

	}

}
