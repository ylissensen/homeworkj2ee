<%--
  Created by IntelliJ IDEA.
  User: chenan
  Date: 2019/3/25
  Time: 下午5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<s:i18n name="message">
<html>
<head>
    <base href="<%=basePath%>">
    <title><s:text name = "titleone"/></title>
</head>

<script language="JavaScript">
    function mylogin(){
        if(isNull(form1.Username.value)){
            alert('<s:text name="alert1"/>');
            return false;
        }
        else if(isNull(form1.Password.value)){
            alert('<s:text name="alert2"/>');
            return false;
        }else{
            return true;
        }
    }
    function isNull(str)
    {
        if ( str == "" ) return true;
        var regu = "^[ ]+$";
        var re = new RegExp(regu);
        return re.test(str);
    }

</script>


<body>
<div style="text-align: center;">
    <h2><br><br><span style="color: #0000ff;  "><s:text name = "head2"/></span></h2>
</div>
<br/>
<form name="form1" id="form1" action="login.action" method="post" onSubmit="return mylogin()">
    <table>
        <div>
            <div style="left: 300px; position: absolute; top: 200px;"><s:text name="form.name"/>
                <input type="text"  name="Username" id="Username" value="" />
            </div>
            <div style="left: 300px; position: absolute; top: 260px;"><s:text name="form.password"/>
                <input type="password"  name="Password" id="Password" value=""/>
            </div>

            <div style="left: 330px; position: absolute; top: 390px;font-max-size: 80px">
                <input type="submit" name="button" id="button1" value="<s:text name="form.submit"/>" />
            </div>
        </div>
    </table>
</form>
</body>
</html>
</s:i18n>