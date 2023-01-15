package com.example.messengerapp.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.messengerapp.DAdapter;
import com.example.messengerapp.R;

import java.util.ArrayList;
import java.util.List;

public class SetMessegeFragment extends Fragment {
    EditText edittext1,edittext2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_set_message, container, false);
        List<String> items= new ArrayList<>();
        edittext1=root.findViewById(R.id.edit);
        edittext2=root.findViewById(R.id.edit2);
        RecyclerView recyclerView= root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DAdapter adapter= new DAdapter(items);
        recyclerView.setAdapter(adapter);


        root.findViewById(R.id.eklebtn).setOnClickListener(view ->{
            String Edit1=edittext1.getText().toString();
            String Edit2=edittext2.getText().toString();
            items.add(Edit1 + " : " + Edit2 );
        } );

        return root;
    }
}