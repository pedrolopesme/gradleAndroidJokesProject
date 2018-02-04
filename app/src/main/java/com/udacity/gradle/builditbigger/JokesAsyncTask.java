package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.jokesandroidlib.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class JokesAsyncTask extends AsyncTask<Context, Void, String> {

    private static MyApi myApiService = null;

    @SuppressLint("StaticFieldLeak")
    private Context context = null;

    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {
            Log.d(this.getClass().getSimpleName(), "Opening Connection to GCE endpoint");
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        if (params.length > 0)
            context = params[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            if (context != null) {
                Log.d(this.getClass().getSimpleName(), "Opening JokeActivity");

                final Intent intent = new Intent(context, JokeActivity.class);
                intent.putExtra(JokeActivity.JOKE_INTENT_EXTRA, result);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            Log.e(this.getClass().getSimpleName(), "It was impossible to open jokesActivity", e);
        }
    }

}
