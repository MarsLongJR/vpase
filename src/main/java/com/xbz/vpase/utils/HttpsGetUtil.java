package com.xbz.vpase.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpsGetUtil {

    public static String doHttpsGetJson(String Url)
    {
        String message = "";
        try
        {
            System.out.println("doHttpsGetJson");
            URL urlGet = new URL(Url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
//            必须是get方式请求    24
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
//            连接超时30秒28
            System.setProperty("sun.net.client.defaultConnectTimeout", "6000");
//            读取超时30秒29 30
            System.setProperty("sun.net.client.defaultReadTimeout", "6000");
            http.connect();
            InputStream is =http.getInputStream();
            int size =is.available();
            byte[] jsonBytes =new byte[size];
            is.read(jsonBytes);
            message=new String(jsonBytes,"UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return message;
    }
}
