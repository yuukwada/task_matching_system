<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">

    <c:param name="content">
        <h1>ようこそ、お悩みマッチングシステムへ</h1>
        <br/><br/><br/><br/><br/><br/>

        <div class="login_create">
            <h2>企業用リンク</h2>
            <a href="<c:url value="/login/company_login"/>">ログイン</a>
            <br/>
            <a href="<c:url value="/companies/new"/>">企業新規登録</a>
            <br/><br/>

            <h2>個人ユーザー用リンク</h2>
            <a href="<c:url value="/login/user_login"/>">ログイン</a>
            <br/>
            <a href="<c:url value="/users/new"/>">ユーザー新規登録</a>
            <br/><br/><br/>

        </div>


    </c:param>

</c:import>