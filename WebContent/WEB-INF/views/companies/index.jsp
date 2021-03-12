<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>

        <h2>企業一覧</h2>
        <a href="<c:url value="/reports/index" />">企業/お悩み 一覧切り替え</a>
        <table id="employee_list">
            <tbody>
                <tr>
                    <th>企業名</th>
                    <th>業種</th>
                    <th>所在地</th>
                    <th>予算帯</th>
                    <th>電話番号</th>
                    <th> </th>
                </tr>
                <c:forEach var="company" items="${companies}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${company.name}" /></td>
                        <td><c:out value="${company.industry}" /></td>
                        <td><c:out value="${company.place_prefecture}" /></td>
                        <td><c:out value="${company.budget}" /></td>
                        <td><c:out value="${company.phone_number}" /></td>
                        <td><a href="<c:url value='/companies/show?id=${company.id}' />">詳細を表示</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${companies_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((companies_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/companies/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <br/><br/>

        <p><a href="<c:url value='/companies/search' />">企業の検索</a></p>

    </c:param>
</c:import>