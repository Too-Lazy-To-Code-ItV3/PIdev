/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author nour2
 */
public class allusers {

    private int ID_User;
    private String Name;
    private String Last_Name;
    private String Nickname;
    private String Email;
    private String Description ;

    public allusers() {
    }

    public allusers(int ID_User, String Name, String Last_Name, String Nickname, String Email, String Description) {
        this.ID_User = ID_User;
        this.Name = Name;
        this.Last_Name = Last_Name;
        this.Nickname = Nickname;
        this.Email = Email;
        this.Description = Description;
    }

    public allusers(String Name, String Last_Name, String Nickname, String Email, String Description) {
        this.Name = Name;
        this.Last_Name = Last_Name;
        this.Nickname = Nickname;
        this.Email = Email;
        this.Description = Description;
    }

    public int getID_User() {
        return ID_User;
    }

    public String getName() {
        return Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getNickname() {
        return Nickname;
    }

    public String getEmail() {
        return Email;
    }

    public String getDescription() {
        return Description;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "allusers{" + "ID_User=" + ID_User + ", Name=" + Name + ", Last_Name=" + Last_Name + ", Nickname=" + Nickname + ", Email=" + Email + ", Description=" + Description + '}';
    }

   

}
