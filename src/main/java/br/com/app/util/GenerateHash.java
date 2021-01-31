package br.com.app.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenerateHash {

	private final String funcaoHash;

	public GenerateHash(String funcaoHash) {

		if (funcaoHash != null && !funcaoHash.isBlank()) {
			this.funcaoHash = funcaoHash;
		} else {
			throw new IllegalArgumentException("The funcaoHash parameter cannot be null or empty");
		}

	}

	public String gerar(String str) {

		try {

			if (str != null && !str.isBlank()) {

				final MessageDigest digest = MessageDigest.getInstance(funcaoHash);
				final byte[] hashbytes = digest.digest(str.trim().getBytes(StandardCharsets.UTF_8));
				return bytesToHex(hashbytes);
			} else {
				throw new IllegalArgumentException("The str parameter cannot be null or empty");
			}

		} catch (NoSuchAlgorithmException e) {

			throw new IllegalArgumentException(funcaoHash + "MessageDigest not available");
		}
	}

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
