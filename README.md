# Simple MVVM, with JUnit tests
The official Android codelab for testing view models https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-basics/index.html#0 implies that you have to use an Android test runner and run tests on a device or emulator.

This is slow, and can be flaky.

This repo is intended to show how `InstantTaskExecutorRule` can be used to test view models / live data from plain old JUnit.

## Idea
LiveData / MVVM is an implementation of the Observer pattern, where the view (in this case, a super simple activity) observes data emitted from the view model. This is great for unit testing, as you can effectively replace the activity with a unit test. The file https://github.com/joetimmins/simple-mvvm-with-junit-tests/blob/master/app/src/test/java/com/example/simplemvvm/MainViewModelTest.kt in this project does that. The basic idea is:

- instantiate a view model in your test
- observe its LiveData field
- invoke the same functions on it that the UI layer would call
- remember to use `InstantTaskExecutorRule`, or nothing works
