package com.example.jokesandroidlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_INTENT_EXTRA = "jokeIntentExtra";

    private TextView tvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String jokeContent = getIntent().getStringExtra(JOKE_INTENT_EXTRA);

        TextView tvJoke = (TextView) findViewById(R.id.tvJoke);
        tvJoke.setText(jokeContent);
    }

}
