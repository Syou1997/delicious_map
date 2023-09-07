package com.example.delicious_map.service.ifs;

import com.example.delicious_map.entity.DeliciousMapMain;
import com.example.delicious_map.entity.DeliciousMapSub;
import com.example.delicious_map.vo.DeliciousMapResponse;
import com.example.delicious_map.vo.DeliciousSubResponse;
import com.example.delicious_map.vo.UpdateFoodReviewResponse;

public interface DeliciousMapService {
	
	public DeliciousMapResponse addStore(DeliciousMapMain info);
	
	public DeliciousSubResponse addFood(DeliciousMapSub info);
	
	public DeliciousSubResponse updateFood(String oldName,String newName);
	
	public UpdateFoodReviewResponse updateFoodReview(String foodName,int newReview);

}
