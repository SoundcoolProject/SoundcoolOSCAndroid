package org.soundcool.upv.oscapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;




public class FourFragment extends Fragment{

    View v; // para poder pedir referencia con findViewById


    public FourFragment() {
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
        this.v = inflater.inflate(R.layout.fragment_four, container, false);

        // Una vez creado el View "v", podemos ejecutar los metodos de los controles, ya que ahora
        // pueden pedir referencia con findViewById
        toggle1();
        slider1();
        pushButtonReverse();
        slider2();
        pushButton1();
        pushButton2();
        pushButton3();
        pushButton4();
        pushButton5();
        pushButton6();
        pushButton7();
        pushButton8();
        pushButton9();
        pushButton10();
        pushButton11();
        pushButton12();

        return v;
    }


    public void toggle1(){
        ToggleButton toggle1 = (ToggleButton) v.findViewById(R.id.cs4_toggleButton1);

        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/toggle1");

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

    public void slider1() {
        SeekBar mySlider1 = (SeekBar) v.findViewById(R.id.cs4_fader1);


        mySlider1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/fader1");
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


    public void pushButtonReverse(){

        final ImageButton myButtonReverse = (ImageButton) v.findViewById(R.id.cs4_button_reverse);


        myButtonReverse.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push13");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButtonReverse.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButtonReverse.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }


    public void slider2() {
        SeekBar mySlider2 = (SeekBar) v.findViewById(R.id.cs4_fader2);


        mySlider2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/fader2");
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

        final ImageButton myButton1 = (ImageButton) v.findViewById(R.id.cs4_button1);


        myButton1.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push1");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton1.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton1.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }


    public void pushButton2(){

        final ImageButton myButton2 = (ImageButton) v.findViewById(R.id.cs4_button2);


        myButton2.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push2");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton2.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton2.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }


    public void pushButton3(){

        final ImageButton myButton3 = (ImageButton) v.findViewById(R.id.cs4_button3);


        myButton3.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push3");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton3.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton3.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }


    public void pushButton4(){

        final ImageButton myButton4 = (ImageButton) v.findViewById(R.id.cs4_button4);


        myButton4.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push4");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton4.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton4.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }

    public void pushButton5(){

        final ImageButton myButton5 = (ImageButton) v.findViewById(R.id.cs4_button5);


        myButton5.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push5");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton5.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton5.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }

    public void pushButton6(){

        final ImageButton myButton6 = (ImageButton) v.findViewById(R.id.cs4_button6);


        myButton6.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push6");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton6.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton6.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }


    public void pushButton7(){

        final ImageButton myButton7 = (ImageButton) v.findViewById(R.id.cs4_button7);


        myButton7.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push7");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton7.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton7.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }


    public void pushButton8(){

        final ImageButton myButton8 = (ImageButton) v.findViewById(R.id.cs4_button8);


        myButton8.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push8");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton8.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton8.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }


    public void pushButton9(){

        final ImageButton myButton9 = (ImageButton) v.findViewById(R.id.cs4_button9);


        myButton9.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push9");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton9.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton9.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }


    public void pushButton10(){

        final ImageButton myButton10 = (ImageButton) v.findViewById(R.id.cs4_button10);


        myButton10.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push10");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton10.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton10.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }

    public void pushButton11(){

        final ImageButton myButton11 = (ImageButton) v.findViewById(R.id.cs4_button11);


        myButton11.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push11");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton11.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton11.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }

    public void pushButton12(){

        final ImageButton myButton12 = (ImageButton) v.findViewById(R.id.cs4_button12);


        myButton12.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/4/push12");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButton12.setPressed(true);    // obligado para feedback visual
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButton12.setPressed(false);    // obligado para feedback visual
                        break;
                }
                return true;
            }
        });
    }

}
