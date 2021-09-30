package com.example.todolist.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.MainActivity;
import com.example.todolist.Model.ToDoModel;
import com.example.todolist.R;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter <ToDoAdapter.ViewHolder> {

    private List<ToDoModel> todoList;
    private MainActivity activity;

    public ToDoAdapter(MainActivity activity){
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        ToDoModel item = todoList.get(position);
        holder.taskName.setText(item.getTask());
        holder.date.setText(item.getDate());
        holder.task.setChecked(toBoolean(item.getStatus()));
    }

    private boolean toBoolean(int n) {
        return n!=0;
    }

    public int getItemCount(){
        return todoList.size();
    }

    public void setTask(List<ToDoModel> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox task;
        TextView date;
        TextView taskName;

        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.checkBox);
            date = view.findViewById(R.id.textViewDate);
            taskName = view.findViewById(R.id.textViewTask);
        }
    }
}
