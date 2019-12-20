package cn.yzstu.baldwinblog.bean;

import java.util.Map;

public class User {
    private Long userId;

    private String userIp;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userProfilePhoto;

    private String userRegistrationTime;

    private String userBirthday;

    private String userAge;

    private String userTelephoneNumber;

    private String userNickname;

    private int userRole;

    private String userDetail;


    public User(Long userId, String userIp, String userName, String userPassword, String userEmail, String userProfilePhoto, String userRegistrationTime, String userBirthday, String userAge, String userTelephoneNumber, String userNickname, Integer userRole, String userDetail) {
        this.userId = userId;
        this.userIp = userIp;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userProfilePhoto = userProfilePhoto;
        this.userRegistrationTime = userRegistrationTime;
        this.userBirthday = userBirthday;
        this.userAge = userAge;
        this.userTelephoneNumber = userTelephoneNumber;
        this.userNickname = userNickname;
        this.userRole = userRole;
        this.userDetail = userDetail;
    }

    public User(Map<String, String> paramMap) {
        this.userId = userId;
        this.userIp = paramMap.containsKey("ip") ? paramMap.get("ip").trim() : null;

        this.userName = paramMap.containsKey("name") ? paramMap.get("name").trim() : null;
        this.userPassword = paramMap.containsKey("password") ? paramMap.get("password").trim() : null;
        this.userEmail = paramMap.containsKey("email") ? paramMap.get("email").trim() : null;
        this.userProfilePhoto = paramMap.containsKey("profilePhoto") ? paramMap.get("profilePhoto").trim() : null;

        this.userRegistrationTime = paramMap.containsKey("registrationTime") ? paramMap.get("registrationTime").trim() : null;

        this.userBirthday = paramMap.containsKey("birthday") ? paramMap.get("birthday").trim() : null;

        this.userAge = paramMap.containsKey("age") ? paramMap.get("age").trim() : null;

        this.userTelephoneNumber = paramMap.containsKey("phone") ? paramMap.get("phone").trim() : null;
        this.userNickname = paramMap.containsKey("nickName") ? paramMap.get("nickName").trim() : null;
        this.userRole = paramMap.containsKey("role") ? Integer.valueOf(paramMap.get("role").trim()) : null;
        this.userDetail = paramMap.containsKey("detail") ? paramMap.get("detail").trim() : null;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userIp='" + userIp + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userProfilePhoto='" + userProfilePhoto + '\'' +
                ", userRegistrationTime='" + userRegistrationTime + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userTelephoneNumber='" + userTelephoneNumber + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userRole=" + userRole +
                ", userDetail='" + userDetail + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto == null ? null : userProfilePhoto.trim();
    }

    public String getUserRegistrationTime() {
        return userRegistrationTime;
    }

    public void setUserRegistrationTime(String userRegistrationTime) {
        this.userRegistrationTime = userRegistrationTime == null ? null : userRegistrationTime.trim();
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday == null ? null : userBirthday.trim();
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge == null ? null : userAge.trim();
    }

    public String getUserTelephoneNumber() {
        return userTelephoneNumber;
    }

    public void setUserTelephoneNumber(String userTelephoneNumber) {
        this.userTelephoneNumber = userTelephoneNumber == null ? null : userTelephoneNumber.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(String userDetail) {
        this.userDetail = userDetail == null ? null : userDetail.trim();
    }


}