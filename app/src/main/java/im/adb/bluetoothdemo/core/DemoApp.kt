package im.adb.bluetoothdemo.core

import android.app.Application
import android.content.Context
import im.adb.bluetoothdemo.bluetooth.BluetoothHelper

class DemoApp : Application() {

    companion object {
        lateinit var instance: DemoApp
            private set

        fun applicationContext(): Context {
            return instance.applicationContext
        }

        fun get() : DemoApp {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        BluetoothHelper.init(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        instance = this
    }
}