package poo_trabalho;

import java.nio.ByteBuffer;
import java.util.Arrays;

public abstract class Usuario {
	
	private String nome;
	private int identificador;
	private String login;
	private String senha;
	private String tipo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdentificador() {
		return identificador;
	}
	public Usuario(String nome, int identificador, String login, String senha) {
		super();
		this.nome = nome;
		this.identificador = identificador;
		this.login = login;
		this.senha = senha;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public byte[] toByte(){
		byte[]aux;
		byte[] struct = new byte[144];
		Arrays.fill(struct, (byte)0);
		ByteBuffer bb = ByteBuffer.wrap(struct);
		aux=getNome().getBytes();
		bb.put(0, aux);
		bb.putInt(60, getIdentificador());
		aux=getSenha().getBytes();
		bb.put(64, aux);
		return struct;
	}

	public byte[] toLogInByte(){
		byte[]aux = getLogin().getBytes();
		byte[] struct = new byte[64];
		Arrays.fill(struct, (byte)0);
		ByteBuffer bb = ByteBuffer.wrap(struct);
		bb.putInt(0, getIdentificador());
		bb.put(4,aux);
		return struct;
	}
	public String getTipo() {
		return tipo;
	}
	
	
}
