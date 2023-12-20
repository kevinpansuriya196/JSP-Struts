package org.example.action;

import java.sql.ResultSet;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;
import org.example.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;

public class Update extends ActionSupport {

    private static final long serialVersionUID = -1905974197186620917L;
    private String uname = "", uemail = "", upass = "", udeg = "", uemailhidden = "";
    private String updateMsg = "";
    private String msg = "";
    private int check = 1;
    ResultSet rs = null;
    Admin dao = new Admin();
    String submitType;
    int i = 0;

    @Override
    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            if (submitType.equals("updatedata")) {
                rs = dao.fetchUserDetails(uemail.trim());
                if (rs != null) {
                    while (rs.next()) {
                        uname = rs.getString("UNAME");
                        uemail = rs.getString("UEMAIL");
                        upass = rs.getString("UPASS");
                        udeg = rs.getString("UDEG");
                    }
                }
                updateMsg = "Record updated successfully";
                Map<String, Object> session = ActionContext.getContext().getSession();
                session.put("updateMsg", updateMsg);
                session.remove("deleteMsg");
                request.setAttribute("updateMsg", updateMsg);
            } else {
                i = dao.updateUserDetails(uname, uemail, upass, udeg, uemailhidden);
                if (i > 0) {
                    check = 2;
                    return "success";
                } else {
                    addActionMessage(getText("message.key"));
                    check = 3;
//                  return "error";
                }
            }
        } catch (Exception e) {
            check = 3;
            request.setAttribute("exceptionMsg",e.getMessage());
            addActionMessage(getText(   "message.key"));
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.remove("updateMsg");
        }
        return "UPDATE";

    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpdateMsg() {
        return updateMsg;
    }

    public void setUpdateMsg(String updateMsg) {
        this.updateMsg = updateMsg;
    }

    public String getUemailhidden() {
        return uemailhidden;
    }

    public void setUemailhidden(String uemailhidden) {
        this.uemailhidden = uemailhidden;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
}
