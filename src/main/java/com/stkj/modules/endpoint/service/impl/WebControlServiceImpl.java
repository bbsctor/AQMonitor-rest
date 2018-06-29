package com.stkj.modules.endpoint.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

import com.stkj.modules.endpoint.service.WebControlService;

@Service("webControlService")
public class WebControlServiceImpl implements WebControlService {

	 Socket socket=null;
		@Override
		public void connect() {	
	            //创建Socket对象
	          try {
				socket=new Socket("localhost",8888);
			} catch (UnknownHostException e) {		
				e.printStackTrace();
			} catch (IOException e) {			
				e.printStackTrace();
			}
	    }

		@Override
		public String SendAndGetMessage(String message) {
			 String info="";
			 try {
		            //根据输入输出流和服务端连接
		            OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
		            PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
		            printWriter.print("服务端你好，我是Balla_兔子");
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
		           // socket.close();
		        } catch (UnknownHostException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			return info;
		}
		
		@Override
		public void closeconnect() {
			// TODO Auto-generated method stub
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
