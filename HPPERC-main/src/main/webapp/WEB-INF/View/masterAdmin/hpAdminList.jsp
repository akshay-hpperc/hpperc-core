<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../includes/adminHeader.jsp" />

    <div class="content content-components">
      <div class="container-fluid pd-x-0 pd-lg-x-10 pd-xl-x-0">
        <div class="d-sm-flex align-items-center justify-content-between mg-b-20 mg-lg-b-25 mg-xl-b-30">
          <div class="w-100">
            <nav aria-label="breadcrumb" class="breadcrumb_nav">
              <ol class="breadcrumb breadcrumb-style1 mg-b-10">
                <li class="breadcrumb-item"><a href="masterAdminDashboard">Dashboard</a></li>
                <li class="breadcrumb-item active" aria-current="page">HP Admin List</li>
              </ol>
            </nav>
            <h4 class="mg-b-0 tx-spacing--1">HP Admin</h4>
          </div>
         
        </div>

        <div class="row row-xs">

          <div class="col-12">
            <div class="card card-body card_border">
              <div>
              <button type="button" class="btn btn-primary btn-sm mr-2" onclick="location.href='hpAdminForm'">Add New HP Admin</button>
              <button type="button" class="btn btn-primary btn-sm" onclick="location.href='#'">Archives</button>
              </div>
            </div>
          </div><!-- col -->
          
           <div class="col-12 mt-3">
            <div class="card card-body card_border">
              <table id="hpAdminListTable" class="table table-bordered">
              	<thead>
              		<tr>
              			<th>Sr. No.</th>
              			<th>First Name</th>
              			<th>Last Name</th>
              			<th>Contact Number</th>
              			<th>Email-id</th>
              			<th>Address</th>
              			<th>Username</th>
              			<th>Role</th>
              			<th>Action</th>
              		</tr> 
              			
              		
              	</thead>
              	<tbody>
              		
              			 <c:forEach items="${userList}"  var="user" varStatus="loop">
              			 <tr>
			         			<td>${loop.count}</td>
			         			<td>${user.firstName}</td>
			         			<td>${user.lastName}</td>
			         			<td>${user.mobileNo}</td>
			         			<td>${user.emailId}</td>
			         			<td>${user.address}</td>
			         			<td>${user.username}</td>
			         			  
			         			<td>
				         			<c:forEach var ="role" items = "${user.roles}" varStatus="roleLoop">
								 	 	<c:if test="${roleLoop.count} > 0}">
								 		,
								 		</c:if>
								 		${role.name} 
								 	</c:forEach>
						 		</td>
			         			 
			   			 
              			<td class="d-flex border-bottom-0">
              				<div class="col"><button class="btn btn-warning btn-sm">Resend Password</button></div> 
              				<div class="col"><i class="far fa-edit"></i></div> 
              				<div class="col"><i class="fa fa-trash"></i></div> 
              		 	</td>
              		</tr>
              		</c:forEach>
              	</tbody>
              </table>
            </div>
          </div><!-- col -->
          
          
        </div><!-- row -->
      </div><!-- container -->
    </div><!-- content -->

   <jsp:include page="../includes/adminFooter.jsp" />
   
   <script>
      $(function(){
        'use strict'

        $('#hpAdminListTable').DataTable({
          language: {
            searchPlaceholder: 'Search...',
            sSearch: '',
            lengthMenu: '_MENU_ items/page',
          }
        });
      });  
      
      $('.dataTables_length select').select2({ minimumResultsForSearch: Infinity });
   </script>
   