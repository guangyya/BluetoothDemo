package im.adb.bluetoothdemo.bluetooth

import android.bluetooth.BluetoothHeadset
import android.bluetooth.BluetoothProfile

class BluetoothServiceListener : BluetoothProfile.ServiceListener{
    override fun onServiceConnected(profile: Int, proxy: BluetoothProfile?) {
        when (profile) {
            BluetoothProfile.HEADSET -> BluetoothHelper.setBluetoothHeadSet(proxy as BluetoothHeadset)
        }
    }

    override fun onServiceDisconnected(profile: Int) {
        when (profile) {
            BluetoothProfile.HEADSET -> BluetoothHelper.setBluetoothHeadSet(null)
        }
    }
}