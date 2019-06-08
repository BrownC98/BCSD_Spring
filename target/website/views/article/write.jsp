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
                <form role="form" id="writeForm" method="post" action="/article/write">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">make article</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="title">Title</label>
                                <input class="form-control" id="title" name="title" placeholder="type Title">
                            </div>
                            <div class="form-group">
                                <label for="content">Content</label>
                                <textarea class="form-control" id="content" name="content" rows="30"
                                          placeholder="Type content" style="resize: none;"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="writer">author</label>
                                <input class="form-control" id="writer" name="writer">
                            </div>
                        </div>
                        <div class="box-footer">
                            <button type="button" class="btn btn-primary listBtn" onclick="location.href = '/article/list'"><i class="fa fa-list"></i> List</button>
                            <div class="pull-right">
                                <button type="reset" class="btn btn-warning"><i class="fa fa-reply"></i> Reset</button>
                                <button type="submit" class="btn btn-success saveBtn"><i class="fa fa-save"></i> Save</button>
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
</body>
</html>