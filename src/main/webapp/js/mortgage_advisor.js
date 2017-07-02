
$(document).ready(function() {
	
	drawResultTable();
	
    function drawResultTable() {
    	

        $('#myTable').DataTable();
    }
	

	$('#bestRatesBOI').DataTable({
		"paging" : false,
		"ordering" : false,
		"info" : false,
		bFilter: false
	});
	
	
            
            
});