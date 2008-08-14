package com.growlr.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User: stuart
 * Date: Aug 13, 2008
 * Time: 5:55:38 PM
 */
public class SHA {

    public static void main(String[] args) {
        System.out.println( getDigest("") );
    }


    public static String getDigest(String str) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA");
            sha.reset();
            sha.update(str.getBytes());

            byte[] bytes = sha.digest();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    sb.append('0');
                    sb.append(hex);
                } else {
                    sb.append(hex);
                }
            }
            return sb.toString();
        }catch ( NoSuchAlgorithmException nsae)  {

        }

        return null;
    }


}