package com.sagar.android_projects.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.sagar.android_projects.recyclerview.adapter.RecyclerviewAddRemoveItemAdapter;

import java.util.ArrayList;

public class AddRemoveItem extends AppCompatActivity {

    RecyclerView recyclerView;

    RecyclerviewAddRemoveItemAdapter adapter;
    ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remove_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_add_remove_item);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        for enabling the predictive animation return true form the supportsPredictiveItemAnimations()
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean supportsPredictiveItemAnimations() {
                return true;
            }
        };
        recyclerView.setLayoutManager(layoutManager);
        /*
        set the item animator as default item animator
         */
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        /*
        add data to recyclerview and set adapter
         */
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("dfbdgb");
        }
        adapter = new RecyclerviewAddRemoveItemAdapter(datas);
        recyclerView.setAdapter(adapter);

        /*
        code to add a item to recyclerview with animation.
        add a data to the dataset and notify the aded position to adapter by notifyItemInserted()
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AddRemoveItem.this, "add item", Toast.LENGTH_SHORT).show();
                            datas.add(2, "dfgbdfb");
                            adapter.notifyItemInserted(2);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        /*
        code to remove item from the recyclerview with animation.
        remove a data from dataset and notify the removed position to adapter by notifyItemRemoved()
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AddRemoveItem.this, "remove item", Toast.LENGTH_SHORT).show();
                            datas.remove(0);
                            adapter.notifyItemRemoved(0);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        /*
        code to change position of a item in recyclerview.
        to do so send the from position and to position to adapter by the method notifyItemMoved()
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AddRemoveItem.this, "move item", Toast.LENGTH_SHORT).show();
                            datas.remove(0);
                            adapter.notifyItemMoved(1,4);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
