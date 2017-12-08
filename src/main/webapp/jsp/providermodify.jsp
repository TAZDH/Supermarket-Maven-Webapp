<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
  <div class="right">
      <div class="location">
          <strong>你现在所在的位置是:</strong>
          <span>供应商管理页面 >> 供应商修改页</span>
      </div>
      <div class="providerAdd">
          <fm:form id="providerForm" method="post" modelAttribute="provider" action="${pageContext.request.contextPath}/jsp/updateProvider.do" enctype="multipart/form-data">
        	<fm:hidden path="id"/>
          <div class="">
                  <label for="proCode">供应商编码：</label>
                  <fm:input path="proCode" id="proName"/>
                  <font color="red"></font>
              </div>
              <div>
                  <label for="proName">供应商名称：</label>
	                <fm:input path="proName" id="proName" readonly="readonly"/>
					<font color="red"></font>
              </div>
              
              <div>
                  <label for="proContact">联系人：</label>
                  <fm:input path="proContact" id="proContact"/>
					<font color="red"></font>
              </div>
              
              <div>
                  <label for="proPhone">联系电话：</label>
                  <fm:input path="proPhone" id="proPhone"/>
				  <font color="red"></font>
              </div>
              
              <div>
                  <label for="proAddress">联系地址：</label>
                  <fm:input path="proContact" id="proContact"/>
              </div>
              
              <div>
                  <label for="proFax">传真：</label>
                  <fm:input path="proFax" id="proFax"/>
              </div>
              
              <div>
                  <label for="proDesc">描述：</label>
                  <fm:input path="proDesc" id="proDesc"/>
              </div>
              <div class="providerAddBtn">
                  <input type="button" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
              </div>
          </fm:form>
      </div>
  </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/providermodify.js"></script>