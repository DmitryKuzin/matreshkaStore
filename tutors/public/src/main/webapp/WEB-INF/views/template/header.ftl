<nav class="navbar navbar-inverse">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/" style="padding:3px;width:150px">
                <span id="logo-name">MatrёшkaStore</span>
                <img id="log-pic" src="/resources/pics/logo.png">
            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <#include "login.ftl" />
                <li><a href="#">Support</a></li>
                <li><a href="#" data-toggle="modal" data-target="#myModal">Cart <span class="badge">$7.98</span></a>
                </li>
            </ul>
        </div>

    </div>
</nav>