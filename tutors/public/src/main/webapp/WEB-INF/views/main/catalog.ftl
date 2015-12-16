<#-- @ftlvariable name="cat" type="ru.dz.labs.api.domain.Category" -->
<#-- @ftlvariable name="selected" type="ru.dz.labs.api.domain.Category" -->
<#include "../template/mainTemplate.ftl">
<#macro m_body>
<div class="container">

    <!--       CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES-->
    <div class="row">
        <#if selected??>
            <div class="col-xs-6 col-md-3">
                <#if selected.parent_id?has_content>
                <a href="/catalog?category=${selected.parent_id.id}" class="thumbnail" id="cat-item">Back to ${selected.parent_id.name}
                <#else>
                <a href="/catalog?category=" class="thumbnail" id="cat-item">Back
                </#if>

                    <#--<img src="/resources/pics/20151122swe1DsOfcv8DM6Bp_DwaaA.jpeg" class="thumbnails" alt="...">-->
                </a>
            </div>
            <#list childrenList as child>
                <div class="col-xs-6 col-md-12">
                    <a href="/catalog?category=${child.id}" class="thumbnail" id="cat-item">
                    ${child.name}
                    <#--<img src="/resources/pics/20151122swe1DsOfcv8DM6Bp_DwaaA.jpeg" class="thumbnails" alt="...">-->
                    </a>
                </div>
            </#list>
            <div class="col-xs-6 col-md-12">
                <hr>
                <h3>${selected.name}</h3>
            </div>
            <#else>
                <#list catalog as cat>
                    <#if cat.parent_id?has_content==false>
                        <div class="col-xs-6 col-md-3">
                            <a href="/catalog?category=${cat.id}" class="thumbnail" id="cat-item">
                            ${cat.name}
                    <#--<img src="/resources/pics/20151122swe1DsOfcv8DM6Bp_DwaaA.jpeg" class="thumbnails" alt="...">-->
                            </a>
                        </div>
                    </#if>
                </#list>
        </#if>

        <#--<div class="col-xs-6 col-md-3" id="cat-item-block">-->
            <#--<a href="#" class="thumbnail" id="cat-item-2">-->
                <#--<img src="/resources/pics/pistacchi-design-01_%20-%20Copy.jpg" class="thumbnails" alt="...">-->
            <#--</a>-->
        <#--</div>-->
    </div>
    <!--          CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES    CATEGORIES-->
    <hr>

    <!--     ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS  -->
    <div class="row">
        <div class="col-sm-6 col-md-3">
            <div class="thumbnail">
                <img src="/resources/pics/one.jpg">
                <div class="caption">
                    <h3>Matreshka #11</h3>
                    <p class="right"><a href="/item" class="btn btn-primary" role="button">Learn more</a> <a href="#" class="btn btn-default" role="button">Buy</a></p>
                </div>
            </div>
        </div>

    </div>
    <!--            ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS    ITEMS-->
</div>
</#macro>