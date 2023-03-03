package com.hui.dict;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.hui.dict.db.DBManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CollectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CollectionFragment extends Fragment {

    private static final String ARG_TYPE = "type";

    private GridView mGV;

    private ArrayAdapter<String> mGridAdapter;
    private List<String> mGridAdapterData;

    private String mType;

    public CollectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mType Parameter 1.
     * @return A new instance of fragment WordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CollectionFragment newInstance(String mType) {
        CollectionFragment fragment = new CollectionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TYPE, mType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getString(ARG_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collection, container, false);

        mGV = view.findViewById(R.id.collection_gv);

        initGridView();

        return view;
    }

    private void initGridView() {
        mGridAdapterData = new ArrayList<>();
        mGridAdapter = new ArrayAdapter<>(getContext(), R.layout.gvitem_word, R.id.gvitem_word_tv, mGridAdapterData);
        mGV.setAdapter(mGridAdapter);

        mGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mType.equals("汉字")) {
                    Intent intent = WordDetailActivity.newIntent(getActivity(), mGridAdapterData.get(i));
                    startActivity(intent);
                } else {
                    Intent intent = ChengyuDetailActivity.newIntent(getActivity(), mGridAdapterData.get(i));
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        mGridAdapterData.clear();

        if (mType.equals("汉字")) {
            mGridAdapterData.addAll(DBManager.queryCollectWordList());
        } else {
            mGridAdapterData.addAll(DBManager.queryCollectChengyuList());
        }

        mGridAdapter.notifyDataSetChanged();
    }
}