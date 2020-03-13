package com.party.studentmanger.service;

import java.util.HashMap;
import java.util.List;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.studentmanger.entity.SystemUsersEntity;
import com.party.studentmanger.mapper.SystemUsersMapper;
import com.party.studentmanger.utils.RedisUtils;
import com.party.studentmanger.utils.TokenUtils;

@Service
public class SystemUserService {
	@Autowired
	private TokenUtils util;
	@Autowired
	RedisUtils rutils;
	
	private SystemUsersEntity entity=new SystemUsersEntity();
	@Autowired
	SystemUsersMapper mapper;
	public HashMap<String, Object> loginSystem(HashMap<String, String> map) {
		
		HashMap<String, Object>  result=new HashMap<String, Object>();
		
		//验证
		entity=mapper.loginSystem(map);
		if(entity==null) {
			result.put("msg", "用户不存在！");
			
			return result;
		}else if(!entity.getUser_password().equals(map.get("user_password"))) {
			result.put("msg", "密码错误！");
			return result;
		}else {
			String token =util.getToken(entity);
			String key=entity.getUser_id()+entity.getUser_password();
			rutils.set(key, token,3600);
			//将生成token存入redis
			result.put("token", token);
			result.put("user",entity);
		}
		return result;
	}

	public SystemUsersEntity getUserByID(String userid) {
		return mapper.getUserByID(userid);
	}
	
	

	public List<HashMap<String, Object>> getMenu(HashMap<String, String> map) {
		return  mapper.getMenu(map);
	}
	

	public  String drawRandomText(int width,int height,BufferedImage verifyImg,String phoneNo) {
        Graphics2D graphics = (Graphics2D)verifyImg.getGraphics();
        graphics.setColor(Color.WHITE);//设置画笔颜色-验证码背景色
        graphics.fillRect(0, 0, width, height);//填充背景
        graphics.setFont(new Font("微软雅黑", Font.BOLD, 40));
        //数字和字母的组合
        String baseNumLetter = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
        StringBuffer sBuffer = new StringBuffer();
        int x = 10;  //旋转原点的 x 坐标
        String ch = "";
        Random random = new Random();
        String verifyStr="";
        for(int i = 0;i < 4;i++){
            graphics.setColor(getRandomColor());
            //设置字体旋转角度
            int degree = random.nextInt() % 30;  //角度小于30度
            int dot = random.nextInt(baseNumLetter.length());
	       ch = baseNumLetter.charAt(dot) + "";
	       verifyStr=verifyStr+ch;
	       sBuffer.append(ch);
	       //正向旋转
	       graphics.rotate(degree * Math.PI / 180, x, 45);
	       graphics.drawString(ch, x, 45);
	       //反向旋转
	       graphics.rotate(-degree * Math.PI / 180, x, 45);
	       x += 48;
	   }
        rutils.set(phoneNo, verifyStr,60);
	   //画干扰线
	   for (int i = 0; i <6; i++) {
	       // 设置随机颜色
	            graphics.setColor(getRandomColor());
	       // 随机画线
	            graphics.drawLine(random.nextInt(width), random.nextInt(height),
	                               random.nextInt(width), random.nextInt(height));
	   }
	   //添加噪点
	   for(int i=0;i<30;i++){
	            int x1 = random.nextInt(width);
	            int y1 = random.nextInt(height);
	            graphics.setColor(getRandomColor());
	            graphics.fillRect(x1, y1, 2,2);
	            }
	   return sBuffer.toString();
	}

	/**
	 * 随机取色
	 */
	private static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256),
				ran.nextInt(256), ran.nextInt(256));
		return color;
	}
}
