public class Main {

    public static void main(String[] args) {

        char[][] maze1 = {
                {'.','.','.','.','.'},
                {'.',' ','.','.','.'},
                {'.',' ',' ',' ','E'},
                {'A',' ','.','.','.'},
                {'.','.','.','.','.'}
        };

        char[][] maze2 = {
                {'.','.','.','.','.','.','.','.'},
                {'.',' ',' ',' ','.','.','.','.'},
                {'.',' ','.','.','.','.',' ','E'},
                {'.',' ',' ',' ',' ',' ',' ','.'},
                {'.',' ','.','.','.','.','.','.'},
                {'.',' ','.','.','.','.','.','.'},
                {'A',' ','.','.','.','.','.','.'},
                {'.',' ',' ','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},

        };

        char[][] maze3 = {
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.',' ',' ',' ',' ','.','.','.','.','.'},
                {'A',' ','.','.',' ','.','.','.','.','.'},
                {'.',' ','.','.','.','.','.','.','.','.'},
                {'.',' ','.','.','.','.','.','.','.','.'},
                {'.',' ','.','.',' ',' ',' ',' ',' ','E'},
                {'.',' ','.','.',' ','.','.','.','.','.'},
                {'.',' ',' ',' ',' ',' ','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},

        };


        BB8 runner = new BB8();
        Maze maze = new Maze(runner,maze1);


        maze.run();
    }


}