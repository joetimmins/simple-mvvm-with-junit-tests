# Simple MVVM, with JUnit tests
The official Android codelab for testing view models https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-basics/index.html#0 implies that you have to use an Android test runner and run tests on a device or emulator.

This is slow, and can be flaky.

This repo is intended to show how `InstantTaskExecutorRule` can be used to test view models / live data from plain old JUnit.
