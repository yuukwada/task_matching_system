<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label for="name">企業名</label><br />
<input required type="text" name="name" value="${company.name}" />
<br /><br />

<label for="place_prefecture">所在地(都道府県)</label><br />
 <select name="place_prefecture">
    <option value="" >"選択してください"</option>
        <option value="北海道"<c:if test="${company.place_prefecture == '北海道'}"> selected</c:if>>北海道</option>
        <option value="青森県"<c:if test="${company.place_prefecture == '青森県'}"> selected</c:if>>青森県</option>
        <option value="岩手県"<c:if test="${company.place_prefecture == '岩手県'}"> selected</c:if>>岩手県</option>
        <option value="宮城県"<c:if test="${company.place_prefecture == '宮城県'}"> selected</c:if>>宮城県</option>
        <option value="秋田県"<c:if test="${company.place_prefecture == '秋田県'}"> selected</c:if>>秋田県</option>
        <option value="山形県"<c:if test="${company.place_prefecture == '山形県'}"> selected</c:if>>山形県</option>
        <option value="福島県"<c:if test="${company.place_prefecture == '福島県'}"> selected</c:if>>福島県</option>
        <option value="茨城県"<c:if test="${company.place_prefecture == '茨城県'}"> selected</c:if>>茨城県</option>
        <option value="栃木県"<c:if test="${company.place_prefecture == '栃木県'}"> selected</c:if>>栃木県</option>
        <option value="群馬県"<c:if test="${company.place_prefecture == '群馬県'}"> selected</c:if>>群馬県</option>
        <option value="埼玉県"<c:if test="${company.place_prefecture == '埼玉県'}"> selected</c:if>>埼玉県</option>
        <option value="千葉県"<c:if test="${company.place_prefecture == '千葉県'}"> selected</c:if>>千葉県</option>
        <option value="東京都"<c:if test="${company.place_prefecture == '東京都'}"> selected</c:if>>東京都</option>
        <option value="神奈川県"<c:if test="${company.place_prefecture == '神奈川県'}"> selected</c:if>>神奈川県</option>
        <option value="新潟県"<c:if test="${company.place_prefecture == '新潟県'}"> selected</c:if>>新潟県</option>
        <option value="富山県"<c:if test="${company.place_prefecture == '富山県'}"> selected</c:if>>富山県</option>
        <option value="石川県"<c:if test="${company.place_prefecture == '石川県'}"> selected</c:if>>石川県</option>
        <option value="福井県"<c:if test="${company.place_prefecture == '福井県'}"> selected</c:if>>福井県</option>
        <option value="山梨県"<c:if test="${company.place_prefecture == '山梨県'}"> selected</c:if>>山梨県</option>
        <option value="長野県"<c:if test="${company.place_prefecture == '長野県'}"> selected</c:if>>長野県</option>
        <option value="岐阜県"<c:if test="${company.place_prefecture == '岐阜県'}"> selected</c:if>>岐阜県</option>
        <option value="静岡県"<c:if test="${company.place_prefecture == '静岡家'}"> selected</c:if>>静岡県</option>
        <option value="愛知県"<c:if test="${company.place_prefecture == '愛知県'}"> selected</c:if>>愛知県</option>
        <option value="三重県"<c:if test="${company.place_prefecture == '三重県'}"> selected</c:if>>三重県</option>
        <option value="滋賀県"<c:if test="${company.place_prefecture == '滋賀県'}"> selected</c:if>>滋賀県</option>
        <option value="京都府"<c:if test="${company.place_prefecture == '京都府'}"> selected</c:if>>京都府</option>
        <option value="大阪府"<c:if test="${company.place_prefecture == '大阪府'}"> selected</c:if>>大阪府</option>
        <option value="兵庫県"<c:if test="${company.place_prefecture == '兵庫県'}"> selected</c:if>>兵庫県</option>
        <option value="奈良県"<c:if test="${company.place_prefecture == '奈良県'}"> selected</c:if>>奈良県</option>
        <option value="和歌山県"<c:if test="${company.place_prefecture == '和歌山県'}"> selected</c:if>>和歌山県</option>
        <option value="鳥取県"<c:if test="${company.place_prefecture == '鳥取県'}"> selected</c:if>>鳥取県</option>
        <option value="島根県"<c:if test="${company.place_prefecture == '島根県'}"> selected</c:if>>島根県</option>
        <option value="岡山県"<c:if test="${company.place_prefecture == '岡山県'}"> selected</c:if>>岡山県</option>
        <option value="広島県"<c:if test="${company.place_prefecture == '広島県'}"> selected</c:if>>広島県</option>
        <option value="山口県"<c:if test="${company.place_prefecture == '山口県'}"> selected</c:if>>山口県</option>
        <option value="徳島県"<c:if test="${company.place_prefecture == '徳島県'}"> selected</c:if>>徳島県</option>
        <option value="香川県"<c:if test="${company.place_prefecture == '香川県'}"> selected</c:if>>香川県</option>
        <option value="愛媛県"<c:if test="${company.place_prefecture == '愛媛県'}"> selected</c:if>>愛媛県</option>
        <option value="高知県"<c:if test="${company.place_prefecture == '高知県'}"> selected</c:if>>高知県</option>
        <option value="福岡県"<c:if test="${company.place_prefecture == '福岡県'}"> selected</c:if>>福岡県</option>
        <option value="佐賀県"<c:if test="${company.place_prefecture == '佐賀県'}"> selected</c:if>>佐賀県</option>
        <option value="長崎県"<c:if test="${company.place_prefecture == '長崎県'}"> selected</c:if>>長崎県</option>
        <option value="熊本県"<c:if test="${company.place_prefecture == '熊本県'}"> selected</c:if>>熊本県</option>
        <option value="大分県"<c:if test="${company.place_prefecture == '大分県'}"> selected</c:if>>大分県</option>
        <option value="宮崎県"<c:if test="${company.place_prefecture == '宮崎県'}"> selected</c:if>>宮崎県</option>
        <option value="鹿児島県"<c:if test="${company.place_prefecture == '鹿児島県'}"> selected</c:if>>鹿児島県</option>
        <option value="沖縄県"<c:if test="${company.place_prefecture == '沖縄県'}"> selected</c:if>>沖縄県</option>

 </select>
