package com.hackereath.Connect_Four.Service;
import com.hackereath.Connect_Four.DAO.gameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final gameDAO gameDAO;

    public GameService(gameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }
    public Optional StartTheGame()
    {
        return gameDAO.StartTheGame();
    }

    public List<Integer> InsertTheCoin(int column) {
        return gameDAO.InsertTheCoin(column);
    }
}
