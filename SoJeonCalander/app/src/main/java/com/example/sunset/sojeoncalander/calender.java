package com.example.sunset.sojeoncalander;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class calender extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<RecyclerItem> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        ImageButton plusbtn = (ImageButton)findViewById(R.id.plusbtn);
        recyclerView = (RecyclerView) findViewById(R.id.rectycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ReAdapter adapter = new ReAdapter(items);
        recyclerView.setAdapter(adapter);

        items.add(new RecyclerItem("hello","helloooooooooooooooooooooooooooooooohelloooooooooooooooooooooooooooooooohelloooooooooooooooooooooooooooooooohelloooooooooooooooooooooooooooooooohelloooooooooooooooooooooooooooooooohelloooooooooooooooooooooooooooooooohelloooooooooooooooooooooooooooooooo"));
        AlertDialog.Builder builder = new AlertDialog.Builder(calender.this);
        builder.setTitle("추가하기");
        builder.setView(R.layout.activity_add);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("asdf", "positive");
                View view = getLayoutInflater().from(getApplicationContext()).inflate(R.layout.activity_add,null);
                EditText title = (EditText) view.findViewById(R.id.edit_add_title);
                EditText description = (EditText) view.findViewById(R.id.edit_add_des);

                Log.d("asdf","title : "+ title.getText().toString()+"des : " + description.getText().toString());
                items.add(new RecyclerItem(title.getText().toString(), description.getText().toString()));
                ReAdapter nAdapter = new ReAdapter(items);
                recyclerView.setAdapter(nAdapter);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog dialog = builder.create();

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

    }

    class ReAdapter extends RecyclerView.Adapter<ReAdapter.MyViewHolder>{
        ArrayList<RecyclerItem> items = new ArrayList<>();

        public ReAdapter(ArrayList<RecyclerItem> items) {
            this.items = items;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().from(getApplicationContext()).inflate(R.layout.recycler_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            RecyclerItem item = items.get(position);
            holder.title.setText(item.getTitle());
            holder.des.setText(item.getDesc());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView title, des;
            public MyViewHolder(View itemView) {
                super(itemView);

                title = (TextView) itemView.findViewById(R.id.item_title);
                des = (TextView) itemView.findViewById(R.id.item_des);
            }
        }
    }
}
