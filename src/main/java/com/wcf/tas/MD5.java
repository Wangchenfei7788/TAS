package com.wcf.tas;

import java.security.MessageDigest;

public class MD5 {
	private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String byteArrayToHexString(byte[] byts) {
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < byts.length; ++i) {
			strBuf.append(byteToHexString(byts[i]));
		}
		return strBuf.toString();
	}

	private static String byteToHexString(byte byts) {
		int i = byts;
		if (i < 0)
			i += 256;
		int ichu = i / 16;
		int iyu = i % 16;
		return hexDigits[ichu] + hexDigits[iyu];
	}

	public static String MD5Encode(String str) {
		String retrStr = null;
		try {
			retrStr = new String(str);
			MessageDigest dige = MessageDigest.getInstance("MD5");
			retrStr = byteArrayToHexString(dige.digest(retrStr.getBytes()));

			StringBuffer secretSB = new StringBuffer();
			secretSB.append(retrStr.substring(8, 16));
			secretSB.append(retrStr.substring(16, 24));
			secretSB.append(retrStr.substring(0, 8));
			secretSB.append(retrStr.substring(24));

			retrStr = secretSB.toString();
		} catch (Exception localException) {
		}
		return retrStr;
	}
}
