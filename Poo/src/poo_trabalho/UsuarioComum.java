package poo_trabalho;

import java.util.Collection;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class UsuarioComum extends Usuario {
	
	private Collection<Musica> coleçãoParticular;
	private String tipo = "comum";
	
	public boolean adicionar(String titulo) {
		Musica m = ColeçãoMusicas.recuperar(titulo);
		if (m != null) {
			if (!coleçãoParticular.contains(m) && coleçãoParticular != null) {
				try {
					byte[] identificador = ByteBuffer.allocate(4).putInt(m.getIdentificador()).array();
    				Collection<byte[]> colecao = new ArrayList<>();
    				colecao.add(identificador);
    				return Persistência.WriteBin(colecao, 1);
				} catch (Exception e) {
					System.out.println(e.toString());
				}

				this.coleçãoParticular.add(m);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public UsuarioComum(String nome, int identificador, String login, String senha) {
		super(nome, identificador, login, senha);
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
			if (titulo.toLowerCase().compareTo(m.getTítulo().toLowerCase()) == 0) return m;
		}
		return null;
	}
	
	public void vizualizar(String titulo) {
		Musica m = buscar(titulo);
		if (m != null) System.out.println("Resultado para '" + titulo + "':\n\n" + m.toStringVizualizar());
		else System.out.println("Música não encontrada.");
	}
	
	public boolean seCadastrar() {
		if (ColeçãoUsuarios.buscar(getLogin()) == null) {
			ColeçãoUsuarios.adicionar(this);
			return true;
		}
		return false;
	}
	
	public boolean seRemover() {
		if (ColeçãoUsuarios.buscar(getLogin()) != null) {
			ColeçãoUsuarios.remover(this);
			return true;
		}
		return false;
	}

	public byte[] toByte(){
		byte[] struct = super.toByte();
		ByteBuffer bb = ByteBuffer.wrap(struct);
		bb.put(124, "usuariocomum".getBytes());
		struct = bb.array();
		return struct;
	}
	public byte[] toLogInByte(){
		return super.toLogInByte();
	}

	public String getTipo() {
		return tipo;
	}
}
