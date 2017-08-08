<!-- BOI Modal -->
<jsp:useBean id="BOIRateChecker" class="com.greenland.model.BOIRateChecker" scope="session"/>
<div class="modal fade" id="boiRatesModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">
        	BOI Rates <br />
        </h4>
      </div>
      <div class="modal-body">
        ${sessionScope[BOIRateChecker.allRatesTableSessionAttribute]}
        <br />
       	<p>The original BOI page with rates can be found here <a href=${sessionScope[BOIRateChecker.urlSessionAttribute]}>link</a></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- End of BOI Modal -->