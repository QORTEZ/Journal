# Journal
Repository for Journal App as part of the requirements of  #7DaysOfCodeChallenge.<br>
This journal is an android application where in users can pen down their thoughts and feelings. Users can register and subsequently
sign in using their google accounts using google's firebase authentification. Once signed in, they can view their priviously recorded
experiences,events or thoughts. Similarly they can add new ones or edit the privously saved ones.
# Getting started
This software was developed using Android Studio IDE, so its recommended that the same IDE be used to view,test,modify,compile or build 
the code.
# Prerequisites
To install the app on a live device, you'll need: <br>
- An Android smartphone running Android Version 4.4 (KitKat).<br>

To install the app on a Computer for development purposes, you'll need:<br>
- A computer running Android Studio, with Google play services downloaded and installed.
# Installing
On an Android smart phone:<br>
- Download the apk provided onto your phone.<br>
- Tap to install and follow the prompts to install.<br>
- Tap the Sign In button to register with the app.<br>
- Enter your google account information to be registered and signed in.<br>
- Tap on + sign at the bottom of the screen to add to your journal or tap to a record to edit it.<br>

On a development environment:<br><br>
- Clone the project using the link of the resipotory to your Android studio or <br>
- Download the zipped file of the code from the repository and extract it to your local computer them import the project to Android Studio.<br>
- Clean build the project to download all the dependencies needed for the app to function correctly.
# Running Tests
The software comes with two in-built automated tests. One using Espresso for UI tests and the other running on Android's jUnitRunner for unit
tests.<br>
The tests can be run on a virtual or real device, by right clickingon the tests then choosing Run Test option.<br> <br>
AddEventScreenUITest<br>
- This test checks whether the UI of AddEventActivity is displayed on AddEventActivity launch. The test attempts to lauch the activity from
the main activity by clicking the floating action bar for add event. On the resulting screen it tries to check if the edittext where the 
event is to be typed exists or not, if exists, the test passes.<br>
This test is important as it is through which events and experiences atre typed into the system.<br>

MainActivityUnitTest<br>
- This test checks whether the MainActivity responsible for showing saved experiences successfully launches and display them.
The test launches the activity then checks whther the recler view for the events is displayed or not by checking  if its null.
If not null, the test passes.<br>
- The test is important because this unit is one of the most crucial for tha app. Its is where the 
events can be displayed, viewed and deleted.

# Deployment
The application will run smothly as long as the user has a google account and the phone meets the minimun
requirements (Android KitKat 4.4).

# Built with
The project is built with maven dependancies whose goal is to allow a developer to comprehend the complete state 
of a development effort in the shortest period of time. 

# Contributing
Any interested party is weelcomed to contribute to the project to suggest or implement new features. Simply send a message to US.

# Versioning <br>
Version 1.0.0
# Author
Rodgers Nyangweso (Qortez)
# License
This project is licensed under the MIT License
# Acknowledgments
- Udacity
- Google Africa Scholarship challenge
- Andela Lerning Community (ALC)



