package Services;

import Interfaces.AllUsersInterface;
import Models.AllUsers;
import Models.Logged;
import Util.MyConnection;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.*;
import java.util.*;


public class AllUsersService implements AllUsersInterface {
    Connection cnx = MyConnection.getInstance().getCnx();


    @Override
    public String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    @Override
    public String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Base64.getDecoder().decode(salt));
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password: " + e.getMessage());
        }
    }

    @Override
    public void AddAu(AllUsers u) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(u.getPassword(), salt);
        try {
            String req = "INSERT INTO allusers(`Name`, `Last_Name`, `Email`, `Birthday`, `Password`,`Salt`, `Nationality`, `type`,`Nickname`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, u.getName());
            ps.setString(2, u.getLast_Name());
            ps.setString(3, u.getEmail());
            ps.setDate(4, u.getBirthday() != null ? Date.valueOf(u.getBirthday()) : null);
            ps.setString(5, hashedPassword);
            ps.setString(6, salt);
            System.out.println(hashedPassword);
            System.out.println(u.getPassword());
            ps.setString(7, u.getNationality());
            ps.setString(8, u.getType());
            ps.setString(9, u.getNickname());
            ps.executeUpdate();
            System.out.println("User Added Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void CreateAU(AllUsers u) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(u.getPassword(), salt);
        try {
            String req = "SELECT * FROM allusers WHERE nickname =? OR email =?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, u.getNickname());
            ps.setString(2, u.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                System.out.println("Error: email or nickname already in use.");

            String verificationCode = generateVerificationCode();
            sendVerificationCode(u.getEmail(), verificationCode);
            System.out.println("A verification email has been sent to your email address. Please check your email and follow the instructions to verify your account.");
            while (true) {
                System.out.println("Please enter the verification code you received by email:");
                Scanner scanner = new Scanner(System.in);
                String code = scanner.nextLine();

                // Check if verification code matches the one stored in the database

                if (verificationCode.equals(code)) {
                    // Verification successful, create user

                    req = "INSERT INTO allusers(`Name`, `Last_Name`, `Email`, `Birthday`, `Password`, `Nationality`, `type`,`Nickname`) VALUES (?,?,?,?,?,?,?,?)";
                    ps = cnx.prepareStatement(req);
                    ps.setString(1, u.getName());
                    ps.setString(2, u.getLast_Name());
                    ps.setString(3, u.getEmail());
                    ps.setDate(4, u.getBirthday() != null ? Date.valueOf(u.getBirthday()) : null);
                    ps.setString(5, hashedPassword);
                    System.out.println(hashedPassword);
                    System.out.println(u.getPassword());
                    ps.setString(6, u.getNationality());
                    ps.setString(7, u.getType());
                    ps.setString(8, u.getNickname());
                    ps.executeUpdate();
                    System.out.println("Account created successfully.");
                    return;


                } else {
                    System.out.println("Verification code is invalid. Please try again.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public void DeleteAu(int ID) throws SQLException {
        try {
            String req = "DELETE FROM allusers WHERE ID_User=" + ID;
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.executeUpdate();
            System.out.println("User  Deleted Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void ModifyAu(AllUsers u, int ID) throws SQLException {
        String salt = generateSalt();
        String hashedPassword = hashPassword(u.getPassword(), salt);
        try {
            String req = "UPDATE `allusers` SET `Name`=?,`Last_Name`=?,`Email`=?,`Birthday`=?,`Password`=?,`Nationality`=?,`type`=?,`Nickname`=? WHERE ID_User=" + ID;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, u.getName());
            ps.setString(2, u.getLast_Name());
            ps.setString(3, u.getEmail());
            ps.setDate(4, Date.valueOf(u.getBirthday()));
            ps.setString(5, hashedPassword);
            ps.setString(6, u.getNationality());
            ps.setString(7, u.getType());
            ps.setString(8, u.getNickname());
            ps.executeUpdate();
            System.out.println("User Modified Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<AllUsers> fetchAU() {
        List<AllUsers> Allusers = new ArrayList<>();
        try {

            String req = "SELECT * FROM allusers";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                AllUsers u = new AllUsers();
                u.setID_User(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setLast_Name(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5).toLocalDate());
                u.setPassword(rs.getString(6));
                u.setNationality(rs.getString(7));
                u.setType(rs.getString(8));
                u.setNickname(rs.getString(9));


                Allusers.add(u);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Allusers;
    }

    @Override
    public AllUsers fetchAUbyID(int ID) throws SQLException {
        AllUsers u = new AllUsers();
        try {

            String req = "SELECT * FROM allusers WHERE `ID_User`=" + ID;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setID_User(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setLast_Name(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5).toLocalDate());
                u.setPassword(rs.getString(6));
                u.setNationality(rs.getString(7));
                u.setType(rs.getString(8));
                u.setNickname(rs.getString(9));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public AllUsers fetchAUbyEmail(String Email) throws SQLException {
        AllUsers u = new AllUsers();
        try {

            String req = "SELECT * From allusers WHERE Email='" + Email + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setID_User(rs.getInt("ID_User"));
                u.setName(rs.getString("Name"));
                u.setLast_Name(rs.getString("Last_Name"));
                u.setEmail(rs.getString("Email"));
                u.setBirthday(rs.getDate("Birthday").toLocalDate());
                u.setPassword(rs.getString("Password"));
                u.setSalt(rs.getString("Salt"));
                u.setNationality(rs.getString("Nationality"));
                u.setType(rs.getString("Type"));
                u.setNickname(rs.getString("Nickname"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public AllUsers fetchAUbyNickname(String Nickname) throws SQLException {
        AllUsers u = new AllUsers();
        try {

            String req = "SELECT * FROM allusers WHERE Nickname='" + Nickname + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setID_User(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setLast_Name(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5).toLocalDate());
                u.setPassword(rs.getString(6));
                u.setSalt(rs.getString(7));
                u.setNationality(rs.getString(8));
                u.setType(rs.getString(9));
                u.setNickname(rs.getString(10));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    public void sendVerificationCode(String recipientEmail, String verificationCode) {
        String senderEmail = "adam.rafraf@esprit.tn"; // Change this to your own email address
        String senderPassword = "hijeoauapslyyqeh"; // Change this to your own email password
        String subject = "Verification Code";
        String message = "Your verification code is " + verificationCode;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Change this to your own SMTP server host if not using Gmail
        props.put("mail.smtp.port", "587"); // Change this to your own SMTP server port if not using Gmail

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(senderEmail));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            email.setSubject(subject);
            email.setText(message);
            Transport.send(email);
            System.out.println("Verification code sent to " + recipientEmail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateVerificationCode() {
        int length = 6;
        String charset = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charset.length());
            sb.append(charset.charAt(randomIndex));
        }
        return sb.toString();
    }

    public boolean login(String emailOrNickname, String password) throws SQLException {

        // First, check if the user is already logged in
        if (Logged.get_instance().getUser() != null) {
            System.out.println("Error: Another user is already logged in.");
            return false;
        }

        // Next, look up the user by email or nickname
        AllUsers user = null;
        if (emailOrNickname.contains("@")) {
            user = fetchAUbyEmail(emailOrNickname);
        } else {
            user = fetchAUbyNickname(emailOrNickname);
        }

        // If the user was not found, return false
        if (user == null) {
            System.out.println("Error: User not found verify your information .");
            return false;
        }

        String hashedPassword = hashPassword(password, user.getSalt());
        // Check the password
        if (!user.getPassword().equals(hashedPassword)) {
            System.out.println("Error: Incorrect password.");
            return false;
        }

        // If we made it this far, the login was successful
        Logged.get_instance().setUser(user);
        System.out.println("Login successful. Welcome, " + user.getLast_Name() + "!");
        return true;
    }


}
