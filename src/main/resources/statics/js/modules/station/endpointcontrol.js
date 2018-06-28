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
var ztree;

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            mn_name: null,
            CN : null,
            Para : null
        },
        showList: true,
        title:null,
        roleList:{},
        user:{
            status:1,
            deptId:null,
            deptName:null,
            roleIdList:[]
        }
    },
    methods: {
    	setInterval: function(){
    		var url = "/endpoint/endpointcontrol/Connect";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                async : true,
                dataType: "json",
                data:{'mn_name': vm.q.mn_name,'Para': vm.q.Para, 'CN':'上报设置时间间隔'}, 
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        }
    }
});