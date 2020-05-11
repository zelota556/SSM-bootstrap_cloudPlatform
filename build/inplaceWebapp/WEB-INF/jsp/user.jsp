<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/1
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta charset="utf-8">
    <base href="${pageContext.request.contextPath}/">
    <!-- 响应式设置viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户管理</title>

    <!-- CDN -->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<h2 class="sub-header">用户列表</h2>
<form class="form-inline">
    <!-- 查询 -->
    <div class="form-group">
        <label>用户ID：</label>
        <form id="show-id">
            <input id="queryUser" name="id" type="text" class="form-control" placeholder="输入设备ID">
        </form>
        <!-- /查询 -->
        <!-- 添加 -->
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal0" onclick="userBack()">查询</button>
        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal1">新增用户</button>
        <!-- /添加 -->
    </div>
</form>

<!-- 编辑Modal 弹窗窗口 -->
<div class="modal fade" id="myModal0">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span><span class="sr-only">关闭弹窗</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">查询结果</h4>
            </div>
            <div class="modal-body">
                <form id="showUserInfo">
                    <div class="form-group">
                        <label>用户ID：</label>
                        <input type="text" id="showUserId" name="id" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>用户名：</label>
                        <input type="text" id="showUserName" name="userName" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>用户密码：</label>
                        <input type="text" id="showUserPassword" name="userPassword" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>用户性别：</label>
                        <input type="text" id="showUserGender" name="userGender" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>用户年龄：</label>
                        <input type="text" id="showUserAge" name="userAge" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>用户生日：</label>
                        <input type="text" id="showUerBirthday" name="userBirthday" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>用户邮箱：</label>
                        <input type="text" id="showUserEmail" name="userEmail" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>用户手机：</label>
                        <input type="text" id="showUserPhone" name="userPhone" class="form-control" placeholder="" readonly="readonly">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- 添加Modal 弹窗窗口 -->

<div class="modal fade" id="myModal1" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span><span class="sr-only">关闭弹窗</span>
                </button>
                <h4 class="modal-title" id="myModalLab1">添加用户</h4>
            </div>
            <div class="modal-body">
                <form id="addUserInfo">
                    <div class="form-group">
                        <label>用户名：</label>
                        <input id="addUserName" name="userName" type="text" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label>用户密码：</label>
                        <input id="addUserPassword" name="userPassword" type="text" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label>用户性别：</label>
                        <input id="addUserGender" name="userGender" type="text" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label>用户年龄：</label>
                        <input id="addUserAge" name="userAge" type="text" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label>用户生日：</label>
                        <input id="addUserBirthday" name="userBirthday" type="date" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label>用户邮箱：</label>
                        <input id="addUserEmail" name="userEmail" type="text" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label>用户手机：</label>
                        <input id="addUserPhone" name="userPhone" type="text" class="form-control" placeholder="">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" onclick="send()">添加</button>
            </div>
        </div>
    </div>
</div>

