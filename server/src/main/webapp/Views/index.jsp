<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title></title>
    <meta charset="utf-8" name="viewport" content="width=device-width">
    <link rel="stylesheet" href="/stylesheets/style.css">
    <link rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="/javascripts/redirect.js"></script>
    <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
</html>
<div class="container">
  <div id="logo"></div>
  <div id="signup">
    <button type="button" onclick="return loadsigin()" class="Signinbutton">SignIn</button>
  </div>
  <!--modalsignin declaration-->
</div>
<div id="signin-modal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" class="close">x</button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="UserName">UserName</label>
            <input id="UserName" type="email | text" placeholder="Enter your username" class="form-control">
          </div>
          <div class="form-group">
            <label for="InputPassword">Password</label>
            <input id="password" type="password" placeholder="Enter your email" class="form-control">
          </div>
        </form><a href="javascript:loadforgotpassword()" class="spmodal">Forgot Password..?</a><br>
        <button type="submit" class="btn btn-default">Submit</button>
        <button type="button" onclick="return loadsignup()" class="btn btn-default">SignUp</button>
      </div>
      <div class="modal-footer"><a href="#" data-dismiss="modal" class="btn">Close</a></div>
    </div>
  </div>
</div>
<div id="signup-modal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" class="close">x</button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="Email">EmailAddress</label>
            <input id="EmailAddress" type="email" placeholder="Enter your EmailAddress" class="form-control">
          </div>
          <div class="form-group">
            <label for="UserName">UserName</label>
            <input id="UserName" type="email | text" placeholder="Enter your username" class="form-control">
          </div>
          <div class="form-group">
            <label for="Password">Password</label>
            <input id="UserName" type="password" placeholder="Enter your Password" class="form-control">
          </div>
          <div class="form-group">
            <label for="RetypePassword">ReTypePassword</label>
            <input id="password" type="password" placeholder="Enter your Password" class="form-control">
          </div>
        </form>
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
      <div class="modal-footer"><a href="#" data-dismiss="modal" class="btn">Close</a></div>
    </div>
  </div>
</div>
<div id="forgotpassword-modal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" class="close">x</button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="Email">EmailAddress</label>
            <input id="EmailAddress" type="email" placeholder="Enter your EmailAddress" class="form-control">
          </div>
        </form>
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
      <div class="modal-footer"><a href="#" data-dismiss="modal" class="btn">Close</a></div>
    </div>
  </div>
</div>