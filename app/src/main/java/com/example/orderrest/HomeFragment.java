package com.example.orderrest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        Button allRest = view.findViewById(R.id.restaurants);

        allRest.setOnClickListener(this);

        return view;


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.restaurants:
            Intent allRest = new Intent(getActivity(),AllRestView.class);
            startActivity(allRest);
            break;

        }

    }
}
