import Models.UserInfo;
import Models.UserInfos;

public class App {

    public static void main(String[] args) {

        UserInfo UI1 = new UserInfo("Web Site", "user", "123456");
        UserInfo UI2 = new UserInfo("Mobile Application", "mobil_user", "123456");
        UserInfo UI3 = new UserInfo("Game", "gamer", "123456");

        UserInfos Database = new UserInfos();
        Database.Add(UI1);
        Database.Add(UI1);
        Database.Add(UI2);
        Database.Add(UI3);

    }

}
