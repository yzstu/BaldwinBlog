package cn.yzstu.baldwinblog.bean;

import java.util.Map;

public class UserBackup {
    private Integer userId;

    private String userNick;

    private String userPassword;

    private String userName;

    private String userEmail;

    private String userDetail;

    private String userPhone;

    private String userOhter;


    public void UserBakup(Map<String, String[]> paramMap) {
        this.userNick = paramMap.containsKey("nickName") ? paramMap.get("nickName")[0].trim() : "null";
        this.userPassword = paramMap.containsKey("password") ? paramMap.get("password")[0].trim() : "null";
        this.userName = paramMap.containsKey("name") ? paramMap.get("name")[0].trim() : "null";
        this.userEmail = paramMap.containsKey("email") ? paramMap.get("email")[0].trim() : "null";
        this.userDetail = paramMap.containsKey("detail") ? paramMap.get("detail")[0].trim() : "null";
        this.userPhone = paramMap.containsKey("phone") ? paramMap.get("phone")[0].trim() : "null";
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick == null ? null : userNick.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(String userDetail) {
        this.userDetail = userDetail == null ? null : userDetail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserOhter() {
        return userOhter;
    }

    public void setUserOhter(String userOhter) {
        this.userOhter = userOhter == null ? null : userOhter.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userDetail='" + userDetail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userOhter='" + userOhter + '\'' +
                '}';
    }
}