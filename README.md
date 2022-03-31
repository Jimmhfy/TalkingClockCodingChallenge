
# TalkingClockCodingChallenge
Welcome to Talking Clock Coding Challenge. 
Gradle run command line is available to this project.

There are three option to choose in command line.

(Option 1) Objective 1: Print out current time 
(Option 2) Objective 2: Covert time by user input
(Option 3) Objective 3: Start Spring and get convert time by Restful API

Command line example:
Please select 1-3 option. To exit, input q
-----------------------------------------------------------
Objective 1: Print out current time
Objective 2: Covert time by user input
Objective 3: Start Spring and get convert time by Restful API
-----------------------------------------------------------

Example of output:
1:00  -> One o'clock
13:00 -> One o'clock
13:15 -> Quarter past one
13:30 -> Half past one
13:45 -> Quarter to two
23:59 -> One to twelve
00:31 -> Twenty nine to one
00:59 -> One to one

For objective 3, there are two Rest API to use:
1. GET Method from: http://localhost:8080/getTime?time=<time>
  - API: http://localhost:8080/getTime?time=12:30
  - Body: No Body Needed
  
2. GET Method from: http://localhost:8080/getTimeWithBody
  - API: http://localhost:8080/getTimeWithBody
  - Body: 12:30
  
Noted that: Port number may be various from default 8080.
