<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>新規企業登録ページ</h2>
        <p class=form_alerm>*企業名、企業Emailアドレス、パスワードは必須入力項目です*</p>

        <form method="POST" enctype="multipart/form-data" action="<c:url value='/companies/create' />" >
            <c:import url="company_form.jsp" />
        </form>

        <br/><br/>
        <p><a href="<c:url value='/' />">トップに戻る</a></p>
    </c:param>
</c:import>