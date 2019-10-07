package Util;

import beans.Competitor;
import beans.User;
import config.Config;

import java.util.Scanner;

public class CompetitonUtil {
    public static Competitor[] registerCompetitors() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many competitors will participate in competition?");
        int competitorCount = scanner.nextInt();
        Competitor[] competitors = new Competitor[competitorCount];
        for (int i =0;i < competitorCount; i++ ) {
            Competitor competitor = registerCompetitor();
            competitors[i] = competitor;
        }
        Config.setCompetitors(competitors);
        System.out.println("All Competitors successfully registered!");
        return competitors;
    }

    public static Competitor[] registerCompetitorsAndShowInfo() {
        Competitor[] competitors = registerCompetitors();
        CompetitonUtil.printCompetitors(competitors);
        return competitors;
    }

    public static Competitor registerCompetitor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Competitor name:");
        String name = scanner.nextLine();

        System.out.println("Competitor surname:");
        String surname = scanner.nextLine();

        System.out.println("Competitor age:");
        int age = scanner.nextInt();

        Competitor competitor = new Competitor(name, surname, age);
        return competitor;
    }

    public static void printCompetitors(Competitor[] competitors) {
        if (competitors == null || competitors.length == 0) {
            return;
        }

        for(int i=0; i < competitors.length; i++) {
            Competitor c = competitors[i];
            System.out.println(c);
        }
    }

    public static void printCompetitors() {
        printCompetitors(Config.getCompetitors());
    }

    public static boolean startCompetition() {
        int winner = 2;
        System.out.println("Guess winner?");

        Scanner scanner = new Scanner(System.in);
        int guessedWinner = scanner.nextInt();

        if (guessedWinner == winner) {
            increasePoint();
            System.out.println("You won! Your point increase to "+ Config.getUser().getPoint());

            return true;
        } else {
            System.out.println("You faild!");

            return false;
        }
    }

    public static void increasePoint() {
        User user = Config.getUser();
        user.setPoint(user.getPoint()+10);
    }


    public static void showPoint() {
        System.out.println("Your Point:"+ Config.getUser().getPoint());
    }

    public static void increaseCompetitors() {
        Competitor[] competitors = Config.getCompetitors();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many competitors you want to append?");
            int increaseCount = scanner.nextInt(); //3
            Competitor[] competitorsNew = new Competitor[competitors.length+3];
            for (int i = 0; i < competitors.length; i++) {
                competitorsNew[i] = competitors[i];
            }

            for (int i =competitors.length; i < competitors.length+increaseCount;  i++) {
                competitorsNew[i] = registerCompetitor();
            }
    }
}
