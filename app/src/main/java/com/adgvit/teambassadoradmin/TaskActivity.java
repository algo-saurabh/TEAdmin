package com.adgvit.teambassadoradmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private int position = 0;
    private int colorpos = 0;
    private LinearLayout taskListView;
    private final List<String> colorTask = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        //GetIntent
        String UserID;
        UserID = getIntent().getStringExtra("UserID");

        //Declarations
        DatabaseReference taskRef= FirebaseDatabase.getInstance().getReference().child("Task").child(UserID);
        final List<TaskNodeObjects> taskList=new ArrayList<>();
        final List<TaskListObjects> adapterList=new ArrayList<>();
        final TaskListAdapter adapter = new TaskListAdapter(getApplicationContext(), R.layout.tasklist_row_layout,adapterList);
        final ConstraintLayout addTask=findViewById(R.id.taskAddTask);
        taskListView=findViewById(R.id.taskRecyclerView);

        //Color List
        colorTask.add("#4E55B4");
        colorTask.add("#0091FF");
        colorTask.add("#FA6400");
        colorTask.add("#F7B500");

        //FireBase Database
        taskRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(taskListView.getChildCount() > 0)
                {
                    taskListView.removeAllViews();
                }
                for(DataSnapshot ds:dataSnapshot.getChildren()) {

                    //key
                    final String key = ds.getKey();

                    //TaskNodeList
                    System.out.println(ds.getValue());
                    final TaskNodeObjects tempdat = ds.getValue(TaskNodeObjects.class);
                    taskList.add(tempdat);
                    assert tempdat != null;

                    //AdapterList
                    final int ran = colorpos % colorTask.size();
                    final TaskListObjects listdata = new TaskListObjects(key,tempdat.getDaysLeft(), Color.parseColor(colorTask.get(ran)));
                    colorpos++;
                    adapterList.add(listdata);

                    //Adapter
                    final View item = adapter.getView(position++, null, null);
                    item.setTag(position);
                    item.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view)
                        {

                        }
                    });
                    taskListView.addView(item);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });

        //Add Task
        addTask.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }
}
