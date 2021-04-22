# OVmusicplayer
OVmusicplayer is a music application that shows lyrics of your music.

### Code style

To maintain the style and quality of the code, are used the bellow static analysis tools. All of them use properly configuration and you find them in the project root directory `.{toolName}`.

| Tools                                                   | Check Command                                                             
| [detekt](https://github.com/arturbosch/detekt)          |  `./gradlew detekt`        | -                         |
| [ktlint](https://github.com/pinterest/ktlint)           |  `./gradlew ktlint`        | `./gradlew ktlintFormat`  |
| [spotless](https://github.com/diffplug/spotless)        |  `./gradlew spotlessCheck` | `./gradlew spotlessApply` |
| [lint](https://developer.android.com/studio/write/lint) |  `./gradlew lint`          | -                         |

## Design

App [support different screen sizes](https://developer.android.com/training/multiscreen/screensizes) and the content has been adapted to fit for mobile devices and tablets. To do that, it has been created a flexible layout using one or more of the following concepts:

-   [Use constraintLayout](https://developer.android.com/training/multiscreen/screensizes#ConstraintLayout)
-   [Avoid hard-coded layout sizes](https://developer.android.com/training/multiscreen/screensizes#TaskUseWrapMatchPar)
-   [Create alternative layouts](https://developer.android.com/training/multiscreen/screensizes#alternative-layouts)
-   [Use the smallest width qualifier](https://developer.android.com/training/multiscreen/screensizes#TaskUseSWQuali)
-   [Use the available width qualifier](https://developer.android.com/training/multiscreen/screensizes#available-width)
-   [Add orientation qualifiers](https://developer.android.com/training/multiscreen/screensizes#TaskUseOriQuali)

In terms of design has been followed recommendations [android material design](https://developer.android.com/guide/topics/ui/look-and-feel) comprehensive guide for
visual, motion, and interaction design across platforms and devices. Granting the project in this way a great user experience (UX) and user interface (UI). 
For more info about UX best practices visit [link](https://developer.android.com/topic/google-play-instant/best-practices/apps).

## Architecture

The architecture of the application is based, apply and strictly complies with each of the following 5 points:

<img src="screenshots/architecture/project_structure.png" width="300" align="right" hspace="20">

-   A single-activity architecture, using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage fragment operations.
-   [Android architecture components](https://developer.android.com/topic/libraries/architecture/), part of Android Jetpack for give to project a robust design, testable and maintainable.
-   Pattern [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) (MVVM) facilitating a [separation](https://en.wikipedia.org/wiki/Separation_of_concerns) of development of the graphical user interface.
-   [S.O.L.I.D](https://en.wikipedia.org/wiki/SOLID) design principles intended to make software designs more understandable, flexible and maintainable.

## Documentation

The documentation is generated following [KDoc](https://kotlinlang.org/docs/reference/kotlin-doc.html) language (the equivalent of Java's [JavaDoc](https://en.wikipedia.org/wiki/Javadoc)) via documentation engine for Kotlin [Dokka](https://github.com/Kotlin/dokka).

To consult it check this open the project `/docs` directory.


### Dependencies

-   [Jetpack](https://developer.android.com/jetpack):
    -   [Android KTX](https://developer.android.com/kotlin/ktx.html) - provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    -   [AndroidX](https://developer.android.com/jetpack/androidx) - major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    -   [Benchmark](https://developer.android.com/studio/profile/benchmark.html) - handles warmup, measures your code performance, and outputs benchmarking results to the Android Studio console.
    -   [LyricView](https://github.com/zhengken/LyricViewDemo) - LyricView is a powerful and flexible custom view to display lyrics within music player under Android
    -   [View Binding](https://developer.android.com/topic/libraries/data-binding/) - allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
    -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    -   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
    -   [Navigation](https://developer.android.com/guide/navigation/) - helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
    -   [Room](https://developer.android.com/topic/libraries/architecture/room) - persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
-   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - managing background threads with simplified code and reducing needs for callbacks.
-   [Hilt](https://dagger.dev/) - dependency injector for replacement all FactoryFactory classes.
-   [Retrofit](https://square.github.io/retrofit/) - type-safe HTTP client.
-   [Coil](https://github.com/coil-kt/coil) - image loading library for Android backed by Kotlin Coroutines.

### Test dependencies

-   [Espresso](https://developer.android.com/training/testing/espresso) - to write concise, beautiful, and reliable Android UI tests
-   [Robolectric](https://github.com/robolectric/robolectric) - industry-standard unit testing framework for Android.
-   [JUnit](https://github.com/junit-team/junit4) - a simple framework to write repeatable tests. It is an instance of the xUnit architecture for unit testing frameworks.
-   [Mockk](https://github.com/mockk/mockk) - provides DSL to mock behavior. Built from zero to fit Kotlin language.
-   [AndroidX](https://github.com/android/android-test) - the androidx test library provides an extensive framework for testing Android apps.

### Plugins

-   [Ktlint](https://github.com/pinterest/ktlint) - an anti-bikeshedding Kotlin linter with built-in formatter.
-   [Detekt](https://github.com/arturbosch/detekt) - a static code analysis tool for the Kotlin programming language.
-   [Spotless](https://github.com/diffplug/spotless) - a code formatter can do more than just find formatting errors.
-   [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) - generates simple object and builder classes for type-safe navigation and access to any associated arguments.
-   [Jacoco](https://github.com/jacoco/jacoco) - code coverage library

## Contributions

Please contribute! We will gladly review any pull requests.
Make sure to read the [Contributing](CONTRIBUTING.md) page first though.
