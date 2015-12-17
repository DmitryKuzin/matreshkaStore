<#-- @ftlvariable name="item" type="ru.dz.labs.api.domain.Goods" -->
<#-- @ftlvariable name="cat" type="ru.dz.labs.api.domain.Category" -->
<#include "../template/itemTemplate.ftl">
<#macro m_body>
<!--suppress ALL -->
<div class="container">
    <ol class="breadcrumb">
        <#--<#list item as cat>-->
            <#--<li><a href="${cat.alias!'#'}">${cat.name!'null'}</a></li>-->
        <#--</#list>-->
        <li><a href="/catalog?catalog=">Back</a></li>
        <#--<li><a href="#">Khokhloma 2015</a></li>-->
        <li class="active">${item.name}</li>
    </ol>
    <div class="row">
        <div class="col-md-4" >
            <img src="${item.image}" class="my-foto" id="item-pic">
        </div>
        <div class="col-md-4">
            <h3></h3>
            ${item.description}
            <hr>

            <div class="row">
                <div class="col-md-6">Collection:</div>
                <div class="col-md-6">${item.category_id.name!'null'}</div>
                <div class="col-md-6">Made in:</div>
                <div class="col-md-6">${item.country}</div>
                <div class="col-md-6">Size:</div>
                <div class="col-md-6">${item.size}</div>
                <div class="col-md-6">Year of production:</div>
                <div class="col-md-6">${item.year}</div>
            </div>

        </div>
        <div class="col-md-3 price">
            <h2 class="price-name">${item.name}</h2>
            <h1 class="price-price">$${item.price}</h1>
            <hr>
            avialability: <div class="price-items">
            <#if item.count==1>
                (last item)red color!
                <#else>
                ${item.count} items
            </#if>
             </div><br>
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