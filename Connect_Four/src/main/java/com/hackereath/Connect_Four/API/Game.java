package com.hackereath.Connect_Four.API;

import com.hackereath.Connect_Four.Service.GameService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.hackereath.Connect_Four.ConnectFourApplication.gameLog;


@RequestMapping(value = "/API")
@RestController
public class Game {
    private final GameService GameService;

    @Autowired
    public Game(GameService gameService) {
        this.GameService = gameService;
    }

    @GetMapping("/START")
    ResponseEntity<String> StartTheGame() {
        GameService.StartTheGame();
        return new ResponseEntity<>(
                "Game is Ready" ,
                HttpStatus.OK);
    }
   /* @GetMapping(path = "START")
    public String StartTheGame()
    {
        gameLog.info("Started");
        GameService.StartTheGame();
        return "READY";
    }*/
    @PostMapping(path = "/Coin:{value}")
    public ResponseEntity<List<Integer>> InsertTheCoin(@PathVariable ("value") int column)
    {
        gameLog.info("Inserted");
        return new ResponseEntity<>(
                GameService.InsertTheCoin(column) ,
                HttpStatus.OK);
    }




}