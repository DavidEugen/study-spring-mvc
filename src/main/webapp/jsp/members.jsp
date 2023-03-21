<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: davideugen
  Date: 2023/03/21
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    MemberRepository memberRepository = MemberRepository.getInstance();

    //비지니스 로직
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>

<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            out.write("    <tr>");
            out.write("     <td>" + member.getId() + "</td>");
            out.write("     <td>" + member.getUsername() + "</td>");
            out.write("     <td>" + member.getAge() + "</td>");
            out.write("    </tr>");
        }
    %>
    </tbody>
</table>

<body>

</body>
</html>
