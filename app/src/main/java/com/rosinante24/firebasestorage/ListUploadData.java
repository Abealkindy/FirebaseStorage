package com.rosinante24.firebasestorage;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListUploadData extends AppCompatActivity {

    @BindView(R.id.recycler_upload)
    RecyclerView recyclerUpload;

    private DatabaseReference databaseReference;

    private ProgressDialog progressDialog;

    private List<Upload> uploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_upload_data);
        ButterKnife.bind(this);

        recyclerUpload.setHasFixedSize(true);
        recyclerUpload.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);

        uploads = new ArrayList<>();

        progressDialog.setMessage("Please wait....");
        progressDialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    uploads.add(upload);
                }

                ListUploadAdapter adapter = new ListUploadAdapter(getApplicationContext(), uploads);

                recyclerUpload.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();
                Toast.makeText(ListUploadData.this, "Gagal bro!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
