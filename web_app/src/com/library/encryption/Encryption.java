package com.library.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class Encryption {
	private String strKey = "Bar12345Bar12345";
	private String initVector = "RandomInitVector";
	

	public String encrypt(String strClearText) {
	    try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(strKey.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(strClearText.getBytes());
            System.out.println("encrypted string: "
                    + Base64.encodeBase64String(encrypted));

            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

		return null ;
	}

	public String decrypt(String strEncrypted) {
	   try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(strKey.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(strEncrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return null ;
	}
	
	public static void main(String[] args) {
		Encryption en =new Encryption();
		String ss =en.encrypt("1234");
		System.out.println(ss);
		System.out.println(en.decrypt(ss));
	}

}