<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/Site.css" />
<link rel="stylesheet" type="text/css" href="css/all.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/toastr.min.css" />

<meta charset="ISO-8859-1">
<title>Login</title>
</head>


<body>

   <div>
       <div id="mainLoader" class="main-loader">
           <div class="dot-floating"></div>
       </div>
      <div class="login">
    <div>
        <div class="login-header">
            <span></span>

             <i class="fas fa-paper-plane"></i>

            <label>Welcome</label>
            <div style="display:none" id="loginLoad" class="loading-dots">
                <div class="loading-dots--dot"></div>
                <div class="loading-dots--dot"></div>
                <div class="loading-dots--dot"></div>
            </div>
        </div>
        <div class="login-body">
            <div>
                <i class="fas fa-user"></i>
                <input placeholder="Username"
                       class="custom"
                       type="text"
                       id="username" />
            </div>
            <div>
                <i class="fas fa-unlock-alt"></i>
                <input placeholder="Your Password"
                       class="custom"
                       type="password"
                       id="password" />
            </div>
            <div>
                <button id="login">Login</button>
            </div>
        </div>
    </div>
</div>
       <div id="mobOverlay" class="mob-overlay"></div>
   </div>
   
<script src="scripts/app.js"></script>
<script src="scripts/jquery-3.3.1.min.js"></script>
<script src="scripts/bootstrap.min.js"></script>
<script src="scripts/layout.js"></script>
<script src="scripts/moment.min.js"></script>
<script src="scripts/toastr.min.js"></script>
<script src="scripts/viewScripts/Login.js"></script>

</body>
</html>