package com.cqc.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private BlueToothController mController = new BlueToothController();
    private Toast mToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void isSupportBlueTooth(View view){
        boolean ret = mController.isSupportBlueTooth();
        showToast("support BlueTooth?"+ret);
    }

    public void isBlueToothEnable(View view){
        boolean ret = mController.getBlueToothStatus();
        showToast("BlueTooth status is "+ret);
    }

    public void requestTurnOnBlueTooth(View view){
        mController.turnOnBlueTooth(this,REQUEST_CODE);
    }

    public void requestTurnOffBlueTooth(View view){
        mController.turnOffBlueTooth();
    }

    private void showToast(String text){
        if (mToast == null){
            mToast = Toast.makeText(this,text,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(text);
        }
        mToast.show();
    }
}