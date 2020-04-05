package test1.pantha.registrationform;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
   Button button1,button2,button3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DownloadInfoOfWeather task=new DownloadInfoOfWeather();
                task.execute();
            }
        });

       ;



    }




    class DownloadInfoOfWeather extends AsyncTask<String, Void, String> {



        @Override
        protected String doInBackground(String... params) {


            Log.e("murugan18", "calling API");







                OkHttpClient client = new OkHttpClient();
                //String path=cpFiles(mFilePath);









                RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)



                        .addFormDataPart("email", "send")

                        .build();




                Request request = new Request.Builder().url("http://192.168.43.41:9000/api")
                        .post(requestBody).build();

            Response response = null;
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String jsonData = null;
            try {
                jsonData = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }


            final Response finalResponse = response;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, finalResponse.body().toString(),
                            Toast.LENGTH_LONG).show();


                }
            });



return null;
                }







        }


}
