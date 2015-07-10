package com.davidllorca.preferences;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    EditText block = null;
    EditText key = null;
    EditText value = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        block = (EditText) rootView.findViewById(R.id.edBlock);
        key = (EditText)rootView.findViewById(R.id.edKey);
        value = (EditText)rootView.findViewById(R.id.edValue);

        Button btnSave = (Button) rootView.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blockValue = block.getText().toString().trim();
                String keyValue = key.getText().toString().trim();
                String valueValue = value.getText().toString().trim();
                ((MainActivity)getActivity()).save(blockValue, keyValue, valueValue);
            }
        });

        Button btnRec = (Button) rootView.findViewById(R.id.btnRec);
        btnRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blockValue = block.getText().toString().trim();
                String keyValue = key.getText().toString().trim();
                String valueValue = ((MainActivity)getActivity()).retrieve(blockValue, keyValue);
                value.setText(valueValue);
            }
        });

        return rootView;
    }
}
