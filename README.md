

## Gradle

### step1

enable dataBinding in your app/build.gradle:

```
    dataBinding
            {
                enabled=true
            }
```


### step2

Add this in your root build.gradle at the end of repositories.

```
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
}
```

### step3
add the dependency in your build.gradle.

```
    implementation 'android.arch.lifecycle:extensions:1.1.0'

```

