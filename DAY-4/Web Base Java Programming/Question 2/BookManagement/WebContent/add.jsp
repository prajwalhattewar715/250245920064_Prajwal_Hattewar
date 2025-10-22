<html><head><title>Add Book</title></head><body>
<h2>Add New Book</h2>
<form action="BookServlet" method="post">
<input type="hidden" name="action" value="INSERT"/>
Title: <input type="text" name="title"/><br><br>
Author: <input type="text" name="author"/><br><br>
Price: <input type="text" name="price"/><br><br>
<input type="submit" value="Add Book"/>
</form>
<a href="BookServlet">Back to List</a>
</body></html>