	function confirmAction(formObject,msg,action){
    	if (! window.confirm(msg)){
    		return;
    	}
    	
    	formObject.action = action;
    	formObject.submit();
	}
	
	function selectInit(selectElementID,selectedForValue){
   		//alert(selectElementID+":"+selectedForValue);   		
   		var selectObj = this.document.getElementById(selectElementID);
   		var selectLength = selectObj.length;
   		
   		for (var i = 0; i<selectLength ; i ++){
   			//alert(selectObj[i].getAttribute("value"));
   			if (selectObj[i].value == selectedForValue){
   				selectObj[i].selected  = true ;
   			}
   		}
   	}
	
	function dataFilter(search_param_name){
		var e = event.srcElement;
		var tmp = removeSearch("URL",search_param_name);
		tmp = removeSearch(tmp,"pn");	
		var search = addSearch(tmp,search_param_name,e.value);
		//alert(search);
		this.location.search= search;
	}
	
	function removeSearch(searchStr,name){
		if (searchStr == "URL"){
			return searchManage(this.location.search.substr(1),"remove",name,"");	
		}
		return searchManage(searchStr,"remove",name,"");	
	}
	
	function getSearch(searchStr,name){
		if (searchStr == "URL"){
			return searchManage(this.location.search.substr(1),"get",name,"");	
		}
		return searchManage(searchStr,"get",name,"");
    }

	function searchManage(searchStr,operType,name,value){
		//alert(searchStr+":"+operType+":"+name+":"+value);
		var searchArray = new Array();
		var returnStr = "";		
		if (searchStr != ""){
			searchArray = searchStr.split("&");			
			for(var i = 0 ; i < searchArray.length ; i ++){
				if (searchArray[i] != ""){
					var paramArray = new Array();
					paramArray = searchArray[i].split("=");		
					if (paramArray[0] == name){
						if (operType == "get"){
							return paramArray[1]
						}
						searchArray.splice(i,1);
						i--;
					}
				}
			}
		}
	
		if (operType == "add"){
			returnStr = name +  "=" + value;
		}
		
		if (operType == "remove"){
		}	
	
		for(var j = 0; j < searchArray.length; j++){
			if (searchArray[j] != ""){
				returnStr += "&" + searchArray[j];
			}
		}
		//alert(returnStr);
		return returnStr;	
	}
	
	function addSearch(searchStr,name,value){
		if (searchStr == "URL"){
			return searchManage(this.location.search.substr(1),"add",name,value);
		}
		return searchManage(searchStr,"add",name,value);	
	}
	
	function pageJump(objId){
		var e = document.getElementById(objId);
		goPage(e.value);
	}
	
	function goPage(pageNum){
		this.location.search = addSearch("URL","pn",pageNum);
	}
