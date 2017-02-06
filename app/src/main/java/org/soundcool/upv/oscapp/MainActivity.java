package org.soundcool.upv.oscapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.illposed.osc.OSCPortOut;

import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {

    public static OSCPortOut MYoscPortOut;
    SharedPreferences sharedPref;
    EditText editTextIP;
    EditText editTextPort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // "Cargamos" las SharedPreferences y pedimos referencias a los campos de texto (todos declarados arriba)
        sharedPref = getPreferences(Context.MODE_PRIVATE);
        editTextIP = (EditText) findViewById(R.id.editTextIP);
        editTextPort = (EditText) findViewById(R.id.editTextPort);


        // Mostramos valores guardados o por defecto
        String showedIP = sharedPref.getString("newIP", "158.42.188.134");
        editTextIP.setText(showedIP);

        int showedPort = sharedPref.getInt("newPort", 8001);
        editTextPort.setText("" + showedPort);

    }

    public void irCreditos(View v){
        // Vamos a la actividad de créditos
        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
    }

    public void irOtraActividad(View v){

        // primero recogemos la IP y número de Puerto establecido en la UI por el usuario o por las SharedPreferences
        String myIP = editTextIP.getText().toString();
        int myPort = Integer.parseInt(editTextPort.getText().toString());

        // Grabamos en SharedPreferences
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("newIP", myIP);
        editor.putInt("newPort", myPort);
        editor.commit();


        // Abrimos puerto OSC (que será el mismo para todos los controles)
        try {
            MYoscPortOut = new OSCPortOut(InetAddress.getByName(myIP), myPort);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        // Vamos a la otra actividad
        Intent intent = new Intent(this, OtraActividad.class);
        startActivity(intent);
    }

}
