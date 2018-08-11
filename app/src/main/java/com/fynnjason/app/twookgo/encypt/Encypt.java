package com.fynnjason.app.twookgo.encypt;

import com.gcssloop.encrypt.symmetric.AESUtil;

import javax.crypto.Cipher;

/**
 * Created by FynnJason on on 2018/8/11.
 * Function：加密，解密
 */
public class Encypt {

    private static final String KEY = "!#123";


    /**
     * 加密
     * @param cleartext
     * @return
     */
    public static String en(String cleartext) {
        return AESUtil.aes(cleartext,KEY, Cipher.ENCRYPT_MODE);
    }

    /**
     * 解密
     * @param ciphertext
     * @return
     */
    public static String de(String ciphertext) {
        return AESUtil.aes(ciphertext, KEY, Cipher.DECRYPT_MODE);
    }
}
