<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>営業マッチングシステム</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">

    </head>
    <body>
        <div id="wrapper">
            <div id="header">

                    <h1><a href="<c:url value='/' />">営業マッチングシステム</a></h1>&nbsp;&nbsp;&nbsp;

                    <c:if test="${sessionScope.login_user != null}">
                        <div id="user_name">
                            <c:out value="${sessionScope.login_user.name}" />&nbsp;さん&nbsp;&nbsp;&nbsp;
                            <a href="<c:url value="/users/show?id=${sessionScope.login_user.id}" />">ユーザー情報</a>&nbsp;&nbsp;&nbsp;
                            <a href="<c:url value='/user_logout' />">ユーザーログアウト</a>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.login_company != null}">
                        <div id="company_name">
                            <c:out value="${sessionScope.login_company.name}" />&nbsp;さん&nbsp;&nbsp;&nbsp;
                            <a href="<c:url value='/reports/favorite_index' />">気になるお悩み一覧</a>&nbsp;
                            <a href="<c:url value='/companies/show?id=${sessionScope.login_company.id}' />">企業情報</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<c:url value='/company_logout' />">企業ログアウト</a>
                        </div>
                    </c:if>


            </div>







            <div id="content">
                ${param.content}
            </div>

            <div id="footer">
                by Yuki Wada.
            </div>

        </div>
    </body>
</html>