package com.library.encryption ;

public class Encyrption {


	public  String encrypt(String strClearText , String strKey) throws Exception {

		return strClearText ;
//		String strData = "";
//		try {
//			SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
//			Cipher cipher = Cipher.getInstance("Blowfish");
//			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
//			byte[] encrypted = cipher.doFinal(strClearText.getBytes());
//			strData = new String(encrypted);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception(e);
//		}
//		return strData;
	}

	public  String decrypt(String strEncrypted, String strKey) throws Exception {
		
		return strEncrypted ;
		
//		String strData = "";
//		try {
//			SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
//			Cipher cipher = Cipher.getInstance("Blowfish");
//			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
//			byte[] decrypted = cipher.doFinal(strEncrypted.getBytes());
//			strData = new String(decrypted);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception(e);
//		}
//		return strData;
	}

	public static void main(String[] args) {
		Encyrption encrypt = new Encyrption() ;
		
		try {
			String ss = encrypt.encrypt("1234" , "X43V1Y3B");
			System.out.println(ss);
			
			System.out.println(encrypt.decrypt(ss, "X43V1Y3B"));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
