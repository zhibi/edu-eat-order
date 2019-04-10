<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<#assign active='couponList'/>
<#include "../include/common-top.ftl"/>
<body>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
    <#include "../include/common-menu.ftl"/>
        <div class="main-content">
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-search">
                            <form role="form" class="form-inline clearfix" id="form2" action="">
                                <div class="input-group col-xs-3">
                                    <span class="input-group-addon">用户名</span>
                                    <input type="text" class="form-control" name="userName" value="${userName!}">
                                </div>
                            </form>
                            <div class="form-tool btn-group">
                                <button class="btn btn-sm btn-success" form="form2">
                                    <i class="icon-search"></i>搜索
                                </button>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>用户名</th>
                                    <th>金额</th>
                                    <th>类别</th>
                                    <th>状态</th>
                                    <th>发放时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pageInfo.list as item>
                                <tr>
                                    <td>${item.userName!}</td>
                                    <td>${item.money!}</td>
                                    <td>${item.species!}</td>
                                    <td>${item.status!}</td>
                                    <td>${item.addTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    <td>
                                        <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                            <a class="btn btn-xs btn-danger" href="javascript:if(confirm('确定要删除吗？')){location.href = '/admin/coupon/delete/${item.id}'}">删除</a>
                                        </div>
                                    </td>
                                </tr>
                                </#list>
                                </tbody>
                            </table>
                        <#include "../include/table-page.ftl"/>
                        </div>
                    </div>
                </div>
            </div>
    </div>
</body>

<#include "../include/resource-script.ftl"/>
</html>