<!-- 列表 -->
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>用户密码</th>
            <th>用户性别</th>
            <th>用户年龄</th>
            <th>用户生日</th>
            <th>用户邮箱</th>
            <th>用户手机</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="result">
        <c:forEach items="${userList}" var="userList">
        <tr>
            <td>${userList.id}</td>
            <td>${userList.userName}</td>
            <td>${userList.userPassword}</td>
            <td>${userList.userGender}</td>
            <td>${userList.userAge}</td>
            <td>${userList.userBirthday}</td>
            <td>${userList.userEmail}</td>
            <td>${userList.userPhone}</td>
            <td>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal2" onclick="updateBack(${userList.id})">编辑</button>
                <!-- 编辑Modal 弹窗窗口 -->
                <div class="modal fade" id="myModal2">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">
                                    <span>&times;</span><span class="sr-only">关闭弹窗</span>
                                </button>
                                <h4 class="modal-title" id="myModalLabel">编辑信息</h4>
                            </div>
                            <div class="modal-body">
                                <form id="updateUserInfo">
                                    <div class="form-group">
                                        <label>设备ID：</label>
                                        <input type="text" id="editUserId" name="id" class="form-control" placeholder="" readonly="readonly">
                                    </div>
                                    <div class="form-group">
                                        <label>用户密码：</label>
                                        <input id="editUserPassword" name="userPassword" type="text" class="form-control" placeholder="">
                                    </div>
                                    <div class="form-group">
                                        <label>用户邮箱：</label>
                                        <input id="editUserEmail" name="userEmail" type="text" class="form-control" placeholder="">
                                    </div>
                                    <div class="form-group">
                                        <label>用户手机：</label>
                                        <input id="editUserPhone" name="userPhone" type="text" class="form-control" placeholder="">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                                <button type="submit" class="btn btn-primary" onclick="updateUser()">保存</button>
                            </div>
                        </div>
                    </div>
                </div>

                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal3"
                        onclick="deleteBack(${userList.id})">删除</button>
                <!-- 删除Modal 弹窗窗口 -->
                <div class="modal fade" id="myModal3">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">
                                    <span>&times;</span><span class="sr-only">关闭弹窗</span>
                                </button>
                                <h4 class="modal-title" id="myModalLabel">删除信息</h4>
                            </div>
                            <div class="modal-body">
                                <form id="deleteUserId">
                                    <div class="form-group">
                                        <label>当前用户ID：</label>
                                        <input type="text" id="idUserDelete" name="id" class="form-control" placeholder="" readonly="readonly"/>
                                    </div>
                                </form>
                                <span>是否确认删除用户信息？</span>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                                <button type="submit" class="btn btn-primary" onclick="deleteUser()">删除</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
        <!-- /列表 -->
        </c:forEach>
    </table>
</div>

<script type="text/javascript">
    function send() {
        $.ajax({
            url:"user/add",
            type: 'post',
            data:new FormData($("#addUserInfo")[0]),
            cache:false,
            contentType:false,
            processData:false,
            success(){
                alert("add success!")
                window.location.reload();
            }
        })
    }

    function updateBack(id){
        $("#updateUserInfo")[0].reset();
        $.ajax({
            url:"user/edit",
            type:"POST",
            data:{"id":id},
            dataType:"json",
            success:function(data){
                $("#editUserId").val(data.id);
                $("#editUserPassword").val(data.userPassword);
                $("#editUserEmail").val(data.userEmail);
                $("#editUserPhone").val(data.userPhone);
            }
        });
    }

    function updateUser(){
        $.ajax({
            type:"POST",
            data:new FormData($("#updateUserInfo")[0]),
            url:"user/update",
            cache:false,
            contentType:false,
            processData:false,
            success:function(){
                alert("修改成功!");
                window.location.reload();
            }
        });
    }

    function deleteBack(id){
        $("#deleteUserId")[0].reset();
        $.ajax({
            type:"POST",
            data:{"id":id},
            url:"user/edit",
            dataType:"json",
            success:function(data){
                $("#idUserDelete").val(data.id);
            }
        });
    }

    function deleteUser(){
        $.ajax({
            type:"POST",
            data:new FormData($("#deleteUserId")[0]),
            url:"user/delete",
            cache:false,
            contentType:false,
            processData:false,
            success:function(){
                alert("删除成功!");
                window.location.reload();
            }
        });

    }

    function userBack(){
        $("#showUserInfo")[0].reset();
        $.ajax({
            type:"POST",
            data:{id: $('#queryUser').val()},
            url:"user/edit",
            dataType:'json',
            success:function (data){
                $("#showUserId").val(data.id);
                $("#showUserName").val(data.userName);
                $('#showUserPassword').val(data.userPassword);
                $('#showUserGender').val(data.userGender);
                $('#showUserAge').val(data.userAge);
                $('#showUerBirthday').val(data.userBirthday);
                $('#showUserEmail').val(data.userEmail);
                $('#showUserPhone').val(data.userPhone);
            }
        });
    }
</script>
</body>
</html>