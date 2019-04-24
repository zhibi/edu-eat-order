<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="home"/>
<style>

  h5 {
    padding-top: 8px;
    padding-bottom: 8px;
    text-indent: 12px;
  }

  .mui-table-view.mui-grid-view .mui-table-view-cell .mui-media-body {
    font-size: 15px;
    margin-top: 8px;
    color: #333;
  }

</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=irzL4Yr34RmfCLCwqd70amzr5EBIGTw0"></script>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
  <img id="img1" src="https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=649303515,1532247418&fm=27&gp=0.jpg">
  <ul class="mui-table-view">
    <li class="mui-table-view-cell">
      ${business.name!}
      <span onclick="location.href='/business/start/${business.id}'" class="mui-icon mui-icon-star-filled"
            <#if start??>style="color: #2ac845" <#else>style="color: #ababab"</#if>></span>
      <span class="mui-badge mui-badge-success">${business.category}</span>
    </li>
    <li class="mui-table-view-cell">
      <span class="mui-icon mui-icon-location"></span>${business.address!}</li>
    <li class="mui-table-view-cell">
      <span class="mui-icon mui-icon-phone"></span>${business.phone!}</li>
    </li>
    <li class="mui-table-view-cell">
      <span class="mui-icon-extra mui-icon-extra-outline"></span>${business.tradeTime!}
      <span style="float: right" class="mui-icon-extra mui-icon-extra-share "></span>
    </li>
    </li>
  </ul>
  <div id="allmap" style="height: 200px"></div>
  <div class="mui-card-footer">
    <button type="button" class="mui-btn mui-btn-primary" onclick="location.href='/order/send/${business.id!}'">预定
    </button>
    <button type="button" class="mui-btn mui-btn-warning" onclick="location.href='/comment/send/${business.id!}'">评论
    </button>
    <button type="button" class="mui-btn mui-btn-success" onclick="location.href='/comment/${business.id!}'">查看评论
    </button>
  </div>
  <h5 style="background-color:#efeff4">热销菜</h5>
  <ul class="mui-table-view mui-grid-view">
    <#list foodList as item>
      <li class="mui-table-view-cell mui-media mui-col-xs-6">
        <a href="#">
          <img class="mui-media-object" src="${item.icon}">
          <div class="mui-media-body" style="height: auto">
            ${item.name}
            <p style="text-align: left">
              <span style="color: red;font-size: 16px">￥${item.price}</span>
              <del style="font-size: 12px">￥${item.oldPrice!}</del>
            </p>
          </div>
        </a></li>
    </#list>
  </ul>
</div>
</body>

<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(${business.pointX!}, ${business.pointY});
    map.centerAndZoom(point, 12);
    var marker = new BMap.Marker(point);  // 创建标注
    map.addOverlay(marker);              // 将标注添加到地图中

    var label = new BMap.Label("${business.name!}", {offset: new BMap.Size(20, -10)});
    marker.setLabel(label);
</script>
</html>