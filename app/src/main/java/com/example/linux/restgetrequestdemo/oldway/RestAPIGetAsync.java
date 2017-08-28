package com.example.linux.restgetrequestdemo.oldway;

import android.os.AsyncTask;
import android.util.Log;

import com.example.linux.restgetrequestdemo.projectactivities.MainActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by linux on 24/8/17.
 */

public class RestAPIGetAsync extends AsyncTask<Void,Void,Void>
{
    StringBuilder builder;


    @Override
    protected Void doInBackground(Void... params)
    {

        builder = new StringBuilder();

//        try {
//
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("ID", 0 );
//            jsonObject.put("Name", "UaQny7QE5PdlWqnPA1o5NQ==");
//            jsonObject.put("NumberOfUsers", "677x4Szy89NbEkRbVk3RfA==");
//
//
//
//            URL url = new URL("https://ilmsdevqa.inspiredlms.com/api/organizations/1270/regions"); //Enter URL here
//            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
//            httpURLConnection.setRequestMethod("GET"); // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
//            httpURLConnection.setDoInput(true);
//            httpURLConnection.setDoOutput(true);
//
//            httpURLConnection.setRequestProperty("Content-Type", "application/json"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
//            httpURLConnection.setRequestProperty("OrgID","1270");
//            httpURLConnection.setRequestProperty("APILoginID","UaQny7QE5PdlWqnPA1o5NQ==");
//            httpURLConnection.setRequestProperty("TransactionKey","677x4Szy89NbEkRbVk3RfA==");
//            httpURLConnection.setRequestProperty("Accept","application/json");
//
//
//
//          //  httpURLConnection.connect();
//
//
//            String urlParameters = "Regin";
//
//
//            DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
//            wr.writeBytes(jsonObject.toString());
//
//
//            Log.d("Response"," "+wr.toString());
//
//            wr.flush();
//            wr.close();
//
//            int responseCode=httpURLConnection.getResponseCode();
//
//            Log.d("header field One"," "+httpURLConnection.getHeaderField(0));
//
//            Log.d("Response Code"," "+responseCode);
//
//
//
//            if (responseCode == HttpsURLConnection.HTTP_OK) {
//
//                Log.d("In if Code"," 200");
//
//                BufferedReader in=new BufferedReader(new
//                        InputStreamReader(
//                        httpURLConnection.getInputStream()));
//
//                StringBuffer sb = new StringBuffer("");
//                String line="";
//
//                while((line = in.readLine()) != null) {
//
//                    sb.append(line);
//                    break;
//                }
//
//                Log.d("OutPut Json", line);
//
//
//                in.close();
//            }
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        HttpGet httpGet = new HttpGet("https://ilmsdevqa.inspiredlms.com/api/organizations/1270/regions");
        HttpClient client = new DefaultHttpClient();

        // Add Headers
        httpGet.addHeader("OrgID", "1270");
        httpGet.addHeader("APILoginID", "UaQny7QE5PdlWqnPA1o5NQ==");
        httpGet.addHeader("TransactionKey", "677x4Szy89NbEkRbVk3RfA==");
        httpGet.addHeader("Accept","application/json");



        try
        {
            HttpResponse response = client.execute(httpGet);

            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();

            System.out.println("before status");

            if (statusCode == 200)
            {
                System.out.println("In status");

                HttpEntity entity = response.getEntity();

                InputStream content = entity.getContent();

                BufferedReader reader = new BufferedReader(new InputStreamReader(content));

                String line;

                while ((line = reader.readLine()) != null)
                {
                    builder.append(line);
                    System.out.println("in while");

                }

                System.out.println(builder.toString());

            }
            else
            {
                Log.e(MainActivity.class.toString(), "Failed to download file");
            }
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }




        return null;


    }
}