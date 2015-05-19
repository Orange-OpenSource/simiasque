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
