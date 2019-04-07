package com.requests;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

public class Request {

    public static String get(String url) throws IOException {

        /*String source ="";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            source +=inputLine;
        in.close();*/
        return "";
    }


    public static String post(String address, List<String> keys, List<String> values) throws IOException {
        String resultat = "";
        OutputStreamWriter w = null;
        BufferedReader r = null;
        try {
            String data="";
            for(int i=0;i < keys.size();i++){
                if (i!=0) data += "&";
                data += URLEncoder.encode(keys.get(i), "UTF-8")+"="+URLEncoder.encode(values.get(i), "UTF-8");
            }

            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            w = new OutputStreamWriter(conn.getOutputStream());
            w.write(data);
            w.flush();

            r = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String ligne;
            while ((ligne = r.readLine()) != null) {
                resultat+=ligne;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{w.close();}catch(Exception e){}
            try{r.close();}catch(Exception e){}
        }
        return resultat;
    }
}
