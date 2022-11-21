package com.sbpdcl.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<StudentModel> mStudentList;
    private Context mContext;
    public RecyclerViewAdapter(Context context, List<StudentModel> studentList){
        mContext = context;
        mStudentList = studentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final StudentModel studentModel = mStudentList.get(position);
        holder.tvClass.setText(studentModel.stu_class);
        holder.tvName.setText(studentModel.name);

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, studentModel.name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvClass,tvName;
        public MyViewHolder(View view){
            super(view);
            tvClass = view.findViewById(R.id.tvClass);
            tvName = view.findViewById(R.id.lblName);
        }
    }
}
