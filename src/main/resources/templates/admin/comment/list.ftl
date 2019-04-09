<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<#assign active='commentList'/>
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
                                    <span class="input-group-addon">评论人</span>
                                    <input type="text" class="form-control" name="userName" value="${userName!}">
                                </div>
                                <div class="input-group col-xs-3">
                                    <span class="input-group-addon">商家</span>
                                    <input type="text" class="form-control" name="businessName" value="${businessName!}">
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
                                    <th>商家</th>
                                    <th>评论人</th>
                                    <th>标签</th>
                                    <th>打分</th>
                                    <th>服务</th>
                                    <th>环境</th>
                                    <th>味道</th>
                                    <th>就餐建议</th>
                                    <th>时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pageInfo.list as item>
                                <tr>
                                    <td>${item.businessName!}</td>
                                    <td>${item.userName!}</td>
                                    <td>${item.flag!}</td>
                                    <td>${item.start!}</td>
                                    <td>${item.serve!}</td>
                                    <td>${item.environment!}</td>
                                    <td>${item.taste!}</td>
                                    <td>${item.diningAdvice!}</td>
                                    <td>${item.addtime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    <td>
                                        <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                            <a class="btn btn-xs btn-danger" href="javascript:if(confirm('确定要删除吗？')){location.href = '/admin/comment/delete/${item.id}'}">删除</a>
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

