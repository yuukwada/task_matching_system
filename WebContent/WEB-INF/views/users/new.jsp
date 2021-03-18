<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>ユーザー 新規登録ページ</h2>
        <p class=form_alerm>*氏名、Emailアドレス、生年月日、パスワードは必須入力項目です*</p>

        <form method="POST" enctype="multipart/form-data" action="<c:url value='/users/create' />">
            <c:import url="user_form.jsp" />
        </form>

        <br/><br/>
        <p><a href="<c:url value='/' />">トップに戻る</a></p>
    </c:param>
</c:import>