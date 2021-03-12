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


        <h2>お悩み一覧</h2>
        <a href="<c:url value="/companies/index" />">企業/お悩み 切り替え</a>
        <table id="report_list">
            <tbody>
                <tr>
                    <th>タイトル</th>
                    <th>お名前</th>
                    <th>住所</th>
                    <th>予算帯</th>
                    <th>関係業種</th>
                    <th> 操作 </th>
                    <th> 操作 </th>
                    <c:if test="${sessionScope.login_company != null}">
                        <th class="favorite">気になる! </th>
                        <th class="favorited_count">☆</th>
                    </c:if>

                </tr>
                <c:forEach var="report" items="${reports}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${report.title}" /></td>
                        <td><c:out value="${report.user.name}" /></td>
                        <td><c:out value="${report.user.place_prefecture}" /></td>
                        <td><c:out value="${report.budget}" /></td>
                        <td><c:out value="${report.industry}" /></td>
                        <td><a href="<c:url value='/reports/show?id=${report.id}' />">詳細を表示</a></td>
                        <td><a href="<c:url value='/users/show?id=${report.user.id}' />">ユーザー詳細</a></td>
                        <c:if test="${sessionScope.login_company != null}">
                            <td class="favorite">

                            <c:set var="check_flag" value="0" />


                            <c:forEach var="favorited_report" items="${favorited_reports}">

                                <c:if test="${favorited_report.id == report.id}">
                                    <c:set var="check_flag" value="1" />
                                </c:if>


                            </c:forEach>


                            <c:if test="${check_flag==1}">
                                <form method="POST" action="<c:url value="/reports/favorite_destroy"/>">
                                    <input type="hidden" name="report_id"value="${report.id}">
                                    <button class="antifollow" type="submit">☆解除</button>
                                </form>
                            </c:if>
                            <c:if test="${check_flag==0}">
                                 <form method="POST" action="<c:url value="/reports/favorite"/>">
                                    <input type="hidden" name="report_id"value="${report.id}">
                                    <button class="follow" type="submit">☆</button>
                                 </form>
                            </c:if>

                            </td>

                            <td class="favorited_count">
                            <c:out value="${fn:length(report.favorite_Company)}" />
                            </td>
                        </c:if>
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

        <p><a href="<c:url value='/reports/search' />">お悩みの検索</a></p>


    </c:param>
</c:import>