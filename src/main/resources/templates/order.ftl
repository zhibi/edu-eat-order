<!DOCTYPE html>
<!-- saved from url=(0053)http://waimai.baidu.com/waimai?qt=orderlist&type=wait -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>我的订单</title>

    <link rel="stylesheet" type="text/css" href="/front/index_files/main_a79c03f.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/cartAlert_69d76b3.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/common_4840c98.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/citybar_2daccc1.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/landing_26d4e9b.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/muti_60d05dd.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/registerDialog_77e55d3.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/userInfo_11c5a6b.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/search_cae56fa.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/addressEditDialog_be19f67.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/search_b1f3d15.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/nav_92fb35c.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/shoplist_b2c246e.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/shopcard_93f9a30.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/dishcard_d331747.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/backtop_e064524.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/footer_bf9a09d.css">

    <link rel="stylesheet" type="text/css" href="/front/order_files/menu_528c8dc.css">
    <link rel="stylesheet" type="text/css" href="/front/order_files/order_7bc6e18.css">
    <link rel="stylesheet" type="text/css" href="/front/order_files/usercenter_1e040d1.css">
</head>
<body>
<#include "include/header.html"/>
<div id="content" class="clearfix" style="min-height: 610px;">
    <div class="main">
        <section class="order-menu">
            <div class="order-menu-pos">
                <div class="order-menu-header">
                    <span>个人中心</span>
                </div>
                <div class="splitter"></div>
                <div class="order-menu-body">
                    <div class="menu-item">
                        <div id="menu-order" class="selected">
                            <span class="menu-icon order-icon"></span>
                            <a href="/order/myOrder"
                               class="menu-title order"><span>我的订单</span></a>
                        </div>
                    </div>

                </div>
            </div>
        </section>

        <section class="usercenter-detail" id="user-order">
            <div class="summary">
                <h3 class="summary-header">全部订单</h3>
            </div>
            <div><a class="cms-charlink" data-node="summary-txtLinkExpand" href="javascript:void(0);"></a></div>
            <div class="order-cards" data-node="order-cards">
            <#list modelList as item>
                <div class="order-card order-process">
                    <div class="pay-status" data-node="order-status">支付成功</div>
                    <div class="order-content">
                        <div class="order-dishes">
                            <table>
                                <tbody>
                                    <#list item.orderItemModelList as im>
                                    <tr data-node="dishes">
                                        <td data-node="dish" data-origin="${im.foodName}">${im.foodName}</td>
                                        <td>${im.count}</td>
                                        <td class="text-right">￥${im.price}</td>
                                        <td>
                                            <#if im.score gt 0>
                                                ${im.score!0}分
                                            <#else >
                                            <form action="/order/score" method="post">
                                                <input type="hidden" name="orderItemId" value="${im.id}">
                                                <input type="number" name="score" min="1" max="5" value="1" style=" border: 1px solid #CECECE;width: 50%;">
                                                <input type="submit" value="打分">
                                            </form>
                                            </#if>

                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                            </table>
                            <div class="order-price"> 总价：<span class="ft-red">￥${item.total}</span></div>
                            <div class="order-delivery">
                                <div class="receive-info">
                                    <span>送餐地址：${item.receiveaddress!}</span>
                                    <span>联系人：${item.receiveuser!}</span> <span>电话：${item.phone!}</span>
                                    <span>备注信息：${item.remark!}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>

            </div>
            <div class="callCenter" data-node="callCenter"></div>
        </section>

        <div class="clearfix" style="_height:0px;_overflow:hidden;"></div>
    </div>
</div>

</body>
</html>