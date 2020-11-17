# v7.2.1
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