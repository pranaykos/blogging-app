<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap-4.1.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<jsp:include page="./partials/navbar.jsp"></jsp:include>

	<div class="d-flex">
		<h1 class="display-4 my-3 mx-auto my-2 d-block">Add New Post Here</h1>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-sm-8 offset-2 my-4">
				<div class="card">
					<div class="card-body">
						<s:form
							modelAttribute="post"
							action="${pageContext.request.contextPath}/user/posts/addPost"
							method="POST">
							<div class="form-group">
								<label for="exampleFormControlInput1">Post Title</label> 
								<s:input type="text" class="form-control" path="title" id="exampleFormControlInput1" />
							</div>
							<div class="form-group">
								<label for="exampleFormControlTextarea1">Content</label>
								<s:textarea class="form-control" path="body" id="exampleFormControlTextarea1" rows="3" /></textarea>
							</div>
							<input type="submit" class="btn btn-info" value="Add Post" />
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%-- <s:form modelAttribute="post"
		action="${pageContext.request.contextPath}/user/posts/addPost"
		method="POST">

		<s:hidden path="id" />

		<p>
			Title
			<s:input path="title" />
			<s:errors path="title"></s:errors>
		</p>

		<p>
			Content
			<s:textarea path="body" />
			<s:errors path="body"></s:errors>
		</p>

		<input type="submit" value="Add Post" />

	</s:form> --%>


	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>