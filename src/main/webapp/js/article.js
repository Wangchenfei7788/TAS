/**
 * 
 */
 
 	function searchArticle(){
   		var paramName = document.mainForm.search_list.value; 
   		var paramValue = document.mainForm.key.value;
   		
   		if(paramName=="article_id")
   		{
   			if(isNaN(paramValue)){
   				alert("请输入正确的文章ID(数字)!");
   		 		return false;	
   			}	
   		}	
   		var tmp = removeSearch("URL","article_id");
   		tmp = removeSearch(tmp,"title");
   		tmp = removeSearch(tmp,"content");
   		tmp = removeSearch(tmp,"keyword");
   		tmp = removeSearch(tmp,"add_user");
   		tmp = removeSearch(tmp,"add_date");
   		tmp = addSearch(tmp,"searchType",paramName);	
   		var search = addSearch(tmp,paramName,paramValue);   		
   		
   		this.location.search= search;
		
   	}

   	function goSearchArticle(){
    	if(event.keyCode == 13){
    		searchArticle();	
    		return false;	
    	}
    }
   	
   	function pageInit(){
   	   	//alert(getSearch("URL","searchType"));
   		selectInit("article_class_list",getSearch("URL","classId"));
   		selectInit("article_filter_list",getSearch("URL","filter"));
   		selectInit("article_order_list",getSearch("URL","order"));   
   		selectInit("search_list",getSearch("URL","searchType"));		
   		selectInit("page_list",getSearch("URL","pn"));
   			   		
   	}