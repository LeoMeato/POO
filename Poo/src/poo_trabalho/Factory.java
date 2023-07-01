package poo_trabalho;

public class Factory {
	
	public static Usuario instanciarUsuario(String tipo, Usuario u, String nome, int identificador, String senha) {
		if (tipo.compareTo("comum") == 0) {
        	u = new UsuarioComum(nome, identificador, null, senha);
        } else if (tipo.compareTo("adm") == 0) {
			u = new Administrador(nome, identificador, null, senha);
		}
		return u;
	}
	
	public static Musica instanciarMusica(String tipo, Musica m, int identificador, String titulo, int seg, int min, String autores, int dia, int mes, int ano, String genero, String arquivo) {
		if (tipo.compareTo("musicainstrumental") == 0) {
        	m = new MusicaInstrumental(identificador, titulo, new Duração(seg, min), autores, new Data(dia, mes, ano), genero, arquivo);
        } else if (tipo.compareTo("cancao") == 0) {
			m = new Canção(identificador, titulo, new Duração(seg, min), autores, new Data(dia, mes, ano), genero, arquivo);
		}
		return m;
	}
	
	public static Musica instanciarMusica(int tipo, Musica m, int identificador, String titulo, Duração duração, String autores, Data data, String genero, String arquivo) {
		if (tipo == 1) {
        	m = new MusicaInstrumental(identificador, titulo, duração, autores, data, genero, arquivo);
        } else if (tipo == 2) {
			m = new Canção(identificador, titulo, duração, autores, data, genero, arquivo);
		}
		return m;
	}
	
}
