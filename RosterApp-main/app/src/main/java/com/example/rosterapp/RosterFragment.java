package com.example.rosterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RosterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_roster, container,
                false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.rosterListView);
        String[] rosterItems = getResources().getStringArray(R.array.rooster_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                rosterItems
        );
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view1, position, id) -> {
            String clickedItem = rosterItems[position];

            Intent intent = new Intent(getActivity(),
                    DetailActivity.class);
            intent.putExtra("UNIT_NAME", clickedItem);
            intent.putExtra("UNIT_POSITION",position);
            startActivity(intent);
        });
    }
}

