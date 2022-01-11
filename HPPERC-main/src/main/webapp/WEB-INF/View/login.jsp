<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="includes/adminHeader.jsp" />
<style>
	#sidebarMenu, .navbar-header .navbar-right{
		display: none;
	}
	
</style>
    <div class="content content-fixed content-auth">
      <div class="container">
        <div class="media align-items-stretch justify-content-center ht-100p pos-relative">
          <div class="media-body align-items-center d-none d-lg-flex">
            <div class="mx-wd-600">
              <img src="resources/assets/img/hpperc_logo.jpg" class="img-fluid" alt="">
            </div>
            
          </div><!-- media-body -->
              
          <div class="sign-wrapper mg-lg-l-50 mg-xl-l-60">
            <div class="wd-100p">
            <c:url value="/login" var="loginProcessingUrl" />
            <form action="${loginProcessingUrl}" method="post">
              <h3 class="tx-color-01 mg-b-5">Sign In</h3>
  
  			<c:if test="${param.error != null}">
						<p class="tx-color-03 tx-16 mg-b-40"> Failed to login. 
								<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}"> 
						 				Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
								</c:if>
						</p>
			</c:if>
			<c:if test="${param.logout != null}">
					<p class="tx-color-03 tx-16 mg-b-40">
					You have been logged out. ${param.logout}</div>
					</p>
			</c:if>
		     <p class="tx-color-03 tx-16 mg-b-40">Welcome! Please signin to continue.</p>

              <div class="form-group">
              
                <label>User Name</label>
                <input type="text" name="username" id="username" class="form-control" placeholder="Enter Username">
              </div>
              <div class="form-group">
                <div class="d-flex justify-content-between mg-b-5">
                  <label class="mg-b-0-f">Password</label>
                  <a href="forgotPass" class="tx-13">Forgot password?</a>
                </div>
                <input type="password" name="password" id="password" class="form-control" placeholder="Enter password">
              </div>
              <input type="submit" class="btn btn-brand-02 btn-block" value="Login">
              
              <div class="tx-13 mg-t-20 tx-center">Haven't Generated Password? <a href="generatePass">Generate here</a></div>
              </form>
            </div>
          </div><!-- sign-wrapper -->
        </div><!-- media -->
      </div><!-- container -->
    </div><!-- content -->

