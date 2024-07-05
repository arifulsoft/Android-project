package com.example.myprject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowallanimalActivity extends AppCompatActivity {
    TextView textView;
    Button back;

    RecyclerView recyclerView;
    ArrayList<Animal> datalist;
    MyAdapter myAdapter;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_showallanimal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        db = FirebaseFirestore.getInstance();
        textView= findViewById(R.id.textView);
        back=findViewById(R.id.button);

        recyclerView = findViewById(R.id.myrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        datalist = new ArrayList<>();

        myAdapter = new MyAdapter(datalist, getApplicationContext());
        recyclerView.setAdapter(myAdapter);

    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ShowallanimalActivity.this, MainActivity.class));
        }
    });



        db.collection("sellAnimals").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> documentSnapshotList = queryDocumentSnapshots.getDocuments();
                for (DocumentSnapshot d : documentSnapshotList) {
                    Animal animal = d.toObject(Animal.class);
                    datalist.add(animal);
                }
                myAdapter.notifyDataSetChanged();
            }
        });



    }
}

