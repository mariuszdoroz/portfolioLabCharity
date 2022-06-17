<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<header>
<%@ include file="main.jsp" %>
</header>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form action="/register" method="post" modelAttribute="user">
        <div class="form-group">
            <form:input type="firstname" path="firstname" placeholder="First Name" />
        </div>
        <div class="form-group">
            <form:input type="lastname" path="lastname" placeholder="Last Name" />
        </div>
        <div class="form-group">
            <form:input type="email" path="username" placeholder="Email" />
        </div>
        <div class="form-group">
            <form:input type="password" path="password" placeholder="Hasło" />
        </div>
<%--        <div class="form-group">--%>
<%--            <form:input type="password" path="password2" placeholder="Powtórz hasło" />--%>
<%--        </div>--%>
        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<%@ include file="footer.jsp" %>
