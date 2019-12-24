package com.biz.product.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biz.product.domain.ProductDTO;
import com.biz.product.service.ProductSerivce;

/*
 * RestController
 * : 지금부터 이 controller는 REST full 서비스를 response할 class라는 의미
 * 이 controller에서 모든 method는 절대 view를 return할 수 없다.
 * 실질적으로 Model, ModelAndView 클래스를 사용하지 않아도 된다.
 * 
 */

@RequestMapping(value="/rest")
@RestController
public class ProductRestController {

	@Autowired
	ProductSerivce pService;
	
	@RequestMapping(value="/getProduct", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public ProductDTO getProduct(String p_code) {
		
		ProductDTO proDTO = pService.findByPCode(p_code);
		return proDTO;
	}
	
	
	@RequestMapping(value="/getString", method=RequestMethod.GET, produces="text/json;charset=UTF-8")
	public String getString(@RequestParam( value="str", // query로 보내는 변수명
	
	// required=false와 defaultValue가 없으면 server는 client에게 400오류를 보내고 처리를 거부한다.
	// 절대 사용자가 만든 vo, dto에는 적용하면 안된다(실제로 값을 보내도 못받음)
	required=false, // 혹시 값을 보내지 않아도 오류를 내지 마라
	defaultValue="없음" // 값을 보내지 않으면 없음 이라는 문자열을 세팅하라
	) String myStr) {
		
		if(myStr.equals("없음")) {
			return "http://localhost:8080/product/getString?str=문자열 형식으로 보내세요";
		}else {
			return "보낸문자열은? : " + myStr;
		}
	}
	
	@RequestMapping(value="/getUUID", method=RequestMethod.GET, produces="text/json;charset=UTF-8")
	public String getString() { 
		
		String strUUID = UUID.randomUUID().toString();
		return strUUID + " : " + strUUID.length();
	}
	
}