<br /><br />

<label for="place_address">所在地(都道府県以下)</label><br />
<input type="text" name="place_address" value="${company.place_address}" />
<br /><br />

<label for="industry">業種</label><br />
    <select name="industry">

    <option value=未登録 >"選択してください"</option>

        <option value="農業，林業"<c:if test="${company.industry == '農業，林業'}"> selected</c:if>>農業，林業</option>
        <option value="漁業"<c:if test="${company.industry == ''}"> selected</c:if>>漁業</option>
        <option value="鉱業，採石業，砂利採取業"<c:if test="${company.industry == '鉱業，採石業，砂利採取業'}"> selected</c:if>>鉱業，採石業，砂利採取業</option>
        <option value="建設業"<c:if test="${company.industry == '建設業'}"> selected</c:if>>建設業</option>
        <option value="製造業"<c:if test="${company.industry == '製造業'}"> selected</c:if>>製造業</option>
        <option value="電気・ガス・熱供給・水道業"<c:if test="${company.industry == '電気・ガス・熱供給・水道業'}"> selected</c:if>>電気・ガス・熱供給・水道業</option>
        <option value="情報通信業"<c:if test="${company.industry == '情報通信業'}"> selected</c:if>>情報通信業</option>
        <option value="運輸業，郵便業"<c:if test="${company.industry == '運輸業，郵便業'}"> selected</c:if>>運輸業，郵便業</option>
        <option value="卸売業・小売業"<c:if test="${company.industry == '卸売業・小売業'}"> selected</c:if>>卸売業・小売業</option>
        <option value="金融業・保険業"<c:if test="${company.industry == '金融業・保険業'}"> selected</c:if>>金融業・保険業</option>
        <option value="不動産業，物品賃貸業"<c:if test="${company.industry == '不動産業，物品賃貸業'}"> selected</c:if>>不動産業，物品賃貸業</option>
        <option value="教育，学習支援業"<c:if test="${company.industry == '教育，学習支援業'}"> selected</c:if>>教育，学習支援業</option>
        <option value="医療，福祉"<c:if test="${company.industry == '医療，福祉'}"> selected</c:if>>医療，福祉</option>
        <option value="学術研究，専門・技術サービス業"<c:if test="${company.industry == '学術研究，専門・技術サービス業'}"> selected</c:if>>学術研究，専門・技術サービス業</option>
        <option value="宿泊業，飲食サービス業"<c:if test="${company.industry == '宿泊業，飲食サービス業'}"> selected</c:if>>宿泊業，飲食サービス業</option>
        <option value="生活関連サービス業，娯楽業"<c:if test="${company.industry == '生活関連サービス業，娯楽業'}"> selected</c:if>>生活関連サービス業，娯楽業</option>
        <option value="人材関連サービス業"<c:if test="${company.industry == '人材関連サービス業'}"> selected</c:if>>人材関連サービス業</option>
        <option value="その他のサービス業"<c:if test="${company.industry == 'その他のサービス業'}"> selected</c:if>>その他のサービス業</option>

 </select>
