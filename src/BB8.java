//BB8 Klasse die, die Funktionen und Werte des läufers enthält

public class BB8 {

    private int posX;
    private int posY;
    private String viewingDirection = "north";
    public BB8(){

    }



    public void setPos(int posY, int posX) {
        this.posX = posX;
        this.posY = posY;
    }


    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    //Funktion zur aktualisierung der Blickrichtung
    public void setVD(String viewingDirection){
        this.viewingDirection = viewingDirection;

    }

    public String getVD(){
        return  viewingDirection;
    }



    //Funktion zur Ausgabe des Läufers als Figur
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

}
