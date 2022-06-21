<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<header>
<%@ include file="main.jsp" %>
</header>
<section class="login-page">
    <h2>Dodaj instytucje</h2>
    <form:form action="/institution" method="post" modelAttribute="institution">
        <div class="form-group">
            <form:input path="name" placeholder="Institution Name" />
        </div>
        <div class="form-group">
            <form:input path="description" placeholder="Institution Description" />
        </div>
        <div>
            <button class="btn--small" type="submit">Add/Edit</button>
        </div>
    </form:form>
        <div>
            <div>
                <h6>Institution list:</h6>
            </div>
            <div>
                <div>
                    <table>
                        <thead>
                        <tr>
                            <th style="width: 5%">id</th>
                            <th style="width: 30%">Title</th>
                            <th style="width: 50%">Subject</th>
                            <th style="width: 15%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${institutionlist}" var="elem">
                            <tr>
                                <td>${elem.id}</td>
                                <td>${elem.name}</td>
                                <td>${elem.description}</td>
                                <td>
                                    <a href="/institution/{id}" class="btn--small" type="button">Edit</a>
                                    <a href="/institution/del/${elem.id}" class="btn--small" type="button"> Delete </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</section>
<%@ include file="footer.jsp" %>
