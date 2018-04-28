<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>确认订单</title>

    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/main_a79c03f.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/cartAlert_69d76b3.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/common_4840c98.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/citybar_2daccc1.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/landing_26d4e9b.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/muti_60d05dd.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/registerDialog_77e55d3.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/userInfo_11c5a6b.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/search_cae56fa.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/addressEditDialog_be19f67.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/search_b1f3d15.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/nav_92fb35c.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/shoplist_b2c246e.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/shopcard_93f9a30.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/dishcard_d331747.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/backtop_e064524.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/index_files/footer_bf9a09d.css">


    <link rel="stylesheet" type="text/css" href="/themes/front/pay_files/commit_21af7b1.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/pay_files/verifyphone_ce8c9cf.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/pay_files/address_be19f67.css">

</head>
<body>

<#include "include/header.html"/>
<div id="content" class="clearfix" style="min-height: 610px;">
    <div class="main">
        <section class="breadcrumb">
            <a href="/">首页</a>
            <i>&gt;</i>
            <a href="/">大懒龙（双子店）</a><i>&gt;</i>
            <span>确认订单</span>
        </section>
        <div class="main-l">
            <div class="empty clearfix"></div>
            <section id="commit_cart" class="cart-section fl">
                <div class="cart" data-node="cart">
                    <div class="title">
                        <div onclick="javascript:window.location='';">
                            <i></i>
                            <span>返回购物车修改</span>
                        </div>
                    </div>
                    <div class="cart-panel">
                        <table>
                            <thead class="cart-head">
                            <tr>
                                <td class="item-name">菜品</td>
                                <td class="item-price">单价</td>
                                <td class="item-count">份数</td>
                                <td class="item-price-all">金额</td>
                                <td class="item-takeplace"></td>
                            </tr>
                            </thead>
                            <tbody class="item-list">
                            <tr class="item " data-stockid="" id="cartItem_1735513608">
                                <td class="item-name">蜜汁脆皮鸡饭</td>
                                <td class="item-price">¥37.99</td>
                                <td class="item-count"><input type="hidden" value="1735513608"><span class="item-count">1</span>
                                </td>
                                <td class="item-price-all">¥37.99</td>
                                <td class="item-takeplace"></td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="collect">
                            <tbody>
                            <tr class="item" data-node="sendPrice" style="">
                                <td class="item-name" colspan="3">配送费</td>
                                <td class="item-price-all">¥<span id="sendFee">4</span></td>
                                <td class="item-takeplace"></td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="bottom-div">

                            <div class="order-msg">
                                总价：<span class="order-total">¥<span id="total_money">44.99</span></span>
                                <p data-node="discountMsg" style="display: none;"></p>
                            </div>
                            <div class="clearfix"></div>

                        </div>
                    </div>
                </div>
                <div class="cart-bottom"></div>
            </section>
            <section class="delivery fl" id="delivery">
                <input type="hidden" value="0" data-node="left-check-count-down">
                <input type="hidden" value="" data-node="left-check-vercode">
                <ul class="delivery-ul">
                    <li class="addr-list-li">
                        <div class="addr-detail new-address-section">
                            <table class="addr-table" border="0">
                                <tbody>
                                <tr>
                                    <td valign="top"><span
                                            class="l-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span></td>
                                    <td><input type="hidden" value="" name="adrr_id">
                                        <div class="form-group">
                                            <div class="input-control"><input type="text" name="user_name"
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
                                            <div class="input-control"><input type="text" name="user_phone"
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
                                            <div class="input-control poi_address"><i class="addr-icon-input"></i>
                                                <input type="text" name="sug_address" placeholder="请输入小区、大厦或学校"
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
                                            <div class="input-control"><input type="text" name="detail_address"
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
                            <span id="orderSubmit"><h2>确认下单</h2></span>
                        </div>
                    </li>
                </ul>
            </section>
            <div class="empty clearfix"></div>
        </div>
    </div>

</body>
</html>