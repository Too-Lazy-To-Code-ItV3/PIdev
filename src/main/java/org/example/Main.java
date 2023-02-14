package org.example;

import Interfaces.AllUsersInterface;
import Models.AllUsers;
import Services.AllUsersService;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AllUsersInterface au = new AllUsersService();

        //player init
        AllUsers u;
        u = new AllUsers("NAMEMMM3", "LAST NAMEMMMM3 ", "EMAILMM2MMMMM@gmail.com", new Date(2008, 1, 20), "PASSWDMMMMM3", "MMNATIONALITYMMM3", "MMMTYPEMMM3");
        //add action
        // au.AddAu(u);

        //select
        au.ModifyAu(u, 3);
        au.DeleteAu(1);
        System.out.println(au.fetchAU());
        System.out.println(au.fetchAUbyID(4));


    }
}