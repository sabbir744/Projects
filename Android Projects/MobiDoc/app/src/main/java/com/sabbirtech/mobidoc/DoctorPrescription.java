package com.sabbirtech.mobidoc;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sabbirtech.mobidoc.helper.DatabaseHelper;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DoctorPrescription extends AppCompatActivity {

    private EditText mname, mdetails;
    private Button msave,madd;
    ImageView mimage;


    private static final int SELECT_PHOTO = 1;
    private static final int CAPTURE_PHOTO = 2;

    private ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarbHandler = new Handler();
    private boolean hasImageChanged = false;
    Bitmap thumbnail;
    DatabaseHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_prescription);



        mname = findViewById(R.id.doctorname);
        mdetails = findViewById(R.id.doctordetails);
        msave = findViewById(R.id.saveimage);
        madd = findViewById(R.id.addimage);
        mimage = findViewById(R.id.prescribeimage);

        madd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(DoctorPrescription.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    mimage.setEnabled(false);
                    ActivityCompat.requestPermissions(DoctorPrescription.this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
                } else {
                    mimage.setEnabled(true);
                }
            }
        });

        msave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addimage(view);
        }
        });



        helper = new DatabaseHelper(this);


    }

    @Nullable
    @Override
    protected Dialog onCreateDialog(int id, Bundle args) {
        AlertDialog.Builder builder ;
        switch (id){
            case 0:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
                break;
            case 1:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAPTURE_PHOTO);
                break;
            case 2:
                mimage.setImageResource(R.drawable.ic_launcher_background);
                break;
        }
        return super.onCreateDialog(id, args);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                mimage.setEnabled(true);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_PHOTO){
            if(resultCode == RESULT_OK) {
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    //set Progress Bar

                    //set profile picture form gallery
                    mimage.setImageBitmap(selectedImage);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }else if(requestCode == CAPTURE_PHOTO){
            if(resultCode == RESULT_OK) {
                onCaptureImageResult(data);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void onCaptureImageResult(Intent data) {
        thumbnail = (Bitmap) data.getExtras().get("data");

        //set Progress Bar

        //set profile picture form camera
        mimage.setMaxWidth(200);
        mimage.setImageBitmap(thumbnail);


    }

    public void addimage(View view)
    {
        mimage.setDrawingCacheEnabled(true);
        mimage.buildDrawingCache();
        Bitmap bitmap = mimage.getDrawingCache();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();
        helper.addimage(data,mdetails.getText().toString(),mname.getText().toString());
        Toast.makeText(this, " saved  successfully", Toast.LENGTH_SHORT).show();
    }
}


