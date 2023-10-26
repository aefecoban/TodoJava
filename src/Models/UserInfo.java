package Models;

public class UserInfo {

    public String Title;
    public String Username;
    public String Email;
    public String Password;

    public String Desc;

    public UserInfo() {
        this("", "", "", "", "");
    }

    public UserInfo(String Title, String Username, String Password) {
        this(Title, Username, Password, "", "");
    }

    public UserInfo(String Title, String Username, String Password, String Email) {
        this(Title, Username, Password, Email, "");
    }

    public UserInfo(String Title, String Username, String Password, String Email, String Desc) {
        this.Title = Title;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Desc = Desc;
    }

    @Override
    public String toString(){
        return "Title : " + Title + "\nUsername : " + Username + "\nEmail : " + Email + "\nPassword : " + Password + "\nDesc : " + Desc + "\n";
    }

}
