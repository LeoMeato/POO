package poo_trabalho;

import java.nio.ByteBuffer;

public class Administrador extends Usuario {
	
	private String tipo = "adm";
	
	public Administrador(String nome, int identificador, String login, String senha) {
		super(nome, identificador, login, senha);
	}
	
    public byte[] toByte(){
		byte[] struct = super.toByte();
		ByteBuffer bb = ByteBuffer.wrap(struct);
		bb.put(124, "administrador".getBytes());
		return struct;
	}

	public byte[] toLogInByte(){
		return super.toLogInByte();
	}
	
	public String getTipo() {
		return tipo;
	}

}
