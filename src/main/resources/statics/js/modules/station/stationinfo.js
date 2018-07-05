$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'station/stationinfo/list',
        datatype: "json",
        colModel: [			
			//{ label: '站点ID', name: 'id', width: 100, key: true},
			{ label: '站点名称', name: 'siteName', width: 75 },
            { label: '站点编号', name: 'siteNum', width: 75 },
			{ label: '省份', name: 'province', width: 75 },
			{ label: '城市', name: 'city', width: 75 },
			{ label: '区域', name: 'area', width: 75 },
			{ label: '设备数量', name: 'devicecounts',  width: 75}
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

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
        	name: null
        },
        showList: true,
        title:null,
        stationinfo:{ }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.stationinfo = {};
        },
        update: function () {
        	var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
        },
        del: function () {
        	var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "station/stationinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
        },
        saveOrUpdate: function () {
            var url = vm.stationinfo.id == null ? "station/stationinfo/save" : "station/stationinfo/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.stationinfo),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
		getInfo: function(id){
			$.get(baseURL + "station/stationinfo/info/"+id, function(r){
                vm.stationinfo = r.stationinfo;
            });
		},
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'mn': vm.q.username,'begindate': vm.q.begindate, 'enddate':vm.q.enddate},
                page:page
            }).trigger("reloadGrid");
        }
    }
});