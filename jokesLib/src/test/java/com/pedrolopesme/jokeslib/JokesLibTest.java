package com.pedrolopesme.jokeslib;

import org.junit.Test;

public class JokesLibTest {
    @Test
    public void test() {
        JokesLib jokesLib = new JokesLib();
        assert jokesLib.getJoke().length() != 0;
    }
}
