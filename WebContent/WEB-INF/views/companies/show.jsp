<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${company != null}">
                <h2>企業詳細ページ</h2>

                <c:if test="${company.image != null}">
                   <div class="profile_image">
                   <img src="${pageContext.request.contextPath}/uploaded/${company.image}">
                   </div>
               </c:if>

                <table>
                    <tbody>
                      <tr>
                        <th>企業名</th>
                        <td><c:out value="${company.name}" /></td>
                      </tr>
                      <tr>
                        <th>業種</th>
                        <td><c:out value="${company.industry}" /></td>
                      </tr>
                      <tr>
                        <th>所在地</th>
                        <td><c:out value="${company.place_prefecture}  ${company.place_address}" /></td>
                      </tr>
                      <tr>
                        <th>サービスの予算</th>
                        <td><fmt:formatNumber value="${company.budget}" pattern="###,###" />程度
                      </tr>
                      <tr>
                        <th>電話番号</th>
                        <td><c:out value="${company.phone_number}" /></td>
                      </tr>
                      <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${company.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${company.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>


                    <c:if test="${company.achieve_image1 != null}">
                        <div class="achieve_image">
                            <img src="${pageContext.request.contextPath}/uploaded/${company.achieve_image1}">
                        </div>
                    </c:if>

                    <c:if test="${company.achieve_image2 != null}">
                        <div class="achieve_image">
                            <img src="${pageContext.request.contextPath}/uploaded/${company.achieve_image2}">
                        </div>
                    </c:if>

                    <c:if test="${company.achieve_image3 != null}">
                        <div class="achieve_image">
                            <img src="${pageContext.request.contextPath}/uploaded/${company.achieve_image3}">
                        </div>
                    </c:if>
                <br/><br/>

                <div class="campany_command">
                    <c:if test="${sessionScope.login_company.id == company.id}">
                        <p><a href="<c:url value="/companies/edit?id=${company.id}" />">企業情報を編集</a></p>
                    </c:if>

                    <br/><br/>

                    <c:if test="${sessionScope.login_user != null}">
                      <div class="company_comment">
                        <form method="POST" action="<c:url value="/companies/comment"/>">
                            <textarea name="content" rows="10" cols="50">${comment.content}</textarea><br/><br/>

                            <input type="hidden" name="company_id" value="${company.id}" />
                            <button class="button" type="submit">企業へコメントする</button>
                        </form>
                    <br/><br/>

                        <form method="POST" action="<c:url value="/companies/comment_index"/>">
                            <input type="hidden" name="company_id" value="${company.id}" />
                            <button class="button" type="submit">この企業のコメント一覧へ</button>
                        </form>
                      </div>
                    </c:if>
                </div>

            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/companies/index" />">一覧に戻る</a></p>
        <br/>

    </c:param>
</c:import>