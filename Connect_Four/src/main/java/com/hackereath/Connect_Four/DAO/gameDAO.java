package com.hackereath.Connect_Four.DAO;

import java.util.Optional;

public interface gameDAO {
    Optional StartTheGame();
    void UpdateDB(int[][] box);
    String InsertTheCoin(int column);
    char CheckWinner(int[][] box,char color,int column,int row);
}
