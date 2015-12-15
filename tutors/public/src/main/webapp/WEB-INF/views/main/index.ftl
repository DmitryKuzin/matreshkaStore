<#include "../template/mainTemplate.ftl">
<#macro m_body>
<#--carousel-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <a href="/item">
                <img src="/resources/pics/3280%20-%20Copy%20(2).jpg" alt="..." class="img-responsive center-block">
            </a>
            <div class="carousel-caption">
                <h2>MATRЁШKA TOY RIGHT NOW JUST FOR $3.99</h2>
                <div class="karusel-description">
                    <a href="/item" class="karusel-link">Learn more </a><a href="#" class="karusel-link">Buy</a>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/resources/pics/4(231)%20-%20Copy.jpg" class="img-responsive center-block">
            <div class="carousel-caption">
                <h2 id="karusel-header">NEW KHOCKHLOMA COLLECTION</h2>
                <div class="karusel-description">
                    <a href="#" class="karusel-link">Learn more </a><a href="#" class="karusel-link">Buy</a>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/resources/pics/slide3.jpg" class="img=responsive center-block">
            <div class="carousel-caption">
                <div class="karusel-description"><a href="#" class="karusel-link">Learn more </a><a href="#" class="karusel-link" >Buy</a></div>
            </div>
        </div>
    </div>
</div>

<#--top-categories-->
<div class="row">
    <div class="col-xs-6 col-md-4">
        <a href="#" class="thumbnail" id="top-cat-left">
            <img src="/resources/pics/post-10726-1201174559.jpg" class="thumbnails">
        </a>
    </div>
    <div class="col-xs-6 col-md-4">
        <a href="#" class="thumbnail" id="top-cat-center">
            <img src="/resources/pics/20151122swe1DsOfcv8DM6Bp_DwaaA.jpeg" class="thumbnails">
        </a>
    </div>
    <div class="col-xs-6 col-md-4">
        <a href="/catalog" class="thumbnail" id="top-cat-right">
            <img src="/resources/pics/uDd.jpeg" class="thumbnails">
        </a>
    </div>
</div>

<script type="text/javascript">
    $('.carousel').carousel();
</script>
</#macro>