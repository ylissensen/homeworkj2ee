package action;

import com.opensymphony.xwork2.ActionSupport;

public class login extends ActionSupport {
    private String Password;
    private String Username;

    public String getUsername() {
        return Username;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }

    //验证登录
    @Override
    public String execute(){
        if("123456".equals(getUsername()) && "123456".equals(getPassword()))
        {
            return SUCCESS;
        }
        else{
            return INPUT;
        }
    }
}
