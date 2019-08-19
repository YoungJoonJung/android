package com.example.recyclerviewstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GreenAdapter.ListItemClickListener {

    private static final int NUM_LIST_ITEMS = 100;
    private static final String TAG = MainActivity.class.getName();

    private GreenAdapter mAdapter;
    private RecyclerView mNumberList;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberList = (RecyclerView) findViewById(R.id.tv_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumberList.setLayoutManager(layoutManager);

        mNumberList.setHasFixedSize(true);

        mAdapter = new GreenAdapter(NUM_LIST_ITEMS, this);

        mNumberList.setAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Log.d(TAG, "Step1) onClick function in");
        if(mToast != null){
            Log.d(TAG, "Step2) function in");
            mToast.cancel();
        }
        String toastMessage = "Item #" + clickedItemIndex + " is cliecked";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        mToast.show();
    }
}
