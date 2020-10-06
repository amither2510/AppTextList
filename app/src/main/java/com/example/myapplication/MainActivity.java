package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.entity.ExampleItem;
import com.example.myapplication.entity.Fruit;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;
    private ArrayList<Fruit> fruitArrayList;
    private AppCompatAutoCompleteTextView autoTextViewCustom;
    private TextView fruitDesc;
    private FruitAdapter fruitAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createExampleList();
        buildRecyclerView();
        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);
        fruitDesc = (TextView) findViewById(R.id.fruitDesc);
        autoTextViewCustom = (AppCompatAutoCompleteTextView) findViewById(R.id.autoTextView1);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
        fruitArrayList = new ArrayList<>();
        fruitArrayList.add(new Fruit(R.drawable.apple, "Apple", "The apple tree is a deciduous tree in the rose family best known for its sweet, pomaceous fruit, the apple."));
        fruitArrayList.add(new Fruit(R.drawable.banna, "Banana", "The banana is an edible fruit — botanically a berry — produced by several kinds of large herbaceous flowering plants in the genus Musa."));
        fruitArrayList.add(new Fruit(R.drawable.watermelons, "Cherry", "A cherry is the fruit of many plants of the genus Prunus, and is a fleshy drupe (stone fruit)."));
        fruitArrayList.add(new Fruit(R.drawable.kiwi, "Grape", "A grape is a fruit, botanically a berry, of the deciduous woody vines of the flowering plant genus Vitis."));
        fruitArrayList.add(new Fruit(R.drawable.kiwi, "Kiwi", "Kiwifruit or Chinese gooseberry is the edible berries of several species of woody vines in the genus Actinidia."));
        fruitArrayList.add(new Fruit(R.drawable.kiwi, "Mango", "Mangoes are juicy stone fruit from numerous species of tropical trees belonging to the flowering plant genus Mangifera, cultivated mostly for their edible fruit."));
        fruitArrayList.add(new Fruit(R.drawable.kiwi, "Pear", "The pear is any of several tree and shrub species of genus Pyrus, in the family Rosaceae."));
        fruitAdapter = new FruitAdapter(this, R.layout.custom_row, fruitArrayList);
        autoTextViewCustom.setThreshold(1);
        autoTextViewCustom.setAdapter(fruitAdapter);
// handle click event and set desc on textview
        autoTextViewCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = (Fruit) adapterView.getItemAtPosition(i);
                fruitDesc.setText(fruit.getDesc());
            }
        });
    }
    public void insertItem(int position) {
        mExampleList.add(position, new ExampleItem(R.drawable.ic_launcher_background, "New Item At Position" + position, "This is Line 2"));
        mAdapter.notifyItemInserted(position);
    }
    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.apple, "Line 1", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.banna, "Line 3", "Line 4"));
        mExampleList.add(new ExampleItem(R.drawable.kiwi, "Line 5", "Line 6"));
    }
    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}