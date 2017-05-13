package com.companybest.ondra.engineerclicker.Activitis;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.companybest.ondra.engineerclicker.Adapters.CustomExpandableListAdapter;
import com.companybest.ondra.engineerclicker.R;
import com.companybest.ondra.engineerclicker.References.ExpandableListDataPump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HelpFragment  extends DialogFragment {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    Context context;


    public HelpFragment(Context context) {
        // Empty constructor required for DialogFragment
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.help_fragment, container,
                false);

        TextView creditText = (TextView) rootView.findViewById(R.id.help_text);
        creditText.setText("HI THIS IS THE CREDIT");
        Button creditBack = (Button) rootView.findViewById(R.id.help_back_button);
        creditBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpFragment.this.dismiss();
            }
        });
        // Do something else
        expandableListView = (ExpandableListView) rootView.findViewById(R.id.help_item_listView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(context, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        context,
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });



        return rootView;
    }

}
