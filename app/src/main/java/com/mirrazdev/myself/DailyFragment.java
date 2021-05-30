/*
 *     Tanggal Pengerjaan : 18/5/2021
 *     Nim : 10118056
 *     Nama : Mirraz Ibrahim
 *     email : mirrazibrahim@gmail.com
 *     Copyright © 2021 Mirraz Ibrahim. All rights reserved.
 */

package com.mirrazdev.myself;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.Adapter recyclerViewAdapter2;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    RecyclerView.LayoutManager recylerViewLayoutManager2;
    ArrayList<DailyModel> data;
    ArrayList<FriendModel> data2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DailyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DailyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DailyFragment newInstance(String param1, String param2) {
        DailyFragment fragment = new DailyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recylerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        data = new ArrayList<>();
        for (int i = 0; i < DailyItem.Headline.length; i++) {
            data.add(new DailyModel(
                    DailyItem.Headline[i],
                    DailyItem.Subhead[i],
                    DailyItem.iconList[i]
            ));
        }

        recyclerViewAdapter = new AdapterDaily(data);
        recyclerView.setAdapter(recyclerViewAdapter);
        //FriendList
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);

        LinearLayoutManager recylerViewLayoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(recylerViewLayoutManager2);
        recyclerView2.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        data2 = new ArrayList<>();
        for (int i = 0; i < FriendItem.Headline.length; i++) {
            data2.add(new FriendModel(
                    FriendItem.Headline[i],
                    FriendItem.Subhead[i],
                    FriendItem.iconList[i]
            ));
        }

        recyclerViewAdapter2 = new AdapterFriend(data2);
        recyclerView2.setAdapter(recyclerViewAdapter2);
        return view;

    }
}