package com.vikas.httpclienttest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Test1NormalReq {

    public static void main(String[] args) throws IOException {

        HttpGet getReq = new HttpGet("https://www.google.com");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse httpResponse = httpClient.execute(getReq)) {
            String statusLine = httpResponse.getStatusLine().toString();
            System.out.println(statusLine);
            HttpEntity entity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(entity));
        }
    }

}
