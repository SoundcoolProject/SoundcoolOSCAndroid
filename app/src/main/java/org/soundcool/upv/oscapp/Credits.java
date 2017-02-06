package org.soundcool.upv.oscapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by jaiserpe on 13/05/2016.
 */
public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

        TextView scrollText = (TextView) findViewById(R.id.credits_textView2);
        scrollText.setMovementMethod(new ScrollingMovementMethod());

    }
}
