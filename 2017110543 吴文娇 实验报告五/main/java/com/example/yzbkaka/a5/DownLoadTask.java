package com.example.yzbkaka.a5;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yzbkaka on 20-4-17.
 */

public class DownLoadTask extends AsyncTask<Void,Integer,Boolean> {

    private Context context;

    private ProgressDialog progressDialog;

    public DownLoadTask(Context context){
        this.context = context;

    }


    @Override
    protected void onPreExecute() {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("当前进度是：");
        progressDialog.setMessage("0%");
        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        int progress = 0;
        try {
            while (progress <= 100){
                progress = progress + 10;
                publishProgress(progress);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressDialog.setMessage(String.valueOf(values[0]) + "%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(aBoolean) Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
    }
}
