//BB8 Klasse die, die Funktionen und Werte des läufers enthält

public class BB8 {

    private int posX;
    private int posY;

    private int previousX;
    private int previousY;
    private String viewingDirection = "north";
    public BB8(){
    }



    //Methode, um die neue Position von BB8 zu setzen, falls dieser sich bewegt, dazu wird die vorherige position zusätzlich gespeichert
    public void setPos(int posY, int posX) {
        previousX = this.posX;
        previousY = this.posY;
        this.posX = posX;
        this.posY = posY;
    }


    //Methode die die x position  von BB8 im Labyrinth ausgibt
    public int getPosX(){
        return posX;
    }

    //Methode die die y position  von BB8 im Labyrinth ausgibt
    public int getPosY(){
        return posY;
    }

    //Funktion, welche die blickrichtung von BB8 ausgibt
    public String getVD(){
        return  viewingDirection;
    }



    //Funktion zur Ausgabe von BB8 als char welcher je nach blickrichtung in eine andere Richtung zeigt
    public char printCharacter(){
        char character = ' ';
        switch (viewingDirection) {
            case "north" : character = '^';
            break;
            case "east" : character = '>';
            break;
            case "south" : character = 'v';
            break;
            case "west" : character =  '<';
            break;
    }

    return character;
    }

    //Funktion um die Blickrichtung von BB8 nach rechts zu drehen
    public void turnRight(){
        switch (viewingDirection) {
            case "north" : viewingDirection = "east";
                break;
            case "east" : viewingDirection = "south";
                break;
            case "south" : viewingDirection = "west";
                break;
            case "west" : viewingDirection = "north";
                break;
        }
    }

    //Funktion um die Blickrichtung von BB8 nach links zu drehen
    public void turnLeft(){
        switch (viewingDirection) {
            case "north" : viewingDirection = "west";
                break;
            case "east" : viewingDirection = "north";
                break;
            case "south" : viewingDirection = "east";
                break;
            case "west" : viewingDirection = "south";
                break;
        }
    }

    //Methode zur ausgabe der vorherigen x Koordinate
    public int getPreviousX(){
        return previousX;
    }

    //Methode zur ausgabe der vorherigen y Koordinate
    public int getPreviousY(){
        return previousY;
    }

}
