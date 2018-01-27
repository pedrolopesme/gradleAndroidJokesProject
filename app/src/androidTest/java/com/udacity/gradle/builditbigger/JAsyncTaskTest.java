package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class JAsyncTaskTest extends AndroidTestCase {

    @Test
    public void asyncTaskTest() throws Exception {
        JokesAsyncTask jokeTask = new JokesAsyncTask();
        jokeTask.execute(InstrumentationRegistry.getContext());
        String joke = jokeTask.get(5, TimeUnit.SECONDS);
        assert !TextUtils.isEmpty(joke);
    }
}
