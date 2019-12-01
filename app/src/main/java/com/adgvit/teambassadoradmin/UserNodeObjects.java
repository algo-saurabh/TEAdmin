package com.adgvit.teambassadoradmin;

public class UserNodeObjects
{
    private String DOB;
    private String Email;
    private Long Level;
    private String Name;
    private String PhoneNo;
    private Long Progress;

    public UserNodeObjects(String DOB, String email, Long level, String name, String phoneNo,Long progress)
    {
        this.DOB = DOB;
        this.Email = email;
        this.Level = level;
        this.Name = name;
        this.PhoneNo = phoneNo;
        this.Progress = progress;
    }

    public UserNodeObjects()
    {
    }


    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getLevel() {
        return Level;
    }

    public void setLevel(Long level) {
        Level = level;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public Long getProgress() {
        return Progress;
    }

    public void setProgress(Long progress) {
        Progress = progress;
    }
}
