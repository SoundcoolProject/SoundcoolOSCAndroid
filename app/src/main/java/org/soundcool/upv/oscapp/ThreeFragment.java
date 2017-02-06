package org.soundcool.upv.oscapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;




public class ThreeFragment extends Fragment{

    View v; // para poder pedir referencia con findViewById
    RadioGroup radioGroup;  // la hacemos "global" porque necesitaremos acceder desde el "panic"

    //************ Para pianito **************
    private ViewGroup myVG;
    private ImageView myImageView;

    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paintW, paintBorder, paintB, paintDown;
    private Rect RectDo, RectRe, RectMi, RectFa, RectSol, RectLa, RectSi, RectDo8va, RectDoS, RectReS, RectFaS, RectSolS, RectLaS;

    private boolean isDoDown = false;
    private boolean isDoSDown = false;
    private boolean isReDown = false;
    private boolean isReSDown = false;
    private boolean isMiDown = false;
    private boolean isFaDown = false;
    private boolean isFaSDown = false;
    private boolean isSolDown = false;
    private boolean isSolSDown = false;
    private boolean isLaDown = false;
    private boolean isLaSDown = false;
    private boolean isSiDown = false;
    private boolean isDo8vaDown = false;


    private int idNuevoPointer = -1;    // -1 indicará que aceptamos nuevos pointers
    private int idOtroPointer = -1;
    private int idAltrePointer = -1;
    private int idAnotherPointer = -1;
    private int teclaNuevoPointer = -1;
    private int teclaOtroPointer = -1;
    private int teclaAltrePointer = -1;
    private int teclaAnotherPointer = -1;


    private boolean iWillSendTheOneLater = false;   // para hacer un apaño

    private SeekBar mySlider3;  // necesario hacerla global para el "panic"


    //******** fin - variables miembro para pianito*******



