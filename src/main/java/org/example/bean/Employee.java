package org.example.bean;

import lombok.Getter;
import lombok.Setter;

public class Employee {

        private String uname;
        private String uemail;
        private String upass;
        private String udeg;
        int srNo;

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getUemail() {
            return uemail;
        }

        public void setUemail(String uemail) {
            this.uemail = uemail;
        }

        public String getUpass() {
            return upass;
        }

        public void setUpass(String upass) {
            this.upass = upass;
        }

        public String getUdeg() {
            return udeg;
        }

        public void setUdeg(String udeg) {
            this.udeg = udeg;
        }

        public int getSrNo() {
            return srNo;
        }

        public void setSrNo(int srNo) {
            this.srNo = srNo;
        }


}
