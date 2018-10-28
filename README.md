# Android MVP

This is a small lib that will help you through your Android features development in order to keep things simple, clear and tidy.

## Events
[ ![Download](https://api.bintray.com/packages/nerdscorrner/MVPLib/AndroidEventsOrientedMvpLibrary/images/download.svg) ](https://bintray.com/nerdscorrner/MVPLib/AndroidEventsOrientedMvpLibrary/_latestVersion)

```groovy
//Events oriented MVP Lib
compile 'com.nerdscorner.mvp:events:LATEST_EVENTS_VERSION'
```
## Interfaces
[ ![Download](https://api.bintray.com/packages/nerdscorrner/MVPLib/AndroidInterfacesOrientedMvpLibrary/images/download.svg) ](https://bintray.com/nerdscorrner/MVPLib/AndroidInterfacesOrientedMvpLibrary/_latestVersion)

```groovy
//Interfaces oriented MVP Lib
compile 'com.nerdscorner.mvp:interfaces:LATEST_INTERFACES_VERSION'
```

## Usage
There are three different options to integrate this MVP library to your application, either having a reference to the presenter within your Activity/Fragment, using behaviours or extending a BaseActivity/BaseFragment that handles all the wiring and setup automagically.
### Direct reference
#### Events
##### Attributes
```java
public class AttributeEventsMainActivity extends AppCompatActivity {
    private AttributeMainPresenter presenter;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ...
            presenter = new AttributeMainPresenter(
                    new AttributeMainView(this, bus),
                    new AttributeMainModel(bus)
            );
        }
}
```

//TODO


## Contributing

Please fork this repository and contribute back using [pull requests](https://github.com/marcherdiego/android_mvp/pulls).

Any contributions, large or small, major features, bug fixes, unit tests are welcomed and appreciated but will be thoroughly reviewed and discussed.


## Author

Diego Marcher | diego@marcher.com.uy
