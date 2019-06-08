<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %><c:set var="path" value=""/>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<%@include file="../include/head.jsp"%>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <%@include file="../include/main_header.jsp"%>
    <!-- Left side column. contains the logo and sidebar -->
    <%@include file="../include/left_column.jsp"%>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Page Header
                <small>Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
            <div class="col-lg-12">
                <form role="form" id="writeform" method="post" action="/article/modify">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">make article</h3>
                        </div>
                        <div class="box-body">
                            <input type="hidden" name="articleNo" value="${article.articleNo}">
                            <div class="form-group">
                                <label for="title">제목</label>
                                <input class="form-control" id="title" name="title" placeholder="제목을 입력해주세요" value="${article.title}">
                            </div>
                            <div class="form-group">
                                <label for="content">내용</label>
                                <textarea class="form-control" id="content" name="content" rows="30"
                                          placeholder="내용을 입력해주세요" style="resize: none;">${article.content}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="writer">작성자</label>
                                <input class="form-control" id="writer" name="writer" value="${article.writer}" readonly>
                            </div>
                        </div>
                        <div class="box-footer">
                            <button type="button" class="btn btn-primary"><i class="fa fa-list"></i> 목록</button>
                            <div class="pull-right">
                                <button type="button" class="btn btn-warning cancelBtn"><i class="fa fa-trash"></i> 취소</button>
                                <button type="submit" class="btn btn-success modBtn"><i class="fa fa-save"></i> 저장</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@include file="../include/main_footer.jsp"%>

    <!-- Control Sidebar -->
    <%@include file="../include/control_sidebar.jsp"%>
</div>
<!-- ./wrapper -->

<%@ include file="../include/plugin_js.jsp"%>
<script>
    $(document).ready(function () {
        var formObj = $("form[role = 'form']");
        console.log(formObj);

        $(".modBtn").on("click", function () {
            formObj.submit();
        });

        $(".cancelBtn").on("click", function () {
            history.go(-1);
        });

        $(".listBtn").on("click", function () {
            self.location = "/article/list"
        });
    })
</script>
</body>
</html>