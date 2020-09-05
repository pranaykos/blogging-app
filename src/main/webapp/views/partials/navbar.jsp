<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="/"><i class="fa fa-comments" aria-hidden="true"></i> <img src="">Discuss<strong>View</strong></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				
				<li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Catagories
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
					  <a class="dropdown-item" href="#">Technology</a>
			          <a class="dropdown-item" href="#">Food</a>
			          <a class="dropdown-item" href="#">Travelling</a>
			          <a class="dropdown-item" href="#">Mobiles</a>
			        </div>
		      </li>
			</ul>



			<%
				if (session.getAttribute("username") != null) {
					out.print("<span class='mr-3 text-white'> Hi, " + session.getAttribute("username") + " </span>");
				}
			%>

			<!-- <span class="mr-3"> Hi Pranay </span> -->


			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2 form-control-sm" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0 btn-sm mx-2"
					type="submit">Search</button>
				<!-- <a href="#" class="btn btn-outline-danger btn-sm">Logout</a> -->
				<%
					if (session.getAttribute("username") != null) {
						out.print("<a href='/logout' class='btn btn-outline-danger btn-sm'>Logout</a>");
					}else{
						out.print("<a href='/loginForm' class='btn btn-outline-danger btn-sm'>Login</a>");
					}
				%>
			</form>
		</div>
	</div>
</nav>