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


        <h2>コメント一覧</h2>
        <table class="comment_list">
            <tbody>
                <tr>
                    <th>内容</th>
                </tr>
                <c:forEach var="comment" items="${comments}">
                    <tr>
                        <td><c:out value="${comment}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <table class="comment_list">
            <tbody>
                <tr>
                    <th>ユーザー名</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><c:out value="${user.name}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <div id="pagination">
            （全 ${comment_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((comment_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/companies/comment_index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <br/><br/>

        <p><a href="<c:url value='/companies/show?id=${company_id}' />">企業詳細に戻る</a></p>


    </c:param>
</c:import>