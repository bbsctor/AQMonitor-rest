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
function getNowFormatDate(dates) {
	var date = new Date(dates);
     var seperator1 = "/";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var hours=date.getHours();
    var Minutes=date.getMinutes();
    var Seconds=date.getSeconds();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if (hours >= 1 && hours <= 9) {
        hours = "0" + hours;
    }
    if (Minutes >= 1 && Minutes <= 9) {
        Minutes = "0" + Minutes;
    }
    if (Seconds >= 1 && Seconds <= 9) {
        Seconds = "0" + Seconds;
    }
    
    var Formatdate = date.getFullYear() + seperator1 + month + seperator1 + strDate 
    				 + " " + hours + seperator2 + Minutes + seperator2 + Seconds;
    				 
    return Formatdate;
    }

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            username: null,
            begindate:null,
            enddate:null
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
        query: function () {
               var myChart = echarts.init(document.getElementById('main'));

        
       		var MN=$("#MN").val();	
                        var colors = ['orange', 'blue', 'black']; 
         	   
         	   
               var option = {
       			color: colors,
       		backgroundColor:'#fff',		//背景色
               title : {
               text: '空气质量-气体含量',
               subtext: 'www.stkj.com',
       		x:'center'					//标题居中
           },
           
           dataZoom:{ 
           	show:'true',
           	type:'inside',
           	
           	//moveOnMouseMove:false,
           	//yAxisIndex:[0,1,2],
           	xAxisIndex:0,
           	},
       	grid: {
               right: '20%',
       		y2:140

           },
           tooltip : {
               trigger: 'axis',
       		 axisPointer: {
                   type: 'cross'
               }
           },
           legend: {
               data:['SO2','CO','NO2','O3','PM2.5','PM10','TVOC'],
       		orient:'horizontal',			//图例垂直布局
       		x:'center',	
       		y:'400px',	
       		selected:{
       			'SO2':false,
       			'NO2':false,
       			}
           },
           toolbox: {
               show : true,				//显示工具箱
               feature : {
                   mark : {show: true},	//辅助线标志
                   magicType : {show: true, type: [ 'line', 'bar', 'stack', 'tiled']}, //动态类型切换，支持直角系下的折线图、柱状图、堆积、平铺转换，
                   restore : {show: true},
                   saveAsImage : {show: true}
               }
           },
       	
           calculable : true,		//是否启用拖拽重计算特性
            xAxis:  [{	//X轴       	
                       type : 'category',
                       data:[]	,
                        axisLabel:{  
                     //  interval:0,//横轴信息全部显示  
                     //  rotate:-60,//-60度角倾斜显示  
                    	 margin:10,
                       interval: 100000,
       				showMinLabel: true,
       				showMaxLabel: true,
                      } ,
                      axisTick:{
                      interval:5
                      }
                   }],
                   yAxis : [
                            {
                                type: 'value',
                                name: 'SO2、NO2、O3、TVOC',
                                min: 0,
                                max: 300,
                                position: 'left',
                                axisLine: {
                                    lineStyle: {
                                    color: colors[0]
                                    }
                                },
                                axisLabel: {
                                    formatter: '{value} ppb'
                                }
                            },
                            {
                                type: 'value',
                                name: 'CO',
                                min: 0,
                                max: 1.2,
                                position: 'right',
                                offset: 80,
                                axisLine: {
                                    lineStyle: {
                                        color: colors[1]
                                    }
                                },
                                axisLabel: {
                                    formatter: '{value} ppm'
                                }
                            },
                            {
                                type: 'value',
                                name: 'PM2.5、PM10',
                                min: 0,
                                max: 120,
                                position: 'right',
                                axisLine: {
                                    lineStyle: {
                                        color: colors[2]
                                    }
                                },
                                axisLabel: {
                                    formatter: '{value} μg/m3'
                                }
                            }
                        ],
                        color:[
                               'red',	//NO2曲线颜色
                               '#9B30FF',//SO2
                               'rgb(195,229,0)',	//O3曲线颜色                       
                               '#1C86EE',	//PM10图颜色
                               '#FF4500',	//PM2.5曲线颜色
                               '#FF83FA',	//O3图颜色
                               'orange' ,   //TVOC曲线颜色           
                               ],
                   series : [	//系列（内容）列表                      
       						{
       		                    name:'NO2',
       		                    type:'line',	//折线图表示（生成农曲线）
       		                    smooth:'true',
       		                    symbol:'emptycircle',	//设置折线图中表示每个坐标点的符号；emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形	                    
       		                    data:[]			
       		                },
       		                
       		                {
       		                    name:'SO2',
       		                    type:'line',
       		                    smooth:'true',
       		                    symbol:'emptyrect',
       		                    data:[]	
       		                },		                
       		                {
       		                    name:'O3',
       		                    type:'line',
       		                    smooth:'true',
       		                    symbol:'circle',	//标识符号为实心圆
       		                  //  yAxisIndex: 1,		//与第二y轴有关
       		                    data:[]	
       		                },		                
       		                {
       		                    name:'PM10',
       		                    smooth:'true',
       		                    type:'bar',		//柱状图表示
       		                    yAxisIndex: 2,
       		                    data:[]	
       		                },		                
       		                {
       		                    name:'PM2.5',
       		                    type:'bar',
       		                    smooth:'true',
       		                    yAxisIndex: 2,
       		                    symbol:'emptydiamond',
       		                    data:[]	
       		                },
       		                {
       		                    name:'CO',
       		                    yAxisIndex: 1,
       		                    type:'line',
       		                    smooth:'true',
       		                    symbol:'diamond',	//标识符号为实心圆
       		                  //  yAxisIndex: 1,		//与第二y轴有关
       		                    data:[]	
       		                },		
       		                {
       		                    name:'TVOC',
       		                    type:'line',
       		                    smooth:'true',
       		                    symbol:'rectangle',	//标识符号为实心圆
       		                  //  yAxisIndex: 1,		//与第二y轴有关
       		                    data:[]	
       		                }		
                   ]
               };
       		 
       	myChart.showLoading();	//数据加载完之前先显示一段简单的loading动画	
       	
       	 var NO2=[];		//NO2数组
       	 var SO2=[];		//SO2数组
       	 var O3=[];		//o3数组
       	 var PM10=[];		//p10数组
       	 var PM25=[];	//pm25数组
       	 var CO=[];
       	 var TVOC=[];
       	 var dates=[];		//时间数组
       	
                $.ajax({	//使用JQuery内置的Ajax方法         
                type : "post",		//post请求方式
              //  contentType:"application/json;charset=utf-8",
                async : true,		//异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : baseURL + '/realtime/rtdata/QueryByTimeAndMN',	//请求发送到ShowInfoIndexServlet处
                data: {'mn': vm.q.username,'begindate': vm.q.begindate, 'enddate':vm.q.enddate},		//提交数据到后台
                dataType : "json",		//返回数据形式为json
                
                success : function(result) {
              
               	 //请求成功时执行该函数内容，result即为服务器返回的json对象
       	         if (result != null && result.length > 0) {
       	                for(var i=0;i<result.length;i++){       
       	                   NO2.push(result[i].no2*1000);		//挨个取出值并填入前面声明的数组
       	                   SO2.push(result[i].so2*1000);
       	                   O3.push(result[i].o3*1000);
       	                   PM10.push(result[i].pm10);
       	                   PM25.push(result[i].pm25);
       	                   CO.push(result[i].co);
       	                   TVOC.push(result[i].tvoc*1000);
       	                   dates.push(getNowFormatDate(result[i].time));
       	                }
       	                myChart.hideLoading();	//隐藏加载动画
       	                
       	                myChart.setOption({		//载入数据
       	   		         xAxis: {
       	   		             data: dates	//填入X轴数据
       	   		         },
       	   		         series: [	//填入系列（内容）数据
       	   		               		{
       			   		             // 根据名字对应到相应的系列
       			   		             name: 'NO2',
       			   		             data: NO2
       	   		         		},
       	   		               		{
       			   		             name: 'SO2',
       			   		             data: SO2
       	   		         		},
       	   		         			{
       			   		             name: 'O3',
       			   		             data: O3
       	   		         		},
       	   		         			{
       			   		             name: 'PM10',
       			   		             data: PM10
       	   		         		},
       	   		         			{
       	   		         			name: 'PM2.5',
       	   		         			data: PM25
         		         			},
          		         				{
         			   		             name: 'TVOC',
         			   		             data: TVOC
         	  		         		},
         	  		         			{
         	  		         			name:'CO',
         	  		         			data:CO
         	  		         		}
       	   		        ]
       	   		     });
       	                
       	         }
       	         else {
       	        	 //返回的数据为空时显示提示信息
       	        	 alert("图表请求数据为空，可前往历史数据查询，您可以稍后再试！");
       	          	 myChart.hideLoading();
       	         }
                
       		},
            	error : function(errorMsg) {
            		//请求失败时执行该函数
                	alert("图表请求数据失败，可能是服务器开小差了");
                	myChart.hideLoading();    	
            	}
           });
          myChart.setOption(option, true);	//载入图表
        window.addEventListener("resize",function(){
           myChart.resize();
       });
         
       }
        },
        getDept: function(){
            //加载部门树
            $.get(baseURL + "sys/dept/list", function(r){
                ztree = $.fn.zTree.init($("#deptTree"), setting, r);
                var node = ztree.getNodeByParam("deptId", vm.user.deptId);
                if(node != null){
                    ztree.selectNode(node);

                    vm.user.deptName = node.name;
                }
            })
        },
        getUser: function(userId){
            $.get(baseURL + "sys/user/info/"+userId, function(r){
                vm.user = r.user;
                vm.user.password = null;

                vm.getDept();
            });
        },
        getRoleList: function(){
            $.get(baseURL + "sys/role/select", function(r){
                vm.roleList = r.list;
            });
        },
        deptTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择部门",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#deptLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    vm.user.deptId = node[0].deptId;
                    vm.user.deptName = node[0].name;

                    layer.close(index);
                }
            });
        }
    }
);