<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../includes/adminHeader.jsp" />

    <div class="content content-components">
      <div class="container-fluid pd-x-0 pd-lg-x-10 pd-xl-x-0">
        <div class="d-sm-flex align-items-center justify-content-between mg-b-20 mg-lg-b-25 mg-xl-b-30">
          <div class="w-100">
            <nav aria-label="breadcrumb" class="breadcrumb_nav">
              <ol class="breadcrumb breadcrumb-style1 mg-b-10">
                <li class="breadcrumb-item"><a href="masterAdminDashboard">Dashboard</a></li>
                <li class="breadcrumb-item"><a href="hpAdminList">HP Admin List</a></li>
                <li class="breadcrumb-item active" aria-current="page">HP Admin Creation Form</li>
              </ol>
            </nav>
            <h4 class="mg-b-0 tx-spacing--1">HP Admin Creation Form</h4>
          </div>
         
        </div>

        <div class="row row-xs">

          <div class="col-12">

            <div class="card card_border">
            <div class="card-header p-2 pl-4">
            	<h4 class="m-0">Personal Information</h4>
            </div>
<div class="card-body">
<form:form id="hpAdminForm" method = "POST" action = "${pageContext.request.contextPath}/masterAdmin/saveHpAdmin" data-parsley-validate="" modelAttribute="user">
		<div class="form-row">
      
            <div class="form-group col-md-4">
              <label class="d-block">First Name <span class="tx-danger">*</span></label>
              <form:input path="firstName" type="text" name="firstName" id="firstName" class="form-control" placeholder="Firstname" value="" required="required" />
            </div>
            <div class="form-group col-md-4">
              <label class="d-block">Last Name <span class="tx-danger">*</span></label>
              <form:input path="lastName" type="text" name="lastName" id="lastName" class="form-control" placeholder="Lastname" value="" required="required" />
            </div>
            <div class="form-group col-md-4">
              <label class="d-block">Contact Number <span class="tx-danger">*</span></label>
              <form:input path="mobileNo" type="text" name="mobileNo" id="mobileNo" class="form-control" placeholder="Mobile number" value="" required="required" />
            </div>
            <div class="form-group col-md-4">
              <label class="d-block">Email-ID <span class="tx-danger">*</span></label>
              <form:input path="emailId" type="text" name="emailId" id="emailId" class="form-control" placeholder="Email Id" value="" required="required" />
            </div>
            <div class="form-group col-md-4">
              <label class="d-block">Address <span class="tx-danger">*</span></label>
              <form:textarea path="address" name="address" id="address" class="form-control" placeholder="Address Here" value="" required="required" />
              
            </div>
            <div class="form-group col-md-4">
              <label class="d-block">User Name <span class="tx-danger">*</span></label>
              <form:input path="username" type="text" name="username" id="username" class="form-control" placeholder="User Name" value="" required="required" />
            </div>
            <!--
		            <form:form method="POST" modelAttribute="role" style="display:none;">
		            <div class="form-group col-md-4">
		               <label class="d-block">Role <span class="tx-danger">*</span></label>
		                <select  class="custom-select" required="">
		                 <option value="">--Select--</option>
					     <c:forEach items="${roleList}"  var="role">
					         <option value="${role.id}">${role.name}</option>
					     </c:forEach>
						 </select>
					</div>
		            </form:form>
            -->  
            <div class="col-md-12 submit_btn p-3">
            	<button class="btn btn-success btn-sm">Submit</button>
            	<button class="btn btn-danger btn-sm">Cancel</button>
            	<button class="btn btn-warning btn-sm">Reset</button>
            </div>
         </div>
</form:form>     
</div>
            
            
          
        
        
            </div>
          </div><!-- col -->
          
          
          
        </div><!-- row -->
      </div><!-- container -->
    </div><!-- content -->

   <jsp:include page="../includes/adminFooter.jsp" />
   <script>
$( document ).ready(function() {
     
    $('#hpAdminForm').parsley().on('field:validated', function() {
    var ok = $('.parsley-error').length === 0;
    $('.bs-callout-info').toggleClass('hidden', !ok);
    $('.bs-callout-warning').toggleClass('hidden', ok);
  })
  .on('form:submit', function() {
    return true; // Don't submit form for this demo
  });
  
});
</script>