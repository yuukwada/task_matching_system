<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${user != null}">
                <h2>ユーザー詳細ページ</h2>

                <c:if test="${user.image != null}">
                   <div class="profile_image">
                   <img src="${pageContext.request.contextPath}/uploaded/${user.image}">
                   </div>
               </c:if>

                <table>
                    <tbody>
                      <tr>
                        <th>氏名</th>
                        <td><c:out value="${user.name}" /></td>
                      </tr>
                      <tr>
                        <th>性別</th>
                        <td><c:out value="${user.gender}" /></td>
                      </tr>
                      <tr>
                        <th>生年月日</th>
                        <td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></td>
                      </tr>
                      <tr>
                        <th>Eメール</th>
                        <td><c:out value="${user.email}" /></td>
                      </tr>
                      <tr>
                        <th>電話番号</th>
                        <td><c:out value="${user.phone_number}" /></td>
                      </tr>
                      <tr>
                        <th>住所</th>
                        <td><c:out value="${user.place_prefecture}"/><c:out value="${user.place_address}" /></td>
                      </tr>

                      <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${user.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${user.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>


                    <p><a href="<c:url value="/users/edit?id=${user.id}" />">ユーザー情報を編集する</a></p>

            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/reports/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>