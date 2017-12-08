<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
          <fm:form id="userForm" method="post" modelAttribute="user" action="${pageContext.request.contextPath}/jsp/updateUser.do" enctype="multipart/form-data">
              	<fm:hidden path="id"/>
                <div>
                    <label >用户名称：</label>
                    <fm:input path="userName" id="userName"/>
                    <!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label >用户性别：</label>
					 <fm:select path="gender" id="gender" items="${genders }">
					 </fm:select>
                </div>
                <div>
                    <label >出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();" value="${user.birthday }">
					<font color="red"></font>
                </div>
                <div>
                    <label >用户电话：</label>
                    <fm:input path="phone" id="phone"/>
                    <!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label>用户地址：</label>
                   <fm:input path="address" id="address"/>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </fm:form>
        </div>
    </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/usermodify.js"></script>
