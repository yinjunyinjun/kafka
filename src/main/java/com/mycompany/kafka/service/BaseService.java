package com.mycompany.kafka.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigInteger;
import java.security.MessageDigest;

public class BaseService {
    public final Log logger = LogFactory.getLog(this.getClass());



    protected String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
