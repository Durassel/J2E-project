package jeeProjectVersion2;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTransac {
    private String url;
    private final String  name;
    private final String password;
    private Connection connect;
    private Statement stat;

    public DBTransac()
    {
        url ="jdbc:derby://localhost:1527/BASESTAG";
        name = "adm";
        password = "adm";
        try {
            connect = DriverManager.getConnection(url, name, password);
            stat = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBTransac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  ArrayList<Member> getMembers()
    {
        ArrayList<Member> members = new ArrayList();
        try {
            ResultSet rs = stat.executeQuery("SELECT * FROM MEMBERS");
            while(rs.next()) {
                members.add(new Member(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("homeNumber"),rs.getString("mobileNumber"),
                rs.getString("workNumber"),rs.getString("address"),rs.getInt("postalCode"),rs.getString("city"),rs.getString("email")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTransac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return members;
    }
    
    public Member getMemberById(int id)
    {
        Member member = new Member();
        try {
            ResultSet rs = stat.executeQuery("SELECT * FROM MEMBERS WHERE id="+id+"");
            while(rs.next()) {
                return  new Member(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("homeNumber"),rs.getString("mobileNumber"),
                rs.getString("workNumber"),rs.getString("address"),rs.getInt("postalCode"),rs.getString("city"),rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTransac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public void changeMember(Member member)
    {
        try {
            stat.executeUpdate("UPDATE MEMBERS SET firstname='"+member.getFirstname() +"' ,lastname='"+member.getLastname()
                +"' ,email='"+member.getEmail()+"' ,homeNumber='"+member.getHomeNum()+"' ,mobileNumber='"+member.getMobileNum()
                +"' ,workNumber='"+member.getWorkNum()+"' ,address='"+member.getAddress()
                +"' ,postalCode="+member.getPostalCode()+" ,city='"+member.getCity()
                +"' WHERE id ="+member.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DBTransac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addMember(Member member)
    {
        try {
            ResultSet rs = stat.executeQuery("SELECT Max(id) as idMax FROM MEMBERS");
            rs.next();
            int idMax = 1;
            if (rs.getString("idMax") != null) {
                idMax = Integer.parseInt(rs.getString("idMax")) + 1;
            }
           
            stat.executeUpdate("INSERT INTO MEMBERS VALUES("+idMax+", '" + member.getFirstname()+"' ,'" + member.getLastname()
                +"' ,'" + member.getEmail()+"' ,'"+member.getHomeNum()+"' ,'"+member.getMobileNum()+"' ,'"+member.getWorkNum()
                +"' ,'"+member.getAddress()+"' ,"+member.getPostalCode()+" ,'"+member.getCity()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DBTransac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delMember(int id)
    {
        ResultSet rs;
        try {
            rs = stat.executeQuery("SELECT id FROM MEMBERS WHERE id=" + id);
            while (rs.next()) {
                stat.executeUpdate("DELETE FROM MEMBERS WHERE id=" + id);       
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTransac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
}
