<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<body>
<#assign active='businessList'/>
<#include "../include/common-top.ftl"/>
<div class="main-container" id="main-container">
  <div class="main-container-inner">
    <#include "../include/common-menu.ftl"/>
    <div class="main-content">
      <div class="page-content">
        <div class="row">
          <div class="col-xs-12">
            <div class="form-search">
              <form role="form" class="form-inline clearfix" id="form" action="">
                <div class="input-group col-xs-3">
                  <span class="input-group-addon">商家名</span>
                  <input type="text" class="form-control" name="name" value="${name!}">
                </div>
              </form>
              <div class="form-tool btn-group">
                <button class="btn btn-sm btn-success" form="form">
                  <i class="icon-search"></i>搜索
                </button>
              </div>
            </div>
            <div class="table-responsive">
              <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                  <th>商家名</th>
                  <th>联系电话</th>
                  <th>位置</th>
                  <th>预约次数</th>
                  <th>点赞次数</th>
                  <th>评论次数</th>
                </tr>
                </thead>
                <tbody>
                <#list pageInfo.list as item>
                  <tr>
                    <td>${item.name}</td>
                    <td>${item.phone}</td>
                    <td>${item.address!}</td>
                    <td>${item.orderNum!0}</td>
                    <td>${item.startNum!0}</td>
                    <td>${item.commendNum!0}</td>
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
  </div>
</body>
<#include "../include/resource-script.ftl"/>

</html>

