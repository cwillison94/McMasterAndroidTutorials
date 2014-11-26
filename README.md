McMasterAndroidTutorials
========================

HOW TO INSTALL ANDROID ADT/SDK:

EDIT: you must also have the JRE (java runtime environment) installed, I believe I am using v1.7

1. Download the android SDK and eclipse ADT bundle. This can be found here: 

   https://developer.android.com/sdk/index.html?hl=i

2. [Alternate] If you already have eclipse installed on your computer you can install the 
   ADT plugin using the new software feature and the update link. This can be done by:
  
   Open eclipse > help > install new software...> add > then use this link: 

   https://dl-ssl.google.com/android/eclipse/

3. Once everything is downloaded/installed you must download the latest api version 
   (In this case android 5.0, api version 21):

   Open eclipse >windows> Android SDK manager > tick Android 5.0 > hit install packages

4. That is it, your done!
   Note for APP TESTING:

-->If you DO NOT have an android phone then you can test your apps using the Android Emulator 
  (virtual device that runs on your computer)

-->If you HAVE an android phone is highly recommended that you test your app on it 
 (much faster then an emulator). In order to run apps in development on your phone 
 you must enable USB debugging. This can be down by:
 
 settings > developer options > usb debugging

*NOTE if you do not see the developer options in your settings then you must enable 
them by going to:

 About phone > tap on Build Version continually 

(until you see a Toast message at the bottom of the screen saying "you are now a developer".)

