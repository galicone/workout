// line chart data
var buyerData = {
	labels : [ "January", "February", "March", "April", "May", "June" ],
	datasets : [ {
		fillColor : "rgba(172,194,132,0.4)",
		strokeColor : "#ACC26D",
		pointColor : "#fff",
		pointStrokeColor : "#9DB86D",
		data : [ 203, 156, 99, 251, 305, 247 ]
	} ]
}

// draw line chart
function createLineChart(element) {
	window.myLine = new Chart(element, {
		type : 'line',
		data : buyerData,
		options : {
			title : {
				display : true,
				text : 'Chart.js Line Chart - Custom Tooltips'
			},
			tooltips : {
				enabled : false
			}
		}
	});
}