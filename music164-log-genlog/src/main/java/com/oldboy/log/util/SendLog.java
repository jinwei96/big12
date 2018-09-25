package com.oldboy.log.util;

import java.awt.*;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;

public class SendLog {

    public static void main(String[] args) throws Exception {

        Random r = new Random();

        //格式化数字串
        DecimalFormat df = new DecimalFormat("000000");

        //发送的日志个数
        for (int i = 0; i < 1000;) {
            String deviceId = "Device"+ df.format(r.nextInt(100)+1);
            String s = GenLogAggUtil.genLogAgg(deviceId);

            String strUrl = "http://192.168.13.16:8089/index.html";
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //定义post请求类型
            conn.setRequestMethod("POST");
            conn.setRequestProperty("content-Type","application/json");
            conn.setRequestProperty("client_time",System.currentTimeMillis()+"");
            //允许输出到服务器
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();

            os.write(s.getBytes());
            os.close();
            System.out.println(conn.getResponseCode());

        }



    }



}