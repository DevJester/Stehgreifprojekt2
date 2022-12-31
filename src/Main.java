import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int mazeNumber;
        Maze maze;

        char[][] maze1 = {
                {'.','.','.','.','.'},
                {'.',' ','.','.','.'},
                {'.',' ',' ',' ','A'},
                {'B',' ','.','.','.'},
                {'.','.','.','.','.'}
        };

        char[][] maze2 = {
                {'.','.','.','.','.','.','.','.'},
                {'.',' ',' ',' ','.','.','.','.'},
                {'.',' ','.','.','.','.',' ','A'},
                {'.',' ',' ',' ',' ',' ',' ','.'},
                {'.',' ','.','.','.','.','.','.'},
                {'.',' ','.','.','.','.','.','.'},
                {'B',' ','.','.','.','.','.','.'},
                {'.',' ',' ','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},

        };

        char[][] maze3 = {
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.',' ',' ',' ',' ','.','.','.','.','.'},
                {'B',' ','.',' ',' ','.','.','.','.','.'},
                {'.',' ','.',' ','.','.','.','.','.','.'},
                {'.',' ','.',' ','.','.','.','.','.','.'},
                {'.',' ','.',' ',' ',' ',' ',' ',' ','A'},
                {'.',' ','.','.',' ','.','.','.',' ','.'},
                {'.',' ',' ',' ',' ',' ','.','.',' ','.'},
                {'.','.','.','.','.','.','.','.','.','.'},

        };


        System.out.println("Folgende Labyrinthe stehen zur verfügung:");


        System.out.println("Labyrinth 1:");
        printMaze(maze1);
        System.out.println("Labyrinth 2:");
        printMaze(maze2);
        System.out.println("Labyrinth 3:");
        printMaze(maze3);
        System.out.println("Welches Labyrinth soll von BB8 gelöst werden?");
        System.out.print("Labyrinth: ");
        mazeNumber = input.nextInt();
        while(mazeNumber < 1 || mazeNumber > 3) {
            System.out.println("Ungültige angabe, bitte eine Zahl von 1-3 angeben.");
            System.out.print("Labyrinth: ");
            mazeNumber = input.nextInt();
        }

        switch (mazeNumber) {
            case 1 :
                maze = new Maze(maze1);
                maze.run();
                break;
            case 2:
                maze = new Maze(maze2);
                maze.run();
                break;
            case 3:
                maze = new Maze(maze3);
                maze.run();
                break;
        }


    }


    public static void printMaze(char[][] maze){

        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }


}