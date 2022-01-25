# BluetoothDemo

To demo the issue for https://issuetracker.google.com/issues/215940251

HOW TO REPRODUCE:
1. Create a work profile using any app
2. Build and install this apk to both user profile and work profile
3. Connected to a bluetooth headset
4. Open the app
5. Click the refresh button
6. check the connected devices

BEHAVIOR:
You'll find that:
1. Outside MDM profile, API will return the bluetooth devices, normally one device and it's address
2. Inside MDM profile, API will always return empty list

NOTE:
1. This issue only happens on Android 12, verified on Android 11, it works fine both inside and outside
2. This issue happends on multiple Pixel devices, checked on Pixel 5 and Pixel 6 Pro, all reproducible
