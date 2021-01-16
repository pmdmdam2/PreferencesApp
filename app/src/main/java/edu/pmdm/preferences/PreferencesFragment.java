package edu.pmdm.preferences;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class PreferencesFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferencias, rootKey);
    }
}