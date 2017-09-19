package com.example.asus.herb4health;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FetchImageFirebase extends AppCompatActivity {

    private DatabaseReference mDatabaseRef;
    private List<ImageUploadConfig>imgList;
    private ListView lv;
    private ImageListAdapter adapter;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_image_firebase);
        imgList = new ArrayList<>();
        lv = (ListView)findViewById(R.id.ListviewsImage);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait loading list image ...");
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(Uploadimage.STORAGE_URL);
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                progressDialog.dismiss();

                //Fetch Img from database
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    //ImageUploadConfig class require default constructor
                    ImageUploadConfig img = snapshot.getValue(ImageUploadConfig.class);
                    imgList.add(img);

                }
                //Init adapter
                adapter = new ImageListAdapter(FetchImageFirebase.this,R.layout.image_item,imgList);
                //Set adapter for listView
                lv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
    }
}
