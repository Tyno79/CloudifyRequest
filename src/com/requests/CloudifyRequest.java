package com.requests;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class CloudifyRequest {

    protected String host;
    protected String base_url = "";

    public CloudifyRequest(String url_base) {
        this.base_url = url_base;
    }

    public String get(String suburl, String params, Map<String, String > header) throws IOException {

        URL url = new URL(base_url+suburl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        if(!params.isEmpty()) {
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(params);
            out.flush();
            out.close();
        }

        if(!header.isEmpty()) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                con.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        int status = con.getResponseCode();
        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }

    public String post(String suburl, String params, Map<String, String > header) throws IOException {
        URL url = new URL(base_url+suburl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        if(!params.isEmpty()) {
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(params);
            out.flush();
            out.close();
        }

        if(!header.isEmpty()) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                con.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        int status = con.getResponseCode();
        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }

    public String update() {
        return "";
    }

    public String put(String suburl, String params, Map<String, String > header) throws IOException {
        URL url = new URL(base_url+suburl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");

        if(!params.isEmpty()) {
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(params);
            out.flush();
            out.close();
        }

        if(!header.isEmpty()) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                con.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));


        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        int status = con.getResponseCode();

        if (status == 400) {
            return "L'email indiqué n'existe pas";
        }

        return content.toString();
    }
}
