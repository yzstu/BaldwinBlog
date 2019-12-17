package cn.yzstu.baldwinblog.bean;

import cn.yzstu.common.utils.DateUtil;

import java.util.Date;
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

    private Byte userAge;

    private Integer userTelephoneNumber;

    private String userNickname;


    private String userDetail;

    private Byte userRole;

    public User(Map<String, String[]> paramMap) {

        this.userNickname = paramMap.containsKey("nickName") ? paramMap.get("nickName")[0].trim() : "null";
        this.userPassword = paramMap.containsKey("password") ? paramMap.get("password")[0].trim() : "null";
        this.userName = paramMap.containsKey("name") ? paramMap.get("name")[0].trim() : "null";
        this.userEmail = paramMap.containsKey("email") ? paramMap.get("email")[0].trim() : "null";
        this.userTelephoneNumber = paramMap.containsKey("phone") ? Integer.valueOf(paramMap.get("phone")[0].trim()) : 000;
        this.userIp = paramMap.containsKey("ip") ? paramMap.get("ip")[0].trim() : "null";
        this.userProfilePhoto = paramMap.containsKey("profilePhoto") ? paramMap.get("profilePhoto")[0].trim() : "null";
        this.userRegistrationTime = paramMap.containsKey("registrationTime") ? paramMap.get("registrationTime")[0].trim() : "1900-01-01";
        this.userBirthday = paramMap.containsKey("birthday") ? paramMap.get("birthday")[0].trim() : "1900-01-01";
        this.userAge = paramMap.containsKey("age") ? Byte.valueOf(paramMap.get("age")[0].trim()) : 18;
        this.userRole = paramMap.containsKey("role") ? Byte.valueOf(paramMap.get("role")[0].trim()) : 2;


        this.userDetail = paramMap.containsKey("detail") ? paramMap.get("detail")[0].trim() : "null";
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
        this.userIp = userIp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    public String getUserRegistrationTime() {
        return userRegistrationTime;
    }

    public void setUserRegistrationTime(String userRegistrationTime) {
        this.userRegistrationTime = userRegistrationTime;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserTelephoneNumber() {
        return userTelephoneNumber;
    }

    public void setUserTelephoneNumber(Integer userTelephoneNumber) {
        this.userTelephoneNumber = userTelephoneNumber;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(String userDetail) {
        this.userDetail = userDetail;
    }

    public Byte getUserRole() {
        return userRole;
    }

    public void setUserRole(Byte userRole) {
        this.userRole = userRole;
    }

    public Byte getUserAge() {
        return userAge;
    }

    public void setUserAge(Byte userAge) {
        this.userAge = userAge;
    }
}