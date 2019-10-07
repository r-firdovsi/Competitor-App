package Util;

import beans.User;
import config.Config;

import java.util.Scanner;

public class UserUtil {
    public static User login(String username, String password) {
        if("Firdovsi".equals(username) && "Parol258".equals(password)) {
            User user = new User(username, password);
            return user;
        };

        throw  new IllegalArgumentException("Username or password is incorrect");
    }

    public static User requireInputAndLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please write your username");
        String username = scanner.nextLine();

        System.out.println("Please write your password");
        String password = scanner.nextLine();

        User user = UserUtil.login(username, password);
        Config.setUser(user);
        return user;
    }

    public static User requireInputAndLogin(int tryCount, boolean throwException) {
        for(int i=0;i<tryCount;i++) {
            try {
                User user = requireInputAndLogin();
                return user;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again!");
            }

        }

//        throw new IllegalArgumentException("You have bannd!"); // System seviyyesinde xeta cixairi
        if(throwException) {
            System.out.println("You have banned");
            System.exit(-1);
        }
        return null;
    }
}
