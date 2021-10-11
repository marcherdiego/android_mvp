[![Nerd's Corner](https://circleci.com/gh/marcherdiego/android_mvp.svg?style=svg)](https://app.circleci.com/pipelines/github/marcherdiego/android_mvp)

# Android MVP

**Events** [ ![Download](https://img.shields.io/maven-central/v/com.github.marcherdiego.mvp/events) ](https://search.maven.org/artifact/com.github.marcherdiego.mvp/events)

**Coroutines** [ ![Download](https://img.shields.io/maven-central/v/com.github.marcherdiego.mvp/coroutines) ](https://search.maven.org/artifact/com.github.marcherdiego.mvp/coroutines)

This is a small library (less than 70KB) that will help you through your Android features development in order to keep things simple, clear and tidy.

Please refer to [this article](https://android.jlelse.eu/android-mvp-doing-it-right-dac9d5d72079) to get a more in-depth explanation about how this library and its components work.

Setup
=======
Add `implementation` or `api` (library projects) dependency

```groovy
implementation "com.github.marcherdiego.mvp:events:LATEST_VERSION" 

// Optional if you want to use coroutines for model operations
implementation "com.github.marcherdiego.mvp:coroutines:LATEST_VERSION" 
```

Usage
=======
There are three different options to integrate this MVP library to your application, either extending a BaseActivity/BaseFragment that handles all the wiring and setup automagically **(recommended)**, having a reference to the presenter within your Activity/Fragment, or using behaviours.
For the three of them, the model, view and presenter behave the same so the only difference is in the activity/fragment

### Extending BaseActivity (recommended)
#### Activity
```kotlin
// Extending BaseActivity will automatically register and unregister the presenter to the bus whenever your activity get resumed or paused
class FeatureActivity : BaseActivity<FeaturePresenter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_activity)

        presenter = FeaturePresenter(
                FeatureView(this),
                FeatureModel()
        )
    }
}
```

#### Fragment
```kotlin
// Extending BaseFragment will automatically register and unregister the presenter to the bus whenever your activity get resumed or paused
class FeatureFragment : BaseFragment<FeaturePresenter>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = FeaturePresenter(
                FeatureView(this),
                FeatureModel()
        )
    }
}
```

### Holding a presenter reference (without inheritance)
#### Activity
```kotlin
class FeatureActivity : AppCompatActivity() {
    private lateinit var presenter: FeaturePresenter
    private var bus = Bus.newInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_activity)

        presenter = FeaturePresenter(
                FeatureView(this),
                FeatureModel(),
                bus
        )
    }

    override fun onResume() {
        super.onResume()
        bus.register(presenter)
    }

    override fun onPause() {
        bus.unregister(presenter)
        super.onPause()
    }
}
```

#### Fragment
```kotlin
class FeatureFragment : Fragment() {
    private lateinit var presenter: FeaturePresenter
    private var bus = Bus.newInstance

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = FeaturePresenter(
                FeatureView(this, bus),
                FeatureModel(bus)
        )
    }

    override fun onResume() {
        super.onResume()
        bus.register(presenter)
    }

    override fun onPause() {
        bus.unregister(presenter)
        super.onPause()
    }
}
```

### MVP components
#### Presenter
```kotlin
class FeaturePresenter(view: FeatureView, model: FeatureModel) : BaseActivityPresenter<FeatureView, FeatureModel>(view, model) {
    //...
}
```
#### View
```kotlin
class FeatureView(activity: FeatureActivity) : BaseActivityView(activity) {
    //...
}
```
#### Model
```kotlin
class FeatureModel : BaseEventsModel() {
    //...
}
```

### Basic wiring
#### Presenter
```kotlin
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

## Coroutines example
```kotlin
import com.nerdscorner.events.coroutines.extensions.withResult

class FeatureModel : BaseEventsModel() {
    private var fetchJob: Job? = null

    fun doSomethingInBackground() {
        fetchJob = withResult(
            resultFunc = someSuspendFunctionHere(),
            success = { // this: SuspendFunctionReturnType
                bus.post(BackgroundTaskCompletedEvent(this))
            },
            fail = { // this: Exception
                bus.post(BackgroundTaskFailedEvent(this.message))
            },
            cancelled = { // Called when executing fetchJob?.cancel()
                Log.e("InheritanceMainModel", "Job cancelled :(")
            }
        )
    }

    fun cancelJob() {
        fetchJob?.cancel()
    }

    class BackgroundTaskCompletedEvent(val pageHtml: String?)
    class BackgroundTaskFailedEvent(val message: String?)
}
```

Contributing
=======

Please fork this repository and contribute back using [pull requests](https://github.com/marcherdiego/android_mvp/pulls).

Any contributions, large or small, major features, bug fixes, unit tests are welcomed and appreciated but will be thoroughly reviewed and discussed.

License
=======

    Copyright 2021 Diego Marcher.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [1]: https://square.github.io/retrofit/
 [2]: https://search.maven.org/remote_content?g=com.squareup.retrofit2&a=retrofit&v=LATEST
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
 [proguard file]: https://github.com/square/retrofit/blob/master/retrofit/src/main/resources/META-INF/proguard/retrofit2.pro
 [okhttp proguard]: https://square.github.io/okhttp/r8_proguard/
 [okio proguard]: https://square.github.io/okio/#r8-proguard


Author
=======

Diego Marcher | diego@marcher.com.uy
