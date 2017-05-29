/**
 * 
 */

$(document).ready(function() {
	

	$('#bestRatesBOI').DataTable({
		"paging" : false,
		"ordering" : false,
		"info" : false,
		bFilter: false
	});
	
	var tableClassName = 'lookup-table';					// rates table class name
	var mortgageTypeHeaderTxt = ' mortgage type name ';		// mortgage type column name: Mover, Switcher, etc.
	
	
	$("."+tableClassName).addClass("hideTable");			// hiding the source table
	
    tableThead = $("." + tableClassName +' thead');

    // Find the heading with the text mortgageTypeHeaderTxt
	var columnTh = $("." + tableClassName + " th:contains(" + mortgageTypeHeaderTxt + ")"); 
    
	// Get the index & increment by 1 to match nth-child indexing
	columnIndex = columnTh.index() + 1;
    
    // finding all the table rows
    rows = $('.'+tableClassName+' > tbody > tr');
    
    // each row is a class of mortgage type
    $(rows).each(
        function(){
            var mortgageType = $(this).find('td:nth-child(' + columnIndex + ')');
            var mortgageTypeStr = $(mortgageType).html();
            
            // TODO: figure out WTF
            if (mortgageTypeStr != null) 
                mortgageTypeStr = mortgageTypeStr.replace(/ /g,"_");
            else 
                console.log("TroubleMaker: "+$(this).remove());
            
            // update each row (tr) with a class name. It will be used to build a result table later.
            $(this).attr('class',mortgageTypeStr);
        }
    );
                
                
    //$("." + tableClassName + ' tr td:nth-child(' + columnIndex + ')').css("color", "#F00"); // Set all the elements with that index in a tr red

    var mortgageTypes = $("." + tableClassName + ' tr td:nth-child(' + columnIndex + ')');
    var newmortgageTypes = new Array();
    
    mortgageTypes.each(
		function() {
			var id = $(this).html();
			newmortgageTypes.push(id);
			}
	);
    
	var radioButtonSet = unique( newmortgageTypes );
        
    // building Bootstrap radio buttons for each Mortgage Type
	
	makeBootstrapRaioButtons(radioButtonSet);
	
	function makeBootstrapRaioButtons(radioButtonSet) {
		$(radioButtonSet).each(
            function(i, val) {
                // no white spaces
                var name = val.replace(/ /g,"_");
                var html = '<label class="btn btn-primary ">';
                
                html += '<input type="radio" name="mortgageTypes" id="' + name + '" autocomplete="off" checked>' + val;
                html += '</label>';
                
                console.log('Radio btns '+html);
                
                $(html).appendTo('#bootstrapRadio');
            }
        );
	}
	
	$('#bootstrapRadio :input').change(function() {
	    $(this).addClass('active').siblings().removeClass('active');
		selectedRows = $('.'+this.id);
		drawResultTable(selectedRows);
	});
	
//        // building radio buttons for each Mortgage Type
//        $(radioButtonSet).each(
//        		function(i, val) {
//        			// no white spaces
//        			var name = val.replace(/ /g,"_");
//        			var radioBtn = $('<input type="radio" name="mortgageTypes" value='+name+'>'+val+'</input>');
//        			radioBtn.appendTo("#mortgageTypes");
//        		}
//        );
//            
//        // build table based on radio button selection
//        var selectedRows;
//        $('input[type=radio][name=mortgageTypes]').change(
//        		function() {
//        			var selectedValue = this.value;
//        			selectedRows = $('.'+selectedValue);
//        			drawResultTable(selectedRows);
//        		}
//        );
    
    
    function drawResultTable(selectedRows) {
    	
    	console.log('Started to draw a Table');
    	console.log('These are the rows:');
    	console.log(selectedRows);
    	
    	// delete all existing tables before creating a new one. Refresh
    	var table = $('#myTable').DataTable();
    	table.destroy();
    	$('#myTable').remove();
    	
        var html = '<table id="myTable" class="display" cellspacing="0" width="100%">';
        html += tableThead.prop('outerHTML');
        html += '<tbody>';
        
        $(selectedRows).each(
            function(i, val) {
                html += val.outerHTML;
            }
        );
            
        html += '</tbody></table>';
        
        console.log('Resul table html: ');
        console.log('html [... '+html+' ...]');

        $(html).appendTo('#resultTable');
        $('#myTable').DataTable();
    }
	
    // remove duplicates from the array
    function unique(list) {
        var result = new Array();
        $.each(list, function(i, e) {
          if ($.inArray(e, result) == -1) result.push(e);
        });
        return result;
      }
            
            
            
});