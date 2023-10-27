import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.crypto.Data;

import Models.UserInfo;
import Models.UserInfos;

public class Application {

    UserInfos Database;
    String DatabaseFile = "";

    public Application() {
        this.Database = new UserInfos();
        this.DatabaseFile = System.getProperty("user.dir");
        this.DatabaseFile += "/database.db";

        this.Boot();
    }

    private void Boot(){
        this.Lood();
    }

    private void Lood(){
        File file = new File(this.DatabaseFile);
        
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                System.err.println(e.getMessage());
            }
        }else{
            try {
                Database.Load(
                    Files.readString(Paths.get(this.DatabaseFile))
                );
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
    
    public void Run(){

        UserInfo UI1 = new UserInfo("Web Site", "user", "123456");
        UserInfo UI2 = new UserInfo("Mobile Application", "mobil_user", "123456");
        UserInfo UI3 = new UserInfo("Game", "gamer", "123456");

        Database.Add(UI1);
        Database.Add(UI2);
        Database.Add(UI3);

        try {
            FileWriter writer = new FileWriter(this.DatabaseFile);
            writer.write(Database.Save());
            writer.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
    }

}
