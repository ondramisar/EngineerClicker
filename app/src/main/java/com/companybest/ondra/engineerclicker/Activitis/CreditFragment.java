package com.companybest.ondra.engineerclicker.Activitis;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.companybest.ondra.engineerclicker.R;

import java.util.ArrayList;


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

        //CREDITS
        ArrayList<String> values = new ArrayList<>();
        values.add("Developed by Ondřej Misař, Contact email: ondramisar124@seznam.cz");
        values.add("Part of graphic is from Jan Cikrle, FACEBOOK: Jan Ciki Cikrle");
        values.add("Main Graphic is from flaticon by Pixel perfect: https://icon54.com/\n" +
                "Freepik: http://www.freepik.com ");

        ListView credit = (ListView) rootView.findViewById(R.id.list_view_credit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        credit.setAdapter(adapter);


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
