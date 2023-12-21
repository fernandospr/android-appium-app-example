This is the companion app for the [appium-tests-example](https://github.com/fernandospr/appium-tests-example) project.

## appium-tests-android-app-example

All screens contain at least one text field, a Set button and a Delete button. The view is bound to the `Item` class.

Clicking Set will set the value of the Item.

Clicking Delete will blank the value of the Item.

### How to run the app

1. Clone this repository.
2. Open it in Android Studio.
3. Run the app in a device/emulator.

### Project content

* Android View Folder
	* Single Item: shows a single item.
	* Three Items: shows three items.
	* Multiple Items: shows a hundred items using a `RecyclerView`.

* Compose Folder
	* Single Item: shows a single item.
	* Three Items: shows three items.
	* Multiple Items: shows a hundred items using a `LazyColumn`.

### Repeated IDs
Using [Appium Inspector](https://github.com/appium/appium-inspector), inspect the screens containing more than an item, you'll notice the IDs are repeated.

Check the [appium-tests-example](https://github.com/fernandospr/appium-tests-example) project to see a way to obtain the desired views despite the IDs are repeated.


### Compose considerations to enable Appium tests

Checking the code, you'll notice the following:

* Using `Modifier.semantics { testTagsAsResourceId = true }` in a container view.
* Using `Modifier.testTagWithPackage("some_id")` on each composable.

These are necessary to enable Appium find the composables by ID.
