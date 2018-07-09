$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'realtime/rtdata/list',
        datatype: "json",
        colModel: [			
			{ label: '时间', name: 'time', width: 100, key: true},
			{ label: '站号', name: 'mn', width: 75 },
            { label: 'SO2', name: 'so2', width: 75 },
			{ label: 'NO2', name: 'no2', width: 75 },
			{ label: 'O3', name: 'o3', width: 75 },
			{ label: 'CO', name: 'co', width: 75 },
			{ label: 'PM10', name: 'pm10',  width: 75},
			{ label: 'PM2.5', name: 'pm25', width: 75},
			{ label: 'TVOC', name: 'tvoc', width: 75}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "deptId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            mn: null,
            begin:null,
            end:null
        },
        showList: true,
    },
    methods: {
    	getBegin: function () {

    	　　　　laydate({

    	　　　　　　elem: '#start',
    	        format: 'YYYY-MM-DD hh:mm:ss', // 分隔符可以任意定义
    	        istime: true,
    	　　　　　　choose: function (begin) {

    	　　　　　　　　vm.q.begin = begin;
    			  alert(vm.q.begin);
    	　　　　　　}
    	　　　　});
    	},
    	getEnd: function () {

    	　　　　laydate({

    	　　　　　　elem: '#end',
                format: 'YYYY-MM-DD hh:mm:ss', // 分隔符可以任意定义
                istime: true,
    	　　　　　　choose: function (end) {

    	　　　　　　　　vm.q.end = end;
    			  alert(vm.q.end);
    	　　　　　　}
    	　　　　});
    	},
        query: function () {
            vm.reload();
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'mn': vm.q.mn,'begindatetime': vm.q.begin, 'enddatetime':vm.q.end},
                page:page
            }).trigger("reloadGrid");
        }
    }
});