package com.pedrolopesme.jokeslib;

import java.util.concurrent.ThreadLocalRandom;

public class JokesLib {

    public String getJoke() {
        final String[] jokes = Jokes.getJokes();
        int randomNum = ThreadLocalRandom.current().nextInt(0, jokes.length);
        return jokes[randomNum];
    }

}
