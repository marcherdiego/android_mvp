# Events - v3.0.0
## New
- [BREAKING CHANGE] Package name updated to match GitHub project
- Added threadMode optional argument to `post()` methods on both View and Model.
- Upgraded dependencies versions

# Coroutines - v2.0.0
## New
- [BREAKING CHANGE] Package name updated to match GitHub project
- Upgraded dependencies versions

# Events - v2.1.0
## New
- Added `post()` methods on both View and Model as a shorthand of `bus.post()`
- Upgraded dependencies versions

# Coroutines - v1.4.0
## New
- Removed deprecated code

# Events - v2.0.0
## New
- [BREAKING CHANGE] Presenter is now nullable on BaseFragment because some reported issues using BottomNavigationView

# Events - v1.3.1
## New
- Updated compile SDK to 31
- Updated AndroidX dependencies
## Fixed
- Added proguard consumer config file

# Coroutines - v1.3.1
## New
- Added new `withResult` and deprecated the previous one

# Events - v1.2.0
## New
- Added a bunch of `onClick` functions on all base Views
- Upgraded kotlin and libraries versions to their latest

# Coroutines - v1.2.0
## New
- Improved `withResult` function to execute suspend functions from the model and cancelling them as requested
## Fixed
- Fixed postDelayed in base presenter to run delayed code in the main thread causing wrong handler exceptions


# Events - v1.1.2
## New
- Added missing onDestroy() call in BaseActivityPresenter
- Added missing presenter.onDestroy() call in BaseActivity

# Coroutines - v1.1.2
## New
- Added postDelayed in base presenter to run delayed code in the main thread


# Events - v1.0.0
## New
- Migration to Sonatype servers (reset version numbers)

# Coroutines - v1.0.0
## New
- Migration to Sonatype servers (reset version numbers)

--------------------------------------------------------------------------------------------------------------

# Events - v8.2.2
## New
- Added `runOnUiThread` function in BaseView class to reduce boilerplate
- Exposed bus on base classes for further extensions

# Coroutines - v1.0.2
## New
- `launchMain` to run suspend functions on the main thread
- `runAsync` to run suspend functions on any scope/dispatcher (Main and IO by default)
- `withResult` to run suspend a functions on any scope/dispatcher (Main and IO by default) and listen for results

# v8.1.0
## New
- Added permission checker/requester helpers (`withPermission` and `withPermissions`) in BasePresenter class

# v8.0.0
## New
- Removed behaviour-based injection
- Fixed fragment tests cases

# v7.2.5
## New
- Kotlin and gradle versions upgrade

# v7.2.0
## New
- Upgrade event bus library to 3.2.0 ! [Release notes](https://greenrobot.org/release/eventbus-3-2/)
- Added replace fragment with tag

# v7.1.1
## Fixed
- Added `open` modifier to BaseFragmentPresenter#onViewStateRestored function

# v7.1.0
## New
- Converted `withFragmentByTag` block to Fragment extension function

# v7.0.0
## New
- Removed deprecated lifecycle functions on View and Model
- Removed deprecated extension functions for fragment transaction handling and find fragments by tag utils

# v6.6.1
## Fixed
- Added `open` modifier to BaseFragmentPresenter#onViewStateRestored function

# v6.6.0
## New
- Added return value to `withFragmentManager`, `withFragmentByTag` and `withFragmentTransaction` functions to
be able to react when no fragmentManager is available
- Deprecated lifecycle functions on View and Model in favor of presenter's ones

# v6.5.0
## New
- onClick with varargs to set the same click listener event to multiple views

# v6.4.0
## New
- MVP for views!
- Test app examples updated!

# v6.3.0
## New
- Abstract functions to with with fragment manager, (supportFragmentManager for Activities and childFragmentManager for Fragments)

# v6.2.0
## New
- Added helper `removeStickyEvent` in the BaseModel class
- Improved README.MD file with more examples
- More examples in testapp

# v6.0.0
## New
- Added postDefault and postStickyDefault methods to post in the default bus without asking for a reference to it
- Added startActivity function helper

# v5.2.0
## New
- Extension functions for fragment transaction handling and find fragments by tag utils

# v5.1.0
## New
- Removed annotations for performance purposes
- Improved withActivity method in BaseView

# v5.0.0
## New
- Removed deprecated MvpConfig file and replaced it with annotations

# v4.0.0
## New
- Android X migration

# v3.0.0
## New
- Refactored and simplified package names
- Removed Commons module to improve build time

# v2.0.0
## New
- Full Kotlin migration

## Fixed
- Nullability checks

# v1.11.2
## New
- Stable version release

# v1.0.0
## New
- Initial release
