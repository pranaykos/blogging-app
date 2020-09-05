<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/bootstrap-4.1.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="./partials/navbar.jsp"></jsp:include>


	<div class="container my-4">
		<div class="row my-4">
			<div class="col-sm-8 offset-2">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">${post.title}</h5>
						<hr>
						<p class="card-text">${post.body}</p>
						<div class="float-left">
							<a href="#" class="btn btn-outline-danger btn-sm">Like</a> <a
								href="#" class="btn btn-outline-success btn-sm">Comment</a>
						</div>

						
						<c:if test="${isSameUser}">
							<div class='float-right'> 
										<a href='#' class='btn btn-outline-warning btn-sm'>Update</a> 
										<a href='#' class='btn btn-outline-danger btn-sm'>Delete</a>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class=" col-sm-8 offset-2 my-3">
				<s:form modelAttribute="newComment"
					action="${pageContext.request.contextPath}/user/posts/${post.id}/comments"
					method="POST">
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Comment Here</label>
						<s:textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3" path="coment" />
						<input type="submit" class="btn btn-outline-primary btn-sm mt-2">
						<input type="reset" class="btn btn-outline-danger btn-sm mt-2">
					</div>
				</s:form>
			</div>
		</div>







		<div class="row">



			<div class="col-sm-8 offset-2">
				<div class="list-group">



					<c:forEach var="comment" items="${comments}">



						<a href="#" class="list-group-item list-group-item-action"> <%-- <div class="d-flex w-100 justify-content-between">
								<h5 class="mb-1">List group item heading</h5>
								<small class="text-muted">3 days ago</small>
							</div> --%>


							<div class="d-flex w-100 justify-content-between">
								<p class="mb-1">Commented By</p>
								<small>3 days ago</small>
							</div> <small class="text-muted">${comment.coment}</small>
						</a>


					</c:forEach>

				</div>
			</div>



		</div>



	</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


</body>
</html>