package poo_trabalho;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class Persistência {
    public static boolean WriteBin(Collection<byte[]> coleção, String arquivo) {
        try {
            /*String nomearquivo="Hola";
        
            if((arquivo-1)==0) nomearquivo = "C:\\Users\\estev\\OneDrive\\\u00C1rea de Trabalho\\POO\\Poo\\src\\poo_trabalho\\users.txt";
            else if((arquivo-2)==0) nomearquivo = "C:\\Users\\estev\\OneDrive\\\u00C1rea de Trabalho\\POO\\Poo\\src\\poo_trabalho\\songs.txt";
            else nomearquivo = "C:\\Users\\estev\\OneDrive\\\u00C1rea de Trabalho\\POO\\Poo\\src\\poo_trabalho\\login.txt";*/
            
            OutputStream outputstream = new FileOutputStream(arquivo);
            DataOutputStream out = new DataOutputStream(outputstream);
            for(byte[] b:coleção){
                out.write(b);
            }
            out.close();
            outputstream.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
            
    }
    public static boolean RemoveFromBin(Collection<byte[]> colecao, String nomearquivo) {
        try {
            File file = new File(nomearquivo);
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            
            for (byte[] b : colecao) {
                long bytePosition = findBytePosition(raf, b);
                if (bytePosition != -1) {
                    removeByte(raf, bytePosition);
                }
            }
            
            raf.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    private static long findBytePosition(RandomAccessFile raf, byte[] b) throws IOException {
        long position = -1;
        long fileLength = raf.length();
        
        for (long i = 0; i < fileLength; i++) {
            raf.seek(i);
            byte[] buffer = new byte[b.length];
            int bytesRead = raf.read(buffer);
            
            if (bytesRead == b.length && Arrays.equals(buffer, b)) {
                position = i;
                break;
            }
        }
        
        return position;
    }

    private static void removeByte(RandomAccessFile raf, long bytePosition) throws IOException {
        long fileLength = raf.length();
        
        for (long i = bytePosition + 1; i < fileLength; i++) {
            raf.seek(i);
            byte b = raf.readByte();
            raf.seek(i - 1);
            raf.writeByte(b);
        }
        
        raf.setLength(fileLength - 1);
    }

}