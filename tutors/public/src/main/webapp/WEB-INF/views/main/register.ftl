<#include "../template/registerTemplate.ftl">
<#macro m_body>
<div class="container">
    <div class="row">
        <form action="/reg" method="post"
        <div class="col-xs-12" style="padding-bottom:5px">
            name <input type="text" name="name">
        </div>
        <div class="col-xs-12" style="padding-bottom:5px">
            email <input type="text" name="email">
        </div>
        <div class="col-xs-12" style="padding-bottom:5px">
            password <input type="text" name="pass">
        </div>
        <div class="col-xs-12" style="padding-bottom:5px">
            avatar <input type="text" name="avatar">
        </div>
    </div>
    <h5>Would you like to enter your home address to receive purchases?</h5>
    <div class="row">
        <button type="button" class="btn btn-default">Yes</button><button type="button" class="btn btn-default">No</button>
    </div>
    <h7>check if flat,index.. does int!!</h7>
    <h7>if yes-></h7>
    <div class="row">
        <div class="col-xs-12" style="padding-bottom:5px">
            area <input type="text" name="area">
        </div>
        <div class="col-xs-12" style="padding-bottom:5px">
            city <input type="text" name="city">
        </div>
        <div class="col-xs-12" style="padding-bottom:5px">
            street <input type="text" name="street">
        </div>
        <div class="col-xs-12" style="padding-bottom:5px">
            house <input type="text" name="house">
        </div>
        <div class="col-xs-12" style="padding-bottom:5px">
            flat <input type="text" name="flat">
        </div>
        <div class="col-xs-12" style="padding-bottom:5px">
            index <input type="text" name="index">
        </div>
    </div>
    <button type="submit" class="btn btn-default">Create account</button>
    </form>
</div>
</#macro>