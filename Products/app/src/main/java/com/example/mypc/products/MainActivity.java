package com.example.mypc.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.app.ProgressDialog;



public class MainActivity extends AppCompatActivity {

    //Button b;
    EditText productname, productid, cost;
    //b =(Button)findViewById(R.id.ok);
    public ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productname = (EditText) findViewById(R.id.editText);
        productid = (EditText) findViewById(R.id.editText2);
        cost = (EditText) findViewById(R.id.editText3);
        progressDialog = new ProgressDialog(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReferenceFromUrl("https://products-e4ac8.firebaseio.com/products/");

    }
    public void ok(View view){

        DatabaseReference id=databaseReference.push();

        id.child("productname").setValue(productname.getText().toString());
        id.child("productid").setValue(productid.getText().toString());
        id.child("cost").setValue(cost.getText().toString());
    }



}