package com.pedrolopesme.jokeslib;

import org.junit.Test;

public class JokesTest {
    @Test
    public void test() {
        assert Jokes.getJokes().length > 0;
    }
}
