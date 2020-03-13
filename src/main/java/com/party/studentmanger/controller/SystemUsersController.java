package com.party.studentmanger.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.party.studentmanger.elementtype.MustToken;
import com.party.studentmanger.service.SystemUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户接口")
@RestController
@RequestMapping("/party")
public class SystemUsersController {
	@Autowired
	private SystemUserService service;
	@ApiOperation(value = "用户登录", notes = "用户登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public HashMap<String,Object> loginSystem(@RequestBody HashMap<String,String> map) {
		return service.loginSystem(map);
	}
	
	
	@ApiOperation(value = "拉取菜单", notes = "拉取菜单")
	@RequestMapping(value = "/getmenu", method = RequestMethod.POST)
	public List<HashMap<String,Object>> getMenu(@RequestBody HashMap<String,String> map) {
		return service.getMenu(map);
	}
	
	@ApiOperation(value = "获取验证码", notes = "获取验证码")
	@RequestMapping("/getVerifyCode")
	public void getVerificationCode(HttpServletResponse response,HttpServletRequest request,@RequestParam("phoneNo") String phoneNo) {
		try {
			int width = 200;
			int height = 69;
			BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//生成对应宽高的初始图片
			String randomText = service.drawRandomText(width, height, verifyImg,phoneNo);
			//单独的一个类方法，出于代码复用考虑，进行了封装。
			//功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符                   
			request.getSession().setAttribute("verifyCode", randomText);
			response.setContentType("image/png");// 必须设置响应内容类型为图片，否则前台不识别
			OutputStream os = response.getOutputStream(); // 获取文件输出流
			ImageIO.write(verifyImg, "png", os);// 输出图片流
			os.flush();
			os.close();// 关闭流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
