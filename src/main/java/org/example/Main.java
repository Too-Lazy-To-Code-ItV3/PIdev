package org.example;

import Interfaces.AllUsersInterface;
import Interfaces.BanInterface;
import Models.AllUsers;
import Models.Ban;
import Models.Logged;
import Services.AllUsersService;
import Services.BanService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;



public class Main {
    public static void main(String[] args) throws SQLException {
        AllUsersInterface au = new AllUsersService();
       /* BanInterface Ba = new BanService();

        //INTI CLASSES
        AllUsers u0,u,u1;
        Ban B,B1;
        u0 = new AllUsers("lefoulen", "foulen ","anothernickname123", "mecoba2403@laserlip.com", LocalDate.of(2000,9,9), "PASSWORDENCRYPTED", "Tunisian", "Artiste");
        //add action
        au.CreateAU(u0);
        u = new AllUsers("USERNAME", "USERLASTNAME ","anothernickname1234567", "hekenoh478@laserlip.com", LocalDate.of(2000,9,9), "PASSWORDENCRYPTED", "Tunisian", "Artiste");
        //add action
        au.CreateAU(u);
        //READ
        System.out.println("SOUT AFTER CREATING USER");
        System.out.println(au.fetchAU());
        //Edit
        u1=new AllUsers("lefoulen", "foulen ","anothernickname23", "balig15132@jobsfeel.com", LocalDate.of(2000,9,9), "PASSWORDENCRYPTED", "Tunisian", "Artiste");
       au.ModifyAu(u1,4);
        System.out.println("SOUT AFTER MODIFYING USER");
        System.out.println(au.fetchAUbyID(4));

        //DELETE
        au.DeleteAu(4);
        System.out.println("SOUT AFTER DELETING USER");
        System.out.println(au.fetchAU());
        //ADD BAN
        B=new Ban(9,"RUDE to users");
        Ba.AddBan(B);
        System.out.println("SOUT AFTER CREATING BAN");
        System.out.println(Ba.fetchBan());
        //EDIT
        B1=new Ban(9,"REASON3");
        Ba.ModifyBan(B1,9);
        System.out.println("SOUT AFTER ModifyING BAN");
        Ba.fetchBanbyIDUser(9);
        //DELETE BAN
        Ba.DeleteBan(2);
        System.out.println("SOUT AFTER DELETING BAN");
        System.out.println(Ba.fetchBanbyIDUser(9));*/
       /* final String ACCOUNT_SID = "AC4730297eb72be182dde74c2a2143deb8";
        final String AUTH_TOKEN = "fba49a82e157a83953c49896694c44ec";


            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber("+21624800307"),
                            new com.twilio.type.PhoneNumber("+12764448061"),
                            "How yikhdem impossible !!!!")
                    .create();

            System.out.println(message.getSid());*/

      //AllUsers u1;
       // u1=new AllUsers("foulen","benfoulen","CRAZY1","foulen@gmail.com",LocalDate.of(2000,9,9),"123456789","Tunisian","Artiste");
        //au.AddAu(u1);
      System.out.println(au.login("CRAZY","AZERTY123456"));
        //System.out.println(au.login("CRAZY1","123456789"));
        System.out.println(Logged.get_instance().getUser().getEmail());




    }
}