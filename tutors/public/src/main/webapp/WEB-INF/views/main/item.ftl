<#include "../template/itemTemplate.ftl">
<#macro m_body>
<!--suppress ALL -->
<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">Semenov's toys</a></li>
        <li><a href="#">Khokhloma 2015</a></li>
        <li class="active">Matreshka №11</li>
    </ol>
    <div class="row">
        <div class="col-md-4" >
            <img src="/resources/pics/one.jpg" class="my-foto" id="item-pic">
        </div>
        <div class="col-md-4">
            <h3></h3>

            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. <hr>

            <div class="row">
                <div class="col-md-6">Collection:</div>
                <div class="col-md-6">Khokhloma 2015</div>
                <div class="col-md-6">Height:</div>
                <div class="col-md-6">20 sm.</div>
                <div class="col-md-6">Width:</div>
                <div class="col-md-6">10 sm.</div>
                <div class="col-md-6">Weight:</div>
                <div class="col-md-6">500 g.</div>
            </div>

        </div>
        <div class="col-md-3 price">
            <h2 class="price-name">Matreshka №11</h2>
            <h1 class="price-price">$3.99</h1>
            <hr>
            avialability: <div class="price-items"> 10 items </div><br>
            count:
            <div class="price-count">
                <a href=""><span class="glyphicon glyphicon-minus" aria-hidden:"true"></span></a>
                <input type="text" value="1" class="price-count-input">
                <a href="#"><span class="glyphicon glyphicon-plus" aria-hidden:"true"></span></a>
            </div>
            <hr>
            <button class="btn btn-primary btn-lg price-cart-button" type="button">Add to Cart <span class="glyphicon glyphicon-shopping-cart"></span></button>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/js/zoomsl-3.0.js"></script>
<script type="text/javascript">
    jQuery(function(){

        $(".my-foto").imagezoomsl({
            zoomrange: [2.12, 12],
            magnifiersize: [530, 340],
            scrollspeedanimate: 10,
            loopspeedanimate: 5,
            cursorshadeborder: "10px solid black",
            magnifiereffectanimate: "slideIn"
        });
    });
</script>
</#macro>