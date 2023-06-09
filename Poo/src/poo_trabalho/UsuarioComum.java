package poo_trabalho;

import java.util.Collection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class UsuarioComum extends Usuario {
	
	private Collection<Musica> coleçãoParticular;
	private String tipo = "comum";
	private String nomeArquivo = this.getNome()+"Playlist.bin";
	
	public boolean adicionar(String titulo) {
		Musica m = ColeçãoMusicas.recuperar(titulo);
		if (m != null && coleçãoParticular != null) {
			if (!coleçãoParticular.contains(m) && coleçãoParticular != null) {
				/*try {
					byte[] identificador = ByteBuffer.allocate(4).putInt(m.getIdentificador()).array();
    				Collection<byte[]> colecao = new ArrayList<>();
    				colecao.add(identificador);
    				return Persistência.WriteBin(colecao, nomeArquivo);
				} catch (Exception e) {
					System.out.println(e.toString());
				}*/

				this.coleçãoParticular.add(m);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public UsuarioComum(String nome, int identificador, String login, String senha) {
		super(nome, identificador, login, senha);
		try {
            File arquivo = new File(nomeArquivo);

            if (arquivo.createNewFile()) {
                //System.out.println("Arquivo criado: " + arquivo.getAbsolutePath());
            } else {
                //System.out.println("O arquivo já existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void criarPlaylist() {
		this.coleçãoParticular = new ArrayList<Musica>();
	}
	
	public boolean remover(String titulo) {
		Musica m = buscar(titulo);
		if (m !=  null) {
			coleçãoParticular.remove(m);
			/*byte[] identificador = ByteBuffer.allocate(4).putInt(m.getIdentificador()).array();
    		Collection<byte[]> colecao = new ArrayList<>();
    		colecao.add(identificador);
    		return Persistência.RemoveFromBin(colecao, nomeArquivo);*/
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
		bb.put(124, "comum".getBytes());
		struct = bb.array();
		return struct;
	}
	public byte[] toLogInByte(){
		return super.toLogInByte();
	}

	public String getTipo() {
		return tipo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void lê() {

	    Musica m = null;
	
	    try (DataInputStream input = Persistência.readBin(nomeArquivo)) {
	    	if (input.available() > 0) this.coleçãoParticular = new ArrayList<Musica>();
	        while (input.available() > 0) {
	            int identificador;
	            identificador = input.readInt();
	            m = ColeçãoMusicas.buscaID(identificador);
	            if (m != null) coleçãoParticular.add(m);
	        }
	        input.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
        
    }
	
	public Collection<byte[]> escreve() {
		Collection<byte[]> col = new ArrayList<byte[]>();
		Iterator<Musica> it = coleçãoParticular.iterator();
		Musica m;
		for (int i = 0; i < coleçãoParticular.size(); i++) {
			m = it.next();
			byte[] struct = new byte[4];
			Arrays.fill(struct, (byte)0);
			ByteBuffer bb = ByteBuffer.wrap(struct);
			bb.putInt(0, m.getIdentificador());
			struct = bb.array();
			col.add(struct);
		}
		return col;
	}
	
	@Override
	public String toString() {
		return "UsuarioComum [coleçãoParticular=" + coleçãoParticular + ", tipo=" + tipo + ", nomeArquivo="
				+ nomeArquivo + ", toString()=" + super.toString() + ", getNome()=" + getNome()
				+ ", getIdentificador()=" + getIdentificador() + ", getLogin()=" + getLogin() + ", getSenha()="
				+ getSenha() + "]";
	}

	public boolean temPlaylist() {
		return (coleçãoParticular != null);
	}

	
}
