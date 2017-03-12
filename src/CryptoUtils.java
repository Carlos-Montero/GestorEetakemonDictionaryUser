/**
 * Created by Carlos on 12/03/2017.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class CryptoUtils {

    private static CryptoUtils ourInstance = new CryptoUtils();
    private final Random r;

    public static CryptoUtils getInstance() {
        return ourInstance;
    }

    private CryptoUtils() {
        r =  new SecureRandom();
    }

    public byte[] hashCompute(String pToHash, byte[] pSalt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pToHash.getBytes());
            byte byteData[] = md.digest();

            byte[] saltedData = new byte[byteData.length];
            int i = 0;
            for (byte b : byteData)
                saltedData[i] = (byte)(b ^ pSalt[i++]);

            md.reset();
            md.update(saltedData);
            //byte saltedDataResult[] = md.digest();

            return md.digest();
        }
        catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }

    public byte[] generateSalt(int pLength) { // We will use normally 32
        byte[] salt = new byte[pLength];
        r.nextBytes(salt);
        return salt;
    }

    public String bytesToBase64(byte[] pToConvert) {
        return Base64.getEncoder().encodeToString(pToConvert);
    }

    public byte[] base64ToBytes(String pToConvert) {
        return Base64.getDecoder().decode(pToConvert.getBytes());
    }

}
