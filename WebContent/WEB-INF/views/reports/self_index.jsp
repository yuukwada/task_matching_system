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


        <h2>自分のお悩み一覧</h2>

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


                </tr>
                <c:forEach var="report" items="${reports}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${report.title}" /></td>
                        <td><c:out value="${report.user.name}" /></td>
                        <td><c:out value="${report.user.place_prefecture}" /></td>
                        <td><c:out value="${report.budget}" /></td>
                        <td><c:out value="${report.industry}" /></td>
                        <td><a href="<c:url value='/reports/show?id=${report.id}' />">詳細を表示</a></td>
                        <td>
                            <c:choose>
                                <c:when test="${report.delete_flag == 1}">
                                        （解決済みです!）
                                </c:when>
                                <c:when test="${report.delete_flag == 0}">
                                    <p><a href="#" onclick="confirmDestroy();">解決済み登録</a></p>
                                    <form method="POST" action="<c:url value='/reports/destroy' />">
                                        <input type="hidden" name="report_id" value="${report.id}" />
                                    </form>
                                    <script>
                                        function confirmDestroy() {
                                            if(confirm("本当に解決済みにしてよろしいですか？")) {
                                                document.forms[1].submit();
                                            }
                                        }
                                    </script>
                                </c:when>
                            </c:choose>
                        </td>

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

        <p><a href="<c:url value='/reports/index' />">通常一覧へ戻る</a></p>

        <c:if test="${sessionScope.login_user != null}">
            <p><a href="<c:url value='/reports/new' />">新規お悩みの登録</a></p>
        </c:if>

        <p><a href="<c:url value='/reports/search' />">お悩みの検索</a></p>


    </c:param>
</c:import>