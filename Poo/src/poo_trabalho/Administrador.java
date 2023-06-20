package poo_trabalho;

import java.nio.ByteBuffer;

public class Administrador extends Usuario {
    public byte[] toByte(){
		byte[] struct = super.toByte();
		ByteBuffer bb = ByteBuffer.wrap(struct);
		bb.put(124, "administrador".getBytes());
		return struct;
	}

	public byte[] toLogInByte(){
		return super.toLogInByte();
	}

}
