package com.mvcproject.goods.contoller.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvcproject.goods.controller.model.vo.Goods;

@Repository
public class GoodsDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Goods> selectGoodsAll() throws Exception{
		List<Goods> goodsList = sqlSession.selectList("Goods.selectGoodsAll");
		return goodsList;
	}

	public Goods selectGoods(String code) throws Exception{
		Goods goods = sqlSession.selectOne("Goods.selectGoods", code);
		return goods;
	}
	
	public int deleteGoods(Goods goods) throws Exception{
		int cnt = sqlSession.delete("Goods.deleteGoods", goods);
		return cnt;
	}
	
	public int insertGoods(Goods goods) throws Exception{
		int cnt = sqlSession.insert("Goods.insertGoods",goods);
		return cnt;
	}
	
	public int updateGoods(Goods goods) throws Exception{
		int cnt = sqlSession.update("Goods.updateGoods", goods);
		return cnt;
	}
	
	
}
