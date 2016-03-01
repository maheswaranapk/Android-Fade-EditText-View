# Android-Fade-EditText-View
This is a Simple Android Custom EditText which fade at the end when the text goes beyond the screen.

**Inspired from this [blog!](https://sriramramani.wordpress.com/2013/06/06/ellip-sis/)**

# **How To use**
Add it to your build.gradle with:
```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```
and:

```gradle
dependencies {
     compile 'com.github.maheswaranapk:Android-Fade-EditText-View:1.0'
}
```

In Layout xml,
```xml
<com.fadeedittext.FadeEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:singleLine="true"
        android:text="The quick brown fox jumps over the lazy dog."/>
```

# **Output**
![alt tag](https://github.com/maheswaranapk/Android-Fade-EditText-View/blob/master/demo/demo.gif)
