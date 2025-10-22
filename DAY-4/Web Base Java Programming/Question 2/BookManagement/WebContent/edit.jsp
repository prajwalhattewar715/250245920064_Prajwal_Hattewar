<%@ page import="com.book.servlet.Book" %>
<%
Book book = (Book) request.getAttribute("book");
%>
<html><head><title>Edit Book</title></head><body>
<h2>Edit Book</h2>
<form action="BookServlet" method="post">
<input type="hidden" name="action" value="UPDATE"/>
<input type="hidden" name="id" value="<%=book.getId()%>"/>
Title: <input type="text" name="title" value="<%=book.getTitle()%>"/><br><br>
Author: <input type="text" name="author" value="<%=book.getAuthor()%>"/><br><br>
Price: <input type="text" name="price" value="<%=book.getPrice()%>"/><br><br>
<input type="submit" value="Update Book"/>
</form>
<a href="BookServlet">Back to List</a>
</body></html>