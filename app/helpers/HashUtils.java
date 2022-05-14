package helpers;


import java.math.BigInteger;
import java.security.MessageDigest;

public class HashUtils {

    public static String getMd5(String s){
        try {

          //Método Original

          /*Uso de cifrado con MD5
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(s.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            String hashtext = bigInt.toString(16);
            while(hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }
            */

            //Corrección DeltaCrateris
            /*Uso de cifrado SHA-256*/

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
            for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if(hex.length() == 1) {
            hexString.append('0');
            }
            hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {}
        return s;
    }
}
