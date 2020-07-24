# MovingTextView
[![platform](https://img.shields.io/badge/Platform-Android-yellow.svg?style=flat-square)](https://www.android.com)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat-square)](https://android-arsenal.com/api?level=16s)
 
 Rotating text is an Android library that can be used to make text switching painless and beautiful, with the use of interpolators, typefaces and more customisations.

# Usage
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
Add the dependency
```
dependencies {
	        implementation 'com.github.shamithshetty:MovingTextView:Tag'
	}
  ```
  
## Example Usage 1 (Simple)
#### XML

```
<com.example.movingtextview.MovingTextView
         app:movingtext="@array/examples"
         app:startstring="shetty"
         app:startcolor="#cc320bdf"
         app:duration="12000"
         app:movingcolor="#e70d0d"
         app:stylebold="true"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:id="@+id/txt"
         android:textSize="20sp"   />
```
#### Demo

<div align="center"><img src="pic.gif"/></div>

##### Java

```
 String str[]={"str","tgg","ff","efwef"};
        txt.setMovingtexts(str);
        txt.setDuration(3000);
        txt.setBold(true);
        txt.setMovingcolor(Color.BLACK);
        txt.setStartingcolor(Color.BLACK);
        txt.setStaringValue("top company");
        txt.startAnimation();
        txt.stopAnimation();
```
  txt.startAnimation(); is used to start animation. we can use inside onCreate or button click event.
  txt.startAnimation();is used to stop animation

###### Attr of XML
```
 <attr name="movingtext" format="string" />
        <attr name="startstring" format="string"/>
        <attr name="startcolor" format="color|reference"/>
        <attr name="movingcolor" format="color|reference"/>
        <attr name="duration" format="integer"/>
        <attr name="stylebold" format="boolean"/>
```

  
