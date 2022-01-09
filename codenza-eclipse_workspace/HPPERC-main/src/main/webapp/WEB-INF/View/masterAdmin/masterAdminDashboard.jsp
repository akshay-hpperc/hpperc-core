<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="../includes/adminHeader.jsp" />

    <div class="content content-components">
      <div class="container-fluid pd-x-0 pd-lg-x-10 pd-xl-x-0">
        <div class="d-sm-flex align-items-center justify-content-between mg-b-20 mg-lg-b-25 mg-xl-b-30">
          <div class="w-100">
            <nav aria-label="breadcrumb" class="breadcrumb_nav">
              <ol class="breadcrumb breadcrumb-style1 mg-b-10">
                <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
              </ol>
            </nav>
            <h4 class="mg-b-0 tx-spacing--1">Welcome to Dashboard</h4>
          </div>
         
        </div>

        <div class="row row-xs">

          <div class="col-sm-6 col-lg-3 mt-2">
            <div class="card dashboard">
              <div class="card-body">
                <div class="d-flex d-lg-block d-xl-flex align-items-end">
                  <h5 class="tx-normal tx-rubik mg-b-0 mg-r-5 lh-1">HP Admin Creation</h5>
                  <i class="fa fa-user" aria-hidden="true"></i>
                  
                </div>
              </div>
              <div class="card-footer text-center tx-13 p-1">
                <a href="hpAdminList" class="link-03">Click to View <i class="icon ion-md-arrow-forward mg-l-5"></i></a>
              </div><!-- card-footer -->
            </div>
          </div><!-- col -->
          <div class="col-sm-6 col-lg-3 mt-2">
            <div class="card dashboard">
              <div class="card-body">
                <div class="d-flex d-lg-block d-xl-flex align-items-end">
                  <h5 class="tx-normal tx-rubik mg-b-0 mg-r-5 lh-1">HPPERC Dashboard</h5>
                  <i class="fa fa-th" aria-hidden="true"></i>
                </div>
              </div>
              <div class="card-footer text-center tx-13 p-1">
                <a href="#" class="link-03">Click to View <i class="icon ion-md-arrow-forward mg-l-5"></i></a>
              </div><!-- card-footer -->
            </div>
          </div><!-- col -->
          <div class="col-sm-6 col-lg-3 mt-2">
            <div class="card dashboard">
              <div class="card-body">
                <div class="d-flex d-lg-block d-xl-flex align-items-end">
                  <h5 class="tx-normal tx-rubik mg-b-0 mg-r-5 lh-1">University Dashboard</h5>
                  <i class="fa fa-th" aria-hidden="true"></i>
                </div>
              </div>
              <div class="card-footer text-center tx-13 p-1">
                <a href="#" class="link-03">Click to View <i class="icon ion-md-arrow-forward mg-l-5"></i></a>
              </div><!-- card-footer -->
            </div>
          </div><!-- col -->
          
         
          
        </div><!-- row -->
      </div><!-- container -->
    </div><!-- content -->
     <jsp:include page="../includes/adminFooter.jsp" />