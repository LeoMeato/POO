package poo_trabalho;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class UsuarioComum extends Usuario {
	
	private Collection<Musica> coleçãoParticular;
	
	public boolean adicionar(String titulo) {
		Musica m = ColeçãoMusicas.recuperar(titulo);
		if (m != null) {
			if (!coleçãoParticular.contains(m)) {
				this.coleçãoParticular.add(m);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void criarPlaylist() {
		this.coleçãoParticular = new ArrayList<Musica>();
	}
	
	public boolean remover(String titulo) {
		Musica m = buscar(titulo);
		if (m !=  null) {
			coleçãoParticular.remove(m);
			return true;
		}
		return false;
	}
	
	public Musica buscar(String titulo) {
		Iterator<Musica> it = coleçãoParticular.iterator();
		Musica m;
		for (int i = 0; i < coleçãoParticular.size(); i++) {
			m = it.next();
			if (titulo.compareTo(m.getTítulo()) == 0) return m;
		}
		return null;
	}
	
	public void vizualizar(String titulo) {
		Musica m = buscar(titulo);
		System.out.println("Resultado para '" + titulo + "':\n\n" + m.toStringVizualizar());
	}
	
}
