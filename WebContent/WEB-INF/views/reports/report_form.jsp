<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="report_date">日付</label><br />
    <input type="date" name="report_date" value="<fmt:formatDate value='${report.report_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="name">氏名</label><br />
    <c:out value="${sessionScope.login_user.name}" />
<br /><br />

<label for="title">タイトル</label><br />
    <input type="text" name="title" value="${report.title}" />
<br /><br />

<label for="content">お悩み内容</label><br />
    <textarea name="content" rows="10" cols="50">${report.content}</textarea>
<br /><br />

<label for="place_prefecture">お悩み関係の都道府県</label><br />
 <select name="place_prefecture">
    <option value="未登録" >"選択してください"</option>
        <option value="北海道">北海道</option>
        <option value="青森県">青森県</option>
        <option value="岩手県">岩手県</option>
        <option value="宮城県">宮城県</option>
        <option value="秋田県">秋田県</option>
        <option value="山形県">山形県</option>
        <option value="福島県">福島県</option>
        <option value="茨城県">茨城県</option>
        <option value="栃木県">栃木県</option>
        <option value="群馬県">群馬県</option>
        <option value="埼玉県">埼玉県</option>
        <option value="千葉県">千葉県</option>
        <option value="東京都">東京都</option>
        <option value="神奈川県">神奈川県</option>
        <option value="新潟県">新潟県</option>
        <option value="富山県">富山県</option>
        <option value="石川県">石川県</option>
        <option value="福井県">福井県</option>
        <option value="山梨県">山梨県</option>
        <option value="長野県">長野県</option>
        <option value="岐阜県">岐阜県</option>
        <option value="静岡県">静岡県</option>
        <option value="愛知県">愛知県</option>
        <option value="三重県">三重県</option>
        <option value="滋賀県">滋賀県</option>
        <option value="京都府">京都府</option>
        <option value="大阪府">大阪府</option>
        <option value="兵庫県">兵庫県</option>
        <option value="奈良県">奈良県</option>
        <option value="和歌山県">和歌山県</option>
        <option value="鳥取県">鳥取県</option>
        <option value="島根県">島根県</option>
        <option value="岡山県">岡山県</option>
        <option value="広島県">広島県</option>
        <option value="山口県">山口県</option>
        <option value="徳島県">徳島県</option>
        <option value="香川県">香川県</option>
        <option value="愛媛県">愛媛県</option>
        <option value="高知県">高知県</option>
        <option value="福岡県">福岡県</option>
        <option value="佐賀県">佐賀県</option>
        <option value="長崎県">長崎県</option>
        <option value="熊本県">熊本県</option>
        <option value="大分県">大分県</option>
        <option value="宮崎県">宮崎県</option>
        <option value="鹿児島県">鹿児島県</option>
        <option value="沖縄県">沖縄県</option>

 </select>
<br /><br />

<label for="industry">お悩みに関係の業種</label><br/>
   <select name="industry">

     <option value="未登録" >"選択してください"</option>
        <option value="農業，林業">農業，林業</option>
        <option value="漁業">漁業</option>
        <option value="鉱業，採石業，砂利採取業">鉱業，採石業，砂利採取業</option>
        <option value="建設業">建設業</option>
        <option value="製造業">製造業</option>
        <option value="電気・ガス・熱供給・水道業">電気・ガス・熱供給・水道業</option>
        <option value="情報通信業">情報通信業</option>
        <option value="運輸業，郵便業">運輸業，郵便業</option>
        <option value="卸売業・小売業">卸売業・小売業</option>
        <option value="金融業・保険業">金融業・保険業</option>
        <option value="不動産業，物品賃貸業">不動産業，物品賃貸業</option>
        <option value="教育，学習支援業">教育，学習支援業</option>
        <option value="医療，福祉">医療，福祉</option>
        <option value="学術研究，専門・技術サービス業">学術研究，専門・技術サービス業</option>
        <option value="宿泊業，飲食サービス業">宿泊業，飲食サービス業</option>
        <option value="生活関連サービス業，娯楽業">生活関連サービス業，娯楽業</option>
        <option value="人材関連サービス業">人材関連サービス業</option>
        <option value="その他のサービス業">その他のサービス業</option>

    </select>
<br/><br/>

<label for="budget">お考えのご予算</label><br/>
    <select name="budget">

     <option value="0" >"登録しない"</option>
     <option value="500000">～500,000</option>
     <option value="1000000">～1,000,000</option>
     <option value="2000000">～2,000,000</option>
     <option value="3000000">～3,000,000</option>
     <option value="4000000">～4,000,000</option>
     <option value="5000000">～5,000,000</option>
     <option value="6000000">～6,000,000</option>
     <option value="7000000">～7,000,000</option>
     <option value="8000000">～8,000,000</option>
     <option value="9000000">～9,000,000</option>
     <option value="10000000">～10,000,000</option>

    </select>
<br/><br/>

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>