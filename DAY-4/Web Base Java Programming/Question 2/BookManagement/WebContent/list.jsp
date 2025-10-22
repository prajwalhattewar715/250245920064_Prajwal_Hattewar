<%@ page import="java.util.*, com.book.servlet.Book" %>
<html><head><title>Book List</title></head><body>
<h2>Book List</h2>
<a href="BookServlet?action=NEW">Add New Book</a>
<table border="1" width="60%">
<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Action</th></tr>
<%
List<Book> listBook = (List<Book>) request.getAttribute("listBook");
for (Book b : listBook) {
%>
<tr>
<td><%= b.getId() %></td>
<td><%= b.getTitle() %></td>
<td><%= b.getAuthor() %></td>
<td><%= b.getPrice() %></td>
<td>
<a href="BookServlet?action=EDIT&id=<%=b.getId()%>">Edit</a>
<a href="BookServlet?action=DELETE&id=<%=b.getId()%>">Delete</a>
</td>
</tr>
<% } %>
</table>
</body></html>