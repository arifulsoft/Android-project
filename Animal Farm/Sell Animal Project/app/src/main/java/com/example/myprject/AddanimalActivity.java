package com.example.myprject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddanimalActivity extends AppCompatActivity {
    Button addanimal;
    EditText name, phone,animaltype,location,askingprice, image;
    FirebaseFirestore db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addanimal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        db=FirebaseFirestore.getInstance();
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        animaltype=findViewById(R.id.animaltype);
        location=findViewById(R.id.location);
        askingprice=findViewById(R.id.askingprice);
        image=findViewById(R.id.image);
        addanimal=findViewById(R.id.add);
        addanimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveanimal(name.getText().toString(),phone.getText().toString(),animaltype.getText().toString(),location.getText().toString(),askingprice.getText().toString(),image.getText().toString());
            }
        });

    }
    public void saveanimal(String name, String phone, String animaltype, String location,String askingprice,String image){
        Map<String,Object> map=new HashMap<>();
        map.put("name",name);
        map.put("phone",phone);
        map.put("animaltype",animaltype);
        map.put("location",location);
        map.put("askingprice",askingprice);
        map.put("image",image);
        db.collection("sellAnimals").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AddanimalActivity.this,"Data saved",Toast.LENGTH_LONG).show();
                startActivity(new Intent(AddanimalActivity.this, MainActivity.class));
            }
        });
    }


}