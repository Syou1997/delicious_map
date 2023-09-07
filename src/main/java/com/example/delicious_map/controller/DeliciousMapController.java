package com.example.delicious_map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.delicious_map.entity.DeliciousMapMain;
import com.example.delicious_map.entity.DeliciousMapSub;
import com.example.delicious_map.service.ifs.DeliciousMapService;
import com.example.delicious_map.vo.AddFoodRequest;
import com.example.delicious_map.vo.AddInfoRequest;
import com.example.delicious_map.vo.DeliciousMapResponse;
import com.example.delicious_map.vo.DeliciousSubResponse;
import com.example.delicious_map.vo.UpdateFoodRequest;
import com.example.delicious_map.vo.UpdateFoodReviewRequest;
import com.example.delicious_map.vo.UpdateFoodReviewResponse;

@RestController
//@Controller
public class DeliciousMapController {
	
	@Autowired
	private DeliciousMapService deliciousMapService;
	
	//新增店家
	@PostMapping(value = "deliciousMapMain/add_info")
	public DeliciousMapResponse addInfo(@RequestBody AddInfoRequest Req) {
		DeliciousMapMain deliciousMapMain = new DeliciousMapMain(Req.getStoreName(),Req.getStoreCity());
		return deliciousMapService.addStore(deliciousMapMain);
	}
	
	//新增餐點
	@PostMapping(value = "deliciousMapSub/add_food")
	public DeliciousSubResponse addFood(@RequestBody AddFoodRequest Req) {
		return deliciousMapService.addFood(new DeliciousMapSub(Req.getStoreName(),Req.getFoodName(),Req.getPrice(),Req.getFoodReview()));
	}
	
	//更新店家
	@PostMapping(value = "deliciousMapSub/update_food")
	public DeliciousSubResponse updateFood(@RequestBody UpdateFoodRequest Req) {
		return deliciousMapService.updateFood(Req.getOldName(), Req.getNewName());
	}
	
	//修改餐點評價
	@PostMapping(value = "deliciousMapSub/update_foodreview")
	public UpdateFoodReviewResponse updateFoodReview(@RequestBody UpdateFoodReviewRequest Req){
		return deliciousMapService.updateFoodReview(Req.getFoodName(), Req.getNewReview());
	};
}
