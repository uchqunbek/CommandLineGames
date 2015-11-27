package uz.unicon.clg;


import javafx.application.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CommandLineGame[] games = new CommandLineGame[]{new FindNumber(), new FindCellNumbers()};
        GameStat gameStat = new GameStat();

        int gamesPlayed = 1;
        int winNumber = 1;

        while (true) {


            for (int x = 1; x <= games.length; x++) {
                System.out.println(x + ". " + games[x - 1].getGameName());
            }

            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose game: ...");
            int chooseGame = scanner.nextInt();
            System.out.println("Choosen game = " + games[chooseGame].getGameName());

            gameStat.setGamesPlayed(gamesPlayed++);
            if (games[chooseGame].run())
                gameStat.setWinNumber(winNumber++);


            System.out.println("Games Played = " + gameStat.getGamesPlayed());
            System.out.println("Win Number = " + gameStat.getWinNumber());

        }


//            /**
//             * TODO: 1. O'yinlar ro'yxatini raqamlangan holda, nomlari bilan ekranga chiqaring va foydalanuvchidan o'yin raqamini kiritishni so'rang. Raqam kiritilgandan so'ng, ushbu raqam ostidagi o'yinni ishga tushiring.
//             * TODO: 2. O'ynalgan o'yinlar soni va g'alabalar sonini saqlaydigan hisobot olib boruvchi klass yarating va ishga tushiring.
//             * */


    }
}
