package gui;

public class GameField {
    private Cell[][] gamefield;

    public GameField(int x, int y) {
        gamefield = new Cell[x][y];
        initField();
    }
    public void drawField(){
        for(int i = 0; i < gamefield.length; i++) {
            for(int j = 0; j < gamefield[i].length; j++) {
                gamefield[i][j].drawCell();
            }
            System.out.println();
        }
    }

    private void initField() {
        for(int i = 0; i < gamefield.length; i++) {
            for(int j = 0; j < gamefield[i].length; j++) {
                gamefield[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell[][] getGamefield(){
        return gamefield;
    }
}
