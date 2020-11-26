package com.hackereath.Connect_Four.DAO;

import java.util.List;
import java.util.Optional;

public interface gameDAO {
    Optional StartTheGame();
    List<Integer> UpdateDB(int[][] box);
    List<Integer> InsertTheCoin(int column);
    char CheckWinner(int[][] box,char color,int column,int row);
}
