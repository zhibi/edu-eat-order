<!DOCTYPE html>
<!-- saved from url=(0046)http://waimai.baidu.com/waimai/shop/1905655425 -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>在线点餐</title>

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

    <link rel="stylesheet" type="text/css" href="/themes/front/business_files/basicinfo_c3e4798.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/business_files/menucommon_bebb0ee.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/business_files/tab_b3d88c8.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/business_files/popCarousel_89218b2.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/business_files/filter_4847ffc.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/business_files/setmeal_864a85e.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/business_files/list_3b46847.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/business_files/collect_35cd19e.css">
    <link rel="stylesheet" type="text/css" href="/themes/front/business_files/menu_f039732.css">
</head>
<body>
<#include "include/header.html"/>
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
            </div>
            <div class="b-cost fr">
                <div class="b-value">¥<strong class="b-num">${business.free!}</strong></div>
                <p class="b-label">配送费</p>
            </div>
            <div class="b-divider fr"></div>
            <div class="b-totime fr">
                <div class="b-value">
                    <strong class="b-num">
                        30分钟</strong>
                    <span class="num-unit"></span></div>
                <p class="b-label">平均送达时间</p>
            </div>
        </section>
        <div class="main-l">
            <section class="menu-tab clearfix">
                <ul>
                    <li class="txt "><a href="/detail/${business.id!}">菜单</a></li>
                    <li class="txt  curr"><a href="/">评论</a></li>
                </ul>
            </section>
            <section class="comment-list" id="comment-list">
                <div class="comment-con" data-node="commCon">

                    <#list commentList as item>
                        <div class="list clearfix">
                            <div class="top-section"><span class="user-name">${item.user!}</span>
                                <span class="fr">${item.addtime?string('yyyy-MM-dd HH:mm:ss')}</span></div>
                            <div class="mid-section"><p>${item.content!}</p></div>

                        </div>
                    </#list>

                    <form action="/comment/send" method="post">
                        <input type="hidden" name="businessid" value="${business.id}">
                        <textarea name="content" cols="150" rows="8"></textarea>
                        <input type="submit" style="    padding: 9px 20px;
    font-size: 20px;
    color: white;

    font-weight: bolder;
    background-color: #ff2d4b;
    margin-top: 89px;" value="发表">
                    </form>


            </section>
        </div>
        <div class="side">
            <section id="shop-notice" class="notice clearfix">
                <p class="warp"></p>
                <h2>商家公告</h2>
                <p class="notice-desc" data-node="shop-notice">${business.notice!}</p>
            </section>
            <section class="cart-section cart-fix" id="cart-section">
                <div class="menu-cart menu-cart-box-shadow">
                    <div class="cart-bar pointer">
                        <span class="cart-desc submit fr" id="cartSubmit" style=""
                              <#if sessionUser??>onclick="location.href ='/order/myCar'"
                              <#else>onclick="alert('请登录')"</#if>>选好了</span>
                    </div>
                </div>
            </section>
        </div>
    </div>

</div>
</body>
<script src="/themes/jquery-1.4.4.min.js"></script>
<script>
    function add(id) {
        <#if sessionUser??>
            $.getJSON("/order/saveItem", {footId: id}, function (result) {
                if (result.code === 200) alert("添加成功");
                else {
                    alert(result.message);
                }
            });
        <#else>
        alert("请登录");
        </#if>

    }

</script>
</html>