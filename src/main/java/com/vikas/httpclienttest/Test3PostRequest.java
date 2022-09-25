package com.vikas.httpclienttest;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test3PostRequest {

    public static void main(String[] args) throws IOException {

        HttpPost httpPost = new HttpPost("https://httpbin.org/post");
        List<NameValuePair> body = new ArrayList<>();
        body.add(new BasicNameValuePair("username","abc"));
        body.add(new BasicNameValuePair("password","123"));
        body.add(new BasicNameValuePair("custom","secret"));
        httpPost.setEntity(new UrlEncodedFormEntity(body));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();
        System.out.println(httpResponse.getStatusLine());
        System.out.println(EntityUtils.toString(entity));

    }

}
