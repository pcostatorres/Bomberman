package presentation.swing;

import presentation.Viewer;
import presentation.control.Cell;
import presentation.control.Level;
import javax.swing.*;
import java.awt.*;

public class BoardViewer extends JPanel
{

    private static final int ROWS = 13;
    private static final int COLUMNS = 31;

    private static final String BRICK_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Brick.png";
    private static final String SOLID_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Solid.png";
    private static final String EMPTY_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Empty.png";
    private static final String PLAYER_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_White.png";
    private static final String ENEMY1_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Ballom.png";
    private static final String BONUS_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Speed.png";
    private static final String GATE_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Mystery.png";
    private static final String BOMB_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Bomb.png";
    /*

    private static final String BRICK_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Brick.png";
    private static final String SOLID_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Solid.png";
    private static final String EMPTY_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Empty.png";
    private static final String PLAYER_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_White.png";
    private static final String ENEMY1_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Balloom.png";
    private static final String BONUS_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Speed.png";
    private static final String GATE_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Mystery.png";
    private static final String BOMB_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Bomb.png";


    /*
    private static final String BRICK_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Brick.png";
    private static final String SOLID_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Solid.png";
    private static final String EMPTY_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Empty.png";
    private static final String PLAYER_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_White.png";
    private static final String ENEMY1_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Balloom.png";

    /*
    private static final String BRICK_PATH = "/home/fgalvao/Dropbox/POO_1213_V/T3/images/Bomberman_Brick.png";
    private static final String SOLID_PATH = "/home/fgalvao/Dropbox/POO_1213_V/T3/images/Bomberman_Solid.png";
    private static final String EMPTY_PATH = "/home/fgalvao/Dropbox/POO_1213_V/T3/images/Bomberman_Empty.png";
    private static final String PLAYER_PATH = "/home/fgalvao/Dropbox/POO_1213_V/T3/images/Bomberman_White.png";
    */

    private ElementViewer[][] board = new ElementViewer[COLUMNS][ROWS];

    public BoardViewer()
    {
        setLayout(new GridLayout(ROWS, COLUMNS));
        initBoard();
        refreshLayout();
    }

    //Fill board with the initial state
    private void initBoard()
    {
        //Fill Edges
        for(int i = 0; i < COLUMNS; ++i)
        {
            board[i][0] = new ElementViewer(SOLID_PATH);
            board[i][ROWS-1] = new ElementViewer(SOLID_PATH);
        }
        for(int i = 1; i < ROWS-1; ++i)
        {
            board[0][i] = new ElementViewer(SOLID_PATH);
            board[COLUMNS-1][i] = new ElementViewer(SOLID_PATH);
        }
        for(int row = 0; row < ROWS; ++row)
        {
            for(int col = 0; col < COLUMNS; ++col)
            {
                if(row == 0 || col == 0 || row == ROWS-1 || col == COLUMNS-1)
                    board[col][row] = new ElementViewer(SOLID_PATH);
                else
                    board[col][row] = new ElementViewer(EMPTY_PATH);
            }
        }
    }

    public void refreshLayout()
    {
        removeAll();
        for(int row = 0; row < ROWS; ++row)
        {
            for(int col = 0; col < COLUMNS; ++col)
            {
                add(board[col][row]);
            }
        }
    }
    public void setBrick(int col, int row)
    {
        board[col][row] = new ElementViewer(BRICK_PATH);
    }
    public void setPlayer(int col, int row)
    {
        board[col][row] = new ElementViewer(PLAYER_PATH);
    }
    public void setEmpty(int col, int row)
    {
        board[col][row] = new ElementViewer(EMPTY_PATH);
    }

    public void setSolidPath(int col, int row)
    {
        board[col][row] = new ElementViewer(SOLID_PATH);
    }
    public void setEnemy(int col, int row)
    {
        board[col][row] = new ElementViewer(ENEMY1_PATH);
    }
    public void setBonus(int col, int row){
        board[col][row] = new ElementViewer(ENEMY1_PATH);
    }

    public void setGate(int col, int row){
        board[col][row] = new ElementViewer(ENEMY1_PATH);
    }

    public void setBomb(int col, int row){
        board[col][row] = new ElementViewer(ENEMY1_PATH);
    }

    public void writeLevel(Level level, BoardViewer viewer){
        Cell[][] levelInfo = level.getBoard();
        for(int i = 0; i<levelInfo.length;i++){
            for(int j =0; j<levelInfo[i].length; j++){
                levelInfo[i][j].printCell(viewer);
            }
        }
    }
}

