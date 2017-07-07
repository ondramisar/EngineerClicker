package com.companybest.ondra.engineerclicker.Activitis;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.Machine;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;


public class BettingTab extends Fragment implements RewardedVideoAdListener{

    MainActivity mainActivity;

    Button playAd;
    Button play50To50;
    Button playShufle;

    private RewardedVideoAd mAd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.betting_tab, container, false);

        mAd = MobileAds.getRewardedVideoAdInstance(getContext());
        mAd.setRewardedVideoAdListener(this);
        //loadAd();

        //AD VIEW
        AdView mAdView4 = (AdView) rootView.findViewById(R.id.adView4);
        AdRequest adRequest4 = new AdRequest.Builder().build();
        //mAdView4.loadAd(adRequest4);

        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.betting_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
            }
        });

        playAd = (Button) rootView.findViewById(R.id.playAd);
        if (!mAd.isLoaded()){
            playAd.setEnabled(false);
        }
        playAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAd.isLoaded()){
                    mAd.show();
                }
            }
        });

        play50To50 = (Button) rootView.findViewById(R.id.playFyftyToFyfty);
        Button buttonForConfurm50To50 = (Button) rootView.findViewById(R.id.buttonConfirmForFyftyFyfty);
        final TextView textViewFor50To50 = (TextView) rootView.findViewById(R.id.textViewForFyftyToFyfty);
        final EditText editTextFor50To50 = (EditText) rootView.findViewById(R.id.editTextFyftyToFyfty);

        if (editTextFor50To50.getText().toString().trim().length() > 0) {
            textViewFor50To50.setText("Your Bet: " + editTextFor50To50.getText());
        }

        buttonForConfurm50To50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextFor50To50.getText().toString().trim().length() > 0) {
                    textViewFor50To50.setText("Your Bet: " + editTextFor50To50.getText());
                        InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
            }
        });

        //FIRST GAME
        play50To50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textViewFor50To50.getText() != "" &&  editTextFor50To50.getText().toString().trim().length() > 0) {

                    Realm realm = Realm.getDefaultInstance();

                    try {
                        final User user = realm.where(User.class).equalTo("name", mainActivity.mainReferences.name).findFirst();

                        if (user.getCoins() > Integer.valueOf(String.valueOf(editTextFor50To50.getText()))) {

                            int min = 0;
                            final int max = 200;

                            Random r = new Random();
                            final int i1 = r.nextInt(max - min + 1) + min;

                            play50To50.setEnabled(false);

                            if (i1 <= 100) {
                                Toast.makeText(getContext(), "YOU HAVE WONE " + textViewFor50To50.getText(), Toast.LENGTH_SHORT).show();
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {

                                        user.setCoins(Integer.valueOf(String.valueOf(editTextFor50To50.getText())), true);
                                    }
                                });
                                TextView txtView = (TextView) ((MainActivity)getContext()).findViewById(R.id.coins);
                                txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));
                            } else {
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {

                                        user.setCoins(Integer.valueOf(String.valueOf(editTextFor50To50.getText())), false);
                                    }
                                });

                                TextView txtView = (TextView) ((MainActivity)getContext()).findViewById(R.id.coins);
                                txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));
                                Toast.makeText(getContext(), "YOU HAVE Lost " + textViewFor50To50.getText(), Toast.LENGTH_SHORT).show();
                            }

                            new CountDownTimer(10000, 1000) {

                                public void onTick(long millisUntilFinished) {

                                }

                                public void onFinish() {
                                    play50To50.setEnabled(true);
                                }
                            }.start();
                        }
                    }finally {
                        realm.close();
                    }
                }

            }
        });


        playShufle = (Button) rootView.findViewById(R.id.playFirstMiniGame);
        Button buttonForConfurmShufl = (Button) rootView.findViewById(R.id.buttonForConfirmShufl);
        final TextView textViewForShufl = (TextView) rootView.findViewById(R.id.textViewForShufl);
        final EditText editTextForShufl = (EditText) rootView.findViewById(R.id.editTextShufle);

        if (editTextForShufl.getText().toString().trim().length() > 0) {
            int i = Integer.valueOf(String.valueOf(editTextForShufl.getText()));

            int min = i - i / 3;
            int max = i + i / 3;
            textViewForShufl.setText("You can win from " + String.valueOf(min) + " to " + String.valueOf(max));
        }

        buttonForConfurmShufl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextForShufl.getText().toString().trim().length() > 0) {
                    int i = Integer.valueOf(String.valueOf(editTextForShufl.getText()));

                    int min = i - i / 3;
                    int max = i + i / 3;
                    textViewForShufl.setText("You can win from " + String.valueOf(min) + " to " + String.valueOf(max));

                    InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
            }
        });

        //SECOND GAME
        playShufle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textViewForShufl.getText() != ""&& editTextForShufl.getText().toString().trim().length() > 0) {

                    Realm realm = Realm.getDefaultInstance();

                    try {
                    final User user = realm.where(User.class).equalTo("name",  mainActivity.mainReferences.name).findFirst();

                    if (user.getCoins() > Integer.valueOf(String.valueOf(editTextForShufl.getText()))) {
                        int i = Integer.valueOf(String.valueOf(editTextForShufl.getText()));

                        int min = i - i / 3;
                        int max = i + i / 3;
                        int minRan = min;
                        final int maxRan = max;

                        Random r = new Random();
                        final int i1 = r.nextInt(maxRan - minRan + 1) + minRan;

                        playShufle.setEnabled(false);

                        Toast.makeText(getContext(), "YOU HAVE WONE " + String.valueOf(i1), Toast.LENGTH_SHORT).show();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                                user.setCoins(Integer.valueOf(String.valueOf(editTextForShufl.getText())), false);
                                user.setCoins(i1, true);

                            }
                        });

                        TextView txtView = (TextView) ((MainActivity)getContext()).findViewById(R.id.coins);
                        txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));
                        new CountDownTimer(10000, 1000) {

                            public void onTick(long millisUntilFinished) {

                            }

                            public void onFinish() {
                                playShufle.setEnabled(true);
                            }
                        }.start();
                    }
                    } finally {
                        realm.close();
                    }
                }

            }
        });

        ((MainActivity)getActivity()).mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float offset, int offsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
            }
        });
        return rootView;
    }

    private void loadAd(){
        if (!mAd.isLoaded()){
            mAd.loadAd("ca-app-pub-4686615482489412/9724660686", new AdRequest.Builder().build());
            //mAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
        }
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Realm realm = Realm.getDefaultInstance();
        try {
            final User user = realm.where(User.class).equalTo("name", mainActivity.mainReferences.name).findFirst();
            RealmResults<Machine> machines = realm.where(Machine.class).findAll();

            int numberOfMachine = 0;
            for (int i = 0; i < machines.size(); i++ ){
                if (machines.get(i).getNumberOfWorkersOnMachine() > 0) {
                    numberOfMachine += 1;
                }
            }
            int min = 500 * numberOfMachine;
            int max = 5000 * numberOfMachine;


            Random r = new Random();
            final int i1 = r.nextInt(max - min + 1) + min;

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    user.setCoins(i1, true);

                }
            });

            TextView txtView = (TextView) ((MainActivity)getContext()).findViewById(R.id.coins);
            txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));
            Toast.makeText(getContext(), "GOT: " + String.valueOf(i1) + " Coins", Toast.LENGTH_LONG).show();

        } finally {
            realm.close();
        }
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
    }

    @Override
    public void onRewardedVideoAdClosed() {
        playAd.setEnabled(false);

        loadAd();

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        loadAd();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        playAd.setEnabled(true);

    }

    @Override
    public void onRewardedVideoAdOpened() {
    }

    @Override
    public void onRewardedVideoStarted() {
    }

}
