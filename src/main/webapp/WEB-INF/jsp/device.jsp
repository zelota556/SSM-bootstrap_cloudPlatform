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
    <title>设备管理</title>

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
<h2 class="sub-header">设备列表</h2>
<form class="form-inline">
    <!-- 查询 -->
    <div class="form-group">
        <label>设备ID：</label>
        <form id="show-id">
        <input id="query" name="id" type="text" class="form-control" placeholder="输入设备ID">
        </form>
        <!-- /查询 -->
        <!-- 添加 -->
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal0" onclick="deviceBack()">查询</button>
        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal1">新增设备</button>
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
                <form id="showDevInfo">
                    <div class="form-group">
                        <label>设备ID：</label>
                        <input type="text" id="showDevId" name="id" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>设备编号：</label>
                        <input type="text" id="showDevNo" name="devNo" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>设备名：</label>
                        <input type="text" id="showDevName" name="devName" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>设备购入时间：</label>
                        <input type="text" id="showDevBuydate" name="devBuydate" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>设备保修时间：</label>
                        <input type="text" id="showDevWarrantydate" name="devWarrantydate" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>设备状态：</label>
                        <input type="text" id="showDevStatus" name="devStatus" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>设备创建时间：</label>
                        <input type="text" id="showDevCreate" name="dateCreate" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>近次维修时间：</label>
                        <input type="text" id="showDevRepairdate" name="devRepairdate" class="form-control" placeholder="" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>近次更新时间：</label>
                        <input type="text" id="showDevUpdate" name="dateUpdate" class="form-control" placeholder="" readonly="readonly">
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
                <h4 class="modal-title" id="myModalLab1">添加设备</h4>
            </div>
            <div class="modal-body">
                <form id="addDevInfo">
                <div class="form-group">
                    <label>设备编号：</label>
                    <input id="addDevNo" name="devNo" type="text" class="form-control" placeholder="">
                </div>
                <div class="form-group">
                    <label>设备名：</label>
                    <input id="addDevName" name="devName" type="text" class="form-control" placeholder="">
                </div>
                <div class="form-group">
                    <label>设备状态：</label>
                    <input id="addDevStatus" name="devStatus" type="text" class="form-control" placeholder="">
                </div>
                <div class="form-group">
                    <label>设备购入时间：</label>
                    <input id="addDevBuyDate" name="devBuydate" type="date" class="form-control" placeholder="">
                </div>
                <div class="form-group">
                    <label>设备保修截止日期：</label>
                    <input id="addDevWarrantyDate" name="devWarrantydate" type="date" class="form-control" placeholder="">
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
            <th>设备ID</th>
            <th>设备编号</th>
            <th>设备名</th>
            <th>购入时间</th>
            <th>保修日期</th>
            <th>设备状态</th>
            <th>创建时间</th>
            <th>近次维修时间</th>
            <th>更新时间</th>
            <th>操作</th>
        </tr>
        </thead>
    <tbody id="result">
        <c:forEach items="${devlist}" var="devList">
        <tr>
            <td>${devList.id}</td>
            <td>${devList.devNo}</td>
            <td>${devList.devName}</td>
            <td>${devList.devBuydate}</td>
            <td>${devList.devWarrantydate}</td>
            <td>${devList.devStatus}</td>
            <td>${devList.dateCreate}</td>
            <td>${devList.devRepairdate}</td>
            <td>${devList.dateUpdate}</td>
            <td>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal2" onclick="updateBack(${devList.id})">编辑</button>
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
                                <form id="updateDevInfo">
                                    <div class="form-group">
                                        <label>设备ID：</label>
                                        <input type="text" id="editId" name="id" class="form-control" placeholder="" readonly="readonly">
                                    </div>
                                    <div class="form-group">
                                        <label>设备编号：</label>
                                        <input type="text" id="editDevNo" name="devNo" class="form-control" placeholder="">
                                    </div>
                                    <div class="form-group">
                                        <label>设备名：</label>
                                        <input type="text" id="editDevName" name="devName" class="form-control" placeholder="">
                                    </div>
                                    <div class="form-group">
                                        <label>设备状态：</label>
                                        <input type="text" id="editDevStatus" name="devStatus" class="form-control" placeholder="">
                                    </div>
                                    <div class="form-group">
                                        <label>近次维修时间：</label>
                                        <input type="text" id="editDevRepairDate" name="devRepairdate" class="form-control" placeholder="">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                                <button type="submit" class="btn btn-primary" onclick="updateDevice()">保存</button>
                            </div>
                        </div>
                    </div>
                </div>

                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal3"
                        onclick="deleteBack(${devList.id})">删除</button>
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
                                <form id="deleteId">
                                    <div class="form-group">
                                        <label>当前设备ID：</label>
                                        <input type="text" id="idDelete" name="id" class="form-control" placeholder="" readonly="readonly"/>
                                    </div>
                                </form>
                                <span>是否确认删除设备信息？</span>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                                <button type="submit" class="btn btn-primary" onclick="deleteDevice()">删除</button>
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
            url:"device/add",
            type: 'post',
            data:new FormData($("#addDevInfo")[0]),
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
        $("#updateDevInfo")[0].reset();
        $.ajax({
            url:"device/edit",
            type:"POST",
            data:{"id":id},
            dataType:"json",
            success:function(data){
                $("#editId").val(data.id);
                $("#editDevNo").val(data.devNo);
                $("#editDevName").val(data.devName);
                $("#editDevStatus").val(data.devStatus);
                $('#editDevRepairDate').val(data.devRepairdate);
            }
        });
    }

    function updateDevice(){
        $.ajax({
            type:"POST",
            data:new FormData($("#updateDevInfo")[0]),
            url:"device/update",
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
        $("#deleteId")[0].reset();
        $.ajax({
            type:"POST",
            data:{"id":id},
            url:"device/edit",
            dataType:"json",
            success:function(data){
                $("#idDelete").val(data.id);
            }
        });
    }

    function deleteDevice(){
        $.ajax({
            type:"POST",
            data:new FormData($("#deleteId")[0]),
            url:"device/delete",
            cache:false,
            contentType:false,
            processData:false,
            success:function(){
                alert("删除成功!");
                window.location.reload();
            }
        });

    }

    function deviceBack(){
        $("#showDevInfo")[0].reset();
        $.ajax({
            type:"POST",
            data:{id: $('#query').val()},
            url:"device/edit",
            dataType:'json',
            success:function (data){
                $("#showDevId").val(data.id);
                $("#showDevNo").val(data.devNo);
                $('#showDevName').val(data.devName);
                $('#showDevBuydate').val(data.devBuydate);
                $('#showDevWarrantydate').val(data.devWarrantydate);
                $('#showDevStatus').val(data.devStatus);
                $('#showDevCreate').val(data.dateCreate);
                $('#showDevRepairdate').val(data.devRepairdate);
                $('#showDevUpdate').val(data.dateUpdate);
        }
        });
    }
</script>
</body>
</html>