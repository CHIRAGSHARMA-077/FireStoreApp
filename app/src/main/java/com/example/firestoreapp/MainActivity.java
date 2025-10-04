package com.example.firestoreapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button saveBTN;
    private Button readBTN;
    private Button updateBTN;
    private Button deleteBTN;
    private TextView textView;
    private EditText nameET;
    private EditText emailET;
    //Firebase firestore
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private DocumentReference friendsref=db.collection("Users").document("hv2s51cllSeNKKKukJ5Z");
    private CollectionReference collectionReference=db.collection("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nameET=findViewById(R.id.nameET);
        emailET=findViewById(R.id.emailET);
        saveBTN=findViewById(R.id.SaveBTN);
        readBTN=findViewById(R.id.readBTN);
        updateBTN=findViewById(R.id.updateBTN);
        deleteBTN=findViewById(R.id.deleteBTN);
        textView=findViewById(R.id.text);
        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveDataToNewDocument();
            }
        });
        readBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetAllDocumentsInCollection();
            }
        });
        updateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateSpecificDocument();
            }
        });
        deleteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteAll();
            }
        });

    }
    private  void SaveDataToNewDocument(){
        String name=nameET.getText().toString();
        String email=emailET.getText().toString();
        Friend friend=new Friend(name,email); // this is an object
        collectionReference.add(friend).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                String docId=documentReference.getId();
            }
        });

        // add method is called to add a new document a specified collection
    }

    private void GetAllDocumentsInCollection(){
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String data="";
                for(QueryDocumentSnapshot snapshot:queryDocumentSnapshots){
                    Friend friend = snapshot.toObject(Friend.class);
                    data+="Name: "+friend.getName()+ "E-mail: "+friend.getEmail()+"\n";
                }textView.setText(data);

            }


        });

    }
    private void UpdateSpecificDocument(){
        String name = nameET.getText().toString();
        String email=emailET.getText().toString();
        friendsref.update("name",name);
        friendsref.update("email",email);
    }
    private void DeleteAll(){

        friendsref.delete();
    }
}