package poo_trabalho;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static byte[] encrypt(String key, byte[] inputBytes) throws CryptoException {
        return doCrypto(Cipher.ENCRYPT_MODE, key, inputBytes);
    }

    public static byte[] decrypt(String key, byte[] inputBytes) throws CryptoException {
        return doCrypto(Cipher.DECRYPT_MODE, key, inputBytes);
    }

    private static byte[] doCrypto(int cipherMode, String key, byte[] inputBytes) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            return cipher.doFinal(inputBytes);

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException ex) {
            throw new CryptoException("Error encrypting/decrypting data", ex);
        }
    }

    public static String getKey(){
        try {
            // Instancia o gerador de chaves para o algoritmo AES
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            
            // Define o tamanho da chave (128 bits no exemplo)
            keyGen.init(128);
            
            // Gera a chave
            SecretKey secretKey = keyGen.generateKey();
            
            return secretKey.toString();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
