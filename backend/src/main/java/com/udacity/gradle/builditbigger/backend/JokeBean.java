package com.udacity.gradle.builditbigger.backend;

import com.pedrolopesme.jokeslib.JokesLib;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeBean extends MyBean {

    public JokeBean() {
        this.myData = new JokesLib().getJoke();
    }

}