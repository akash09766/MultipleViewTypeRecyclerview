package com.developer.skylight.multipleviewtyperecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.developer.skylight.multipleviewtyperecyclerview.R;
import com.developer.skylight.multipleviewtyperecyclerview.adapter.RecordAdapter;
import com.developer.skylight.multipleviewtyperecyclerview.model.Records;
import com.developer.skylight.multipleviewtyperecyclerview.model.ResponseData;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String mServerResponse = "{ \"data\": [ { \"name\": \"s1\", \"isStudent\": 1 }, { \"name\": \"t1\", \"isStudent\": 0 }, { \"name\": \"s2\", \"isStudent\": 1 }, { \"name\": \"s3\", \"isStudent\": 1 }, { \"name\": \"t2\", \"isStudent\": 0 }, { \"name\": \"t3\", \"isStudent\": 0 }, { \"name\": \"s4\", \"isStudent\": 1 }, { \"name\": \"t4\", \"isStudent\": 0 }, { \"name\": \"s5\", \"isStudent\": 1 }, { \"name\": \"s6\", \"isStudent\": 1 }, { \"name\": \"t5\", \"isStudent\": 0 }, { \"name\": \"t6\", \"isStudent\": 0 } ] }";
    private RecyclerView mRecordListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setIdsToViews();
        setListenersToViews();

        onResponse(mServerResponse);
    }

    private void onResponse(String mServerResponse) { // assume this as volley response method

        ResponseData responseData = new Gson().fromJson(mServerResponse, ResponseData.class);

        processData(responseData.getData());
    }

    private void processData(ArrayList<Records> data) {

        ArrayList<Records> studentRecords = new ArrayList<>();
        ArrayList<Records> teacherRecords = new ArrayList<>();
        ArrayList<Records> adapterData = new ArrayList<>();


        // creating two diff records
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIsStudent() == 1) {
                studentRecords.add(data.get(i));
            } else {
                teacherRecords.add(data.get(i));
            }
        }

        // combining two record as per adapter requirement
        for (int i = 0; i < studentRecords.size(); i++) {
            if (i == 0) {
                Records records = studentRecords.get(i);
                records.setIsFirstRecord(1);
                adapterData.add(records);
            } else {
                adapterData.add(studentRecords.get(i));
            }
        }

        for (int i = 0; i < teacherRecords.size(); i++) {
            if (i == 0) {
                Records records = teacherRecords.get(i);
                records.setIsFirstRecord(1);
                adapterData.add(records);
            } else {
                adapterData.add(teacherRecords.get(i));
            }
        }

        mRecordListview.setAdapter(new RecordAdapter(adapterData, this));
    }

    private void setIdsToViews() {

        mRecordListview = findViewById(R.id.record_list_id);
    }

    private void setListenersToViews() {

        mRecordListview.setLayoutManager(new LinearLayoutManager(this));
    }
}
