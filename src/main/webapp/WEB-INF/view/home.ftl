<#import "spring.ftl" as spring />
<h2>Hello, jikra</h2>

<div>Name: ${customer.name}</div>
<div>Age: ${customer.age!"default value"}</div>
<div>Birth: ${customer.birth!"N/A"}</div>

<form name="user" action="/sample/customer" method="post">
    Firstname: <input type="text" name="name"/> <br/>
    Age: <input type="number" name="age"/><br/>
    Date: <input type="date" name="birth"/><br/>
    <input type="submit" value="OK"> <br/>
    <@spring.bind "customer.age"/>
    ${spring.status.errorMessage}
    ${spring.status.errorCode}
</form>

<hr>

<form name="upload" method="post" action="/sample/upload"
      enctype="multipart/form-data">
    File1: <input type="file" name="uploadFile" multiple>
    <input type="submit" value="OK">
</form>

<hr>
<h3>version: ${version}</h3>