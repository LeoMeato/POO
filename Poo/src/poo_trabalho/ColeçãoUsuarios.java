package poo_trabalho;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class ColeçãoUsuarios {
	
	private static Collection<Usuario> coleção = new ArrayList<Usuario>();

	public static boolean adicionar(Usuario u) {
		boolean contém = coleção.contains(u);
		if(!contém) coleção.add(u);
		return !contém;
	}
	
	public static boolean remover(Usuario u) {
		boolean contém = coleção.contains(u);
		if(contém) coleção.remove(u);
		return contém;
	}
	
	public static Usuario buscar(String login) {
		
		Iterator<Usuario> it = coleção.iterator();
		Usuario u;
		int tamanho = coleção.size();
		for(int i = 0; i < tamanho; i++) {
			u = it.next();
			if (u.getLogin().compareTo(login) == 0) return u;
		}
		return null;
		
	}
	
}
