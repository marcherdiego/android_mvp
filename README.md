# Android MVP

This is a small lib that will help you through your Android features development in order to keep things simple, clear and tidy.

Please refer to [this article](https://android.jlelse.eu/android-mvp-doing-it-right-dac9d5d72079) to get a more in-depth explanation about how this library and its components work. 

## Setup
[ ![Download](https://api.bintray.com/packages/nerdscorrner/MVPLib/Events/images/download.svg) ](https://bintray.com/nerdscorrner/MVPLib/Events/_latestVersion)

```groovy
//Events oriented MVP Lib
implementation "com.nerdscorner.mvp:events:LATEST_VERSION" 
```

## Usage
There are three different options to integrate this MVP library to your application, either having a reference to the presenter within your Activity/Fragment, using behaviours or extending a BaseActivity/BaseFragment that handles all the wiring and setup automagically.

### Extending BaseActivity
#### Activity
```kotlin
import com.nerdscorner.mvplib.events.activity.BaseActivity

class FeatureActivity : BaseActivity<FeaturePresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_activity)

        // This will automatically register and unregister the presenter to the bus whenever your activity get resumed or paused
        presenter = FeaturePresenter(
                FeatureView(this),
                FeatureModel()
        )
    }
}
```
#### Presenter
```kotlin
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter

class FeaturePresenter(view: FeatureView, model: FeatureModel) : BaseActivityPresenter<FeatureView, FeatureModel>(view, model) {
    ...
}
```
#### View
```kotlin
import com.nerdscorner.mvplib.events.view.BaseActivityView

class FeatureView(activity: FeatureActivity) : BaseActivityView(activity) {
    ...
}
```
#### Model
```kotlin
import com.nerdscorner.mvplib.events.model.BaseEventsModel

class FeatureModel : BaseEventsModel() {
    ...
}
```

### Basic wiring
#### Presenter
```kotlin
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter
import org.greenrobot.eventbus.Subscribe

class FeaturePresenter(view: FeatureView, model: FeatureModel) : BaseActivityPresenter<FeatureView, FeatureModel>(view, model) {

    // Event posted by the view
    @Subscribe
    fun onActionClicked(event: FeatureView.ActionClickedEvent) {
        view.setTextValue("Executing background task...")
        model.doSomethingInBackground()
    }

    // Event posted by the model
    @Subscribe
    fun onBackgroundTaskCompleted(event: FeatureModel.BackgroundTaskCompletedEvent) {
        view.setTextValue("Background task completed")
    }
}
```
#### View
```kotlin
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R

class FeatureView(activity: AppCompatActivity) : BaseActivityView(activity) {
    private var textView: TextView = activity.findViewById(R.id.text)

    init {
        // Helper library method to handle click event
        onClick(R.id.some_button, ActionClickedEvent())
        
        // Optionally you can do
        activity.findViewById<View>(R.id.some_button)?.setOnClickListener {
            bus.post(ActionClickedEvent())
        }
    }

    fun setTextValue(value: CharSequence) {
        textView.text = value
    }

    class ActionClickedEvent
}
```
#### Model
```kotlin
import com.nerdscorner.mvplib.events.model.BaseEventsModel

class FeatureModel : BaseEventsModel() {

    fun doSomethingInBackground() {
        backendCall().execute {
            success = {
                bus.post(BackgroundTaskCompletedEvent())
            }
        }
    }

    class BackgroundTaskCompletedEvent
}
```

## Contributing

Please fork this repository and contribute back using [pull requests](https://github.com/marcherdiego/android_mvp/pulls).

Any contributions, large or small, major features, bug fixes, unit tests are welcomed and appreciated but will be thoroughly reviewed and discussed.


## Author

Diego Marcher | diego@marcher.com.uy
