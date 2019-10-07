package Util;

import java.util.Scanner;

public class MenuUtil {
    public static int showMenu() {
        System.out.println("Please select menu:");
        String menuStr = "1-Yarishmacilari daxil et\n2-Yarishmaya bashla\n3-Xalini oyren\n4-Ishtirakcilarin sayini artir\n5-Yarismacilarabax\n6-Logout\n";
        System.out.println(menuStr);
        Scanner scanner = new Scanner(System.in);

        int selectMenu = scanner.nextInt();
        if  (selectMenu > 0 && selectMenu < 6) {
            return selectMenu;
        } else {
            System.out.println("Invalid menu selected");
            return -1;
        }

    }

    public static int showMenuInfinite() {
        while(true) {
            int selectedMenu = showMenu();
            if (selectedMenu == 1) {
                CompetitonUtil.registerCompetitorsAndShowInfo();
            } else if (selectedMenu == 2) {
                CompetitonUtil.startCompetition();
            } else if (selectedMenu == 3) {
                CompetitonUtil.showPoint();
            } else if (selectedMenu == 4) {
                CompetitonUtil.increaseCompetitors();
            } else if (selectedMenu == 5) {
                CompetitonUtil.printCompetitors();
            } else if (selectedMenu == 6) {
                UserUtil.requireInputAndLogin(3, true);
            }
        }
    }
}
