package com.hackereath.Connect_Four.API;

import com.hackereath.Connect_Four.Service.GameService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import static com.hackereath.Connect_Four.ConnectFourApplication.gameLog;


@RequestMapping(value = "/API")
@RestController
public class Game {
    private final GameService GameService;

    @Autowired
    public Game(GameService gameService) {
        this.GameService = gameService;
    }

    @PostMapping(path = "START")
    public void StartTheGame()
    {
        gameLog.info("Started");
        GameService.StartTheGame();
    }
    @PostMapping(path = "/Coin:{value}")
    public String InsertTheCoin(@PathVariable ("value") int column)
    {
        gameLog.info("Inserted");
        return GameService.InsertTheCoin(column);
    }




}