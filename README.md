# Pyramid-Academy-Team-Schedule-Project
Team schedule project repo

## Members
- riboney
- CBush88
- ijanett
- ramaunk
![Schedule Project](https://user-images.githubusercontent.com/109172533/186980121-54c9e4e4-39a6-4fa1-b873-b8ab41dbb5e5.png)

Assumptions:
Times will generally be of the length given in the input
There should be no gaps between events and lunch
Events can end in the afternoon any time between 4:00 and 5:00PM
Networking event starts immediately after the final event of the day

Design:
Talks are read from input file and transformed into objects with title and duration attributes
Largest duration first filling algorithm for each session
Avoids 45 minute blocks when it will create a scheduling problem
Output to JavaFX window
