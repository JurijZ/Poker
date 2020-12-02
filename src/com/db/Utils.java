package com.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> ReadCardsFile(String path) {

        try{
            BufferedReader bufReader = new BufferedReader(new FileReader(path));
            ArrayList<String> listOfLines = new ArrayList<>();

            String line = bufReader.readLine();

            while (line != null) {
                listOfLines.add(line);
                line = bufReader.readLine();
            }

            bufReader.close();

            return listOfLines;
        }
        catch (IOException e){
            System.out.println(e);
        }
        return null;
    }

    public static List<Game> ExtractGames(List<String> list){
        List<Game> games = new ArrayList<Game>();

        list.forEach((l) -> {
            var cards = l.split(" ");

            Hand player1 = new Hand(cards[0], cards[1], cards[2], cards[3], cards[4]);
            Hand player2 = new Hand(cards[5], cards[6], cards[7], cards[8], cards[9]);

            var game = new Game(player1, player2);

            games.add(game);
        });

        return games;
    }
}
