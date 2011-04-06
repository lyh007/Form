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
     <script>
         function submitForm(submitType){
             var form=document.getElementById("formId");
             document.getElementById("submitType").value=submitType;
             form.submit();
         }
     </script>
</head>
<body>
<div class="outline">
    <form action="formdata/form-data!step2.action" method="POST" id="formId">
        <input type="hidden" name="submitType" value=1 id="submitType">
        <div class="floatRight">
            <div class="topRightHeader"> Admissions Contract</div>
            <div><strong>CAMPUS:</strong>
                <input class="checkbox" name="text_20_1" type="checkbox" value="Al">Aldie</input>
                <input class="checkbox" name="text_20_1" type="checkbox" value="Br">Broadlands</input>
                <input class="checkbox" name="text_20_1" type="checkbox" value="Fa">Fairfax</input>
                <input class="checkbox" name="text_20_1" type="checkbox" value="Re">Reston</input>
                <input class="checkbox" name="text_20_1" type="checkbox" value="We">Westfields</input>

            </div>
        </div>
        <div class="topHeader">The Boyd School</div>
        <hr/>
        <div class="content contractRight ">
            <div>
                <div class="inverseHeader">Contact Information</div>
                <div class="contactContent">
                    Child's Home # <input class="bottom" name="formData.text_20_2" type="text" size="25"><br/>
                    E-mail (home) # <input class="bottom" name="formData.text_20_3" type="text" size="24"><br/>
                    Mother's Home # <input class="bottom" name="formData.text_20_4" type="text" size="23"><br/>
                    Mother's Work # <input class="bottom" name="formData.text_20_5" type="text" size="24"><br/>
                    Mother's Cell # <input class="bottom" name="formData.text_20_6" type="text" size="26"><br/>
                    Mother's Email(work) # <input class="bottom" name="formData.text_20_7" type="text" size="16"><br/>
                    Father's Home # <input class="bottom" name="formData.text_20_8" type="text" size="23"><br/>
                    Father's Work # <input class="bottom" name="formData.text_20_9" type="text" size="24"><br/>
                    Father's Cell # <input class="bottom" name="formData.text_20_10" type="text" size="26"><br/>
                    Father's Email (work) # <input class="bottom" name="formData.text_20_11" type="text" size="16">
                </div>
            </div>

        </div>
        <div class="content">
            I hereby make application for my
            <input class="checkbox" name="text_20_12" type="checkbox" value="son">son</input>
            <input class="checkbox" name="text_20_12" type="checkbox" value="daughter">daughter</input><br/>
            whose full name is <input class="bottom" name="formData.text_20_13" type="text" size="90"><br/>
            Age <input class="bottom" name="formData.text_20_14" type="text" size="3">
            Date of Birth <input class="bottom" name="formData.text_20_15" type="text" size="10">
            Nickname <input class="bottom" name="formData.text_20_16" type="text" size="55"><br/>
            Address <input class="bottom" name="formData.text_20_17" type="text" size="100"><br/>
            City <input class="bottom" name="formData.text_20_18" type="text" size="53">
            State <input class="bottom" name="formData.text_20_19" type="text" size="10">
            Zip <input class="bottom" name="formData.text_20_20" type="text" size="20">
            <hr/>
            Mother's Name <input class="bottom" name="formData.text_50_1" type="text" size="93"><br/>
            Address <input class="bottom" name="formData.text_50_2" type="text" size="100"><br/>
            Occupation & Employer's Name <input class="bottom" name="formData.text_50_3" type="text" size="74"><br/>
            Father's Name <input class="bottom" name="formData.text_50_4" type="text" size="93"><br/>
            Address <input class="bottom" name="formData.text_50_5" type="text" size="100"><br/>
            Occupation & Employer's Name <input class="bottom" name="formData.text_50_6" type="text" size="74"><br/>
            Please list any center or daycare programs your child has previously attended or is currently attending
            <br/>
            <input class="bottom" name="formData.text_50_7" type="text" size="110">
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
                    Date of birth<input class="bottom" name="formData.text_50_8" type="text" size="75"><br/>
                    Date certificate issued<input class="bottom" name="formData.text_50_9" type="text" size="63"><br/>
                    State and country of birth<input class="bottom" name="formData.text_50_10" type="text" size="61"><br/>
                    Certificate number<input class="bottom" name="formData.text_50_11" type="text" size="68"><br/>
                    Hospital<input class="bottom" name="formData.text_50_12" type="text" size="80"><br/>
                    Physician / Midwife <input class="bottom" name="formData.text_50_13" type="text" size="67"><br/>
                </div>
                <div>
                    <input class="checkbox" name="text_50_14" type="checkbox" value="ccbc">Certified copy of birth certificate</input>
                    <br/>
                    <input class="checkbox" name="text_50_14" type="checkbox" value="brc">Birth registration Card</input><br/>
                    <input class="checkbox" name="text_50_14" type="checkbox" value="nob">Notification of birth</input><br/>
                    <input class="checkbox" name="text_50_14" type="checkbox" value="pass">Passport</input><br/>
                    <input class="checkbox" name="text_50_14" type="checkbox" value="paoop">Placement agreement or other placement
                    proof</input><br/>
                </div>
            </div>

            <br/>

            <div style="clear:both;" style="margin:0px 20px;"></div>
            <div style="line-height:100%;margin:0px 20px;">
                <div class="floatRight"><input class="bottom" name="formData.text_50_15" type="text" size="30"><br/>Date</div>
                <div class="floatRight"><input class="bottom" name="formData.text_50_16" type="text" size="64"><br/>Director / Director
                    Designee Signature
                </div>
                <div class="floatRight"><input class="bottom" name="formData.text_50_17" type="text" size="64"><br/>Director / Director
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
        <div><input type="button" value="Save & Exit" onclick="submitForm(1)"/><input type="submit" value="Save & Continue"  onclick="submitForm(2)"/></div>
    </form>
</div>
</body>
</html>