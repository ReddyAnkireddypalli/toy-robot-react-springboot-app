# toy-robot-react-springboot
# Toy Robot

In this React project, we have a toy robot that can be placed anywhere on a 5 x 5 tabletop. 
With it's state-of-the-art artificial intelligence, it is impossible for the robot to fall off the table even when it is commanded to do so.

## Getting Started

Below are some simple instructions to make sure you're able to run this project.

### Prerequisites

To run this, you will need to have Java8, Maven, Nodejs installed to use npm. Once you've navigated to the folder with the project, run the action below.

```
>mvn clean install

```

This will allow your computer to download all the dependencies I use throughout the project and generate .jar file with react and spring boot files.

### Running the Program

To run the Toy Robot Application, you will need to run the following command

```
>java -jar target/toy-robot-0.0.1-SNAPSHOT.jar

```
It starts the application...

Then you have to paste this url `http://localhost:8080` into browser, it opens application.

## How to Play the Game

These are the following commands for this game:

- PLACE X,Y,F
- MOVE
- LEFT
- RIGHT
- REPORT

Once one of these valid commands are typed into the input at the top of the page, the command will be executed. Read below for details on each command.

### PLACE X,Y,F

The **PLACE X,Y,F** command places our robot onto the board. Valid X and Y values range from 0 to 5. Any other value will be ignored because of the robot's advanced AI.

F stands for what direction the robot is facing. The valid facing directions are:

- North
- East
- South
- West

All other actions specified above cannot be executed until the robot is placed on the tabletop.

You are allowed to re-place the robot at any time.

### MOVE

The **MOVE** command moves the robot one unit forward in the direction it is facing. If the move moves the robot off the board, the command is ignored.

### LEFT

The **LEFT** command changes the direction the robot is facing by 90 degrees to the left.

For example, if facing North and given the LEFT command, the robot will now be facing West.

### RIGHT

The **RIGHT** command changes the direction the robot is facing by 90 degrees to the right.

For example, if facing North and given the RIGHT command, the robot will now be facing East.

### REPORT

The **REPORT** command prints the current location of the robot to the screen.

## Test Data

Here are some examples of commands to give to the robot, and the corresponding output.

```
  •	place 0,0,NORTH
  •	move
  •	report => Output:0, 1, NORTH
  
  •	place 0, 0, NORTH
  •	left
  •	report => Output:0, 0, WEST
  
  •	place 1,2,EAST
  •	move
  •	move
  •	left
  •	move
  •	report => Output:3, 3, NORTH
```


## Built With

- [create-react-app](https://github.com/facebook/create-react-app) - Boiler plate for React
- [React](https://reactjs.org/) - JavaScript frontend framework
- [SpringBoot] (https://spring.io/projects/spring-boot) - Spring Boot framework

## Author

- **Reddy Ankireddypalli**

