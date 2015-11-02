<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<div class="container">


    <div class="row " style="margin-top: 10%";>
       <div class="col-lg-6 shadow-z-2 col-lg-offset-3">
           <h1 class="text-primary"><%
               if (session.getAttribute("message")==null){
                   out.println("登录界面");
               }
               else {
                   out.println(session.getAttribute("message"));
               }
           %></h1>
           <form class="form-horizontal"  action="req.jsp" method="post">

               <div class="form-group">
                   <label for="name" class="col-lg-2 control-label">用戶名</label>
                   <div class="col-lg-10">
                       <input type="text" class="form-control" name="username" id="name" placeholder="username">
                   </div>
               </div>

               <div class="form-group">
                   <label for="password" class="col-lg-2 control-label">密码</label>
                   <div class="col-lg-10">
                       <input type="password" class="form-control " id="password" name="password" placeholder="password">
                   </div>
               </div>
               <input class="btn pull-right right btn-material-blue-grey" type="submit" value="提交"/>
               <input class="btn pull-right btn-material-blue-grey" onclick="confer()" type="reset" value="重设"/>

           </form>
       </div>
    </div>
</div>
<br>

<script>
    function confer(){
        return confirm('你确定不是手滑了吗？');

    }
</script>

</body>
</html>
