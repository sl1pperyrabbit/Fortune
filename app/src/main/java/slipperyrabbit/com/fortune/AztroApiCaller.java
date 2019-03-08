package slipperyrabbit.com.fortune;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AztroApiCaller extends AsyncTask<String, String, String> {
    String apiUrl = " https://aztro.sameerkumar.website?sign=leo&day=today";
    String data = new String();


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String response = new String();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            //connection.setRequestProperty("sign", "leo");
            //connection.setRequestProperty("day", "today");

            connection.setDoOutput(true);
            BufferedOutputStream output = new BufferedOutputStream(connection.getOutputStream());

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
            writer.write(data);
            writer.flush();
            writer.close();
            output.close();

            int responseCode = connection.getResponseCode();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();

            while((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

            bufferedReader.close();
            response = result.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.e("Api Url : ", apiUrl);
        Log.e("Response : ", response);

        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
