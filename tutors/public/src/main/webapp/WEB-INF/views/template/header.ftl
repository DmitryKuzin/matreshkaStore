 <#--@ftlvariable name="curUser" type="java.util.List<ru.dz.labs.api.domain.Users>" -->
 <script>
     jQuery(document).ready(function($) {

         $("#login-nav").submit(function(event) {

             // Prevent the form from submitting via the browser.
             event.preventDefault();

             searchViaAjax();

         });

     });
     function searchViaAjax(){
            var data={};
            data["email"]=$("#exampleInputEmail2").val();
            data["pass"]=$("#exampleInputPassword2").val();
            $.ajax({
                type: "POST",
                contentType : "application/json",
                url: "/ajax",
                data: JSON.stringify(data),
                dataType : 'json',
                timeout : 100000,
                success : function(data) {
                    console.log("SUCCESS: ", data);
                    display(data);
                },
                error : function(e) {
                    console.log("ERROR: ", e);
                    display(e);
                },
                done : function(e) {
                    console.log("DONE");

                }
            });
     }
     function display(data) {
         var json = "<li><a href='#' style='color:white'>"+ dropQuotes(JSON.stringify(data.result.name, null, 4)) + "</a></li>";
//         $('#must-be-replaced').html(json);
         var json2="<li class='dropdown' id='must-be-replaced'>"
        +"<a href='#' class='dropdown-toggle' data-toggle='dropdown'><b>"+ dropQuotes(JSON.stringify(data.result.name, null, 4))+"</b> <span class='caret'></span></a>"+
         "<ul id='login-dp' class='dropdown-menu'>"
                 +"<li><div class='row'><div class='col-md-12'><div class='row'><div class='col-md-12'><img style='width: 100%' src='/resources/pics/user-man-circle-invert-512.png'>"+
                " </div><div class='col-md-12'><h5>login</h5></div></div>"
                +"<form class='form' role='form' accept-charset='UTF-8' id='login-nav'><div class='form-group'>"
                 +"<button type='submit' id='signOut' class='btn btn-primary btn-block'>Sign out</button>"
                +"</div></form></div></div></li></ul></li>";
         $('#must-be-replaced').replaceWith(function(){
             return json2;
         });
     }
     function dropQuotes(a){
         var b=""+a;
         b= b.substring(1);
         b= b.substring(0, b.length-1);
         return b;
     }
 </script>
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
                <#if userlogined??>
                <#--<li><a href="#" style='color:white'>${userName}</a></li>-->
                <#include "account.ftl"/>
                <#else>
                <#include "login.ftl" />
                </#if>
                <li><a href="#">Support</a></li>
                <li><a href="#" data-toggle="modal" data-target="#myModal">Cart <span class="badge">$7.98</span></a>
                </li>
            </ul>
        </div>

    </div>
</nav>