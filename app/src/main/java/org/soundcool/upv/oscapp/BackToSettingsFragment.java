package org.soundcool.upv.oscapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;


/**
 * Created by jaiserpe on 08/06/2016.
 */
public class BackToSettingsFragment extends Fragment{


    public BackToSettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // No me hace falta cargar un layout


    // para que la pestaña de al lado no vuelva a settings, que es un error que me daba
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getActivity().finish(); // volvemos a settings
        }
    }
}
