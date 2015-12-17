<#-- @ftlvariable name="cat" type="ru.dz.labs.api.domain.Category" -->
<#-- @ftlvariable name="selected" type="ru.dz.labs.api.domain.Category" -->
<#-- @ftlvariable name="good" type="ru.dz.labs.api.domain.Goods" -->
<#-- @ftlvariable name="child" type="ru.dz.labs.api.domain.Category" -->
<#include "../template/catalogTemplate.ftl">
<#macro m_body>
<div class="container">

    <!--       CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES-->
    <div class="row" style="padding-top:20px">
        <#if selected??>
            <#--<div class="col-xs-6 col-md-3">-->
                <#--<#if selected.parent_id?has_content>-->
                <#--<a href="/catalog?category=${selected.parent_id.id}" class="thumbnail" id="cat-item">Back to ${selected.parent_id.name}-->
                <#--<#else>-->
                <#--<a href="/catalog?category=" class="thumbnail" id="cat-item">Back-->
                <#--</#if>-->

                    <#--&lt;#&ndash;<img src="/resources/pics/20151122swe1DsOfcv8DM6Bp_DwaaA.jpeg" class="thumbnails" alt="...">&ndash;&gt;-->
                <#--</a>-->
            <#--</div>-->
            <#list childrenList as child>
                <div class="col-xs-6 col-md-3">
                    <a href="/catalog?category=${child.id}" class="thumbnail" id="cat-item">
                    ${child.name}
                    <img src="${child.alias}" class="thumbnails" alt="...">
                    </a>
                </div>
            </#list>
            </div>
            <h3>Items</h3>
            <hr>
            <div class="chip">
                <b>${selected.name}</b>
                <a href="/catalog?catalog="><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
            </div>
            <div class="row">
                <#list selected.goods as good >
                    <div class="col-sm-6 col-md-3">
                        <div class="thumbnail">
                            <img src="${good.image}" style="max-width: 70%;
    max-height: 70%;">
                            <div class="caption">
                                <h3>${good.name}</h3>
                                <p class="right"><a href="/item?id=${good.id}" class="btn btn-primary" role="button">Learn more</a> <a href="#" class="btn btn-default" role="button">Buy</a></p>
                            </div>
                        </div>
                    </div>
                </#list>

            </div>
            <#else>
                <#list catalog as cat>
                    <#if cat.parent_id?has_content==false>
                        <div class="col-xs-6 col-md-3">
                            <a href="/catalog?category=${cat.id}" class="thumbnail" id="cat-item">
                            <img src="${cat.alias}" class="thumbnails" alt="...">
                            </a>
                        </div>
                    </#if>
                </#list>
            </div>
            <h3>Items</h3>
            <hr>
            <div class="row">
                <#list allGoods as good>
                    <div class="col-sm-6 col-md-3">
                        <div class="thumbnail">
                            <img src="${good.image}" style="max-width: 70%;
    max-height: 70%;">
                            <div class="caption">
                                <h3>${good.name}</h3>
                                <p class="right"><a href="/item?id=${good.id}" class="btn btn-primary" role="button">Learn more</a> <a href="#" class="btn btn-default" role="button">Buy</a></p>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </#if>

</div>
</#macro>