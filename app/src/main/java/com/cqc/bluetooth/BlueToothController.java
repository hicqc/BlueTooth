package com.cqc.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

/**
 * 蓝牙适配器
 */
public class BlueToothController {

    private BluetoothAdapter mAdapter;

    public BlueToothController() {
        mAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    /**
     * 是否支持蓝牙
     * @return true支持 false不支持
     */
    public boolean isSupportBlueTooth(){
        if (mAdapter != null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断蓝牙当前状态
     * @return true打开 false关闭
     */
    public boolean getBlueToothStatus(){
        assert (mAdapter != null);
        return mAdapter.isEnabled();
    }

    public void turnOnBlueTooth(Activity activity,int requestCode){
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity.startActivityForResult(intent,requestCode);
    }
}
