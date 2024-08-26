package com.xzy.ble.simplebledemo.bluetooth.device;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.util.Log;

import com.xzy.ble.simplebledemo.bluetooth.BaseBleDevice;
import com.xzy.ble.simplebledemo.bluetooth.utils.HexUtil;

import java.util.UUID;


/**
 * 具体的硬件设备,如果有多台设备，可以有多个该类的定义。
 *
 * @author 002034
 */
public class BleDevice extends BaseBleDevice {
    private static final String TAG = "BleDevice";

    /**
     * 根据具体硬件进行设置
     **/
    public static final String MAC = "94:C9:60:B4:C7:B9";
    private static final UUID DEVICE_SERVICE_UUID = UUID.fromString("55535343-fe7d-4ae5-8fa9-9fafd205e455");
    private static final UUID DEVICE_WRITE_UUID = UUID.fromString("49535343-8841-43f4-a8d4-ecbe34729bb3");
    private static final UUID DEVICE_NOTIFY_UUID = UUID.fromString("49535343-1e4d-4bd9-ba61-23c647249616");


    @SuppressLint("StaticFieldLeak")
    private static BleDevice mBleDevice;

    private BleDevice(Context context) {
        super(context);
        serviceUuid = DEVICE_SERVICE_UUID;
        writeUuid = DEVICE_WRITE_UUID;
        notifyUuid = DEVICE_NOTIFY_UUID;
    }

    public static BleDevice getInstance(Context context){
        if(mBleDevice == null){
            mBleDevice = new BleDevice(context);
        }
        return mBleDevice;
    }
}
