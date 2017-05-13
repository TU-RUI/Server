package com.server.utils;

import java.security.MessageDigest;

public class MD5Util {
	
	
	public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] b = md5.digest(byteArray);
        StringBuffer buf = new StringBuffer("");
        int i;
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }
        String result = "";
        result = buf.toString().substring(8, 24);
        return result;
    }

    /**
     * 测试主函数
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("test");
        System.out.println("原始：" + str);
        String md5 = md5Encode(str);
        System.out.println("md5 String\n"+md5);
        byte[] b = md5.getBytes();
        System.out.println(new String(b,"UTF-8"));
    }
}
