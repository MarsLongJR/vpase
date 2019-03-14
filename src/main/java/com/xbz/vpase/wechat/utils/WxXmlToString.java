package com.xbz.vpase.wechat.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @ClassName   微信xml文件转化为String字符串
 * @Description InputStream流转换成String字符串
 * @company:www.xinbeize.com
 * @author:Mars
 */
public class WxXmlToString {
    public static String inputStream2String(InputStream inStream, String encoding){
        String result = null;
        ByteArrayOutputStream outStream = null;
        try { if(inStream != null){ outStream = new ByteArrayOutputStream();
            byte[] tempBytes = new byte[1024]; int count = 0;
            while((count = inStream.read(tempBytes)) != -1){
                outStream.write(tempBytes, 0, count);
            }
            tempBytes = null;
            outStream.flush();
            result = new String(outStream.toByteArray(), encoding); outStream.close();
        }
        } catch (Exception e) { result = null;
        }
        return result;
    }
}
