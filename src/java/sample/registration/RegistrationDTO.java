/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.registration;

/**
 *
 * @author Mai Linh
 */
public class RegistrationDTO {

    private String userId;
    private int password;
    private String fullName;
    private boolean rold;

    public RegistrationDTO(String userId, int password, String fullName, boolean rold) {
        this.userId = userId;
        this.password = password;
        this.fullName = fullName;
        this.rold = rold;
    }

    public RegistrationDTO() {
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the password
     */
    public int getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(int password) {
        this.password = password;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the rold
     */
    public boolean isRold() {
        return rold;
    }

    /**
     * @param rold the rold to set
     */
    public void setRold(boolean rold) {
        this.rold = rold;
    }

}
