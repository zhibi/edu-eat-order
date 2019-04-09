<head>
    <meta charset="utf-8"/>
    <title>后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link rel="stylesheet" href="/webjars/chosen/1.8.7/chosen.min.css"/>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/webjars/font-awesome/3.2.1/css/font-awesome.min.css"/>
    <!--[if IE 7]>
    <link rel="stylesheet" href="/webjars/font-awesome/3.2.1/css/font-awesome-ie7.min.css"/>
    <![endif]-->
    <!-- page specific plugin styles -->
    <!-- ace styles -->
    <link rel="stylesheet" href="/plugins/ace/css/ace.min.css"/>
    <link rel="stylesheet" href="/plugins/ace/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="/plugins/ace/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/plugins/ace/css/ace-ie.min.css"/>
    <![endif]-->

    <link rel="stylesheet" href="/webjars/bootstrap-fileinput/4.3.1/css/fileinput.min.css">
    <link rel="stylesheet" href="/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">

    <!-- inline styles related to this page -->
    <!-- ace settings handler -->

    <script src="/plugins/ace/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="/webjars/html5shiv/3.7.2/dist/html5shiv.min.js"></script>
    <script src="/webjars/respond/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<div class="modal fade" id="modalMsg" tabindex="-1" role="dialog" aria-labelledby="modalMsgLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="modalAcceptLabel">信息提示</h4>
            </div>
            <div class="modal-body" id="m-msg">

            </div>
        </div>
    </div>
</div>