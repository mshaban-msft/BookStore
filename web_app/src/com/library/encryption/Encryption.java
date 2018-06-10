package com.library.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	private String strKey = "hashash";

	public String encrypt(String strClearText) {
		String strData = "";
		try {
			SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted = cipher.doFinal(strClearText.getBytes());
			strData = new String(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
			//throw new Exception(e);
		}
		return strData;
	}

	public String decrypt(String strEncrypted) {
		String strData = "";
		try {
			SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted = cipher.doFinal(strEncrypted.getBytes());
			strData = new String(decrypted);
		} catch (Exception e) {
			e.printStackTrace();
		//	throw new Exception(e);
		}
		return strData;
	}
	
	public static void main(String[] args) {
		Encryption en =new Encryption();
		String ss =en.encrypt("telio");
		System.out.println(ss);
		System.out.println(en.decrypt(ss));
	}

}