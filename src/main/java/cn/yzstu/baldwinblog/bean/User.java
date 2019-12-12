package cn.yzstu.baldwinblog.bean;

public class User {
    private Integer userId;

    private String userNick;

    private String userPassword;

    private String userName;

    private String userEmail;

    private String userDetail;

    private String userPhone;

    private String userOhter;

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