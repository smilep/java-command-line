package com.smilep.random;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import au.com.bytecode.opencsv.CSVWriter;

import com.smilep.model.RunThisMethod;
import com.smilep.util.Util;

@SuppressWarnings("deprecation")
public class DLInfoGatherer {

    public static final String URL = "https://dlpay.dimts.in/dldetail/default.aspx";
    private static HttpClient client;
    private static Properties properties = Util.properties;

    static {
        try {
            /*
             * System.setProperty("org.apache.commons.logging.Log",
             * "org.apache.commons.logging.impl.SimpleLog"); System.setProperty(
             * "org.apache.commons.logging.simplelog.showdatetime" , "true");
             * System.setProperty(
             * "org.apache.commons.logging.simplelog.log.org.apache.http.wire",
             * "DEBUG");
             */

            SSLContext sslContext = SSLContext.getInstance("SSL");

            // set up a TrustManager that trusts everything
            sslContext.init(null, new TrustManager[] { new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    // System.out.println("getAcceptedIssuers =============");
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    // System.out.println("checkClientTrusted =============");
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    // System.out.println("checkServerTrusted =============");
                }
            } }, new SecureRandom());

            SSLSocketFactory sf = new SSLSocketFactory(sslContext);
            Scheme httpsScheme = new Scheme("https", 443, sf);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(httpsScheme);

            ClientConnectionManager cm = new SingleClientConnManager(schemeRegistry);
            client = new DefaultHttpClient(cm);
        } catch (Exception e) {
            System.err.println("Error in initialising http client");
            e.printStackTrace();
        }

    }

    @RunThisMethod
    public static void startDLInfoGatherer(BufferedReader br) throws Exception {
        List<String[]> rows = new ArrayList<String[]>();
        rows.add(new String[] { "DL Number", "Name" });
        String strLine = null;
        while ((strLine = br.readLine()) != null) {
            postRequest(rows, strLine);
        }
        client.getConnectionManager().shutdown();
        writeToFile(rows);
    }

    private static void postRequest(List<String[]> rows, String dlNum) throws Exception {
        HttpPost post = new HttpPost(URL);

        // Setting headers and request params
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("__EVENTARGUMENT", ""));
        urlParameters.add(new BasicNameValuePair("__EVENTTARGET", ""));
        urlParameters.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", "6DDDDFFC"));
        urlParameters.add(new BasicNameValuePair("__EVENTVALIDATION",
                "/wEWAwKV1M+9AQK3tefKAQKA4slj14z/GBeWug6PQB1UjURBhsRw3bQ="));
        urlParameters
                .add(new BasicNameValuePair(
                        "__VIEWSTATE",
                        "/wEPDwUKLTMzMzc4OTg0NA9kFgJmD2QWAgIDD2QWAgIBD2QWMAIPDxYCHgdWaXNpYmxlaGQCEw8PFgIfAGhkZAIVDw8WAh8AaGRkAhcPDxYCHwBoZGQCGQ8PFgIfAGhkZAIbDw8WAh8AaGRkAh8PDxYCHwBoZGQCIQ8PFgIfAGhkZAIjDw8WAh8AaGRkAicPDxYCHwBoZGQCKw8PFgIfAGhkZAIxDw8WAh8AaGRkAjMPDxYCHwBoZGQCNQ8PFgIfAGhkZAI5Dw8WBB4EVGV4dGUfAGhkZAI9Dw8WBB8BZR8AaGRkAkEPDxYCHwBoZGQCRQ8PFgIfAGhkZAJJDw8WAh8AaGRkAk0PDxYCHwBoZGQCUQ8PFgIfAGhkZAJVDzwrAA0AZAJXDzwrAA0AZAJZDzwrAA0AZBgDBSNjdGwwMCRDb250ZW50UGxhY2VIb2xkZXIxJGd2X2RldGFpbA9nZAUjY3RsMDAkQ29udGVudFBsYWNlSG9sZGVyMSRHcmlkVmlldzIPZ2QFI2N0bDAwJENvbnRlbnRQbGFjZUhvbGRlcjEkR3JpZFZpZXcxD2dkmYtFpbsxUJfW5XEpJIk93SkNAyk="));
        urlParameters.add(new BasicNameValuePair("ctl00$ContentPlaceHolder1$txtdlno", dlNum));
        urlParameters.add(new BasicNameValuePair("ctl00$ContentPlaceHolder1$Button1", "Search"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        post.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        post.addHeader("DNT", "1");
        post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:43.0) Gecko/20100101 Firefox/43.0");
        post.addHeader("Accept-Language", "en-US,en;q=0.5");
        post.addHeader("Referer", "https://dlpay.dimts.in/dldetail/");
        post.addHeader("Connection", "keep-alive");

        StringBuffer result = new StringBuffer();

        // Post form
        if ("true".equalsIgnoreCase(properties.getProperty("localMode"))) {
            // Get HTML response from property file
            result.append(properties.getProperty("sampleResponseHTML"));
        } else {
            HttpResponse response = client.execute(post);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        }

        // System.out.println(result.toString());
        parseHtml(rows, result.toString());
    }

    private static void parseHtml(List<String[]> rows, String htmlStr) {
        try {
            Document document = Jsoup.parse(htmlStr.toString());
            String dlNum = document.getElementById("ctl00_ContentPlaceHolder1_txtplno").attr("value");
            String firstName = document.getElementById("ctl00_ContentPlaceHolder1_txtname").attr("value");
            rows.add(new String[] { dlNum, firstName });
            System.out.println(firstName);
        } catch (Exception e) {
            System.err.println("Data not found for this ID");
        }
    }

    private static void writeToFile(List<String[]> rows) {
        CSVWriter csvWriter = null;
        try {
            csvWriter = new CSVWriter(new FileWriter(DLInfoGatherer.class.getSimpleName() + ".csv"));
            csvWriter.writeAll(rows);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
