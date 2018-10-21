/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author Mai Linh
 */
public class RegistrationDAO {

    public int checkLogin(String username, int password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select role From tbl_User Where userId = ? And password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setInt(2, password);

                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("role");
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
        return -1;
    }
    private List<RegistrationDTO> listAccounts;

    public List<RegistrationDTO> getListAccounts() {
        return listAccounts;
    }
/**
 * chuyền default value trong khi gọi hàm
 */
    public boolean insertRecord(String userId, int password, String confirm, int role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Insert into tbl_User (userId, password, fullName, role)"
                        + " Values(?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, userId);
                stm.setInt(2, password);
                stm.setString(3, confirm);
                stm.setInt(4, role);
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
}
