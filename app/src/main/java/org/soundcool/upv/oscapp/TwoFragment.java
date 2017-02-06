package org.soundcool.upv.oscapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;




public class TwoFragment extends Fragment{

    View v; // para poder pedir referencia con findViewById

    public TwoFragment() {
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
        this.v = inflater.inflate(R.layout.fragment_two, container, false);

        // Una vez creado el View "v", podemos ejecutar los metodos de los controles, ya que ahora
        // pueden pedir referencia con findViewById
        slider1();
        slider2();
        slider3();
        slider4();
        slider5();
        slider6();
        slider7();
        slider8();
        slider9();

        return v;
    }

    public void slider1() {
        SeekBar mySlider1 = (SeekBar) v.findViewById(R.id.cs2_fader1);


        mySlider1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/2/fader1");
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
        SeekBar mySlider2 = (SeekBar) v.findViewById(R.id.cs2_fader2);


        mySlider2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/2/fader2");
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
        SeekBar mySlider3 = (SeekBar) v.findViewById(R.id.cs2_fader3);


        mySlider3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/2/fader3");
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

    public void slider4() {
        SeekBar mySlider4 = (SeekBar) v.findViewById(R.id.cs2_fader4);


        mySlider4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/2/fader4");
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

    public void slider5() {
        SeekBar mySlider5 = (SeekBar) v.findViewById(R.id.cs2_fader5);


        mySlider5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/2/fader5");
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

    public void slider6() {
        SeekBar mySlider6 = (SeekBar) v.findViewById(R.id.cs2_fader6);


        mySlider6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/2/fader6");
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

    public void slider7() {
        SeekBar mySlider7 = (SeekBar) v.findViewById(R.id.cs2_fader7);


        mySlider7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/2/fader7");
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


    public void slider8() {
        SeekBar mySlider8 = (SeekBar) v.findViewById(R.id.cs2_fader8);


        mySlider8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/2/fader8");
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


    public void slider9() {
        SeekBar mySlider9 = (SeekBar) v.findViewById(R.id.cs2_fader9);


        mySlider9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/2/fader9");
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

}