<br /><br />

<label for="phone_number">電話番号</label><br />
<input type="text" name="phone_number" value="${company.phone_number}" />
<br /><br />

<label for="email">メールアドレス</label><br />
<input required type="text" name="email" value="${company.email}" />
<br /><br />

<label for="budget">サービスの予算帯</label><br />
    <select name="budget">

     <option value="0" >"選択してください"</option>
        <option value="500000"<c:if test="${company.budget == 500000}"> selected</c:if>>～500,000</option>
        <option value="1000000"<c:if test="${company.budget == 1000000}"> selected</c:if>>500,000～1,000,000</option>
        <option value="2000000"<c:if test="${company.budget == 2000000}"> selected</c:if>>1,000,000～2,000,000</option>
        <option value="3000000"<c:if test="${company.budget == 3000000}"> selected</c:if>>2,000,000～3,000,000</option>
        <option value="4000000"<c:if test="${company.budget == 4000000}"> selected</c:if>>3,000,000～4,000,000</option>
        <option value="5000000"<c:if test="${company.budget == 5000000}"> selected</c:if>>4,000,000～5,000,000</option>
        <option value="6000000"<c:if test="${company.budget == 6000000}"> selected</c:if>>5,000,000～6,000,000</option>
        <option value="7000000"<c:if test="${company.budget == 7000000}"> selected</c:if>>6,000,000～7,000,000</option>
        <option value="8000000"<c:if test="${company.budget == 8000000}"> selected</c:if>>7,000,000～8,000,000</option>
        <option value="9000000"<c:if test="${company.budget == 9000000}"> selected</c:if>>8,000,000～9,000,000</option>
        <option value="10000000"<c:if test="${company.budget == 10000000}"> selected</c:if>>9,000,000～10,000,000</option>

    </select>
<br /><br />

<label for="achieve">実績(複数可)</label><br />
<input type="text" name="achieve" value="${company.achieve}" />
<br /><br />

<label for="password">パスワード</label><br />
<input type="password" name="password" />
<br /><br />

<label for="image">企業イメージの登録</label><br/>
<input type="file" name="image" value="${company.image}" >
<br /><br />

<label for="achieve_image1">実績についての画像(1)</label><br/>
<input type="file" name="achieve_image1" value="${company.achieve_image1}" >
<br /><br />

<label for="achieve_image2">実績についての画像(2)</label><br/>
<input type="file" name="achieve_image2" value="${company.achieve_image2}" >
<br /><br />

<label for="achieve_image3">実績についての画像(3)</label><br/>
<input type="file" name="achieve_image3" value="${company.achieve_image3}" >
<br /><br />


<input type="hidden" name="_token" value="${_token}" />
<button class="button" type="submit">登録</button>