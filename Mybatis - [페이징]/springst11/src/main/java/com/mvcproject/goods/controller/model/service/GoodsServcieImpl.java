package com.mvcproject.goods.controller.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcproject.goods.controller.model.dao.GoodsDao;
import com.mvcproject.goods.controller.model.vo.Goods;

@Service
public class GoodsServcieImpl implements GoodsService{

	@Autowired
	GoodsDao goodsDao;

	@Override
	public List<Goods> selectGoodsAll() throws Exception {
		List<Goods> goodsList = goodsDao.selectGoodsAll();
		return goodsList;
	}
	
	@Override
	public Goods selectGoods(String code) throws Exception{
		Goods goods = goodsDao.selectGoods(code);
		return goods;
	}
	
	@Override
	public int deleteGoods(Goods goods) throws Exception{
		int cnt = goodsDao.deleteGoods(goods);
		return cnt;
	}
	
	@Override
	public int insertGoods(Goods goods) throws Exception{
		int cnt = goodsDao.insertGoods(goods);
		return cnt;
	}
	
	@Override
	public int updateGoods(Goods goods) throws Exception{
		int cnt = goodsDao.updateGoods(goods);
		return cnt;
	}
}
