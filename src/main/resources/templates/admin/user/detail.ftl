<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<#assign active='userList'/>
<body>
<#include "../include/common-top.ftl"/>
<div class="main-container" id="main-container">
  <div class="main-container-inner">
    <#include "../include/common-menu.ftl"/>
    <div class="main-content">
      <div class="page-content">
        <div class="col-xs-12">
          <div class="row-fluid">
            <div class="widget-box">
              <div class="widget-header widget-header-blue widget-header-flat">
                <h4 class="lighter">
                  <i class="icon-plus"></i>修改用户信息
                </h4>
              </div>
              <div class="widget-body">
                <div class="widget-main">
                  <div class="step-content row-fluid position-relative">
                    <form class="form-horizontal" action="/admin/user/update" method="post">
                      <input type="hidden" name="id" value="${user.id!}"/>
                      <div class="form-group has-info">
                        <label
                                class="col-xs-12 col-sm-3 control-label no-padding-right">手机号</label>
                        <div class="col-xs-12 col-sm-5">
                          <input type="text" class="width-100" readonly
                                 value="${user.phone}"/>
                        </div>
                      </div>
                      <div class="form-group has-info">
                        <label class="col-xs-12 col-sm-3 control-label no-padding-right">用户名</label>
                        <div class="col-xs-12 col-sm-5">
                          <input type="text" class="width-100" name="username"
                                 value="${user.username!}"/>
                        </div>
                      </div>
                      <div class="form-group has-info">
                        <label class="col-xs-12 col-sm-3 control-label no-padding-right">昵称</label>
                        <div class="col-xs-12 col-sm-5">
                          <input type="text" class="width-100" name="name"
                                 value="${user.name!}"/>
                        </div>
                      </div>
                      <div class="form-group has-info">
                        <label class="col-xs-12 col-sm-3 control-label no-padding-right">邮箱</label>
                        <div class="col-xs-12 col-sm-5">
                          <input type="text" class="width-100" name="email"
                                 value="${user.email!}"/>
                        </div>
                      </div>
                      <div class="form-group has-info">
                        <label class="col-xs-12 col-sm-3 control-label no-padding-right">微信</label>
                        <div class="col-xs-12 col-sm-5">
                          <input type="text" class="width-100" name="wx"
                                 value="${user.wx!}"/>
                        </div>
                      </div>

                      <div class="form-group has-info">
                        <label class="col-xs-12 col-sm-3 control-label no-padding-right">密码</label>
                        <div class="col-xs-12 col-sm-5">
                          <input type="password" class="width-100" name="password"/>
                        </div>
                      </div>


                      <hr/>
                      <div class="row-fluid wizard-actions">
                        <button class="btn" type="reset">重置</button>
                        <button class="btn btn-success" type="submit">提交</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>

            <div class="widget-box">
              <div class="widget-header widget-header-blue widget-header-flat">
                <h4 class="lighter">
                  <i class="icon-inbox"></i>用户画像
                </h4>
              </div>
              <div class="widget-body">
                <div class="widget-main">
                  <div id="hx"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- /.page-content -->
    </div>
    <!-- /.main-content -->
  </div>
  <!-- /.main-container -->
</body>
<#include "../include/resource-script.ftl"/>
<script src="/plugins/g2/g2.min.js"></script>
<script src="/plugins/g2/data-set.min.js"></script>
<script type="text/javascript">
    var data = ${map!};
    var chart = new G2.Chart({
        container: 'hx',
        forceFit: true,
        height: window.innerHeight
    });
    chart.source(data, {
        percent: {
            formatter: function formatter(val) {
                val = val * 100 + '%';
                return val;
            }
        }
    });
    chart.coord('theta', {
        radius: 0.75
    });
    chart.tooltip({
        showTitle: false,
        itemTpl: '<li><span style="background-color:{color};" class="g2-tooltip-marker"></span>{name}: {value}</li>'
    });
    chart.intervalStack().position('count').color('name').label('count', {
        formatter: function formatter(val, item) {
            return item.point.name + ': ' + val;
        }
    }).tooltip('name*count', function (name, count) {
        count = count * 100 + '%';
        return {
            name: name,
            value: count
        };
    }).style({
        lineWidth: 1,
        stroke: '#fff'
    });
    chart.render();
</script>
</html>

