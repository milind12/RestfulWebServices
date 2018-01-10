/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorld;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Milind Ghiya
 */
@Path("contest")
public class ContestService {

    @GET
    @Path("/{cn}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contest> getContests(@PathParam("cn") String collegename) throws SQLException, ClassNotFoundException {
        List<Contest> l = new ArrayList<Contest>();

        Contest c = null;
        Connection con = null;
        Statement stmt = null;
        con = DBConnection.createConnection(con);

        String sql = "Select * from contest where collegename='" + collegename + "'";

        stmt = con.createStatement();
        Date d1, d2;
        ResultSet rs = stmt.executeQuery(sql);
        SimpleDateFormat sdf = null;
        while (rs.next()) {
            c = new Contest();
            c.setCollegename(rs.getString("collegename"));
            c.setUserid(rs.getInt("userid"));
            c.setContestId(rs.getInt("contestid"));
            c.setName(rs.getString("name"));

            d1 = new Date(rs.getTimestamp("start").getTime());
            d2 = new Date(rs.getTimestamp("end").getTime());
            c.setStartdate(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(d1));
            c.setEnddate(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(d2));
            l.add(c);
        }
        stmt.close();
        con.close();

        return l;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contest> getAllContests() throws SQLException, ClassNotFoundException {
        List<Contest> l = new ArrayList<Contest>();

        Contest c = null;
        Connection con = null;
        Statement stmt = null;
        con = DBConnection.createConnection(con);

        String sql = "Select * from contest";

        stmt = con.createStatement();
        Date d1, d2;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            c = new Contest();
            c.setCollegename(rs.getString("collegename"));
            c.setUserid(rs.getInt("userid"));
            c.setContestId(rs.getInt("contestid"));
            c.setName(rs.getString("name"));
            d1 = new Date(rs.getTimestamp("start").getTime());
            d2 = new Date(rs.getTimestamp("end").getTime());

            c.setStartdate(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(d1));
            c.setEnddate(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(d2));
            l.add(c);
        }
        stmt.close();
        con.close();

        return l;

    }
}
