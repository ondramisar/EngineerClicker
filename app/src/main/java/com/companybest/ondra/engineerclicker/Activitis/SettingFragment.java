package com.companybest.ondra.engineerclicker.Activitis;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.R;



public class SettingFragment extends DialogFragment {

Context context;

    public SettingFragment(Context context) {
        // Empty constructor required for DialogFragment
        this.context = context;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.setting_fragment, container,
                false);


        //EVERYTHING IS JUST SETTING FOR MUSIC
        final TextView musicText = (TextView) rootView.findViewById(R.id.musicSet);
        final SeekBar musicSet = (SeekBar) rootView.findViewById(R.id.seekBarFormusicSet);
        Button confirm = (Button) rootView.findViewById(R.id.confirmSetting);

        final SharedPreferences sharedPreferences = context.getSharedPreferences("com.companybest.ondra.engineerclicker.Activitis", Context.MODE_PRIVATE);


        musicSet.setProgress(sharedPreferences.getInt("music",0));


        musicText.setText("MUSIC: " + String.valueOf(sharedPreferences.getInt("music",0)));

        musicSet.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                musicText.setText("MUSIC: " + String.valueOf(progress));
                MainActivity.audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int finalMusicVol = musicSet.getProgress();

                sharedPreferences.edit().putInt("music", finalMusicVol).apply();

                MainActivity.audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,finalMusicVol, 0);

                SettingFragment.this.dismiss();
            }
        });

        // Do something else
        return rootView;
    }

}
