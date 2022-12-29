//BB8 Klasse die, die Funktionen und Werte des läufers enthält

public class BB8 {

    int posX;
    int posY;
    String viewingDirection = "east";
    public BB8(){

    }



    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }


    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }
}
