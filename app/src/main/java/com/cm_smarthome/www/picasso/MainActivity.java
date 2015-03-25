package com.cm_smarthome.www.picasso;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MainActivity extends ActionBarActivity {

    get g1 = new get();

    private ImageView imageView;
    private ImageView imageView2;

    Context context = this;
    private ProgressDialog progressDialog;

    private String x; //variable Global

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

       /* // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        g1.getData();
        x = g1.x;

        Picasso.with(context).load(x).into(imageView);
        Glide.with(context).load(x).into(imageView2);*/

        new myAsyncTask().execute();

    }
    public class myAsyncTask extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute()//ทำก่อนเข้า doInBackground
            {
                progressDialog = ProgressDialog.show(MainActivity.this, "โหลดการทำงานของ Method", "กรุณารอสักครู่");
            }

            @Override
            protected String doInBackground(String... paramsXD)//ทำงานหลัก แล้วส่งค่าไปที่ onPostExecute
            {
            String x = null;//variable Local
            try
            {
                g1.getData();
                x = g1.x;
            }
            catch (Exception e) {
                Log.e("Error", "XD");
            }
            return x;
        }

        @Override
        protected void onPostExecute(String input)//ทำงานหลังจาก ทำ doInBackground เสร็จแล้ว
        {
            String url = input;

            Picasso.with(context).load(url).into(imageView);
            Glide.with(context).load(url).fitCenter().into(imageView2);

            Toast.makeText(context, "Complete", Toast.LENGTH_SHORT).show();

            progressDialog.dismiss();
        }
    }
}
