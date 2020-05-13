/*
 * M Fathurrohman Mauludin - 10117214
 */

package com.fathurrohman.akb10117214.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.fathurrohman.akb10117214.MainActivity;
import com.fathurrohman.akb10117214.R;

// Senin 11 Mei 2020, 10117214, M Fathurrohman Mauludin, IF7

public class ActivitySplash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(ActivitySplash.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
