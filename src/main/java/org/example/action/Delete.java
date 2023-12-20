package org.example.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.example.dao.Admin;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Delete extends ActionSupport {

    private static final long serialVersionUID = -146601914103585418L;

    String uemail, deleteMsg;
    Admin dao = new Admin();

    @Override
    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();

        try {
            int isDeleted = dao.deleteUserDetails(uemail);
            if (isDeleted > 0) {
                deleteMsg = "Record deleted successfully";
                Map<String, Object> session1 = ActionContext.getContext().getSession();
                session1.put("deleteMsg", deleteMsg);
                session1.remove("updateMsg");
                request.setAttribute("deleteMsg", deleteMsg);
                return "success";
            } else {

                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "DELETE";

    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getDeleteMsg() {
        return deleteMsg;
    }

    public void setDeleteMsg(String deleteMsg) {
        this.deleteMsg = deleteMsg;
    }
}
