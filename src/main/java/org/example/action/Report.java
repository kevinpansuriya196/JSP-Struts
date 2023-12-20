package org.example.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.example.bean.Employee;
import org.example.dao.Admin;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;

public class Report extends ActionSupport {

    private static final long serialVersionUID = 6329394260276112660L;
    ResultSet rs = null;
    Employee bean = null;
    List<Employee> beanList = null;
    Admin admin = new Admin();
    private String delete = "";
    private String updateMsg = "";

    private boolean noData = false;
    private boolean check = false;
    private boolean check1 = false;

    HttpServletRequest request = ServletActionContext.getRequest();

    Map<String, Object> session = ActionContext.getContext().getSession();
    Object message = session.get("deleteMsg");
    Object message1 = session.get("updateMsg");

    @Override
    public String execute() throws Exception {
        if (message != null) {
            String message1 = session.get("deleteMsg").toString();
            System.out.println(message1);
            check = true;
        } else {
            check = false;
        }
        if (message1 != null) {
            String message2 = session.get("updateMsg").toString();
            System.out.println(message2);
            check1 = true;
        } else {
            check1 = false;
        }


        try {
            beanList = new ArrayList<Employee>();
            rs = admin.report();
            int i = 0;
            if (rs != null) {
                while (rs.next()) {
                    i++;
                    bean = new Employee();
                    bean.setSrNo(i);
                    bean.setUname(rs.getString("UNAME"));
                    bean.setUemail(rs.getString("UEMAIL"));
                    bean.setUpass(rs.getString("UPASS"));
                    bean.setUdeg(rs.getString("UDEG"));
                    beanList.add(bean);
                }
            }
            if (i == 0) {
                noData = false;
            } else {
                noData = true;
            }
            try {
                if (check = true) {

                    delete = message.toString();
                    System.out.println(delete);
                    request.setAttribute("delete", delete);

                } else {
                    delete = "delete ok";
                }
            } catch (Exception e) {
            }
            try {
                if (check1 = true) {
                    updateMsg = message1.toString();
                    System.out.println(updateMsg);
                    request.setAttribute("updateMsg", updateMsg);

                } else {
                    updateMsg = "update ok";
                }
            } catch (Exception e) {
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "REPORT";
    }

    public boolean isNoData() {
        return noData;
    }

    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    public List<Employee> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<Employee> beanList) {
        this.beanList = beanList;
    }
}
