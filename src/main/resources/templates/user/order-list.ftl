<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="order"/>
<#assign navTitle= '我的预约'/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
  <#list orderList as item>
    <div class="mui-card">
      <div class="mui-card-header mui-card-media">
        <img src="${item.businessIcon}">
        <div class="mui-media-body">
          ${item.businessName!}
          <p>预约于 ${item.addTime?string('yyyy-MM-dd HH:mm:ss')}</p>
        </div>
      </div>
      <div class="mui-card-content">
        <ul class="mui-table-view">
          <li class="mui-table-view-cell">预留电话：${item.phone!}</li>
          <li class="mui-table-view-cell">预约人数：${item.num!}</li>
          <li class="mui-table-view-cell">预约时间：${item.orderTime!}</li>
          <li class="mui-table-view-cell">预约费用：${item.total!}</li>
        </ul>
        <div class="mui-card-content-inner">
          ${item.remark!}
        </div>
      </div>
      <div class="mui-card-footer">
        <a href="/order/detail/${item.id}">详情</a>
      </div>
    </div>
  </#list>

</div>
</body>

</html>