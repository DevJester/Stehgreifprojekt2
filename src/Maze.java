//Labyrinth Klasse in der die Funktionen und Werete von den Labyrinten gespeichert werden
public class Maze {

    char[][] maze;

    BB8 runner;
    Map map;
    int endX;
    int endY;
    boolean skipMove = false;





    public Maze(BB8 runner,char[][] maze){
        this.runner = runner;
        this.maze = maze;
        this.map = new Map(maze.length, maze[0].length);
    }

    //Hier wird der Lösungsverlauf gestartet
    public void run(){
        int turn = 0;
        setEnd();
        System.out.println("Folgendes Labyrinth wird gelöst:");
        printMaze();
        setRunnerPosition();
        updateRunnerPosition();

        while (!completed()) {

            turn++;
            System.out.println("\nSchritt " + turn + ":");
            turnRunner();
            updateRunnerPosition();
            map.addToMap(runner.getPosY(),runner.getPosX(),runner.printCharacter());
            printMaze();


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        turn++;
        System.out.println("\nSchritt " + turn+ ":");
        updateRunnerPosition();
        printMaze();
        moveRunner();

        System.out.println("\nIch bin wie folgt an das Ziel gekommen:");
        map.printMap();
    }

    //Funktion, die BB8 bewegt
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

        if(tempY < 0 || tempY > maze.length - 1|| tempX < 0 || tempX > maze[0].length - 1) {
            updateRunnerPosition();
            return;
        }

        if(tempY != runner.getPosY() || tempX != runner.getPosX()) maze[runner.getPosY()][runner.getPosX()] = ' ';

        runner.setPos(tempY,tempX);
        updateRunnerPosition();

    }

    //Methode zum Überprüfen, ob BB8 sich drehen muss, um weiterzukommen
    private void turnRunner(){
        int x = runner.getPosX();
        int y = runner.getPosY();

        switch (runner.getVD()) {

            case "north" :
                if (x + 1 != runner.getPreviousX()  && maze[y][x+1] == ' ' || maze[y][x+1] == 'E') runner.turnRight();
                else if(maze[y - 1][x] == '.')runner.turnLeft();
                else if(maze[y-1][x] == ' ' || maze[y-1][x] == 'E') moveRunner();
                break;

            case "east" :
                if(y + 1 != runner.getPreviousY() && maze[y+1][x] == ' ' || maze[y+1][x] == 'E') runner.turnRight();
                else if (maze [y][x+1] == '.')runner.turnLeft();
                else if(maze[y][x+1] == ' ' || maze[y][x+1] == 'E') moveRunner();
                break;
            case "south" :
                if( x-1 != runner.getPreviousX() && maze[y][x-1] == ' ' || maze[y][x-1] == 'E' ) runner.turnRight();
                else if(maze[y + 1][x] == '.')runner.turnLeft();
                else if(maze[y+1][x] == ' ' || maze[y+1][x] == 'E') moveRunner();
                break;
            case "west" :
                if( y-1 != runner.getPreviousY() && maze[y-1][x] == ' ' || maze[y-1][x] == 'E')runner.turnRight();
                else if(maze[y][x - 1] == '.')runner.turnLeft();
                else if(maze[y][x-1] == ' ' || maze[y][x-1] == 'E') moveRunner();
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

    //Methode die BB8 seine neue Position zuteilt, falls er sich bewegen kann
    private void updateRunnerPosition(){

        maze[runner.getPosY()][runner.getPosX()] = runner.printCharacter();

    }

    //Methode die überprüft, ob BB8 sich auf dem Ziel befindet
    private boolean completed() {

        if(runner.getPosX() == endX && runner.getPosY() == endY) {
            return true;
        }

        return false;
    }

    //Methode welche die Koordinaten vom ziel bestimmt
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
