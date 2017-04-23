package com.companybest.ondra.engineerclicker.Activitis;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.R;


public class CreditFragment extends DialogFragment {

    Context context;
    public CreditFragment(Context context) {
        // Empty constructor required for DialogFragment
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.credit_fragment, container,
                false);

        TextView creditText = (TextView) rootView.findViewById(R.id.credit_text);
        creditText.setText("HI THIS IS THE CREDIT");
        Button creditBack = (Button) rootView.findViewById(R.id.creditBack);
        creditBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreditFragment.this.dismiss();
            }
        });
        // Do something else
        return rootView;
    }

}
