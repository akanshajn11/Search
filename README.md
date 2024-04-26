# Android Application to search content using Jetpack Compose


## Architecture

This application is built using the **MVVM architecture** pattern. The separation of concerns is implemented using Models, Views, ViewModels.

**Views**

Views handle only the immediate interactions with the user. They only display data which they get from ViewModel. They take the user input and provide it to the ViewModel.

In this application, we have the MainActivity as View. The UI is designed in Jetpack Compose. The MainActivity sets the content for the Compose screen. To show different states and components on the screen, views are added in the design package.

**ViewModel**

Views make a call to ViewModel for data. Viewmodel acts as a glue between View and business logic. In this application, MainViewModel provides data to the MainActivity by getting it from the OrderDataGenerator.

**LiveData**

LiveData is lifecycle aware library for creating observables. Since it is lifecycle aware it will not notify about data changes if the View where it is observed is destroyed. 

Views observe LiveData from the ViewModel to display data on the UI.

This application also has following features of LiveData.

- MediatorLiveData: To observe changes in multiple LiveData objects simultaneously.
- Transformations:  To transform the data emitted by LiveData object in required form.

**Model**

Models are used for data flow in the application. In this application, OrderDataGenerator is used as a mock service to fetch data with some delay. Models are added to map the data from mock service and to map different screen states.  




 
