<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>


        <h2>検索お悩み一覧</h2>
        <table id="report_list">
            <tbody>
                <tr>
                    <th>タイトル</th>
                    <th>お名前</th>
                    <th>電話番号</th>
                    <th>住所</th>
                    <th>予算帯</th>
                    <th>お悩みに関係する業種</th>
                    <th> </th>
                    <th> </th>
                </tr>
                <c:forEach var="report" items="${reports}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${report.title}" /></td>
                        <td><c:out value="${report.user.name}" /></td>
                        <td><c:out value="${report.user.phone_number}" /></td>
                        <td><c:out value="${report.user.place_prefecture}" /></td>
                        <td><c:out value="${report.budget}" /></td>
                        <td><c:out value="${report.industry}" /></td>
                        <td><a href="<c:url value='/reports/show?id=${report.id}' />">詳細を表示</a></td>
                        <td><a href="<c:url value='/users/show?id=${report.user.id}' />">ユーザー詳細</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${reports_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((reports_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/reports/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <br/><br/>

        <c:if test="${sessionScope.login_user != null}">
            <p><a href="<c:url value='/reports/new' />">新規お悩みの登録</a></p>
        </c:if>

        <p><a href="<c:url value='/reports/index' />">通常一覧に戻る</a></p>


    </c:param>
</c:import>