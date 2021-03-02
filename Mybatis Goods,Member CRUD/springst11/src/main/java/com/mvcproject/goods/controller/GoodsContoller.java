package com.mvcproject.goods.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvcproject.goods.controller.model.service.GoodsService;
import com.mvcproject.goods.controller.model.vo.Goods;



@Controller
public class GoodsContoller {

	@Autowired
	GoodsService goodsService;
	
	@RequestMapping(value="goodsList.do", method=RequestMethod.GET)
	public ModelAndView selectGoodsAll(ModelAndView modelAndView) throws Exception{
		List<Goods> goodsList = goodsService.selectGoodsAll();
		
		modelAndView.addObject("goodsList", goodsList);
		modelAndView.setViewName("goods/goodsList");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="goodsDel.do", method=RequestMethod.GET)
	public ModelAndView deleteGoods(Goods goods, ModelAndView modelAndView) throws Exception{
		int cnt = goodsService.deleteGoods(goods);
		modelAndView.addObject("cnt",cnt);
		modelAndView.setViewName("redirect:goodsList.do");
		return modelAndView;
	}
	
	@RequestMapping(value="goodsIns.do", method=RequestMethod.GET)
	public ModelAndView insertGoods(ModelAndView modelAndView) throws Exception{
		modelAndView.setViewName("goods/goodsInsertForm");
		return modelAndView;
	}
	
	@RequestMapping(value="goodsIns.do", method=RequestMethod.POST)
	public ModelAndView insertGoods(Goods goods, ModelAndView modelAndView) throws Exception{
		int cnt = goodsService.insertGoods(goods);
		modelAndView.addObject("cnt", cnt);
		modelAndView.setViewName("redirect:goodsList.do");
		return modelAndView;
	}
	
	@RequestMapping(value="goodsUpt.do", method=RequestMethod.GET)
	public ModelAndView updateGoods(String code, ModelAndView modelAndView) throws Exception{
		Goods goods = goodsService.selectGoods(code);
		modelAndView.addObject("goods", goods);
		modelAndView.setViewName("goods/goodsUpdateForm");
		return modelAndView;
	}
	
	@RequestMapping(value="goodsUpt.do", method=RequestMethod.POST)
	public ModelAndView updateGoods(Goods goods, ModelAndView modelAndView) throws Exception{
		int cnt = goodsService.updateGoods(goods);
		modelAndView.addObject("cnt",cnt);
		modelAndView.setViewName("redirect:goodsList.do");
		return modelAndView;
	}
	
	  @RequestMapping(value="codeData.do", method=RequestMethod.GET)
	  @ResponseBody
	  public String goodsAjax(String goodsCode) throws Exception {
	      Goods goods =  goodsService.selectGoods(goodsCode);
	      
	      JSONObject jsonData = new JSONObject();
	      if(goods==null){
	         jsonData.put("codeDup", "");
	      } else {
	         jsonData.put("codeDup", "dup");
	      }
	      return jsonData.toJSONString();
	   }
}
