package poo_trabalho;

import java.util.Collection;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ColeçãoUsuarios {
	
	private static Collection<Usuario> coleção = new ArrayList<Usuario>();
	
	public static void imprimePrimeiro() {                     //método de teste
		Iterator<Usuario> it = coleção.iterator();
		System.out.println(it.next().getIdentificador());
	}

	public static boolean adicionar(Usuario u) {
		boolean contém = coleção.contains(u);
		if(!contém && u != null) coleção.add(u);
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
			if (u.getLogin().toLowerCase().compareTo(login.toLowerCase()) == 0) return u;
		}
		return null;
		
	}
	public static void escrever(){
		Iterator<Usuario> it = coleção.iterator();
		Usuario m;
		Collection<byte[]> col = new ArrayList<byte[]>();
		for (int i = 0; i < coleção.size(); i++) {
			m = it.next();
			col.add(m.toByte());
		}
		Persistência.writeBin(col, "users.bin");
	}
	
	public static void escreverLogin(){
		Iterator<Usuario> it = coleção.iterator();
		Usuario m;
		Collection<byte[]> col = new ArrayList<byte[]>();
		for (int i = 0; i < coleção.size(); i++) {
			m = it.next();
			col.add(m.toLogInByte());
		}
		Persistência.writeBin(col, "login.bin");
	}
	
	public static void lê() {

	    Usuario u = null;
	
	    try (DataInputStream input = Persistência.readBin("users.bin")) {
	        while (input.available() > 0) {
	            byte[] nomeb = new byte[60];
	            byte[] senhab = new byte[60];
	            byte[] tipob = new byte[20];
	            int identificador;
	            input.read(nomeb);
	            identificador = input.readInt();
	            input.read(senhab);
	            input.read(tipob);
	            String nome = new String(nomeb).trim();
	            String senha = new String(senhab).trim();
	            String tipo = new String(tipob).trim();
	            u = Factory.instanciarUsuario(tipo, u, nome, identificador, senha);
	            coleção.add(u);
	        }
	        input.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
        
    }
	
	public static void lêLogin() {
		
		Usuario u;
	
	    try (DataInputStream input = Persistência.readBin("login.bin")) {
	        while (input.available() > 0) {
	        	Iterator<Usuario> it = coleção.iterator();
	            byte[] loginb = new byte[60];
	            int identificador;
	            identificador = input.readInt();
	            input.read(loginb);
	            String login = new String(loginb).trim();
	            
	            for (int i = 0; i < coleção.size(); i++) {
	            	u = it.next();
	            	if (u.getIdentificador() == identificador) {
	            		u.setLogin(login);
	            		break;
	            	}
	            }


	        }
	        input.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
        
    }
	
	public static void lêPlaylist() {
		
		Usuario u;
		Iterator<Usuario> it = coleção.iterator();
		for (int i = 0; i < coleção.size(); i++) {
			u = it.next();
			if (u.getTipo().compareTo("comum") == 0) {
				UsuarioComum uc = (UsuarioComum) u;
				uc.lê();
			}
		}
		
	}
	
	public static void escrevePlaylist() {
		
		Usuario u;
		Iterator<Usuario> it = coleção.iterator();
		for (int i = 0; i < coleção.size(); i++) {
			u = it.next();
			if (u.getTipo().compareTo("comum") == 0) {
				UsuarioComum uc = (UsuarioComum) u;
				if (uc.temPlaylist()) Persistência.writeBin(uc.escreve(), uc.getNomeArquivo());
			}
		}
		
	}
	
}
