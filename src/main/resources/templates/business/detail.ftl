<!DOCTYPE html>
<!-- saved from url=(0046)http://waimai.baidu.com/waimai/shop/1905655425 -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>在线预约</title>

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

    <link rel="stylesheet" type="text/css" href="/front/business_files/basicinfo_c3e4798.css">
    <link rel="stylesheet" type="text/css" href="/front/business_files/menucommon_bebb0ee.css">
    <link rel="stylesheet" type="text/css" href="/front/business_files/tab_b3d88c8.css">
    <link rel="stylesheet" type="text/css" href="/front/business_files/popCarousel_89218b2.css">
    <link rel="stylesheet" type="text/css" href="/front/business_files/filter_4847ffc.css">
    <link rel="stylesheet" type="text/css" href="/front/business_files/setmeal_864a85e.css">
    <link rel="stylesheet" type="text/css" href="/front/business_files/list_3b46847.css">
    <link rel="stylesheet" type="text/css" href="/front/business_files/collect_35cd19e.css">
    <link rel="stylesheet" type="text/css" href="/front/business_files/menu_f039732.css">
</head>
<body>
<#include "../include/header.html"/>
<div id="content" class="clearfix" style="min-height: 610px;">
    <div class="main">
        <section class="breadcrumb">
            <a href="/">首页</a>
            <i>&gt;</i>
            <span>${business.name}</span>
        </section>
        <section class="basicinfo">
            <div class="b-img fl">
                <img width="198" height="120" src="${business.icon!}" data-src="${business.icon!}">
            </div>
            <div class="b-info fl">
                <div class="one-line">
                    <h2>${business.name}</h2>
                </div>
                <dl>
                    <dt><i class="icon icon-time"></i>接单时间:&nbsp;</dt>
                    <dd class="bussinessStatus">
                        <span>07:00-20:00</span><strong class="doing">营业中</strong></dd>
                </dl>
                <dl>
                    <dt><i class="icon icon-address"></i>商户地址:&nbsp;</dt>
                    <dd>
                        ${business.address!}
                    </dd>
                </dl>
                <dl>
                    <dt><i class="icon icon-phone"></i>商户电话:&nbsp;</dt>
                    <dd>
                        ${business.phone!}
                    </dd>
                </dl>
            </div>
            <div class="b-cost fr">
                <div class="b-value"><strong class="b-num">${business.category!}</strong></div>
                <p class="b-label">分类</p>
            </div>
            <div class="b-divider fr"></div>
            <div class="b-price fr">
                <div class="b-value"><strong class="b-num">${business.startNum}</strong></div>
                <p class="b-label">点赞次数</p>
            </div>
            <div class="b-divider fr"></div>
            <div class="b-price fr">
                <div class="b-value">
                    <strong class="b-num">${business.orderNum}</strong>
                    <span class="num-unit"></span></div>
                <p class="b-label">预约次数</p>
            </div>
            <div class="b-divider fr"></div>
            <div class="b-totime fr">
                <div class="b-value">
                    <strong class="b-num">${business.commendNum}</strong>
                    <span class="num-unit"></span></div>
                <p class="b-label">评论次数</p>
            </div>
        </section>
        <div class="main-l">
            <section class="menu-tab clearfix">
                <ul>
                    <li class="txt curr"><a href="/">菜单</a></li>
                    <li class="txt  "><a href="/comment/${business.id}">评论</a></li>
                </ul>
            </section>
            <section class="menu-list">
                <div class="list-wrap" id="menu_2">
                    <div class="list-status">
                        <span class="title">热销</span></div>
                    <div class="list clearfix">
                        <ul>
                            <#list foodList as item>
                                <li class="list-item">
                                    <figure class="headimg fl">
                                        <div class="bg-img"
                                             style="background: url('${item.icon}') center center no-repeat;background-size:cover;-webkit-background-size:cover;-o-background-size:cover;-moz-background-size:cover;-ms-background-size:cover;"></div>
                                    </figure>
                                    <div class="info fl">
                                        <h3 data-title="${item.name}">${item.name}</h3>
                                        <div class="info-desc">
                                            <p class="m-hot-value">
                                                <span class="sales-count">人推荐</span><span class="divider"></span>
                                                <span class="sales-count">月售47份</span>
                                            </p>
                                            <p class="m-hot-value">
                                                <span class="stock-count">库存9996份</span></p>
                                        </div>
                                        <div class="m-price">
                                            <span class="activityprice"><strong>¥${item.price}</strong></span>&nbsp;&nbsp;<del>
                                                <strong>¥${item.oldPrice}</strong></del>&nbsp;&nbsp;
                                        </div>
                                    </div>
                                </li>

                            </#list>

                        </ul>
                    </div>
                </div>
            </section>
        </div>
        <div class="side">
            <section id="shop-notice" class="notice clearfix">
                <p class="warp"></p>
                <h2>商家公告</h2>
                <p class="notice-desc" data-node="shop-notice">${business.content!}</p>
            </section>
            <section class="cart-section cart-fix" id="cart-section">
                <div class="menu-cart menu-cart-box-shadow">
                    <div class="cart-bar pointer">
                        <span class="cart-desc submit fr" id="cartSubmit" style=""
                              <#if sessionUser??>onclick="location.href ='/order/myCar'"
                              <#else>onclick="alert('请登录')"</#if>>预&nbsp;约</span>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
</body>
</html>