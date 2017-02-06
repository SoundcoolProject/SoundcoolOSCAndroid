package org.soundcool.upv.oscapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;




public class OneFragment extends Fragment{

    View v; // para poder pedir referencia con findViewById


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.v = inflater.inflate(R.layout.fragment_one, container, false);

        // Una vez creado el View "v", podemos ejecutar los metodos de los controles, ya que ahora
        // pueden pedir referencia con findViewById
        slider1();
        slider2();
        slider3();
        pushButton1();
        pushButton2();
        pushButton3();
        toggle1();

        return v;
    }


    public void slider1() {
        SeekBar mySlider1 = (SeekBar) v.findViewById(R.id.cs1_fader1);


        mySlider1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/1/fader1");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void slider2() {
        SeekBar mySlider2 = (SeekBar) v.findViewById(R.id.cs1_fader2);


        mySlider2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg [0] = new String("/1/fader2");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void slider3() {
        SeekBar mySlider3 = (SeekBar) v.findViewById(R.id.cs1_fader3);


        mySlider3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg [0] = new String("/1/fader3");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void pushButton1(){

        final Button myButton1 = (Button) v.findViewById(R.id.cs1_button1);

        myButton1.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/1/push1");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton1.setPressed(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton1.setPressed(false);
                        break;
                }
                return true;
            }
        });
    }


    public void pushButton2(){

        final Button myButton2 = (Button) v.findViewById(R.id.cs1_button2);

        myButton2.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/1/push2");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton2.setPressed(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton2.setPressed(false);
                        break;
                }
                return true;
            }
        });
    }

    public void pushButton3(){

        final Button myButton3 = (Button) v.findViewById(R.id.cs1_button3);

        myButton3.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/1/push3");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton3.setPressed(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton3.setPressed(false);
                        break;
                }
                return true;
            }
        });
    }

    public void toggle1(){
        ToggleButton toggle = (ToggleButton) v.findViewById(R.id.cs1_toggle1);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/1/toggle1");

                if (isChecked) {
                    // The toggle is enabled
                    OSCmsg[1] = new Float(1.);
                    new OSCsender().execute(OSCmsg);

                } else {
                    // The toggle is disabled
                    OSCmsg[1] = new Float(0.);
                    new OSCsender().execute(OSCmsg);
                }
            }
        });
    }


}