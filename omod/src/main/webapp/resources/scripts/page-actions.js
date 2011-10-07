

var EVT =
{
	ready : function()
	{
		/**
		 * Page Actions
		 */
		var enableCheck = true;
		var pageId = jQuery("#pageId").val();
		if(enableCheck && pageId != undefined && eval("CHECK." + pageId))
		{
			eval("CHECK." + pageId + "()");
		}

		/**
		 * Ajax Indicator when send and receive data
		 */
		if(jQuery.browser.msie)
		{
			jQuery.ajaxSetup({cache: false});
		}
	
	}
};

var CHECK = 
{
	
	
	reportPage : function()
	{
		
		var validator = jQuery("#reportForm").validate(
		{
			event : "blur",
			rules : 
			{
			
				"name" : { required : true}
				
			}
		});
	},reportList : function()
	{
		jQuery('.date-pick').datepicker({yearRange:'c-30:c+30', dateFormat: 'dd/mm/yy', changeMonth: true, changeYear: true});
	},
	configPage : function()
	{
		
		var validator = jQuery("#configForm").validate(
		{
			event : "blur",
			rules : 
			{
			
				"real_path_p" : { required : true},
				"url_data_p" : { required : true},
				"url_birt_p" : { required : true},
				"width_p" : { required : true,digits : true},
				"height_p" : { required : true,digits : true},
				"format_p" : { required : true}
			}
		});
	},
	reportTypePage : function()
	{
		
		var validator = jQuery("#reportTypeForm").validate(
		{
			event : "blur",
			rules : 
			{
			
				"name" : { required : true},
				"reportFile" : {
		            required: {
		                depends: function() {
		                    return (jQuery("#id").val() == null || jQuery("#id").val() =='' ? true : false);
		                }
		            }, accept: "rptdesign|rptlibrary"
		        }
			}
		});
	}
	
};

/**
 * Pageload actions trigger
 */

jQuery(document).ready(
	function() 
	{
		EVT.ready();
	}
);



