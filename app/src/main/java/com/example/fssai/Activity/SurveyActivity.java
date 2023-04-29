package com.example.fssai.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fssai.Adapter.SurveyAdapter;
import com.example.fssai.Adapter.SurveyModel;
import com.example.fssai.R;

import java.util.ArrayList;
import java.util.List;

public class SurveyActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SurveyAdapter adapter;
    EditText sampleName,outletName,batchNo,mfgDate,expDate;
    TextView photos,signature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        sampleName = findViewById(R.id.et_sampleName);
        outletName = findViewById(R.id.et_outletname);
        batchNo = findViewById(R.id.et_batchno);
        mfgDate = findViewById(R.id.et_mfgdate);
        expDate = findViewById(R.id.et_expdate);
        photos = findViewById(R.id.tv_locationimg);
        signature = findViewById(R.id.tv_signature);

        // initialize the RecyclerView
        mRecyclerView = findViewById(R.id.recycler_view_survey);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // create a list of items to display in the RecyclerView
        List<SurveyModel> itemList = new ArrayList<>();
        itemList.add(new SurveyModel("city","fso","date","location",true));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",true));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));
        itemList.add(new SurveyModel("city","fso","date","location",false));

        // create the adapter and set it to the RecyclerView
        adapter = new SurveyAdapter(itemList,this);
        mRecyclerView.setAdapter(adapter);
    }

    void uploadPhoto(){

    }
}
