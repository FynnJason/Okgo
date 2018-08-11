package com.fynnjason.app.twookgo.model;

/**
 * Created by FynnJason on on 2018/8/11.
 * Function：
 */
public class UserModel {


    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {


        private int userid;
        private String nickname;
        private String mobile;
        private String image;
        private int level;
        private String zhifubao;
        private String tbid;
        private String amount;
        private String earnamount;
        private int inviter;
        private int regdays;

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getZhifubao() {
            return zhifubao;
        }

        public void setZhifubao(String zhifubao) {
            this.zhifubao = zhifubao;
        }

        public String getTbid() {
            return tbid;
        }

        public void setTbid(String tbid) {
            this.tbid = tbid;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getEarnamount() {
            return earnamount;
        }

        public void setEarnamount(String earnamount) {
            this.earnamount = earnamount;
        }

        public int getInviter() {
            return inviter;
        }

        public void setInviter(int inviter) {
            this.inviter = inviter;
        }

        public int getRegdays() {
            return regdays;
        }

        public void setRegdays(int regdays) {
            this.regdays = regdays;
        }
    }
}
