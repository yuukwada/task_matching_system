<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>


        <h2>気になる企業一覧</h2>

        <table id="favorited_report_list">
            <tbody>
                <tr>
                    <th>企業名</th>
                    <th>所在地</th>
                    <th>サービス予算帯</th>
                    <th>業種</th>
                    <th> 操作 </th>
                </tr>
                <c:forEach var="favorited_company" items="${favorited_companies}" varStatus="status">
                    <tr class="row${status.count % 2}">

                        <td><c:out value="${favorited_company.name}" /></td>
                        <td><c:out value="${favorited_company.place_prefecture}" /></td>
                        <td><c:out value="${favorited_company.budget}" /></td>
                        <td><c:out value="${favorited_company.industry}" /></td>
                        <td><a href="<c:url value='/companies/show?id=${favorited_company.id}' />">詳細を表示</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${favorites_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((favorites_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/companies/favorite_index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <br/><br/>

        <p><a href="<c:url value='/companies/index' />">通常一覧に戻る</a></p>


    </c:param>
</c:import>