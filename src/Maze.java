//Labyrinth Klasse in der die Funktionen und Werete von den Labyrinten gespeichert werden
public class Maze {

    char[][] maze;
    char[][] path;
    BB8 runner;


    public Maze(BB8 runner,char[][] maze){
        this.runner = runner;
        this.maze = maze;
    }

    public void run(){
        System.out.println("L");
    }

    //Methode zur Ausgabe des Labyrinths
    public void printMaze(){

        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

    }



}
