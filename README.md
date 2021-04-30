Tic-Tac-Toe Kata
An application developed using Test Driven Development

To Run the application:
To download the project, simply open a terminal window and execute the below command:
git clone https://github.com/Sowmya-KJ23/2021-DEV1-048.git

To execute the tests:
cd to project directory and execute:
mvn test -Dtest=com.tictactoe.ApplicationTests

To Launch the API:
In a terminal, cd to project directory and execute:
mvn exec:java -Dexec.mainClass=com.tictactoe.Application

The API will be able at: http://localhost:8081/tic-tac-toe/ url

For a new game:
POST an empty body to http://localhost:8081/tic-tac-toe/game

To make a move:
POST to the URL http://localhost:8081/tic-tac-toe/move with the following body
'{"game" : {"id" : 1}, "cellNumber" : 5, "playerType" : "X"}' 
