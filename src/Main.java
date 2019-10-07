import Util.MenuUtil;
import Util.UserUtil;
import beans.User;

public class Main {
    public static void main(String[] args) {
        User user = UserUtil.requireInputAndLogin(1, true);
        System.out.println("Hello, "+ user.getUsermane());
        MenuUtil.showMenuInfinite();
    }
}
