package action;

import Util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class login extends ActionSupport {
    private String Userpwd;
    private String Iduser;

    public String getIduser() {
        return Iduser;
    }
    public void setIduser(String Iduser) {
        this.Iduser = Iduser;
    }
    public String getUserpwd() {
        return Userpwd;
    }
    public void setUserpwd(String Userpwd) {
        this.Userpwd = Userpwd;
    }

    //验证登录
    @Override
    public String execute(){
        System.out.println("-------"+Iduser+"-----"+Userpwd);
        //ActionContext ctx = ActionContext.getContext();
        Session s = HibernateUtil.getSession();
        Transaction tx=s.beginTransaction();
        String hql= "From entities.UserEntity u where u.iduser=? and u.userpwd=?";
        List lst = s.createQuery(hql).setString(0, Iduser).setString(1,Userpwd).list();
        tx.commit();
        HibernateUtil.closeSession();

        if(lst.size()==1)
        {
            return SUCCESS;
        }
        else{
            return INPUT;
        }
    }
}
