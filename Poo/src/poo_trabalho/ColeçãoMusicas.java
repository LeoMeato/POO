package poo_trabalho;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ColeçãoMusicas {
	
	private static Collection<Musica> coleção = new ArrayList<Musica>();
	
	public static Musica recuperar(String nome) {            
		Iterator<Musica> it = coleção.iterator();
		Musica m;
		int tamanho = coleção.size();
		for (int i = 0; i < tamanho; i++) {
			m = it.next();
			if (m.getTítulo().compareTo(nome) == 0) return m;
		}
		return null;
	}
	
	public static boolean cadastra(Musica musica) {
		boolean contém = coleção.contains(musica);
		if(!contém) coleção.add(musica);
		return !contém;
	}
	
	/*public boolean atualizar(Musica musica) {          // o que seria atualizar uma música? Só tirar a antiga e botar uma nova?
		
	}*/
	
	public static boolean remover(Musica musica) {
		boolean contém = coleção.contains(musica);
		if(contém) coleção.remove(musica);
		return contém;
	}

}
