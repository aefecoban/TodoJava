package Models;

import java.util.ArrayList;

import javax.swing.DebugGraphics;

import com.google.gson.Gson;

public class UserInfos {
    
    ArrayList<UserInfo> infos = new ArrayList<UserInfo>();
    Gson gson = new Gson();

    public UserInfos() {
        this(new ArrayList<UserInfo>());
    }

    public UserInfos(ArrayList<UserInfo> infoFromOutside) {
        infos = infoFromOutside;
    }

    public int size(){
        return infos.size();
    }

    public void Add(UserInfo ui){
        if(!this.infos.contains(ui))
            this.infos.add(ui);
    }

    public void Remove(UserInfo ui){
        if(this.infos.contains(ui))
            this.infos.remove(ui);
    }

    public void Remove(int ID){
        if(ID < this.infos.size())
            this.infos.remove(ID);
    }

    public UserInfo Get(int ID){
        return this.infos.get(ID);
    }

    public UserInfo Get(String Title){
        for (UserInfo userInfo : infos) {
            if(userInfo.Title == Title){
                return userInfo;
            }
        }
        return null;
    }

    public ArrayList<UserInfo> Search(String SearchText){
        ArrayList<UserInfo> results = new ArrayList<UserInfo>();

        for (UserInfo userInfo : infos) {
            if(
                userInfo.Title.contains(SearchText) ||
                userInfo.Username.contains(SearchText) ||
                userInfo.Email.contains(SearchText) ||
                userInfo.Password.contains(SearchText) ||
                userInfo.Desc.contains(SearchText)
            )
                results.add(userInfo);
        }

        return results;
    }

    public void Load(String Json){
        System.out.println("Json");
        System.out.println(Json);
        ArrayList<UserInfo> buff = gson.fromJson(Json, this.infos.getClass());
        if(buff != null){
            this.infos = buff;
        }
    }

    public String Save(){
        return gson.toJson(this.infos);
    }

}
