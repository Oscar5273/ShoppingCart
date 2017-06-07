package test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

final class Password {

	   

	  private SecureRandom random = new SecureRandom();
	     
	  /* Set password to new value, zeroing out password */
	  void setPassword(char[] pass)
	      throws IOException, GeneralSecurityException  {
	    byte[] salt = new byte[12];
	    random.nextBytes(salt);
	    //saveBytes(salt, "salt.bin");   
	    byte[] hashVal = hashPassword( pass, salt);
	    //saveBytes(hashVal,"password.bin");
	    Arrays.fill(hashVal, (byte) 0);
	  }
	  /* Indicates if given password is correct */
	  boolean checkPassword(char[] pass)
	      throws IOException, GeneralSecurityException  {
	    byte[] salt = loadBytes("salt.bin");
	    byte[] hashVal1 = hashPassword( pass, salt);
	    // Load the hash value stored in password.bin
	    byte[] hashVal2 = loadBytes("password.bin");
	    boolean arraysEqual = timingEquals( hashVal1, hashVal2);
	    Arrays.fill(hashVal1, (byte) 0);
	    Arrays.fill(hashVal2, (byte) 0);
	    return arraysEqual;
	  }
	   
	  /* Encrypts password & salt and zeroes both */
	  private byte[] hashPassword(char[] pass, byte[] salt)
	      throws GeneralSecurityException {
	    KeySpec spec = new PBEKeySpec(pass, salt, 65536, 128);
	    Arrays.fill(pass, (char) 0);
	    Arrays.fill(salt, (byte) 0);
	    SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	    return f.generateSecret(spec).getEncoded();
	  }
	  /**
	   * Indicates if both byte arrays are equal
	   * but uses same amount of time if they are the same or different
	   * to prevent timing attacks
	   */
	  public static boolean timingEquals(byte b1[], byte b2[]) {
	    boolean result = true;
	    int len = b1.length;
	    if (len > b2.length) {
	      result = false;
	      len = b2.length;
	    }
	    for (int i = 0; i < len; i++) {
	      result &= (b1[i] == b2[i]);
	    }
	    return result;
	  }
	  private void saveBytes(byte[] bytes, String filename) throws IOException {
	    // ... write bytes to the file
	  }
	  private byte[] loadBytes(String filename) throws IOException {
		return null;
	    // ... read bytes to the file
	  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
