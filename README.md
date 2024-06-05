# Mars Rover 

## Acknowledgements 
This project is part of the Java Development Bootcamp at Northcoders. I would like to formally thank Simon Morgan, Chris Ward, Alex Davis and Neil Hughes for their guidance for this project and throughout the bootcamp.

## Introduction
Nasa has recently launched one of their rover's to mars to gather samples for research. It is going to reach the red planet shortly, and we must specify the coordinates of the research area (the plateau) the starting location of the rover and the direction it will be facing when it lands. We must also transmit a list of instructions for it to perform when it arrives.
The project should fail gracefully when exceptions occur and give you the chance to repeat inputs when you fail to give them in the correct format. The project should be structured in such a way as to extensible with maybe a goal of sending various types of vehicles to on it's dusty hills.

## Flow of the program
This section will lead you through what the program will do as a user at each stage.
### Getting plateau size
The program will start with prompting you for the size of the research area you are considering with where you will input two numbers telling you the maximum coordinate size on the research area. The two numbers must be integers between one and five (inclusive). This will be written in the form of "[int][space][int]". If, for example, we put in the input "5 5" we would get part of the integer lattice formed by {0,1,2,3,4,5} x {0,1,2,3,4,5} giving a total of 36 possible locations in the research area. 

Any deviation from the rules and it will query you again; it is a billion dollar mission after all so we must get our inputs correct.

### Getting the rovers starting location
Now that we have defined our location we will now query for a starting location for the rover. This should take the form of "[int][space][int][space][First letter of compass direction (capital)]" any deviation will result an being queried for the input again the same as last time. However this will tell you if the format was wrong or if the location was not valid i.e. not in the plateau.

### Getting the list of instructions
You will now be queried to give a list of instructions which should be a string of built out of the characters 'L', 'M' and 'R'. The rover will read from left to right and turning left 90 degrees when it sees an 'L' and right 90 degrees when it sees an 'R' and move forward one coordinate when it sees an 'M'. The program will check the input is in the correct format and will query you again if the format is incorrect.

### Executing the instructions
The rover will start reading your instruction string from right to left and perform the actions that have been assigned , if the rover will be out of bounds it will perform an emergency stop and announce its position. If there is no emergency stop it will complete all instructions and announce its position.
