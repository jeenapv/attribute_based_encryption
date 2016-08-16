/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jithinpv
 */
public class Dbcon {
    
    public Connection con = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    public Dbcon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/attribute_based_encrption", "root", "root");
            stmt = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public int insert(String sql) {
        System.out.println(sql);
        int r = 0;
        try {
            r = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public ResultSet select(String sql) {
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public int update(String sql) {
        System.out.println(sql);
        int a = 0;
        try {
            a = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
    
}
