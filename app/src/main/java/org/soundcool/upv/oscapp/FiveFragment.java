package org.soundcool.upv.oscapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;




public class FiveFragment extends Fragment{

    //**************** Variables miembro para los multisliders ************

    private SeekBar mySlider1;
    private SeekBar mySlider2;
    private SeekBar mySlider3;
    private SeekBar mySlider4;
    private SeekBar mySlider5;
    private SeekBar mySlider6;
    private SeekBar mySlider7;
    private SeekBar mySlider8;
    private SeekBar mySlider9;
    private SeekBar mySlider10;
    private SeekBar mySlider11;
    private SeekBar mySlider12;
    private SeekBar mySlider13;
    private SeekBar mySlider14;
    private SeekBar mySlider15;
    private SeekBar mySlider16;
    private SeekBar mySlider17;
    private SeekBar mySlider18;
    private SeekBar mySlider19;
    private SeekBar mySlider20;

    private float a1;
    private boolean isAnchoCalculated =  false;

    private ViewGroup myVG;

    //**************** FIN - Variables miembro para los multisliders ************

    View v; // para poder pedir referencia con findViewById

    public FiveFragment() {
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
        this.v = inflater.inflate(R.layout.fragment_five, container, false);

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
        slider10();
        slider11();
        slider12();
        slider13();
        slider14();
        slider15();
        slider16();
        slider17();
        slider18();
        slider19();
        slider20();

        container();    // Es lo que hace funcionar al multislider

        toggle();
        sliderDuration();
        pushButtonStart();
        pushButtonClear();

        return v;
    }


    //**************** Métodos para los multisliders ************

    public void calculaAnchos(){  // En un principio tenia mas lineas pq calculaba el ancho de cada slider
        this.a1 = mySlider1.getWidth();
        this.isAnchoCalculated = true;
    }

