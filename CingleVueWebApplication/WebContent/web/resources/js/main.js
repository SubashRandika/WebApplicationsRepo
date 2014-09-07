$(document).ready(function() {
				var oTable = $('#example').dataTable( {
					"bProcessing": true,
					"bJQueryUI": true,
					"sPaginationType": "full_numbers",
					"sAjaxSource":"http://localhost:8080/CingleVueWebApplication/api/schools",
					"sAjaxDataProp": "schools",
					"aoColumns": [
						{ "mData": "school.schoolName" },
						{ "mData": "subject" },
						{ "mData": "latestY3" },
						{ "mData": "latestY5" },
						{ "mData": "latestY7" },
						{ "mData": "latestY9" },
						{ "mData": "rawGainY3Y5" },
						{ "mData": "factoredGainY3Y5" },
						{ "mData": "glgY3Y5" },
						{ "mData": "latestGainInGainY3Y5" }
					]
				} );
} );