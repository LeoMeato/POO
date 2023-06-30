package poo_trabalho;

import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

     public static boolean WriteBin(Collection<byte[]> colecao, String arquivo) {
        try {
            OutputStream outputStream = new FileOutputStream(arquivo);
            DataOutputStream out = new DataOutputStream(outputStream);
            for (byte[] b : colecao) {
                out.write(b);
                System.out.println("aoba");
            }
            out.close();
            outputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean RemoveFromBin(Collection<byte[]> colecao, String nomearquivo) {
        try {
            RandomAccessFile raf = new RandomAccessFile(nomearquivo, "rw");

            for (byte[] b : colecao) {
                long bytePosition = findBytePosition(raf, b);
                if (bytePosition != -1) {
                    removeByte(raf, bytePosition);
                }
            }

            raf.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
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

    public static byte[] ReadBin(int n, String nomearquivo) {
    	
    	byte[] zeroBytes = new byte[n];
		Arrays.fill(zeroBytes, (byte)0);
		
        try {
            FileInputStream fis = new FileInputStream(nomearquivo);
            DataInputStream dis = new DataInputStream(fis);

            Collection<byte[]> colecao = new ArrayList<>();

            int bytesRead;
            byte[] buffer = new byte[zeroBytes.length];

            while ((bytesRead = dis.read(buffer)) != -1) {
                if (bytesRead == zeroBytes.length && bytesAreEqual(buffer, zeroBytes)) {
                    break;
                }

                colecao.add(buffer);
                buffer = new byte[zeroBytes.length];
            }

            dis.close();
            fis.close();

            return combineByteArrays(colecao);
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
	/*public static DataInputStream ReadBin(String nomearquivo) {
		
		FileInputStream filein;
		try {
			filein = new FileInputStream(nomearquivo);
			DataInputStream in = new DataInputStream(filein);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			return in;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	
	}*/

    private static boolean bytesAreEqual(byte[] array1, byte[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    private static byte[] combineByteArrays(Collection<byte[]> colecao) {
        int totalLength = 0;

        for (byte[] array : colecao) {
            totalLength += array.length;
        }

        byte[] combinedArray = new byte[totalLength];
        int currentIndex = 0;

        for (byte[] array : colecao) {
            System.arraycopy(array, 0, combinedArray, currentIndex, array.length);
            currentIndex += array.length;
        }

        return combinedArray;
    }
}