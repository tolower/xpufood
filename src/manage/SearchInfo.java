package manage;

import java.util.ArrayList;
import java.util.List;

import food.*;
import restaurant.*;

public class SearchInfo {
	// 根据关键字返回查询的餐馆或饭菜信息
	public List searchResult(String kw) {
		List list = new ArrayList();
		try {
			RestaurantDAO resdao = new RestaurantDAO();
			list.addAll(resdao.searchByName(kw));
			FoodDAO foodao = new FoodDAO();
			list.addAll(foodao.searchByName(kw));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	// 根据查询信息返回food结果
	public List<Food> foodResult(String foodType, Integer foodLevel,
			Integer foodLoveCount, String foodName) {
		List<Food> list = null;
		String sql = "select * from food where food_type='" + foodType
				+ "' or food_level=" + foodLevel + " or food_lovecount="
				+ foodLoveCount + " or food_name like '%"+foodName+"%'";
		try {
			FoodDAO dao = new FoodDAO();
			list=dao.findByProperty(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
