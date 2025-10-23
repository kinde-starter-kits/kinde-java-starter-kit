<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.kinde.principal.KindePrincipal" %>
<!DOCTYPE html>
<html>
<head>
    <title>KindeAuth</title>
    <link rel="stylesheet" type="text/css" href="../static/index.css" />
</head>
<body>
<header>
    <nav class="nav container">
        <h1 class="text-display-3">KindeAuth</h1>
        <div class="profile-blob">
<%
KindePrincipal kindePrincipal = (KindePrincipal)request.getUserPrincipal();
if (kindePrincipal.getUserInfo().getPicture() != null) {
%>
            <img class="avatar" src="<%=kindePrincipal.getUserInfo().getPicture()%>" alt="user profile avatar" />
<%
} else {
%>
            <div class="avatar"><%=kindePrincipal.getUserInfo().getId()%></div>
<%
}
%>
            <div>
                <p class="text-heading-2"><%=kindePrincipal.getUserInfo().getId()%></p>
                <button class="text-subtle" onclick="redirectToLogOut()">Sign out</button>
            </div>
        </div>
    </nav>
</header>

<main>
    <div class="container">
        <div class="card start-hero">
            <p class="text-body-2 start-hero-intro">Woohoo!</p>
            <p class="text-display-2">
                Your authentication is all sorted.
                <br />
                Build the important stuff.
            </p>
        </div>
        <section class="next-steps-section">
            <h2 class="text-heading-1">Next steps for you</h2>
        </section>
    </div>
</main>

<footer class="footer">
    <div class="container">
        <strong class="text-heading-2">KindeAuth</strong>
        <p class="footer-tagline text-body-3">
            Visit our <a class="link" href="https://kinde.com/docs">help center</a>
        </p>
        <small class="text-subtle">© 2023 KindeAuth, Inc. All rights reserved</small>
    </div>
</footer>

<script inline="javascript">
    function redirectToLogOut() {
        window.location.href = "../logout";
    }
</script>
</body>
</html>
