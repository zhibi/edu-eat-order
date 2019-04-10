<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>确认订单</title>

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


    <link rel="stylesheet" type="text/css" href="/front/pay_files/commit_21af7b1.css">
    <link rel="stylesheet" type="text/css" href="/front/pay_files/verifyphone_ce8c9cf.css">
    <link rel="stylesheet" type="text/css" href="/front/pay_files/address_be19f67.css">
<script src="/jquery-1.4.4.min.js"></script>
</head>
<body>

<#include "include/header.html"/>
<div id="content" class="clearfix" style="min-height: 610px;">
    <div class="main">
        <section class="breadcrumb">
            <span>确认订单</span>
        </section>
        <div class="main-l">
            <div class="empty clearfix"></div>
            <section id="commit_cart" class="cart-section fl">
                <div class="cart" data-node="cart">
                    <div class="cart-panel">
                        <table>
                            <thead class="cart-head">
                            <tr>
                                <td class="item-name">菜品</td>
                                <td class="item-count">份数</td>
                                <td class="item-price-all">金额</td>
                                <td class="item-price-all">操作</td>
                                <td class="item-takeplace"></td>
                            </tr>
                            </thead>
                            <tbody class="item-list">
                            <#list modelList as item>
                            <tr class="item " data-stockid="" id="cartItem_1735513608">
                                <td class="item-name">${item.foodName}</td>
                                <td class="item-count">${item.count}</td>
                                <td class="item-price">¥${item.price!}</td>
                                <td class="item-price"><a href="/order/delItem/${item.id}">删除</a></td>
                                <td class="item-takeplace"></td>
                            </tr>
                            </#list>

                            </tbody>
                        </table>
                        <div class="bottom-div">

                            <div class="order-msg">
                                总价：<span class="order-total">¥<span id="total_money">${money!0}</span></span>
                                <p data-node="discountMsg" style="display: none;"></p>
                            </div>
                            <div class="clearfix"></div>

                        </div>
                    </div>
                </div>
                <div class="cart-bottom"></div>
            </section>
            <section class="delivery fl" id="delivery">
                <form action="/order/pay" method="post">
                    <ul class="delivery-ul">
                        <li class="addr-list-li">
                            <div class="addr-detail new-address-section">
                                <table class="addr-table" border="0">
                                    <tbody>
                                    <tr>
                                        <td valign="top"><span
                                                class="l-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span></td>
                                        <td>
                                            <div class="form-group">
                                                <div class="input-control"><input type="text" name="receiveuser"
                                                                                  placeholder="您的姓名" value=""
                                                                                  class="placeholder-con"> <span
                                                        class="star">*</span></div>
                                                <div class="error-msg v-hide"></div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top"><span
                                                class="l-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</span></td>
                                        <td>
                                            <div class="form-group">
                                                <div class="input-control"><input type="text" name="phone"
                                                                                  placeholder="11位手机号" value=""
                                                                                  class="placeholder-con"> <span
                                                        class="star">*</span></div>
                                                <div class="error-msg v-hide"></div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top"><span
                                                class="l-label">位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置</span></td>
                                        <td>
                                            <div class="form-group">
                                                <div class="input-control ">
                                                    <input type="text" name="receiveaddress" placeholder="请输入小区、大厦或学校"
                                                           value="" class="placeholder-con poi_address"> <span
                                                            class="star">*</span>
                                                </div>
                                                <div class="error-msg v-hide"></div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top"><span class="l-label">备注</span></td>
                                        <td>
                                            <div class="form-group">
                                                <div class="input-control"><input type="text" name="remark"
                                                                                  class="placeholder-con">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </li>
                        <li>
                            <div class="delivery-lable">
                                <span class="lable"></span>
                            </div>
                            <div class="delivery-input hide delivery-btn" style="display: block;">
                                <span id="orderSubmit" onclick="$('form').submit()"><h2>确认下单</h2></span>
                            </div>
                        </li>
                    </ul>
                </form>
            </section>
            <div class="empty clearfix"></div>
        </div>
    </div>

</body>
</html>