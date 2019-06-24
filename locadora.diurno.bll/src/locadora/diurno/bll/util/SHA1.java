package locadora.diurno.bll.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA1 {

	public static String encryptPassword(String password) throws Exception {

	    MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	    crypt.reset();
	    crypt.update(password.getBytes("UTF-8"));

	    return new BigInteger(1, crypt.digest()).toString(16);
	}
}
