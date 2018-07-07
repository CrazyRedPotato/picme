package com.picme.utils;

import java.util.Random;


public class PwdProductor {
	private final static String globalSalt = "12345!@*(?";
	
	private final static String randomSaltLib = "abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+{}|:<>?ZXCVBNM";
	
	private static Random random = new Random(System.nanoTime());
	
	public final static int randomSaltLength = 10;
	
	private static int getRandom() {
	    int bound = randomSaltLib.length();
		int ret = random.nextInt(bound);

		return ret;
	}

	public static String getRandomSalt() {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < randomSaltLength; i++) {
    		sb.append(randomSaltLib.charAt(getRandom()));
    	}
    	return sb.toString();
	}
	
	public static String createPwdhash(String randomSalt, String pwd) {
		Integer hash = (globalSalt +  randomSalt + pwd).hashCode();
		return  hash.toString();
	}
	
	public static String getGlobalsalt() {
		return globalSalt;
	}
	
	public static boolean checkPwdhash(String randomSalt, String pwdhash, String pwd) {
		Integer hash = (globalSalt +  randomSalt + pwd).hashCode();
		if (hash.toString().equals(pwdhash)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String createhash(String str) {
		return Integer.toString(str.hashCode());
	}
	
}
