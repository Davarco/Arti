package com.lunchareas.arti;

/* StockFragment.java
 * v1.1.0
 * 2017-05-30
 *
 * Copyright (C) 2017  Vanshaj Singhania, David Zhang, Emil Tu
 * Full copyright information available in MainActivity.java
 */

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class StockFragment extends Fragment {

    private ArtiData data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stock_fragment, container, false);
        data = new ArtiData(this.getActivity());

        try {
            setUp(view);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    private void setUp(View view) throws Exception {
        List<String> stockStrings = data.returnStocks();
        List<Stock> stocks = new ArrayList<>();

        for (String s : stockStrings) {
            stocks.add(new Stock(s, view.getContext(), false));
        }

        ((ListView) view.findViewById(R.id.stock_list)).setAdapter(new StockAdapter(stocks));
    }}
