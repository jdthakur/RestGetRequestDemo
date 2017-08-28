package com.example.linux.restgetrequestdemo.oldway;

import android.os.AsyncTask;
import android.util.Log;

import com.example.linux.restgetrequestdemo.projectactivities.MainActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by linux on 24/8/17.
 */

public class RestAPIPutAsync extends AsyncTask<Void,Void,Void> {

    StringBuilder builder;


    @Override
    protected Void doInBackground(Void... params) {

        builder = new StringBuilder();


        HttpPut httpPut = new HttpPut("https://ilmsdevqa.inspiredlms.com/api/organizations/1270/regions/10061");
        HttpClient client = new DefaultHttpClient();

        // Add Headers
        httpPut.addHeader("OrgID", "1270");
        httpPut.addHeader("APILoginID", "UaQny7QE5PdlWqnPA1o5NQ==");
        httpPut.addHeader("TransactionKey", "677x4Szy89NbEkRbVk3RfA==");
        httpPut.addHeader("Accept","application/json");

        try {
            httpPut.setEntity(new StringEntity("{\"name\":\"Jaysingh Regin\"}"));
        } catch (UnsupportedEncodingException e) {
           System.out.print(e.toString());
        }

        try
        {
            HttpResponse response = client.execute(httpPut);

            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();

            Log.d("Status Code"," "+statusCode);

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
