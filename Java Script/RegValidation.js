// all validation of the fields will go here 

// this function will be called when user clicks on submit button and 
// this function will call all other functions to validate and if any of the validation 
// fails then it return false, if all fields are validated returns true 
function fnValidateForm(){
	if(!fnValidateName())
		return false;

	if(!fnValidatePassword())
		return false;

	if(!fnValildateSex())
		return false;

	if(!fnValidateQualification())
		return false;

	if(!fnValidateAddress())
		return false;

	if(!fnValidateInterest())
		return false;


	if(!fnValidateCountry())
		return false;

	alert("Congrats, fields are validate, \nprocessing for Registration ");
	return true;
}


function fnValidateName(){
	fname=document.regForm.userName.value

	if(fname.length<6){
		alert("Please enter name more than 6 chars");
		document.regForm.userName.value="";
		return false;
	}

	if(fname.charAt(0)==" "){
		document.regForm.userName.value="";
		alert("Sorry name cannot start with leading spaces");
		return false;
	}
		
	spl="1234567890`~!@#$%^&*()_+=-\";:/.,<>?";

	for(var i=0; i<spl.length; i++){
		if(fname.indexOf(spl.charAt(i))>=0){
		document.regForm.userName.value="";
			alert("Sorry Name cannot have special chars or numbers ");
			return false;
		}
	}
	return true;
}

function fnValidatePassword(){
	passwd = document.regForm.userPwd.value 

	if(passwd.length<6){
		alert("Sorry password cannot be less than 6 chars");
		return false;
	}

	repasswd = document.regForm.cPwd.value 

	if(passwd.length==repasswd.length){
		for(var i=0; i<passwd.length; i++){
			if(passwd.charAt(i)!=repasswd.charAt(i)){
				alert("Sorry password mismatch");	
				return false;
			}
		}
	}else{
		alert("Password length mis match");
		return false;
	}

	return true;
}

function fnValildateSex(){
	
	s = document.regForm.sex

	
	for(var i=0; i<s.length; i++){
		if(s[i].checked)
			return true;
	}

	alert("Please select your sex");
	return false;
}

function fnValidateAddress(){
	address = document.regForm.addrs.value 

	if(address.charAt(0)==" "){
		alert("Sorry address Cannot start with a space");
		return false;
	}

	if(address.length<8){
		alert("Address length should be more than 8 chars");
		return false;
	}

	return true;
}

function fnValidateInterest(){
	if(document.regForm.cb1.checked || document.regForm.cb2.checked || 
		document.regForm.cb3.checked || document.regForm.cb4.checked ){
		return true;
	}

	alert("Please select your area of interest");
	return false;
}



function fnValidateCountry(){
	country = document.regForm.country

	if(country.selectedIndex<1){
		alert("please select the country from the list");
		return false;
	}

	return true;
}


function fnValidateQualification(){
	quali = document.regForm.qual

	if(quali.selectedIndex<1){
		alert("Sorry please select your Qualification ");
		return false;
	}

	return true;
}


// for enabling 
function fnEnableReg(){
	if(document.regForm.terms[0].checked)
		document.regForm.regBtn.disabled=false;
}

// for disabling 
function fnDisableReg(){
	if(document.regForm.terms[1].checked)
		document.regForm.regBtn.disabled=true;
}







