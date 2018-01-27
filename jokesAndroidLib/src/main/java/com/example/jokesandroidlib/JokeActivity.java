package com.example.jokesandroidlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_INTENT_EXTRA = "jokeIntentExtra";

    private TextView tvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(this.getClass().getSimpleName(), "Opening JokeActivity");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String jokeContent = getIntent().getStringExtra(JOKE_INTENT_EXTRA);

        tvJoke = (TextView) findViewById(R.id.tvJoke);
        tvJoke.setText(jokeContent);
    }

}
