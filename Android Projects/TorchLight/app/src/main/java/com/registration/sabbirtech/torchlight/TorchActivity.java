package com.registration.sabbirtech.torchlight;

import android.content.Context;
import android.graphics.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TorchActivity extends AppCompatActivity {

    Button onbutton;
    Button offbutton;
    Boolean flashlight = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);

      onbutton = (Button)  findViewById(R.id.onbtn);
      offbutton =(Button) findViewById(R.id.offbtn);
      onbutton.setOnClickListener(new View.OnClickListener() {
          @RequiresApi(api = Build.VERSION_CODES.M)
          @Override
          public void onClick(View v) {
             if (flashlight)
             {
                // turnoff();

             }
            else
             {
                 turnon();
                //Toast.makeText(TorchActivity.this, "Torch off", Toast.LENGTH_SHORT).show();
                 Toast.makeText(TorchActivity.this, "Torch on", Toast.LENGTH_SHORT).show();
             }

          }
      });
      offbutton.setOnClickListener(new View.OnClickListener() {
          @RequiresApi(api = Build.VERSION_CODES.M)
          @Override
          public void onClick(View v) {
              if(!flashlight)
              {
                  //turnon();
              }
              else
              {
                  turnoff();

                  Toast.makeText(TorchActivity.this, "Torch off", Toast.LENGTH_SHORT).show();

              }
          }
      });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void turnoff() {

        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try
        {
            String camid = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(camid,false);
            flashlight = false;
        } catch (CameraAccessException e) {

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void turnon()

    {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try
        {
           String camid = cameraManager.getCameraIdList()[0];
           cameraManager.setTorchMode(camid,true);
           flashlight = true;
        } catch (CameraAccessException e) {

        }

    }


}
