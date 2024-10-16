<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row" style="margin-top:40px">
	<div class="col-lg-12">
		<div class="card">
			<div class="card-header">
				<i class="fa fa-comments fa-fw"></i> Reply
				<!-- Button to Open the Modal -->
				<button type="button" class="btn btn-primary btn-sm pull-right" data-toggle="modal" data-target="#replyModal" id="newReplyBtn">
				  New Reply
				</button>
			</div>
			
			
			<div class="card-body">
				<ul class="chat">
					<li class="left clearfix" data-rno="1">
						<div>
						
							<div class="header">
								<strong class="primary-font">홍길동</strong>
								<small class="pull-right text-muted">2024-01-01</small>
							</div>
							<p><pre>Good job</pre></p>
						</div>
					</li>
				</ul>
			</div><!-- card-body -->
			
			<div class="card-footer">
				<ul class="pagination pagination-sm">
				  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
				  <li class="page-item"><a class="page-link" href="#">1</a></li>
				  <li class="page-item"><a class="page-link" href="#">2</a></li>
				  <li class="page-item"><a class="page-link" href="#">3</a></li>
				  <li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<!-- The Modal -->
<div class="modal fade" id="replyModal">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">comment</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        	<input type="hidden" id="replyRno">
          	<textarea rows="4" class="form-control" id="replyContent"></textarea>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
        	<button type="button" class="btn btn-primary" data-dismiss="modal" id="replyWriteBtn">등록</button>
        	<button type="button" class="btn btn-success" data-dismiss="modal" id="replyUpdateBtn">update</button>
          	<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
</div>