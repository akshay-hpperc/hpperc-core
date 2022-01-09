

    
    <script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/lib/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/lib/feather-icons/feather.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/lib/perfect-scrollbar/perfect-scrollbar.min.js"></script>

    <script src="<%=request.getContextPath()%>/resources/assets/js/dashforge.js"></script>
     <script src="<%=request.getContextPath()%>/resources/lib/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/lib/datatables.net-dt/js/dataTables.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/lib/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/lib/datatables.net-responsive-dt/js/responsive.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/select2/js/select2.min.js"></script>
    <!-- append theme customizer -->
    <script src="<%=request.getContextPath()%>/resources/lib/js-cookie/js.cookie.js"></script>
    <script src="<%=request.getContextPath()%>/resources/assets/js/dashforge.settings.js"></script>
    <script src="<%=request.getContextPath()%>/resources/lib/parsleyjs/parsley.min.js"></script>
    
    
    <script>
    (function($) {
   	 $('.digit-group').find('input').each(function() {
   	    	$(this).attr('maxlength', 1);
   	    	$(this).on('keyup', function(e) {
   	    		var parent = $($(this).parent());
   	    		
   	    		if(e.keyCode === 8 || e.keyCode === 37) {
   	    			var prev = parent.find('input#' + $(this).data('previous'));
   	    			
   	    			if(prev.length) {
   	    				$(prev).select();
   	    			}
   	    		} else if((e.keyCode >= 48 && e.keyCode <= 57) || (e.keyCode >= 65 && e.keyCode <= 90) || (e.keyCode >= 96 && e.keyCode <= 105) || e.keyCode === 39) {
   	    			var next = parent.find('input#' + $(this).data('next'));
   	    			
   	    			if(next.length) {
   	    				$(next).select();
   	    			} else {
   	    				if(parent.data('autosubmit')) {
   	    					parent.submit();
   	    				}
   	    			}
   	    		}
   	    	});
   	    });
   })(jQuery);
    </script>
    
    
  </body>
</html>
