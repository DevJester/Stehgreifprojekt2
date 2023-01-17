import java.util.Arrays;
//Map Klasse, in der die schritte, die von BB8 gemacht wurden gespeichert werden
public class Map {
    char[][] map;

    public Map(int y, int x){
        this.map = new char[y][x];
        fillMap();
    }


    //Methode um die Karte vorerst mit leeren feldern zu füllen
    private void fillMap(){

        for(int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], ' ');
            System.out.println();
        }
    }

    //Methode zur ausgabe der Karte in Text form in der Konsole
    public void printMap(){
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //HIer kann ein schritt der gemacht wurde der Karte hinzugefügt werden
    public void addToMap(int y, int x, char runner) {
        map[y][x] = runner;
    }
}
