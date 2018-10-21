/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.mobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author Mai Linh
 */
public class MobileDAO {

    List<MobileDTO> listMobiles;

    public List<MobileDTO> getListMobiles() {
        return listMobiles;
    }

    public void searchFromStaffByName(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                 String sql = "Select * From tbl_Mobile Where mobileName Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    Float lastname = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    MobileDTO dto = new MobileDTO(mobileId, description, lastname, mobileName, yearOfProduction, quantity, notSale);
                    if (this.listMobiles == null) {
                        this.listMobiles = new ArrayList<>();
                    }
                    this.listMobiles.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void searchFromStaffByID(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select * From tbl_Mobile Where mobileId Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    Float lastname = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    MobileDTO dto = new MobileDTO(mobileId, description, lastname, mobileName, yearOfProduction, quantity, notSale);
                    if (this.listMobiles == null) {
                        this.listMobiles = new ArrayList<>();
                    }
                    this.listMobiles.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean deleteByID(String mobileId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Delete from tbl_Mobile where mobileId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, mobileId);

                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateByID(String mobileId, float price, String description, int quantity, boolean notSale) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "update tbl_Mobile Set price = ?, description = ?, quantity = ?, notSale = ? Where mobileId = ?";
                stm = con.prepareStatement(sql);
                stm.setFloat(1, price);
                stm.setString(2, description);
                stm.setInt(3, quantity);
                stm.setBoolean(4, notSale);
                stm.setString(5, mobileId);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean insertRecord(String mobileId, float price, String description, int quantity, boolean notSale, int yearOfProduct, String mobileName) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Insert Into tbl_Mobile (mobileId, price, description, quantity, mobileName, notSale, yearOfProduct)"
                        + " values(?, ?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, mobileId);
                stm.setFloat(2, price);
                stm.setString(3, description);
                stm.setInt(4, quantity);
                stm.setString(5, mobileName);
                stm.setBoolean(6, notSale);
                stm.setInt(7, yearOfProduct);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public void searchFromStaffByPrice(float min, float max) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select * From tbl_Mobile Where price Between ? And ?";
                stm = con.prepareStatement(sql);
                stm.setFloat(1, min);
                stm.setFloat(2, max);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    Float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                    if (this.listMobiles == null) {
                        this.listMobiles = new ArrayList<>();
                    }
                    this.listMobiles.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
