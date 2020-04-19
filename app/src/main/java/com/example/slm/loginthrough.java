package com.example.slm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class loginthrough extends AppCompatActivity {
    private TextView mHeadingLabel;
    private ImageView mFingerprintImage;
    private TextView mparaLabel;
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginthrough);
        mHeadingLabel=(TextView)findViewById(R.id.HeadingLabel);
        mFingerprintImage=(ImageView) findViewById(R.id.fingerprintimage);
        mparaLabel=(TextView)findViewById(R.id.paraLabel);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            fingerprintManager =(FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            keyguardManager=(KeyguardManager) getSystemService(KEYGUARD_SERVICE);
            if(!fingerprintManager.isHardwareDetected()){

            mparaLabel.setText("Fingerprint Scanner not detected in device");
            }
            else if (ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT)!= PackageManager.PERMISSION_GRANTED){
               mparaLabel.setText("Permission not granted to use Fingerprint Scanner");
            } else if (!keyguardManager.isKeyguardSecure()){

                mparaLabel.setText("Add lock to your phone is Settings");

            } else if(!fingerprintManager.hasEnrolledFingerprints()){
                mparaLabel.setText("You should add atleast 1 Fingerprint to use this Feature");


            }else {

                mparaLabel.setText("Placed your finger on sensor");
                FingerprintHandler fingerprintHandler= new FingerprintHandler (this);
                fingerprintHandler.startAuth(fingerprintManager, null);
            }

        }

    }

    public void biometric(View v) {
        Intent i = new Intent(loginthrough.this, MainActivity.class);
        startActivity(i);
    }
}