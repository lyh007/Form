<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@include file="/common/taglibs.jsp" %>

<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <meta name="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)">
    <meta name="created" content="Sun, 30 Jan 2011 03:24:42 GMT">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <title>The Boyd School</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/boyd.css"/>

</head>
<body>
<div class="outline">
    <div class="floatRight">
        <div class="topRightHeader"> Admissions Contract</div>
        <div><strong>CAMPUS:</strong>
            <input class="checkbox" name="formData.text_20_1" type="checkbox" <s:iterator var="campus" value="text_20_1" status="campusStatus"><s:if test="text_20_1[#campusStatus.index]=='Al'">checked="checked"</s:if></s:iterator>>Aldie</input>
            <input class="checkbox" name="formData.text_20_1" type="checkbox" <s:iterator var="campus" value="text_20_1" status="campusStatus"><s:if test="text_20_1[#campusStatus.index]=='Br'">checked="checked"</s:if></s:iterator>>Broadlands</input>
            <input class="checkbox" name="formData.text_20_1" type="checkbox" <s:iterator var="campus" value="text_20_1" status="campusStatus"><s:if test="text_20_1[#campusStatus.index]=='Fa'">checked="checked"</s:if></s:iterator>>Fairfax</input>
            <input class="checkbox" name="formData.text_20_1" type="checkbox" <s:iterator var="campus" value="text_20_1" status="campusStatus"><s:if test="text_20_1[#campusStatus.index]=='Re'">checked="checked"</s:if></s:iterator>>Reston</input>
            <input class="checkbox" name="formData.text_20_1" type="checkbox" <s:iterator var="campus" value="text_20_1" status="campusStatus"><s:if test="text_20_1[#campusStatus.index]=='We'">checked="checked"</s:if></s:iterator>>Westfields</input>
        </div>
    </div>
    <div class="topHeader">The Boyd School</div>
    <hr/>
    <div class="content contractRight ">
        <div>
            <div class="inverseHeader">Contact Information</div>
            <div class="contactContent">
                Child's Home # <input class="bottom" name="formData.text_20_2" type="text" size="25" value="<s:property value="formData.text_20_2"/>"><br/>
                E-mail (home) # <input class="bottom" name="formData.text_20_3" type="text" size="24" value="<s:property value="formData.text_20_3"/>"><br/>
                Mother's Home # <input class="bottom" name="formData.text_20_4" type="text" size="23" value="<s:property value="formData.text_20_4"/>"><br/>
                Mother's Work # <input class="bottom" name="formData.text_20_5" type="text" size="24" value="<s:property value="formData.text_20_5"/>"><br/>
                Mother's Cell # <input class="bottom" name="formData.text_20_6" type="text" size="26" value="<s:property value="formData.text_20_6"/>"><br/>
                Mother's Email(work) # <input class="bottom" name="formData.text_20_7" type="text" size="16" value="<s:property value="formData.text_20_7"/>"><br/>
                Father's Home # <input class="bottom" name="formData.text_20_8" type="text" size="23" value="<s:property value="formData.text_20_8"/>"><br/>
                Father's Work # <input class="bottom" name="formData.text_20_9" type="text" size="24" value="<s:property value="formData.text_20_9"/>"><br/>
                Father's Cell # <input class="bottom" name="formData.text_20_10" type="text" size="26" value="<s:property value="formData.text_20_10"/>"><br/>
                Father's Email (work) # <input class="bottom" name="formData.text_20_11" type="text" size="16" value="<s:property value="formData.text_20_11"/>">
            </div>
        </div>

    </div>
    <div class="content">
        I hereby make application for my                                                 
        <input class="checkbox" name="formData.text_20_12" type="checkbox" <s:iterator var="relation" value="text_20_12" status="relationStatus"><s:if test="text_20_12[#relationStatus.index]=='son'">checked="checked"</s:if></s:iterator>>son</input>
        <input class="checkbox" name="formData.text_20_12" type="checkbox" <s:iterator var="relation" value="text_20_12" status="relationStatus"><s:if test="text_20_12[#relationStatus.index]=='daughter'">checked="checked"</s:if></s:iterator>>daughter</input><br/>
        whose full name is <input class="bottom" name="formData.text_20_13" type="text" size="90" value="<s:property value="formData.text_20_13"/>"><br/>
        Age <input class="bottom" name="formData.text_20_14" type="text" size="3" value="<s:property value="formData.text_20_14"/>">
        Date of Birth <input class="bottom" name="formData.text_20_15" type="text" size="10" value="<s:property value="formData.text_20_15"/>">
        Nickname <input class="bottom" name="formData.text_20_16" type="text" size="55" value="<s:property value="formData.text_20_16"/>"><br/>
        Address <input class="bottom" name="formData.text_20_17" type="text" size="100" value="<s:property value="formData.text_20_17"/>"><br/>
        City <input class="bottom" name="formData.text_20_18" type="text" size="53" value="<s:property value="formData.text_20_18"/>">
        State <input class="bottom" name="formData.text_20_19" type="text" size="10" value="<s:property value="formData.text_20_19"/>">
        Zip <input class="bottom" name="formData.text_20_20" type="text" size="20" value="<s:property value="formData.text_20_20"/>">
        <hr/>
        Mother's Name <input class="bottom" name="formData.text_50_1" type="text" size="93" value="<s:property value="formData.text_50_1"/>"><br/>
        Address <input class="bottom" name="formData.text_50_2" type="text" size="100" value="<s:property value="formData.text_50_2"/>"><br/>
        Occupation & Employer's Name <input class="bottom" name="formData.text_50_3" type="text" size="74" value="<s:property value="formData.text_50_3"/>"><br/>
        Father's Name <input class="bottom" name="formData.text_50_4" type="text" size="93" value="<s:property value="formData.text_50_4"/>"><br/>
        Address <input class="bottom" name="formData.text_50_5" type="text" size="100" value="<s:property value="formData.text_50_5"/>"><br/>
        Occupation & Employer's Name <input class="bottom" name="formData.text_50_6" type="text" size="74" value="<s:property value="formData.text_50_6"/>"><br/>
        Please list any center or daycare programs your child has previously attended or is currently attending
        <br/>
        <input class="bottom" name="formData.text_50_7" type="text" size="110" value="<s:property value="formData.text_50_7"/>">
    </div>
    <hr/>
    <div>
        <strong>PROOF OF INDENTITY VERIFICATION</strong> In the effort to help identify missing children, the
        Virginia
        Department of Social Services requires
        us, as a school offereing child care, to ask for information pertaining to a child's previous, if any, child
        care. Parents are also
        asked to present the school with proof of the child's identity and age. In compliance with this regulation,
        the
        Boyd School asks that
        you provide us with that requested information. Proof of the child's identity and age may include a
        certified
        copy of the child's
        birth certitifacte, birth registration card, notification of the child'sbirth (hospital, physician or
        midwife
        record), or a passport.
        In the case of adoption, ad placement agreement or other proof of the child's identity from a child
        palcement
        agency is also acceptable.
        we ask that you provide us with this information at the time of your child's enrollment. no ltater than his
        or
        her first day.
        Please understand we don need to keep the originaldocument. We only need to transfer the information on to
        the
        enrollment application.
    </div>

    <div class="border content">
        <div style="margin:0px 20px;"><strong>OFFICE USE ONLY:</strong></div>
        <div style="margin:10px 20px;">
            <div class="floatRight">
                Date of birth<input class="bottom" name="formData.text_50_8" type="text" size="75" value="<s:property value="formData.text_50_3"/>"><br/>
                Date certificate issued<input class="bottom" name="formData.text_50_9" type="text" size="63" value="<s:property value="formData.text_50_9"/>"><br/>
                State and country of birth<input class="bottom" name="formData.text_50_10" type="text" size="61" value="<s:property value="formData.text_50_10"/>"><br/>
                Certificate number<input class="bottom" name="formData.text_50_11" type="text" size="68" value="<s:property value="formData.text_50_11"/>"><br/>
                Hospital<input class="bottom" name="formData.text_50_12" type="text" size="80" value="<s:property value="formData.text_50_12"/>"><br/>
                Physician / Midwife <input class="bottom" name="formData.text_50_13" type="text" size="67" value="<s:property value="formData.text_50_13"/>"><br/>
            </div>
            <div>
                <input class="checkbox" name="formData.text_50_14" type="checkbox"   <s:iterator var="office" value="text_50_14" status="officeStatus"><s:if test="text_50_14[#officeStatus.index]=='ccbc'">checked="checked"</s:if></s:iterator>>Certified copy of birth
                certificate</input>
                <br/>
                <input class="checkbox" name="formData.text_50_14" type="checkbox"  <s:iterator var="office" value="text_50_14" status="officeStatus"><s:if test="text_50_14[#officeStatus.index]=='brc'">checked="checked"</s:if></s:iterator>>Birth registration Card</input><br/>
                <input class="checkbox" name="formData.text_50_14" type="checkbox"  <s:iterator var="office" value="text_50_14" status="officeStatus"><s:if test="text_50_14[#officeStatus.index]=='nob'">checked="checked"</s:if></s:iterator>>Notification of birth</input><br/>
                <input class="checkbox" name="formData.text_50_14" type="checkbox"   <s:iterator var="office" value="text_50_14" status="officeStatus"><s:if test="text_50_14[#officeStatus.index]=='pass'">checked="checked"</s:if></s:iterator>>Passport</input><br/>
                <input class="checkbox" name="formData.text_50_14" type="checkbox"  <s:iterator var="office" value="text_50_14" status="officeStatus"><s:if test="text_50_14[#officeStatus.index]=='paoop'">checked="checked"</s:if></s:iterator>>Placement agreement or other
                placement
                proof</input><br/>
            </div>
        </div>

        <br/>

        <div style="clear:both;" style="margin:0px 20px;"></div>
        <div style="line-height:100%;margin:0px 20px;">
            <div class="floatRight"><input class="bottom" name="formData.text_50_15" type="text" size="30"  value="<s:property value="formData.text_50_15"/>"><br/>Date
            </div>
            <div class="floatRight"><input class="bottom" name="formData.text_50_16" type="text" size="64"  value="<s:property value="formData.text_50_16"/>"><br/>Director
                / Director
                Designee Signature
            </div>
            <div class="floatRight"><input class="bottom" name="formData.text_50_17" type="text" size="64"  value="<s:property value="formData.text_50_17"/>"><br/>Director
                / Director
                Designee(PRINT)
            </div>
        </div>
        <div style="clear:both;"></div>
    </div>
    <hr/>
    <div style="margin:20px 0px;">
        <div class="normal"><strong>VIRGINIA SCHOOL ENTRANCE FORM</strong></div>
        <div class="normal">All students are required to have a VIrginina School Health Form signed and dated byh a
            physician.
            This form must be submitted by your child's first day.
        </div>
    </div>
    <hr/>
    <div><input type="button" value="Back" onclick="history.back()"/></div>
</div>
</body>
</html>