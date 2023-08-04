package com.example.asm.api_res;

public class LoginRes {
    private boolean status;
    private class user{
        private String email;
        private String id;
        private String avatar;
        private String student_code;
        private boolean gender;
        private String birthday;
        private String address;
        private String course;

        public user() {
        }

        public user(String email, String id, String avatar, String student_code, boolean gender, String birthday, String address, String course) {
            this.email = email;
            this.id = id;
            this.avatar = avatar;
            this.student_code = student_code;
            this.gender = gender;
            this.birthday = birthday;
            this.address = address;
            this.course = course;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getStudent_code() {
            return student_code;
        }

        public void setStudent_code(String student_code) {
            this.student_code = student_code;
        }

        public boolean isGender() {
            return gender;
        }

        public void setGender(boolean gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }
    }

    public LoginRes() {
    }

    public LoginRes(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
