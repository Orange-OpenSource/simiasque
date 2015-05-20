#SIMIASQUE

##What is Simiasque?
Simiasque is an android application designed for developpers. It allows them to manually hide the status bar under an overlay mask, preventing stress tests (monkey tests) from clicking it.

##Why
Monkey tests can be really annoying, and browsing among notifications and settings rather that the application seams to be a frequent issue. *This app can be a simple work around to a common problem.*
- http://stackoverflow.com/questions/7457730/preventing-status-bar-expansion
- http://stackoverflow.com/questions/22251327/how-to-prevent-monkey-to-open-status-bar
- http://stackoverflow.com/questions/25284233/prevent-status-bar-for-appearing-android-modified/25308654#25308654
- ...

##How to install
You can choose to download source code and compile it yourself, or you may want to directly download and install [this demo apk](https://github.com/Orange-OpenSource/simiasque/raw/master/demo/simiasque-debug.apk)

if you prefer to compile it yourself, juste clone our repo
```
git clone https://github.com/Orange-OpenSource/simiasque.git
```
and execute gradle command to compile and install the projet to your phone:
```
./gradlew installDebug
```
##How to use
###User interface 
Simply launch the application to get a switch that will allow you to turn the overlay mask on/off.
###Command line
You can also use adb to toggle the overlay.

To turn it on: 
```
adb shell am broadcast -a org.thisisafactory.simiasque.SET_OVERLAY --ez enable true
```
To turn it off:
```
adb shell am broadcast -a org.thisisafactory.simiasque.SET_OVERLAY --ez enable false
```
###From another app
You can trigger Simiasque from another app using our broadcast receiver. Simply fire an intent with action `org.thisisafactory.simiasque.SET_OVERLAY` and an extra boolean `enable` set to true to show the mask and false to hide it.

##Screenshots:
![](http://orange-opensource.github.io/simiasque/images/screenshot01.png)
![](http://orange-opensource.github.io/simiasque/images/screenshot02.png)
![](http://orange-opensource.github.io/simiasque/images/screenshot03.png)

##Contributing
Contributions to Simiasque are welcome and greatly appreciated.

##Author:
Arnaud Ruffin

##License:
MPL-2.0
