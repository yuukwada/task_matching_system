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


        <h2>気になるお悩み一覧</h2>
        <a href="<c:url value="/companies/index" />">企業/お悩み 切り替え</a>
        <table id="favorited_report_list">
            <tbody>
                <tr>
                    <th>タイトル</th>
                    <th>お名前</th>
                    <th>地域</th>
                    <th>予算帯</th>
                    <th>関係業種</th>
                    <th class="action"> 操作 </th>
                    <th> 操作 </th>
                </tr>
                <c:forEach var="favorited_report" items="${favorited_reports}" varStatus="status">
                    <tr class="row${status.count % 2}">

                        <td><c:out value="${favorited_report.title}" /></td>
                        <td><c:out value="${favorited_report.user.name}" /></td>
                        <td><c:out value="${favorited_report.place_prefecture}" /></td>
                        <td><c:out value="${favorited_report.budget}" /></td>
                        <td><c:out value="${favorited_report.industry}" /></td>
                        <td>
                        <c:choose>
                                <c:when test="${favorited_report.delete_flag == 1}">
                                        （解決済み!）
                                </c:when>
                                <c:when test="${favorited_report.delete_flag == 0}">
                                  <a href="<c:url value='/reports/show?id=${report.id}' />">詳細を表示</a>
                                </c:when>
                        </c:choose>
                        </td>


                        <td><a href="<c:url value='/users/show?id=${favorited_report.user.id}' />">ユーザー詳細</a></td>

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
                        <a href="<c:url value='/reports/favorite_index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <br/><br/>

        <p><a href="<c:url value='/reports/index' />">通常一覧に戻る</a></p>


    </c:param>
</c:import>