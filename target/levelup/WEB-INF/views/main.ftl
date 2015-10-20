<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<!DOCTYPE html>
<html>
<head>
    <title>My Zoo</title>
    <link href="<@c.url value="/resources/css/main.css" />" rel="stylesheet" media="screen"/>
    <link href="<@c.url value="/resources/css/lib/bootstrap.css" />" rel="stylesheet" media="screen"/>
    <link href="<@c.url value="/resources/css/lib/font-awesome.css" />" rel="stylesheet" media="screen"/>
    <link href="<@c.url value="/resources/css/lib/jquery-ui.css" />" rel="stylesheet" media="screen"/>
    <link href="<@c.url value="/resources/css/lib/jquery-ui.structure.css" />" rel="stylesheet" media="screen"/>
    <link href="<@c.url value="/resources/css/lib/jquery-ui.theme.css" />" rel="stylesheet" media="screen"/>
    <script type="text/javascript" src="<@c.url value="/resources/js/jquery-2.1.4.js"/>"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/jquery-ui.js"/>"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/main.js"/>"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/myjs.js"/>"></script>
    <script type="text/javascript">
        var $applicationRoot = "<@s.url value="/" />";
        var $host = document.location.protocol + '//' + document.location.host;
        var $hostRoot = document.location.protocol + '//' + document.location.host + $applicationRoot;
    </script>
</head>

<body>
<div class="container">
    <div class="page-header">
        <h1 id="zoo">My Zoo</h1>
    </div>
    <div class="col-lg-12">
        <table id="animals-table" class="table table-striped">
            <thead>
            <tr>
                <td>Имя</td>
                <td>Возраст</td>
                <td>Пол</td>
                <td>WTF</td>
                <td></td>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
        <button id="add-animal" class="btn btn-success pull-right go">Добавить</button>
        <#--<button id="save-animal" class="btn btn-success pull-right">Сохранить</button>-->
        <div id="animals-pre-loader" class="text-center">
            <i class="fa fa-refresh fa-spin fa-2x"></i>
        </div>
    </div>
    <div id="message-block">
    </div>
</div>

<div id="modal_form"><!-- Сaмo oкнo -->
    <span id="modal_close">X</span> <!-- Кнoпкa зaкрыть -->
    <!-- Тут любoе сoдержимoе -->
    <table id="animals-table-modal" class="table table-striped">
        <thead>
        <tr>
            <td>Имя</td>
            <td>Возраст</td>
            <td>Пол</td>
            <td>WTF</td>
            <td></td>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
    <button id="save-animal" class="btn btn-success pull-right">Сохранить</button>
</div>
<div id="overlay"></div><!-- Пoдлoжкa -->

<#--<div id="slide">-->

<#--</div>-->

</body>
</html>