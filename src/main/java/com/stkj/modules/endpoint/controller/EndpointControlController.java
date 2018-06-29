package com.stkj.modules.endpoint.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.stkj.common.utils.PageUtils;
import com.stkj.common.utils.R;
import com.stkj.modules.endpoint.service.WebControlService;
import com.stkj.modules.realtime.entity.RealData;
import com.stkj.modules.realtime.service.RTDataService;
import com.stkj.modules.sys.controller.AbstractController;

@RestController
@RequestMapping("/endpoint/endpointcontrol")
public class EndpointControlController extends AbstractController {
	@Autowired
	private WebControlService webControlService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/Connect")
	@RequiresPermissions("endpoint:endpointcontrol:connect")
	public R connect(@RequestParam Map<String, Object> params){
		String mn_name = (String)params.get("mn_name");
		String data = (String)params.get("data");
		String Para = (String)params.get("Para");
		String CN = (String)params.get("CN");

		String info="";
        String MN="";
        String CN_order="";
        String result="监测站 "+mn_name+"\t";
        String str="";
        if(mn_name.equals("1"))
            MN="88888880000001";
        else if(mn_name.equals("2"))
            MN="88888880000002";
        else if(mn_name.equals("3"))
            MN="88888880000003";
        else if(mn_name.equals("4"))
            MN="88888880000004";
        
        if(CN.equals("设置上报时间间隔"))
            CN_order="setRtdInterval";
        else  if(CN.equals("设置现场机时间"))
        { 
            CN_order="setSystemTime";    
            Para=Para.replaceAll(" ", "");
            Para=Para.replaceAll("-", "");
            Para=Para.replaceAll(":", "");
        }
        else if(CN.equals("获取现场机时间"))
            CN_order="getSystemTime";
        else if(CN.equals("开始采集实时数据"))
            CN_order="startGettingRTData";
        else if(CN.equals("停止采集实时数据"))
            CN_order="stopGettingRTData";              
        else if(CN.equals("远程校准"))
            CN_order="teleCalibration";  
        
        
        if(Para.equals(""))
            Para="NULL";
        if(data==null)
      	  str=MN+";"+CN_order+";"+Para+"\n";
        else
      	  str=MN+";"+CN_order+";"+Para+";"+data+"\n";
        
        try {
            Socket  socket=new Socket("192.168.8.61",60002); 
            socket.setSoTimeout(30000);
            //根据输入输出流和服务端连接
               OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
               PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
               printWriter.print(str);
               printWriter.flush();
               socket.shutdownOutput();//关闭输出流
               
               InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
               InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
               BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//缓冲区           
               String temp=null;//临时变量
               while((temp=bufferedReader.readLine())!=null){
                   info+=temp;
                   System.out.println("客户端接收服务端发送信息："+info);
               }     
               
               //关闭相对应的资源
               bufferedReader.close();
               inputStream.close();
               printWriter.close();
               outputStream.close();
               socket.close();
           
               String[] strarray=info.split(";");                 
                if(strarray[1].equals("1")&&strarray[2].equals("null")){
                    result+=CN+"\t 监测站连接异常";
                }
                else if(strarray[1].equals("2")&&strarray[2].equals("null")){
                    result+=CN+" 指令执行出错";
               }
                else if(strarray[1].equals("3")&&strarray[2].equals("null")){
                    result+=CN+" 指令执行超时";
               }
                else if(strarray[1].equals("0")&&strarray[2].equals("null")){
                    result+=CN+" 指令设置成功";
               }
            
                else  {
                    SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
                    SimpleDateFormat formatter2=new SimpleDateFormat("yyyyMMddHHmmss");   
                    try {
                       strarray[2]=formatter1.format(formatter2.parse(strarray[2]));
                       result+="当前时间为："+strarray[2];
                   } catch (ParseException e) {
                       e.printStackTrace();
                   }                  
               }                                                 
            }
        catch (UnknownHostException e) {
              result="网络异常";      
           } catch (IOException e) {
              result="网络异常";  
           } 
		
		return R.ok().put("result", result);
	}
}
