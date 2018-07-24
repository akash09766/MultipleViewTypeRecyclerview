package com.developer.skylight.multipleviewtyperecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer.skylight.multipleviewtyperecyclerview.R;
import com.developer.skylight.multipleviewtyperecyclerview.model.Records;

import java.util.ArrayList;

/**
 * Created by akash.wangalwar on 24/07/18.
 */

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder> {

    private static final String TAG = RecordAdapter.class.getSimpleName();

    private static final int STUDENT_WITH_HEADER = 1;
    private static final int STUDENT_WITHOUT_HEADER = 2;
    private static final int TEACHER_WITH_HEADER = 3;
    private static final int TEACHER_WITHOUT_HEADER = 4;

    private ArrayList<Records> listData;
    private LayoutInflater layoutInflater;

    public RecordAdapter(ArrayList<Records> listData, Context context) {

        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


        switch (viewType) {

            case STUDENT_WITH_HEADER:
                return new RecordViewHolder(layoutInflater.inflate(R.layout.student_with_header_row, viewGroup, false), viewType);

            case STUDENT_WITHOUT_HEADER:
                return new RecordViewHolder(layoutInflater.inflate(R.layout.student_with_out_header_row, viewGroup, false), viewType);

            case TEACHER_WITH_HEADER:
                return new RecordViewHolder(layoutInflater.inflate(R.layout.teacher_with_header_row, viewGroup, false), viewType);

            case TEACHER_WITHOUT_HEADER:
                return new RecordViewHolder(layoutInflater.inflate(R.layout.teacher_with_out_header_row, viewGroup, false), viewType);

            default:
                return new RecordViewHolder(layoutInflater.inflate(R.layout.student_with_header_row, viewGroup, false), viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder recordViewHolder, int position) {

        if (getItemViewType(position) == STUDENT_WITH_HEADER) {
            recordViewHolder.mStudentNameTv.setText(listData.get(position).getName());

        } else if (getItemViewType(position) == STUDENT_WITHOUT_HEADER) {
            recordViewHolder.mStudentNameTv.setText(listData.get(position).getName());

        } else if (getItemViewType(position) == TEACHER_WITH_HEADER) {
            recordViewHolder.mTeacherNameTv.setText(listData.get(position).getName());

        } else if (getItemViewType(position) == TEACHER_WITHOUT_HEADER) {
            recordViewHolder.mTeacherNameTv.setText(listData.get(position).getName());

        }
    }

    @Override
    public int getItemCount() {

        return listData.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (listData.get(position).getIsStudent() == 1) {

            if (listData.get(position).getIsFirstRecord() == 1) {
                return STUDENT_WITH_HEADER;
            } else {
                return STUDENT_WITHOUT_HEADER;
            }
        } else {
            if (listData.get(position).getIsFirstRecord() == 1) {
                return TEACHER_WITH_HEADER;
            } else {
                return TEACHER_WITHOUT_HEADER;
            }
        }
    }

    protected class RecordViewHolder extends RecyclerView.ViewHolder {

        private TextView mStudentNameTv;
        private TextView mTeacherNameTv;

        public RecordViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            if (viewType == STUDENT_WITH_HEADER) {
                mStudentNameTv = itemView.findViewById(R.id.student_name_tv_id);

            } else if (viewType == STUDENT_WITHOUT_HEADER) {
                mStudentNameTv = itemView.findViewById(R.id.student_name_without_header_tv_id);

            } else if (viewType == TEACHER_WITH_HEADER) {
                mTeacherNameTv = itemView.findViewById(R.id.teacher_name_tv_id);

            } else if (viewType == TEACHER_WITHOUT_HEADER) {
                mTeacherNameTv = itemView.findViewById(R.id.teacher_name_without_header_tv_id);
            }

        }
    }
}
