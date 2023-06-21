package poo_trabalho;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
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
			if (m.getTítulo().toLowerCase().compareTo(nome.toLowerCase()) == 0) return m;
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

	public static void escrever(){
		Iterator<Musica> it = coleção.iterator();
		Musica m;
		Collection<byte[]> col = new ArrayList<byte[]>();
		for (int i = 0; i < coleção.size(); i++) {
			m = it.next();
			col.add(m.toByte());
		}
		Persistência.WriteBin(col, 796);
	}
}
