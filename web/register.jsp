<%-- 
    Document   : logIn
    Created on : Jul 14, 2015, 10:17:44 AM
    Author     : linshangzhen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>Register Page</title>
    </head>
    <body>

        <br/><br/><br/><br/>

        <form action="RegisterServlet" class="form-horizontal col-md-offset-4">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-3">
                    <input type="name" class="form-control" id="inputEmail3" placeholder="Name" name="name">
                </div>
                <h5><span class="label label-danger" >${registerErrors.name }</span></br>

            </div>
                
                <div class="form-group">
                <label for="inputEmail4" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-3">
                    <input type="name" class="form-control" id="inputEmail4" placeholder="Email" name="email">
                </div>
                <h5><span class="label label-danger" >${registerErrors.email }</span></br>

            </div>
                
                
            <div class="form-group">
                <label for="inputPassword5" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-3">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
                </div>
               <h5><span class="label label-danger" >${registerErrors.password }</span></br>
            </div>
            
            <div class="form-group">
                <label for="inputPassword5" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-3">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password Again" name="password1">
                </div>
               <h5><span class="label label-danger" >${registerErrors.password1}</span></br>
            </div>
            
            
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-10">
                    <button type="submit" class="btn btn-primary">注册</button>
                </div>
            </div>
        </form>
    </body>
</html>
