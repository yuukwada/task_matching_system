# task_matching_system
「お悩み」は企業、個人に関わらず、大なり小なり誰でも持っているものです。 お悩みを解決できるがニーズを欲しがっている企業と、ニーズを持っているが解決法を欲しがっているお客様。その双方を結び付けるためのツールです。

# 使用技術
Java(8),MySQL(5.1.45),HTML5,CSS3,Servlet,JSTL,Hibernate,JPQL,GitHub,Eclipse

# 概要
task_matching_systemは以下の機能を実装しています。

- 新規会員登録機能:
このサイトを利用するには新規会員登録が必要です。
企業、個人別に
「名前」、「アドレス」、「パスワード」、「アイコン画像」等を会員情報として登録していただきます。

- Login/Logout機能:
新規会員登録後はログインをしてこのツールを使うことができます。

- Report機能:
個人ユーザー画面から「お悩み」を投稿することができます。
お悩みには「タイトル」、「内容」、「予算」、「関係する業種」、「関係の都道府県」
を入力していただき、それをもとに企業からのアプローチを受けることができます。

- Comment機能:
個人ユーザーから企業に対し、評判などのコメントを残すことができます。

- Favorite機能:
気になる企業や、お悩みに「気になる!」することができます。
「気になる!」した企業やお悩み一覧の表示もでき、よりスムーズなマッチングに繋げることができます。
「気になる!」を解除することもできます。

- Search機能:
個人ユーザーは企業を、企業はお悩みを、それぞれ「業種」「都道府県」「予算」で検索を行い、
絞り込むことができます。

# 設計図

サイトマップ

![サイトマップ](https://user-images.githubusercontent.com/77527527/111414172-d9f0b200-8722-11eb-8b93-36d933645d0d.png)



データベース図
![データベース図](https://user-images.githubusercontent.com/77527527/111414214-ec6aeb80-8722-11eb-8f6d-8f1d2e87bbae.png)


## Heroku URL
https://task-matching-system-tms.herokuapp.com/


# 使用方法
動画をご確認ください。



## 動画
- ログイン/気になる!機能/コメント投稿/検索機能

![ログイン機能](https://user-images.githubusercontent.com/77527527/111903429-9e891700-8a85-11eb-8b1e-c3696319f82b.mp4)

![気になる!機能](https://user-images.githubusercontent.com/77527527/112443676-93d5c700-8d90-11eb-9a78-e1a6e4aa4638.mp4)

![コメント機能](https://user-images.githubusercontent.com/77527527/111903463-cc6e5b80-8a85-11eb-9029-a8b3536f2407.mp4)

![検索機能](https://user-images.githubusercontent.com/77527527/111903480-d728f080-8a85-11eb-8aea-a5793ecd1e49.mp4)

---------------------------------------------------------------------------------------------------------------------------------------------------------------------

- ユーザー/企業/お悩み/新規登録ページ

![ユーザー新規登録](https://user-images.githubusercontent.com/77527527/111910018-f41fec80-8aa2-11eb-80e4-cae2ddd2156f.mp4)

![企業新規登録](https://user-images.githubusercontent.com/77527527/111910061-23cef480-8aa3-11eb-8055-045eff3466ef.mp4)

![お悩み新規登録](https://user-images.githubusercontent.com/77527527/111910039-0863e980-8aa3-11eb-94bf-b49cbf820ee5.mp4)

---------------------------------------------------------------------------------------------------------------------------------------------------------------------

- ユーザー詳細/企業詳細/お悩み/詳細ページ

![ユーザー詳細](https://user-images.githubusercontent.com/77527527/111910073-3c3f0f00-8aa3-11eb-9acc-03dfe643625d.mp4)

![企業詳細](https://user-images.githubusercontent.com/77527527/111910089-4f51df00-8aa3-11eb-8d94-3fd6a981074b.mp4)

![お悩み詳細](https://user-images.githubusercontent.com/77527527/111910113-6690cc80-8aa3-11eb-93c2-89052d06a560.mp4)

---------------------------------------------------------------------------------------------------------------------------------------------------------------------

# エピソード
プログラミングの学習を本格的に始めて3ヶ月程経過しています。
ポートフォリオとして、自分が前職の営業職にて感じたテレアポや、飛び込み営業などの
ニーズ発見作業における非効率感を解決したい、という思いを基に設計と作成を行いました。
ユーザーの目線を意識し、「気になる!」機能や「気になる!」した企業やお悩みの一覧表示、
コメント機能、検索機能を盛り込むことで、「需要と供給のマッチングのしやすさ」を念頭に置いて制作
を進めました。<br>
苦労した点はフィルターの実装で、今までに制作したシステムに比べ、複雑なシステム構造になったため、
実装の過程で無数のエラーに遭遇しました。エラーが起きた箇所をその都度洗い出し、原因を考え、調べて、
修正を繰り返すことで無事に完成させることができました。



# 著者
Yuuki Wada