    public void slider1() {
        this.mySlider1 = (SeekBar) v.findViewById(R.id.cs5_seekBar1);


        mySlider1.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona


        mySlider1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/1");
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
        this.mySlider2 = (SeekBar) v.findViewById(R.id.cs5_seekBar2);


        mySlider2.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/2");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider3() {
        this.mySlider3 = (SeekBar) v.findViewById(R.id.cs5_seekBar3);


        mySlider3.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/3");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider4() {
        this.mySlider4 = (SeekBar) v.findViewById(R.id.cs5_seekBar4);


        mySlider4.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/4");
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
        this.mySlider5 = (SeekBar) v.findViewById(R.id.cs5_seekBar5);


        mySlider5.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/5");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider6() {
        this.mySlider6 = (SeekBar) v.findViewById(R.id.cs5_seekBar6);


        mySlider6.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona


        mySlider6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/6");
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
        this.mySlider7 = (SeekBar) v.findViewById(R.id.cs5_seekBar7);


        mySlider7.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/7");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider8() {
        this.mySlider8 = (SeekBar) v.findViewById(R.id.cs5_seekBar8);


        mySlider8.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/8");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider9() {
        this.mySlider9 = (SeekBar) v.findViewById(R.id.cs5_seekBar9);


        mySlider9.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/9");
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

    public void slider10() {
        this.mySlider10 = (SeekBar) v.findViewById(R.id.cs5_seekBar10);


        mySlider10.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider10.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/10");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }


    public void slider11() {
        this.mySlider11 = (SeekBar) v.findViewById(R.id.cs5_seekBar11);


        mySlider11.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona


        mySlider11.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/11");
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

    public void slider12() {
        this.mySlider12 = (SeekBar) v.findViewById(R.id.cs5_seekBar12);


        mySlider12.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/12");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider13() {
        this.mySlider13 = (SeekBar) v.findViewById(R.id.cs5_seekBar13);


        mySlider13.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider13.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/13");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider14() {
        this.mySlider14 = (SeekBar) v.findViewById(R.id.cs5_seekBar14);


        mySlider14.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider14.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/14");
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

    public void slider15() {
        this.mySlider15 = (SeekBar) v.findViewById(R.id.cs5_seekBar15);


        mySlider15.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider15.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/15");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider16() {
        this.mySlider16 = (SeekBar) v.findViewById(R.id.cs5_seekBar16);


        mySlider16.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona


        mySlider16.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/16");
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

    public void slider17() {
        this.mySlider17 = (SeekBar) v.findViewById(R.id.cs5_seekBar17);


        mySlider17.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider17.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/17");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider18() {
        this.mySlider18 = (SeekBar) v.findViewById(R.id.cs5_seekBar18);


        mySlider18.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider18.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/18");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider19() {
        this.mySlider19 = (SeekBar) v.findViewById(R.id.cs5_seekBar19);


        mySlider19.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider19.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/19");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void slider20() {
        this.mySlider20 = (SeekBar) v.findViewById(R.id.cs5_seekBar20);


        mySlider20.setEnabled(false); // buen comoportamiento... aparenta desactivado pero funciona

        mySlider20.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/multifader1/20");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }

    public void container(){

        this.myVG = (ViewGroup) v.findViewById(R.id.cs5_ViewGroup1);

        myVG.setOnTouchListener(new ViewGroup.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    // En la Prueba solo implementé ACTION_MOVE e iba bien... pero si ahora pongo
                    // ACTION_DOWN sin break, la app puede responder tb a clicks
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:

                        // Delimitamos GroupView para evitar dar valores de fuera (negativos y mayores) cuando el gesto sale del GroupView
                        if ((event.getX() >= 0 && event.getY() >= 0) && (event.getX() <= myVG.getWidth() && event.getY() <= myVG.getHeight())) {

                            if (!isAnchoCalculated){ // Lo hacemos solo una vez
                                calculaAnchos();
                            }

                            int valor = Math.round((1 - (event.getY() / myVG.getHeight())) * 100);

                            switch (findFader(event.getX())){
                                case 1:
                                    mySlider1.setProgress(valor);
                                    break;
                                case 2:
                                    mySlider2.setProgress(valor);
                                    break;
                                case 3:
                                    mySlider3.setProgress(valor);
                                    break;
                                case 4:
                                    mySlider4.setProgress(valor);
                                    break;
                                case 5:
                                    mySlider5.setProgress(valor);
                                    break;
                                case 6:
                                    mySlider6.setProgress(valor);
                                    break;
                                case 7:
                                    mySlider7.setProgress(valor);
                                    break;
                                case 8:
                                    mySlider8.setProgress(valor);
                                    break;
                                case 9:
                                    mySlider9.setProgress(valor);
                                    break;
                                case 10:
                                    mySlider10.setProgress(valor);
                                    break;

                                case 11:
                                    mySlider11.setProgress(valor);
                                    break;
                                case 12:
                                    mySlider12.setProgress(valor);
                                    break;
                                case 13:
                                    mySlider13.setProgress(valor);
                                    break;
                                case 14:
                                    mySlider14.setProgress(valor);
                                    break;
                                case 15:
                                    mySlider15.setProgress(valor);
                                    break;
                                case 16:
                                    mySlider16.setProgress(valor);
                                    break;
                                case 17:
                                    mySlider17.setProgress(valor);
                                    break;
                                case 18:
                                    mySlider18.setProgress(valor);
                                    break;
                                case 19:
                                    mySlider19.setProgress(valor);
                                    break;
                                case 20:
                                    mySlider20.setProgress(valor);
                                    break;

                            }
                            //Log.d("DEBUG_TAG", ("X: " + event.getX()) + " - Y: " + event.getY());
                            //Log.d("DEBUG_TAG", ("fader " + findFader(event.getX()) + "a2= " + a2));
                        }
                        break;


                }
                return true;    // esto no lo tengo muy claro
            }
        });

    }


    public int findFader(float coordX){

        /* Aqui calculaba cada ancho de cada slider, pero no es practico y asumire que todos son iguales
        // Si asumo que todos tienen el mismo ancho puedo utilizar multiplicaciones
        if (coordX <= a1){ return 1;}
        else if (coordX > a1  && coordX <= a1 + a2) {return 2;}
        else if (coordX > a1 + a2  && coordX <= a1 + a2 + a3) {return 3;}
        else if (coordX > a1 + a2 + a3  && coordX <= a1 + a2 + a3 + a4) {return 4;}
        else if (coordX > a1 + a2 + a3 + a4  && coordX <= a1 + a2 + a3 + a4 + a5) {return 5;}
        else {return -1;}
        */

        if (coordX <= a1){ return 1;}
        else if (coordX > a1  && coordX <= a1 * 2) {return 2;}
        else if (coordX > a1 * 2  && coordX <= a1 * 3) {return 3;}
        else if (coordX > a1 * 3  && coordX <= a1 * 4) {return 4;}
        else if (coordX > a1 * 4  && coordX <= a1 * 5) {return 5;}
        else if (coordX > a1 * 5  && coordX <= a1 * 6) {return 6;}
        else if (coordX > a1 * 6  && coordX <= a1 * 7) {return 7;}
        else if (coordX > a1 * 7  && coordX <= a1 * 8) {return 8;}
        else if (coordX > a1 * 8  && coordX <= a1 * 9) {return 9;}
        else if (coordX > a1 * 9  && coordX <= a1 * 10) {return 10;}
        else if (coordX > a1 * 10  && coordX <= a1 * 11) {return 11;}
        else if (coordX > a1 * 11  && coordX <= a1 * 12) {return 12;}
        else if (coordX > a1 * 12  && coordX <= a1 * 13) {return 13;}
        else if (coordX > a1 * 13  && coordX <= a1 * 14) {return 14;}
        else if (coordX > a1 * 14  && coordX <= a1 * 15) {return 15;}
        else if (coordX > a1 * 15  && coordX <= a1 * 16) {return 16;}
        else if (coordX > a1 * 16  && coordX <= a1 * 17) {return 17;}
        else if (coordX > a1 * 17  && coordX <= a1 * 18) {return 18;}
        else if (coordX > a1 * 18  && coordX <= a1 * 19) {return 19;}
        else if (coordX > a1 * 19  && coordX <= a1 * 20) {return 20;}
        else {return -1;}
    }


    //**************** FIN - Métodos para los multisliders ************


    public void toggle(){
        ToggleButton toggle1 = (ToggleButton) v.findViewById(R.id.cs5_toggle);

        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/toggle1");

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


    public void sliderDuration() {
        SeekBar mySlidersliderDuration = (SeekBar) v.findViewById(R.id.cs5_fader1);
        final TextView durationDisplay = (TextView) v.findViewById(R.id.cs5_display);

        mySlidersliderDuration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/fader1");
                OSCmsg[1] = new Float(progress / 100.0);
                new OSCsender().execute(OSCmsg);

                // Mostramos la duracion
                double duration = progress / 100.0 * 10;
                durationDisplay.setText(String.format("%.1f", duration));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void pushButtonStart(){

        final Button myButtonStart = (Button) v.findViewById(R.id.cs5_buttonStart);

        myButtonStart.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/push1");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButtonStart.setPressed(true);   // para que el feedback visual funcione
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButtonStart.setPressed(false);    // para que el feedback visual funcione
                        break;
                }
                return true;
            }
        });
    }


    public void pushButtonClear(){

        final Button myButtonClear = (Button) v.findViewById(R.id.cs5_buttonClear);

        myButtonClear.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View yourButton, MotionEvent theMotion) {
                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/5/push2");

                switch (theMotion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OSCmsg[1] = new Float(1.);
                        new OSCsender().execute(OSCmsg);
                        myButtonClear.setPressed(true);   // para que el feedback visual funcione
                        break;
                    case MotionEvent.ACTION_UP:
                        OSCmsg[1] = new Float(0.);
                        new OSCsender().execute(OSCmsg);
                        myButtonClear.setPressed(false);    // para que el feedback visual funcione
                        clearInApp();   // Reseteamos los faders tb en la app
                        break;
                }
                return true;
            }
        });
    }

    public void clearInApp(){   // en el modulo habrá un doble Clear.. pero funciona bien
        mySlider1.setProgress(0);
        mySlider2.setProgress(0);
        mySlider3.setProgress(0);
        mySlider4.setProgress(0);
        mySlider5.setProgress(0);
        mySlider6.setProgress(0);
        mySlider7.setProgress(0);
        mySlider8.setProgress(0);
        mySlider9.setProgress(0);
        mySlider10.setProgress(0);
        mySlider11.setProgress(0);
        mySlider12.setProgress(0);
        mySlider13.setProgress(0);
        mySlider14.setProgress(0);
        mySlider15.setProgress(0);
        mySlider16.setProgress(0);
        mySlider17.setProgress(0);
        mySlider18.setProgress(0);
        mySlider19.setProgress(0);
        mySlider20.setProgress(0);
    }


}