    public ThreeFragment() {
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
        this.v = inflater.inflate(R.layout.fragment_three, container, false);

        // Una vez creado el View "v", podemos ejecutar los metodos de los controles, ya que ahora
        // pueden pedir referencia con findViewById

        myImageView = (ImageView) v.findViewById(R.id.cs3_image_view1);
        myVG = (ViewGroup) v.findViewById(R.id.cs3_ViewGroup1);

        // Para poder dibujar teclas antes de dibujarse el contenedor
        ViewTreeObserver vto = myVG.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //myVG.getViewTreeObserver().removeGlobalOnLayoutListener(this); // creo que no hace falta
                int width = myVG.getMeasuredWidth();
                int height = myVG.getMeasuredHeight();
                dibujaPiano(width, height);
            }
        });

        container(); // es el metodo que hace funcionar el piano
        slider1();
        slider2();
        toggle1();
        panicButton();
        octaveRadioButtons();

        return v;
    }

    //********** Empiezan metodos del pianito  ***************************************
    public void dibujaPiano(int width, int height){

        int keyboardWidth = width;
        int keyboardHeight = height;
        int widthWhiteKey = keyboardWidth / 8;     // HACER: ver si hay que hacer cast a int o hacer un round
        int widthBlackKey = widthWhiteKey * 2 / 3; // HACER: ver si hay que hacer cast a int o hacer un round

        bitmap = Bitmap.createBitmap(keyboardWidth, keyboardHeight, Bitmap.Config.ARGB_8888); // HACER estudiar eso del Bitmap.Config.ARGB_8888

        canvas = new Canvas(bitmap);

        // Para las teclas blancas
        paintW = new Paint();
        paintW.setColor(Color.WHITE);
        paintW.setStyle(Paint.Style.FILL);

        // Para hacer los bordes negros
        paintBorder = new Paint();
        paintBorder.setColor(Color.BLACK);
        paintBorder.setStyle(Paint.Style.STROKE);
        paintBorder.setStrokeWidth(4);

        // Para las teclas negras
        paintB = new Paint();
        paintB.setColor(Color.BLACK);
        paintB.setStyle(Paint.Style.FILL);

        // Para las teclas Down
        paintDown = new Paint();
        paintDown.setColor(Color.rgb(13, 230, 230));
        paintDown.setStyle(Paint.Style.FILL);

        // Primero dibujamos las teclas blancas
        // Tecla Do
        int leftxDo = 0;
        int topy = 0;
        int rightxDo = widthWhiteKey;
        int bottomy = keyboardHeight;
        RectDo = new Rect(leftxDo, topy, rightxDo, bottomy);
        canvas.drawRect(RectDo, paintW);
        canvas.drawRect(RectDo, paintBorder);

        // Tecla Re
        int leftx_Re = widthWhiteKey;
        int rightx_Re = leftx_Re + widthWhiteKey;
        RectRe = new Rect(leftx_Re, topy, rightx_Re, bottomy);
        canvas.drawRect(RectRe, paintW);
        canvas.drawRect(RectRe, paintBorder);

        // Tecla Mi
        int leftx_Mi = widthWhiteKey * 2;
        int rightx_Mi = leftx_Mi + widthWhiteKey;
        RectMi = new Rect(leftx_Mi, topy, rightx_Mi, bottomy);
        canvas.drawRect(RectMi, paintW);
        canvas.drawRect(RectMi, paintBorder);

        // Tecla Fa
        int leftx_Fa = widthWhiteKey * 3;
        int rightx_Fa = leftx_Fa + widthWhiteKey;
        RectFa = new Rect(leftx_Fa, topy, rightx_Fa, bottomy);
        canvas.drawRect(RectFa, paintW);
        canvas.drawRect(RectFa, paintBorder);

        // Tecla Sol
        int leftx_Sol = widthWhiteKey * 4;
        int rightx_Sol = leftx_Sol + widthWhiteKey;
        RectSol = new Rect(leftx_Sol, topy, rightx_Sol, bottomy);
        canvas.drawRect(RectSol, paintW);
        canvas.drawRect(RectSol, paintBorder);

        // Tecla La
        int leftx_La = widthWhiteKey * 5;
        int rightx_La = leftx_La + widthWhiteKey;
        RectLa = new Rect(leftx_La, topy, rightx_La, bottomy);
        canvas.drawRect(RectLa, paintW);
        canvas.drawRect(RectLa, paintBorder);

        // Tecla Si
        int leftx_Si = widthWhiteKey * 6;
        int rightx_Si = leftx_Si + widthWhiteKey;
        RectSi = new Rect(leftx_Si, topy, rightx_Si, bottomy);
        canvas.drawRect(RectSi, paintW);
        canvas.drawRect(RectSi, paintBorder);

        // Tecla Do Octava
        int leftx_Do8va = widthWhiteKey * 7;
        int rightx_Do8va = leftx_Do8va + widthWhiteKey;
        RectDo8va = new Rect(leftx_Do8va, topy, rightx_Do8va, bottomy);
        canvas.drawRect(RectDo8va, paintW);
        canvas.drawRect(RectDo8va, paintBorder);



        // Los sostenidos los dibujamos despues de los naturales
        // Tecla Do#
        int leftx_DoS = leftx_Re - (widthBlackKey / 2);
        int rightx_DoS = leftx_DoS + widthBlackKey;
        int bottomyB = keyboardHeight * 2 / 3;  // Lo calculamos solo esta vez
        RectDoS = new Rect(leftx_DoS, topy, rightx_DoS, bottomyB);
        canvas.drawRect(RectDoS, paintB);
        canvas.drawRect(RectDoS, paintBorder);


        // Tecla Re#
        int leftx_ReS = leftx_Mi - (widthBlackKey / 2);
        int rightx_ReS = leftx_ReS + widthBlackKey;
        RectReS = new Rect(leftx_ReS, topy, rightx_ReS, bottomyB);
        canvas.drawRect(RectReS, paintB);
        canvas.drawRect(RectReS, paintBorder);

        // Tecla Fa#
        // Esta algoritmica es mejor que la de la tecla Re#. HACER: cambiar el Re#
        int leftx_FaS = leftx_Sol - (widthBlackKey / 2);
        int rightx_FaS = leftx_FaS + widthBlackKey;
        RectFaS = new Rect(leftx_FaS, topy, rightx_FaS, bottomyB);
        canvas.drawRect(RectFaS, paintB);
        canvas.drawRect(RectFaS, paintBorder);

        // Tecla Sol#
        int leftx_SolS = leftx_La - (widthBlackKey / 2);
        int rightx_SolS = leftx_SolS + widthBlackKey;
        RectSolS = new Rect(leftx_SolS, topy, rightx_SolS, bottomyB);
        canvas.drawRect(RectSolS, paintB);
        canvas.drawRect(RectSolS, paintBorder);

        // Tecla La#
        int leftx_LaS = leftx_Si - (widthBlackKey / 2);
        int rightx_LaS = leftx_LaS + widthBlackKey;
        RectLaS = new Rect(leftx_LaS, topy, rightx_LaS, bottomyB);
        canvas.drawRect(RectLaS, paintB);
        canvas.drawRect(RectLaS, paintBorder);

        // Ya podemos visualizar el piano
        myImageView.setImageBitmap(bitmap);

    }

    // es el metodo que hace funcionar el piano
    public void container(){

        this.myVG = (ViewGroup) v.findViewById(R.id.cs3_ViewGroup1);

        myVG.setOnTouchListener(new ViewGroup.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {



                //if ((event.getX() >= 0 && event.getY() >= 0) && (event.getX() <= myVG.getWidth() && event.getY() <= myVG.getHeight())) {  // comentado para resolver el problema de salirnos del pianito

                //switch (event.getAction()) {  // OLD... no detectaba el ACTION_POINTER_DOWN
                switch (MotionEventCompat.getActionMasked(event)){
                    case MotionEvent.ACTION_DOWN:

                        int tecla_down = down(event.getX(), event.getY(), event.getPointerId(0));
                        //[de momento no pongo lo de la derecha pq al hacer muteALL resetea las variables de seguimiento ded tecla] hazReleaseTodosMenosUno(tecla_down);    // Nos aseguramos haciendo este mute ya que sabemos seguro que solo hay un dedo en pantalla
                        break;


                    case MotionEvent.ACTION_POINTER_DOWN: // Para detectar multitouches después del primero

                        // Vemos si se permite nuevos pointers,
                        if ((idNuevoPointer == -1) || (idOtroPointer == -1) || (idAltrePointer == -1) || (idAnotherPointer == -1)) {

                            int tecla_down2 = down(event.getX(event.getActionIndex()), event.getY(event.getActionIndex()), event.getPointerId(event.getActionIndex()));
                            // HACER: Si acabo no usando ni tecla_down2 ni tecla_down (de ACTION_DOWN), deberia quitarlas
                        }
                        break;


                    case MotionEvent.ACTION_UP:
                        muteAll();
                        break;


                    case MotionEvent.ACTION_POINTER_UP: // Para detectar multitouches después del primero

                        if (idNuevoPointer == event.getPointerId(event.getActionIndex())) {
                            hazReleaseTeclaInt(teclaNuevoPointer);
                            idNuevoPointer = -1;
                            teclaNuevoPointer = -1;
                        } else if (idOtroPointer == event.getPointerId(event.getActionIndex())) {
                            hazReleaseTeclaInt(teclaOtroPointer);
                            idOtroPointer = -1;
                            teclaOtroPointer = -1;
                        } else if (idAltrePointer == event.getPointerId(event.getActionIndex())) {
                            hazReleaseTeclaInt(teclaAltrePointer);
                            idAltrePointer = -1;
                            teclaAltrePointer = -1;
                        } else if (idAnotherPointer == event.getPointerId(event.getActionIndex())) {
                            hazReleaseTeclaInt(teclaAnotherPointer);
                            idAnotherPointer = -1;
                            teclaAnotherPointer = -1;
                        }
                        break;


                    case MotionEvent.ACTION_MOVE: // Aqui hacemos posible los glisandos

                        if (event.getPointerCount() == 1) { // solo permitimos el glissando si hay un solo dedo.

                            iWillSendTheOneLater =  true;   // este apaño es necesario y se hace efectivo en down()
                            int tecla_down3 = down(event.getX(event.getActionIndex()), event.getY(event.getActionIndex()), event.getPointerId(event.getActionIndex()));
                            if (tecla_down3 != -1){ // solo hacemos esto si ha habido cambio de tecla
                                hazReleaseTodosMenosUno(tecla_down3, event.getPointerId(event.getActionIndex()));
                            }
                            iWillSendTheOneLater =  false;

                        }
                        break;

                }
                //}else {
                //AQUI SE DETECTA QUE NOS HEMOS SALIDO DEL PIANO
                //}
                return true;    // Esto no lo tengo claro
            }

        });


    }



    public void hazReleaseTeclaInt(int tecla){
        switch (tecla){
            case 1:
                isDoDown = false;
                actualizaTeclaDo(); // esta llamada siempre ira despues de actualizar el valor de isDoDown
                ceroPorOSC("/3/push1");
                // Log.d("ReleasePointer", "Do");
                break;
            case 2:
                isDoSDown = false;
                actualizaTeclaDoS(); // esta llamada siempre ira despues de actualizar el valor de isDoSDown
                ceroPorOSC("/3/push2");
                // Log.d("ReleasePointer", "Do#");
                break;
            case 3:
                isReDown = false;
                actualizaTeclaRe(); // esta llamada siempre ira despues de actualizar el valor de isReDown
                ceroPorOSC("/3/push3");
                // Log.d("ReleasePointer", "Re");
                break;
            case 4:
                isReSDown = false;
                actualizaTeclaReS(); // esta llamada siempre ira despues de actualizar el valor de isReSDown
                ceroPorOSC("/3/push4");
                // Log.d("ReleasePointer", "Re#");
                break;
            case 5:
                isMiDown = false;
                ceroPorOSC("/3/push5");
                actualizaTeclaMi(); // esta llamada siempre ira despues de actualizar el valor de isMiDown
                // Log.d("ReleasePointer", "Mi");
                break;
            case 6:
                isFaDown = false;
                ceroPorOSC("/3/push6");
                actualizaTeclaFa(); // esta llamada siempre ira despues de actualizar el valor de isFaDown
                // Log.d("ReleasePointer", "Fa");
                break;
            case 7:
                isFaSDown = false;
                ceroPorOSC("/3/push7");
                actualizaTeclaFaS(); // esta llamada siempre ira despues de actualizar el valor de isFaSDown
                // Log.d("ReleasePointer", "Fa#");
                break;
            case 8:
                isSolDown = false;
                ceroPorOSC("/3/push8");
                actualizaTeclaSol(); // esta llamada siempre ira despues de actualizar el valor de isSolDown
                // Log.d("ReleasePointer", "Sol");
                break;
            case 9:
                isSolSDown = false;
                ceroPorOSC("/3/push9");
                actualizaTeclaSolS(); // esta llamada siempre ira despues de actualizar el valor de isSolSDown
                // Log.d("ReleasePointer", "Sol#");
                break;
            case 10:
                isLaDown = false;
                ceroPorOSC("/3/push10");
                actualizaTeclaLa(); // esta llamada siempre ira despues de actualizar el valor de isLaDown
                // Log.d("ReleasePointer", "La");
                break;
            case 11:
                isLaSDown = false;
                ceroPorOSC("/3/push11");
                actualizaTeclaLaS(); // esta llamada siempre ira despues de actualizar el valor de isLaSDown
                // Log.d("ReleasePointer", "La#");
                break;
            case 12:
                isSiDown = false;
                ceroPorOSC("/3/push12");
                actualizaTeclaSi(); // esta llamada siempre ira despues de actualizar el valor de isSiDown
                // Log.d("ReleasePointer", "Si");
                break;
            case 13:
                isDo8vaDown = false;
                ceroPorOSC("/3/push13");
                actualizaTeclaDo8va(); // esta llamada siempre ira despues de actualizar el valor de isDo8vaDown
                // Log.d("ReleasePointer", "Do8va");
                break;

        }
    }


    public void hazReleaseTodosMenosUno(int tecla, int currentPointerID){  // para los glissandos de ACTION_MOVE
        // Log.d("Release", "TodosMenosUno");

        muteAllMenosUnPointer(tecla, currentPointerID);

        switch(tecla){
            case 1:

                isDoDown = true;
                actualizaTeclaDo(); // esta llamada siempre ira despues de actualizar el valor de isDoDown
                unoPorOSC("/3/push1");
                break;

            case 2:

                isDoSDown = true;
                actualizaTeclaDoS(); // esta llamada siempre ira despues de actualizar el valor de isDoSDown
                unoPorOSC("/3/push2");
                break;

            case 3:

                isReDown = true;
                actualizaTeclaRe(); // esta llamada siempre ira despues de actualizar el valor de isReDown
                unoPorOSC("/3/push3");
                break;

            case 4:

                isReSDown = true;
                actualizaTeclaReS(); // esta llamada siempre ira despues de actualizar el valor de isReSDown
                unoPorOSC("/3/push4");
                break;

            case 5:

                isMiDown = true;
                actualizaTeclaMi(); // esta llamada siempre ira despues de actualizar el valor de isMiDown
                unoPorOSC("/3/push5");
                break;

            case 6:

                isFaDown = true;
                actualizaTeclaFa(); // esta llamada siempre ira despues de actualizar el valor de isFaDown
                unoPorOSC("/3/push6");
                break;

            case 7:

                isFaSDown = true;
                actualizaTeclaFaS(); // esta llamada siempre ira despues de actualizar el valor de isFaSDown
                unoPorOSC("/3/push7");
                break;

            case 8:

                isSolDown = true;
                actualizaTeclaSol(); // esta llamada siempre ira despues de actualizar el valor de isSolDown
                unoPorOSC("/3/push8");
                break;

            case 9:

                isSolSDown = true;
                actualizaTeclaSolS(); // esta llamada siempre ira despues de actualizar el valor de isSolSDown
                unoPorOSC("/3/push9");
                break;

            case 10:

                isLaDown = true;
                actualizaTeclaLa(); // esta llamada siempre ira despues de actualizar el valor de isLaDown
                unoPorOSC("/3/push10");
                break;

            case 11:

                isLaSDown = true;
                actualizaTeclaLaS(); // esta llamada siempre ira despues de actualizar el valor de isLaSDown
                unoPorOSC("/3/push11");
                break;

            case 12:

                isSiDown = true;
                actualizaTeclaSi(); // esta llamada siempre ira despues de actualizar el valor de isSiDown
                unoPorOSC("/3/push12");
                break;

            case 13:

                isDo8vaDown = true;
                actualizaTeclaDo8va(); // esta llamada siempre ira despues de actualizar el valor de isDo8vaDown
                unoPorOSC("/3/push13");
                break;
        }
    }

    public void muteAll(){
        // Enviar ceros por OSC. Hacer una funcion ya que esto se utiliza en varios sitios
        todoCerosOSC();

        // actualizar teclado visualmente
        redibujaPiano();

        // Todos false
        isDoDown = isDoSDown = isReDown = isReSDown = isMiDown = isFaDown = isFaSDown = isSolDown = isSolSDown = isLaDown = isLaSDown = isSiDown = isDo8vaDown = false;
        // Log.d("MUTE ALL", "HECHO");

        // Reset de variables de nuevos pointers
        idNuevoPointer = idOtroPointer = idAltrePointer = idAnotherPointer = -1;
        teclaNuevoPointer = teclaOtroPointer = teclaAltrePointer = teclaAnotherPointer = -1;
    }

    public void muteAllMenosUnPointer(int tecla, int currentPointerID){ // para los glissandos de ACTION_MOVE

        // Enviar ceros por OSC. Hacer una funcion ya que esto se utiliza en varios sitios
        todoCerosOSC();

        // actualizar teclado visualmente
        redibujaPiano();

        // Todos false
        isDoDown = isDoSDown = isReDown = isReSDown = isMiDown = isFaDown = isFaSDown = isSolDown = isSolSDown = isLaDown = isLaSDown = isSiDown = isDo8vaDown = false;

        // Reset TODOS MENOS UNO de las variables de nuevos pointers
        if (idNuevoPointer ==  currentPointerID) {
            teclaNuevoPointer = tecla;  // conceptualmente esto no es un "reset", sino una actualizacion, pero es una actualizacion necesaria
            idOtroPointer = -1;
            teclaOtroPointer = -1;
            idAltrePointer = -1;
            teclaAltrePointer = -1;
            idAnotherPointer = -1;
            teclaAnotherPointer = -1;

        }
        // no se si con "else if" sería mejor o peor... el caso es que usando solo "if" funciona bien!!... con lo que no voy a tocarlo :)
        if (idOtroPointer ==  currentPointerID) {
            teclaOtroPointer = tecla;
            idNuevoPointer = -1;
            teclaNuevoPointer = -1;
            idAltrePointer = -1;
            teclaAltrePointer = -1;
            idAnotherPointer = -1;
            teclaAnotherPointer = -1;
        }

        if (idAltrePointer ==  currentPointerID) {
            teclaAltrePointer = tecla;
            idNuevoPointer = -1;
            teclaNuevoPointer = -1;
            idOtroPointer = -1;
            teclaOtroPointer = -1;
            idAnotherPointer = -1;
            teclaAnotherPointer = -1;

        }

        if (idAnotherPointer ==  currentPointerID) {
            teclaAnotherPointer = tecla;
            idNuevoPointer = -1;
            teclaNuevoPointer = -1;
            idOtroPointer = -1;
            teclaOtroPointer = -1;
            idAltrePointer = -1;
            teclaAltrePointer = -1;

        }

    }

    public int down(float mX, float mY, int pointerID){
        int tecla = -1;
        // primero detectamos tecla...
        // Primero los sostenidos

        if (RectDoS.contains(Math.round(mX), Math.round(mY))) {
            if (!isDoSDown) {     // queremos enviar por OSC el 1. sólo una vez
                isDoSDown = true;
                actualizaTeclaDoS(); // esta llamada siempre ira despues de actualizar el valor de isDoSDown
                tecla = 2;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push2");}
                // Log.d("_DOWN", "Do#");

            }
        }else if (RectReS.contains(Math.round(mX), Math.round(mY))) {
            if (!isReSDown) {     // queremos enviar por OSC el 1. sólo una vez
                isReSDown = true;
                actualizaTeclaReS(); // esta llamada siempre ira despues de actualizar el valor de isReSDown
                tecla = 4;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push4");}
                // Log.d("_DOWN", "Re#");

            }


        }else if (RectFaS.contains(Math.round(mX), Math.round(mY))) {
            if (!isFaSDown) {     // queremos enviar por OSC el 1. sólo una vez
                isFaSDown = true;
                actualizaTeclaFaS(); // esta llamada siempre ira despues de actualizar el valor de isFaSDown
                tecla = 7;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push7");}
                // Log.d("_DOWN", "Fa#");

            }


        }else if (RectSolS.contains(Math.round(mX), Math.round(mY))) {
            if (!isSolSDown) {     // queremos enviar por OSC el 1. sólo una vez
                isSolSDown = true;
                actualizaTeclaSolS(); // esta llamada siempre ira despues de actualizar el valor de isSolSDown
                tecla = 9;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push9");}
                // Log.d("_DOWN", "Sol#");

            }


        }else if (RectLaS.contains(Math.round(mX), Math.round(mY))) {
            if (!isLaSDown) {     // queremos enviar por OSC el 1. sólo una vez
                isLaSDown = true;
                actualizaTeclaLaS(); // esta llamada siempre ira despues de actualizar el valor de isLaSDown
                tecla = 11;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push11");}
                // Log.d("_DOWN", "La#");

            }


        }

        // luego los naturales
        else if (RectDo.contains(Math.round(mX), Math.round(mY))) {
            if (!isDoDown) {     // queremos enviar por OSC el 1. sólo una vez
                isDoDown = true;
                actualizaTeclaDo(); // esta llamada siempre ira despues de actualizar el valor de isDoDown
                tecla = 1;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push1");}
                // Log.d("_DOWN", "Do");

            }
        } else if (RectRe.contains(Math.round(mX), Math.round(mY))) {
            if (!isReDown) {     // queremos enviar por OSC el 1. sólo una vez
                isReDown = true;
                actualizaTeclaRe(); // esta llamada siempre ira despues de actualizar el valor de isReDown
                tecla = 3;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push3");}
                // Log.d("_DOWN", "Re");

            }
        } else if (RectMi.contains(Math.round(mX), Math.round(mY))) {
            if (!isMiDown) {     // queremos enviar por OSC el 1. sólo una vez
                isMiDown = true;
                actualizaTeclaMi(); // esta llamada siempre ira despues de actualizar el valor de isMiDown
                tecla = 5;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push5");}
                // Log.d("_DOWN", "Mi");

            }
        } else if (RectFa.contains(Math.round(mX), Math.round(mY))) {
            if (!isFaDown) {     // queremos enviar por OSC el 1. sólo una vez
                isFaDown = true;
                actualizaTeclaFa(); // esta llamada siempre ira despues de actualizar el valor de isFaDown
                tecla = 6;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push6");}
                // Log.d("_DOWN", "Fa");

            }
        } else if (RectSol.contains(Math.round(mX), Math.round(mY))) {
            if (!isSolDown) {     // queremos enviar por OSC el 1. sólo una vez
                isSolDown = true;
                actualizaTeclaSol(); // esta llamada siempre ira despues de actualizar el valor de isSolDown
                tecla = 8;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push8");}
                // Log.d("_DOWN", "Sol");

            }
        } else if (RectLa.contains(Math.round(mX), Math.round(mY))) {
            if (!isLaDown) {     // queremos enviar por OSC el 1. sólo una vez
                isLaDown = true;
                actualizaTeclaLa(); // esta llamada siempre ira despues de actualizar el valor de isLaDown
                tecla = 10;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push10");}
                // Log.d("_DOWN", "La");

            }
        } else if (RectSi.contains(Math.round(mX), Math.round(mY))) {
            if (!isSiDown) {     // queremos enviar por OSC el 1. sólo una vez
                isSiDown = true;
                actualizaTeclaSi(); // esta llamada siempre ira despues de actualizar el valor de isSiDown
                tecla = 12;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push12");}
                // Log.d("_DOWN", "Si");

            }
        } else if (RectDo8va.contains(Math.round(mX), Math.round(mY))) {
            if (!isDo8vaDown) {     // queremos enviar por OSC el 1. sólo una vez
                isDo8vaDown = true;
                actualizaTeclaDo8va(); // esta llamada siempre ira despues de actualizar el valor de isDo8vaDown
                tecla = 13;
                if (!iWillSendTheOneLater) {unoPorOSC("/3/push13");}
                // Log.d("_DOWN", "Do8va");

            }
        }



        // Ahora asignamos
        if (tecla != -1) {   // Sin este "if" desde ACTION_MOVE se entraria muchas veces y no funcionaria bien

            if (idNuevoPointer == -1) {
                idNuevoPointer = pointerID;
                teclaNuevoPointer = tecla;

            } else if (idOtroPointer == -1) {
                idOtroPointer = pointerID;
                teclaOtroPointer = tecla;

            } else if (idAltrePointer == -1) {
                idAltrePointer = pointerID;
                teclaAltrePointer = tecla;

            } else if (idAnotherPointer == -1) {
                idAnotherPointer = pointerID;
                teclaAnotherPointer = tecla;
            }
            // else if (.. vamos mirando todos los pointers
        }

        return tecla;
    }

    public void redibujaPiano(){
        // primero las naturales
        // Do
        canvas.drawRect(RectDo, paintW);
        canvas.drawRect(RectDo, paintBorder);

        // Re
        canvas.drawRect(RectRe, paintW);
        canvas.drawRect(RectRe, paintBorder);

        // Mi
        canvas.drawRect(RectMi, paintW);
        canvas.drawRect(RectMi, paintBorder);

        // Fa
        canvas.drawRect(RectFa, paintW);
        canvas.drawRect(RectFa, paintBorder);

        // Sol
        canvas.drawRect(RectSol, paintW);
        canvas.drawRect(RectSol, paintBorder);

        // La
        canvas.drawRect(RectLa, paintW);
        canvas.drawRect(RectLa, paintBorder);

        // Si
        canvas.drawRect(RectSi, paintW);
        canvas.drawRect(RectSi, paintBorder);

        // Do 8va
        canvas.drawRect(RectDo8va, paintW);
        canvas.drawRect(RectDo8va, paintBorder);


        // luego los sostenidos
        // Do#
        canvas.drawRect(RectDoS, paintB);
        canvas.drawRect(RectDoS, paintBorder);

        // Re#
        canvas.drawRect(RectReS, paintB);
        canvas.drawRect(RectReS, paintBorder);

        // Fa#
        canvas.drawRect(RectFaS, paintB);
        canvas.drawRect(RectFaS, paintBorder);

        // Sol#
        canvas.drawRect(RectSolS, paintB);
        canvas.drawRect(RectSolS, paintBorder);

        // La#
        canvas.drawRect(RectLaS, paintB);
        canvas.drawRect(RectLaS, paintBorder);



        // para visualizarlo
        myImageView.setImageBitmap(bitmap);

    }

    public void actualizaTeclaDo(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isDoDown

        // Do
        actualizoDo();

        // Sobredibujamos sostenidos adyacentes
        // Do#
        actualizoDoS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaDoS(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isDoSDown

        // Do#
        actualizoDoS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaRe(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isReDown

        // Re
        actualizoRe();

        // Sobredibujamos sostenidos adyacentes
        actualizoDoS();
        actualizoReS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaReS(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isReSDown

        actualizoReS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaMi(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isMiDown

        actualizoMi();

        // Sobredibujamos sostenidos adyacentes
        actualizoReS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaFa(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isFaDown

        actualizoFa();

        // Sobredibujamos sostenidos adyacentes
        actualizoFaS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaFaS(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isFaSDown

        actualizoFaS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaSol(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isSolDown

        actualizoSol();

        // Sobredibujamos sostenidos adyacentes
        actualizoFaS();
        actualizoSolS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaSolS(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isSolSDown

        actualizoSolS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaLa(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isLaDown

        actualizoLa();

        // Sobredibujamos sostenidos adyacentes
        actualizoSolS();
        actualizoLaS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaLaS(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isLaSDown

        actualizoLaS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaSi(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isSiDown

        actualizoSi();

        // Sobredibujamos sostenidos adyacentes
        actualizoLaS();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }

    public void actualizaTeclaDo8va(){ //Ojo: su llamada siempre ira despues de actualizar el valor de isDo8vaDown

        actualizoDo8va();

        // para visualizarlo
        myImageView.setImageBitmap(bitmap);
    }


    public void actualizoDo(){
        // Do
        if (isDoDown){
            canvas.drawRect(RectDo, paintDown);
            canvas.drawRect(RectDo, paintBorder);
        } else{
            canvas.drawRect(RectDo, paintW);
            canvas.drawRect(RectDo, paintBorder);
        }
    }

    public void actualizoDoS(){
        // Do#
        if (isDoSDown){
            canvas.drawRect(RectDoS, paintDown);
            canvas.drawRect(RectDoS, paintBorder);
        } else{
            canvas.drawRect(RectDoS, paintB);
            canvas.drawRect(RectDoS, paintBorder);
        }
    }

    public void actualizoRe(){
        // Re
        if (isReDown){
            canvas.drawRect(RectRe, paintDown);
            canvas.drawRect(RectRe, paintBorder);
        } else{
            canvas.drawRect(RectRe, paintW);
            canvas.drawRect(RectRe, paintBorder);
        }
    }

    public void actualizoReS(){
        // Re#
        if (isReSDown){
            canvas.drawRect(RectReS, paintDown);
            canvas.drawRect(RectReS, paintBorder);
        } else{
            canvas.drawRect(RectReS, paintB);
            canvas.drawRect(RectReS, paintBorder);
        }
    }

    public void actualizoMi(){
        // Mi
        if (isMiDown){
            canvas.drawRect(RectMi, paintDown);
            canvas.drawRect(RectMi, paintBorder);
        } else{
            canvas.drawRect(RectMi, paintW);
            canvas.drawRect(RectMi, paintBorder);
        }
    }

    public void actualizoFa(){
        // Fa
        if (isFaDown){
            canvas.drawRect(RectFa, paintDown);
            canvas.drawRect(RectFa, paintBorder);
        } else{
            canvas.drawRect(RectFa, paintW);
            canvas.drawRect(RectFa, paintBorder);
        }
    }

    public void actualizoFaS(){
        // Fa#
        if (isFaSDown){
            canvas.drawRect(RectFaS, paintDown);
            canvas.drawRect(RectFaS, paintBorder);
        } else{
            canvas.drawRect(RectFaS, paintB);
            canvas.drawRect(RectFaS, paintBorder);
        }
    }

    public void actualizoSol(){
        // Sol
        if (isSolDown){
            canvas.drawRect(RectSol, paintDown);
            canvas.drawRect(RectSol, paintBorder);
        } else{
            canvas.drawRect(RectSol, paintW);
            canvas.drawRect(RectSol, paintBorder);
        }
    }

    public void actualizoSolS(){
        // Sol#
        if (isSolSDown){
            canvas.drawRect(RectSolS, paintDown);
            canvas.drawRect(RectSolS, paintBorder);
        } else{
            canvas.drawRect(RectSolS, paintB);
            canvas.drawRect(RectSolS, paintBorder);
        }
    }

    public void actualizoLa(){
        // La
        if (isLaDown){
            canvas.drawRect(RectLa, paintDown);
            canvas.drawRect(RectLa, paintBorder);
        } else{
            canvas.drawRect(RectLa, paintW);
            canvas.drawRect(RectLa, paintBorder);
        }
    }

    public void actualizoLaS(){
        // La#
        if (isLaSDown){
            canvas.drawRect(RectLaS, paintDown);
            canvas.drawRect(RectLaS, paintBorder);
        } else{
            canvas.drawRect(RectLaS, paintB);
            canvas.drawRect(RectLaS, paintBorder);
        }
    }

    public void actualizoSi(){
        // Si
        if (isSiDown){
            canvas.drawRect(RectSi, paintDown);
            canvas.drawRect(RectSi, paintBorder);
        } else{
            canvas.drawRect(RectSi, paintW);
            canvas.drawRect(RectSi, paintBorder);
        }
    }

    public void actualizoDo8va(){
        // Do 8va
        if (isDo8vaDown){
            canvas.drawRect(RectDo8va, paintDown);
            canvas.drawRect(RectDo8va, paintBorder);
        } else{
            canvas.drawRect(RectDo8va, paintW);
            canvas.drawRect(RectDo8va, paintBorder);
        }
    }




    public void unoPorOSC(String oscAddress){ // con "uno" en nombre de la funcion evito equivocarme pq evito escribir cifras muchas veces
        // NOTA: en la app final podemos construir el msg OSC en la clase Util que tengo pensado hacer
        // pero tanto unoPorOSC() como ceroPorOSC() creo que estaria bien que siguieran estando (con otro codigo, claro)
        Object[] OSCmsg = new Object[2];
        OSCmsg[0] = new String(oscAddress);
        OSCmsg[1] = new Float(1.);
        new OSCsender().execute(OSCmsg);
    }

    public void ceroPorOSC(String oscAddress){  // con "cero" en nombre de la funcion evito equivocarme pq evito escribir cifras muchas veces
        Object[] OSCmsg = new Object[2];
        OSCmsg[0] = new String(oscAddress);
        OSCmsg[1] = new Float(0.);
        new OSCsender().execute(OSCmsg);
    }

    public void todoCerosOSC(){
        ceroPorOSC("/3/push1");
        ceroPorOSC("/3/push2");
        ceroPorOSC("/3/push3");
        ceroPorOSC("/3/push4");
        ceroPorOSC("/3/push5");
        ceroPorOSC("/3/push6");
        ceroPorOSC("/3/push7");
        ceroPorOSC("/3/push8");
        ceroPorOSC("/3/push9");
        ceroPorOSC("/3/push10");
        ceroPorOSC("/3/push11");
        ceroPorOSC("/3/push12");
        ceroPorOSC("/3/push13");
    }

    //******************** fin - metodos del pianito ***************************

    public void slider1() {
        SeekBar mySlider1 = (SeekBar) v.findViewById(R.id.cs3_fader1);
        final TextView instrumentMIDIdisplay = (TextView) v.findViewById(R.id.cs3_display);

            mySlider1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                    Object[] OSCmsg = new Object[2];
                    OSCmsg[0] = new String("/3/fader1");
                    OSCmsg[1] = new Float(progress / 100.0);
                    new OSCsender().execute(OSCmsg);

                    // Mostramos el numero MIDI del Instrumento seleccionado
                    int numberMIDI = (int) Math.floor(progress / 100.0 * 127) + 1;
                    instrumentMIDIdisplay.setText("" + numberMIDI);
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
        SeekBar mySlider2 = (SeekBar) v.findViewById(R.id.cs3_fader2);


        mySlider2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar mySlider, int progress, boolean fromUser) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/3/fader2");
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

    public void toggle1(){
        ToggleButton toggle = (ToggleButton) v.findViewById(R.id.cs3_toggle);
        toggle.setChecked(true);    // Necesario ya que el modulo aparece activado de inicio

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/3/toggle1");


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


    public void octaveRadioButtons(){

        radioGroup = (RadioGroup) v.findViewById(R.id.cs3_radio_octaves);

        // Inicializamos a C3
        RadioButton rbC3 = (RadioButton) v.findViewById(R.id.cs3_radio_c3);
        rbC3.setChecked(true);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // obtener indice (fijo) a partir del Id (cambiante)
                int indice = radioGroup.indexOfChild(v.findViewById(checkedId));

                // Enviamos mensaje OSC
                cambiaOctavaOSC(indice);

            }
        });
    }

    public void cambiaOctavaOSC(int indice){

        // Empezamos a crear el mensaje OSC
        Object[] OSCmsg = new Object[2];
        OSCmsg[0] = new String("/3/fader3");
        OSCmsg[1] = new Float(indice + 0.1);    // sumar 0.1 es por asegurarnos

        // Enviamos mensaje OSC
        new OSCsender().execute(OSCmsg);

    }


    public void panicButton(){

        ImageButton button = (ImageButton) v.findViewById(R.id.cs3_panic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mView) {

                int indiceOriginal = radioGroup.indexOfChild(v.findViewById(radioGroup.getCheckedRadioButtonId()));

                Object[] OSCmsg = new Object[2];
                OSCmsg[0] = new String("/3/fader3");

                for (int i = 0; i < 11; i++){       // pasamos por todas las octavas
                    OSCmsg[1] = new Float(i + 0.1);
                    new OSCsender().execute(OSCmsg);
                    todoCerosOSC();     // release de todas las teclas de cada octava
                }

                // volvemos a la octava original
                cambiaOctavaOSC(indiceOriginal);

            }
        });
    }

}
