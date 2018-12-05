package com.dxp.springbootnetty.service.vo;

/**
 * @author carzy.
 * @date 16:50 2018/12/4
 */
public class StudentInfo {

    public StudentInfo() {
    }

    public StudentInfo(String username, String pwd, String remark) {
        this.username = username;
        this.pwd = pwd;
        this.remark = remark;
    }

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 备注
     */
    private String remark;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
