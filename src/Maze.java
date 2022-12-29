import java.util.Arrays;
import java.util.Objects;

//Labyrinth Klasse in der die Funktionen und Werete von den Labyrinten gespeichert werden
public class Maze {

    char[][] maze;

    char[][] path;

    BB8 runner;
    int endX;
    int endY;

    int lastX;
    int lastY;




    public Maze(BB8 runner,char[][] maze){
        this.runner = runner;
        this.maze = maze;
    }

    public void run(){
        int turn = 0;
        setEnd();
        System.out.println("Folgendes Labyrinth wird gelöst:");
        printMaze();
        setRunnerPosition();
        updateRunnerPosition();

        while (!completed()) {

            turn++;
            System.out.println("Schritt " + turn + ":");
            printMaze();
            turnRunner();
            updateRunnerPosition();
            moveRunner();


            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


        turn++;
        System.out.println("\n\nSchritt " + turn+ ":");
       // lookForPath();
        updateRunnerPosition();
        printMaze();
        moveRunner();

    }
    private void moveRunner(){
        int tempX = runner.getPosX();
        int tempY = runner.getPosY();


        switch (runner.getVD()) {
            case "north" : tempY -= 1;
                break;
            case "east" : tempX += 1;
                break;
            case "south" : tempY += 1;
                break;
            case "west" : tempX -= 1;
        }



        if(tempY < 0 || tempY > maze.length - 1|| tempX < 0 || tempX > maze[0].length - 1 || maze[tempY][tempX] == '.') {
            updateRunnerPosition();

            return;
        }


        if(tempY != runner.getPosY() || tempX != runner.getPosX()) maze[runner.getPosY()][runner.getPosX()] = ' ';



        lastX = runner.getPosX();
        lastY = runner.getPosY();
        runner.setPos(tempY,tempX);
        updateRunnerPosition();

    }

    private void turnRunner(){
        int x = runner.getPosX();
        int y = runner.getPosY();

        switch (runner.getVD()) {

            case "north" :
                if (maze[y][x+1] == ' ' || maze[y][x+1] == 'E') runner.turnRight();
                else if(y - 1 < 0) runner.turnLeft();
                else if(maze[y - 1][x] == '.')runner.turnLeft();

                break;

            case "east" :
                if(maze[y+1][x] == ' ' || maze[y+1][x] == 'E') runner.turnRight();
                else if(x +1 >= maze.length - 1 ) runner.turnLeft();
                else if (maze [y][x+1] == '.')runner.turnLeft();
                break;
            case "south" :
                if(maze[y][x-1] == ' ' || maze[y][x-1] == 'E' ) runner.turnRight();
                else if(y + 1 >= maze.length -1) runner.turnLeft();
                else if(maze[y + 1][x] == '.')runner.turnLeft();
                break;
            case "west" :
                if(maze[y-1][x] == ' ' || maze[y-1][x] == 'E')runner.turnRight();
                else if(x - 1 < 0) runner.turnLeft();
                else if(maze[y][x - 1] == '.')runner.turnLeft();


                }



        }



    //Methode zur Ausgabe des Labyrinths
    private void printMaze(){

        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Funktion zur bestimmung der Startposition von BB8
    private void setRunnerPosition(){
        int temp;
        for(int i = 0; i < maze.length; i++){
            if(maze[i][0] == 'A') {
                runner.setPos(i,0);
            }
        }

    }

    private void updateRunnerPosition(){

        maze[runner.getPosY()][runner.getPosX()] = runner.printCharacter();

    }

    private boolean completed() {

        if(runner.getPosX() == endX && runner.getPosY() == endY) {
            return true;
        }

        return false;
    }



    private void setEnd(){
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++){
                if(maze[i][j] == 'E') {
                    endX = j;
                    endY = i;
                }
            }
        }
    }



}
