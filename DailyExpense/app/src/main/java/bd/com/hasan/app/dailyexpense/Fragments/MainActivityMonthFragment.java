package bd.com.hasan.app.dailyexpense.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bd.com.hasan.app.dailyexpense.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityMonthFragment extends Fragment {


    public MainActivityMonthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_activity_month, container, false);
    }

}
