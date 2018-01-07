$(function() {
	var ctx, data, myLineChart, options;
	Chart.defaults.global.responsive = true;
	ctx = $('#line-chart').get(0).getContext('2d');
	options = {
		scaleShowGridLines : true,
		scaleGridLineColor : "rgba(0,0,0,.05)",
		scaleGridLineWidth : 1,
		scaleShowHorizontalLines : true,
		scaleShowVerticalLines : true,
		bezierCurve : false,
		bezierCurveTension : 0.4,
		pointDot : true,
		pointDotRadius : 4,
		pointDotStrokeWidth : 1,
		pointHitDetectionRadius : 20,
		datasetStroke : true,
		datasetStrokeWidth : 1,
		datasetFill : true,
	};
	data = {
		labels : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug',
				'Sep', 'Oct', "Nov", "Dec" ],
		datasets : [ {
			label : "访问量趋势",
			fillColor : "rgba(34, 167, 240,0.2)",
			strokeColor : "#22A7F0",
			pointColor : "#22A7F0",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "#22A7F0",
			data : [ 28, 48, 40, 19, 55, 27, 30, 39, 59, 34, 51, 26 ]
		} ]
	};
	myLineChart = new Chart(ctx).Line(data, options);
});

$(function() {
	var ctx, data, myLineChart, options;
	Chart.defaults.global.responsive = true;
	ctx = $('#pie-chart').get(0).getContext('2d');
	options = {
		showScale : false,
		scaleShowGridLines : false,
		scaleGridLineColor : "rgba(0,0,0,.05)",
		scaleGridLineWidth : 0,
		scaleShowHorizontalLines : false,
		scaleShowVerticalLines : false,
		bezierCurve : false,
		bezierCurveTension : 0.4,
		pointDot : false,
		pointDotRadius : 0,
		pointDotStrokeWidth : 2,
		pointHitDetectionRadius : 20,
		datasetStroke : true,
		datasetStrokeWidth : 4,
		datasetFill : true,
		legendTemplate : "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
	};
	data = [ {
		value : 300,
		color : "#FA2A00",
		highlight : "#FA2A00",
		label : "女"
	}, {
		value : 50,
		color : "#1ABC9C",
		highlight : "#1ABC9C",
		label : "未知"
	}, {
		value : 100,
		color : "#FABE28",
		highlight : "#FABE28",
		label : "男"
	} ];
	myLineChart = new Chart(ctx).Pie(data, options);
});