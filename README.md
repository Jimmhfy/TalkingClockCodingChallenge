
# TalkingClockCodingChallenge
Welcome to Talking Clock Coding Challenge. 

To run project, use 
  `gradle build` 
  `gradle run` or IDE.
  

There are three option to choose in command line.

(Option 1) Objective 1: Print out current time <br />
(Option 2) Objective 2: Covert time by user input <br />
(Option 3) Objective 3: Start Spring and get convert time by Restful API <br />

Command line example:<br />
Please select 1-3 option. To exit, input q <br />
-----------------------------------------------------------
Objective 1: Print out current time
Objective 2: Covert time by user input
Objective 3: Start Spring and get convert time by Restful API
-----------------------------------------------------------

Example of output:
1:00  -> One o'clock <br />
13:00 -> One o'clock <br />
13:15 -> Quarter past one <br />
13:30 -> Half past one <br />
13:45 -> Quarter to two <br />
23:59 -> One to twelve <br />
00:31 -> Twenty nine to one <br />
00:59 -> One to one <br />

For objective 3, there are two Rest API to use:
1. GET Method from: http://localhost:8080/getTime?time=<time>
  - API: http://localhost:8080/getTime?time=12:30
  - Body: No Body Needed
  
2. GET Method from: http://localhost:8080/getTimeWithBody
  - API: http://localhost:8080/getTimeWithBody
  - Body: 12:30
  
Noted that: Port number may be various from default 8080.
