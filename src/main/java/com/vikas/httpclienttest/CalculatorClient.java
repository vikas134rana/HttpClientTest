package com.vikas.httpclienttest;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CalculatorClient {

    private static final String SERVER_URI = "http://localhost:8080/server";
    private static final String SUM_URI = "/sum";
    private static final String SUBTRACT_URI = "/subtract";
    private static final String MULTIPLY_URI = "/multiply";
    private static final String DIVIDE_URI = "/divide";

    private static final int NUM1 = 10;
    private static final int NUM2 = 2;

    public static void main(String[] args) throws IOException, URISyntaxException {

        HttpGet httpGet = new HttpGet(SERVER_URI + SUM_URI);
        List<NameValuePair> param = new ArrayList<>();
        param.add(new BasicNameValuePair("num1", NUM1 + ""));
        param.add(new BasicNameValuePair("num2", NUM2 + ""));
        URI uri = new URIBuilder(httpGet.getURI()).addParameters(param).build();
        httpGet.setURI(uri);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();

        System.out.println(httpResponse.getStatusLine());
        System.out.println(EntityUtils.toString(entity));
    }

}
