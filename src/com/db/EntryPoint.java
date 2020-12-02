package com.db;

import java.util.List;

public class EntryPoint {

    public static void main(String[] args) {

        // Read the data from the file into a list
        var list = Utils.ReadCardsFile("src/p054_poker.txt");

        // Create a list of games
        List<Game> games = Utils.ExtractGames(list);

        // Process each game
        Rules rules = new Rules();
        Integer player1Wins = 0;
        Integer player2Wins = 0;
        Integer equals = 0;

        for(Game g: games){
            var p1rank = rules.RankEvaluator(g.P1);
            var p2rank = rules.RankEvaluator(g.P2);

            if (p1rank > p2rank){
                player1Wins++;
            }
            else if (p1rank < p2rank) {
                player2Wins++;
            }
            else {
                // If ranks are equal then extra checks are needed
                var winner = rules.EqualRankEvaluator(p1rank, g.P1, g.P2);
                if (winner == -1){
                    player1Wins++;
                } else if (winner == 1){
                    player2Wins++;
                }
                else {
                    equals++;
                }
            }
        };

        System.out.println("Player1 wins: " + player1Wins);
        System.out.println("Player2 wins: " + player2Wins);
        System.out.println("Equals: " + equals);
    }
}
