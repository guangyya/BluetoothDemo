package im.adb.bluetoothdemo.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothHeadset
import android.content.Context
import android.util.Log

object BluetoothHelper {
    private const val TAG = "BluetoothHelper"

    lateinit var applicationContext: Context
    private var bluetoothHeadset: BluetoothHeadset? = null
    private var bluetoothServiceListener = BluetoothServiceListener()

    fun init(context: Context) {
        applicationContext= context
        BluetoothAdapter.getDefaultAdapter()?.getProfileProxy(applicationContext, bluetoothServiceListener, BluetoothHeadset.HEADSET)
    }

    fun setBluetoothHeadSet(bluetoothHeadset: BluetoothHeadset?) {
        Log.d(TAG, "setBluetoothHeadSet $bluetoothHeadset")
        this.bluetoothHeadset = bluetoothHeadset
    }

    fun getConnectedDevices(): List<BluetoothDevice> {
        Log.d(TAG, "getConnectedDevices")
        /**
         * NOTE: here is the root cause
         * when App running outside of MDM profile, this API can return correctly
         * when App running inside of MDM profile, this API always return an empty list
         */
        return bluetoothHeadset?.connectedDevices ?: emptyList()
    }
}