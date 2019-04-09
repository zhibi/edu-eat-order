package edu.eat.order.base.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author 执笔
 * @date 2019/3/30 21:14
 */
public class MD5Utils {

    /**
     * md5 加密
     *
     * @param source
     * @return
     */
    public static String encrypt(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(source.getBytes(StandardCharsets.UTF_8));
            return toHex(bytes);
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    /**
     * 验证密码
     *
     * @param source
     * @param sign
     * @return
     */
    public boolean verify(String source, String sign) {
        return sign.equalsIgnoreCase(encrypt(source));
    }

    private static String toHex(byte[] bytes) {
        char[] hexDigits = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (byte aByte : bytes) {
            ret.append(hexDigits[aByte >> 4 & 15]);
            ret.append(hexDigits[aByte & 15]);
        }
        return ret.toString();
    }
}
