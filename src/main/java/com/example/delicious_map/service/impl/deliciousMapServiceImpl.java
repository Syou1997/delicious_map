package com.example.delicious_map.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.delicious_map.constants.RtnCode;
import com.example.delicious_map.entity.DeliciousMapMain;
import com.example.delicious_map.entity.DeliciousMapSub;
import com.example.delicious_map.repository.DeliciousMapMainDao;
import com.example.delicious_map.repository.DeliciousMapSubDao;
import com.example.delicious_map.service.ifs.DeliciousMapService;
import com.example.delicious_map.vo.DeliciousMapResponse;
import com.example.delicious_map.vo.DeliciousSubResponse;
import com.example.delicious_map.vo.UpdateFoodRequest;
import com.example.delicious_map.vo.UpdateFoodReviewResponse;

@Service
public class DeliciousMapServiceImpl implements DeliciousMapService {

	@Autowired
	private DeliciousMapMainDao deliciousMapMainDao;

	@Autowired
	private DeliciousMapSubDao deliciousMapSubDao;

	// 穝糤坝┍
	@Override
	public DeliciousMapResponse addStore(DeliciousMapMain info) {
		// ň
		if (info == null) {
			return new DeliciousMapResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		if (!StringUtils.hasText(info.getStoreName()) || !StringUtils.hasText(info.getStoreCity())) {

			return new DeliciousMapResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}

		DeliciousMapMain res = deliciousMapMainDao.save(info);

		return new DeliciousMapResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	// 穝糤繺翴
	@Override
	public DeliciousSubResponse addFood(DeliciousMapSub info) {
		// ň
		if (info == null) {
			return new DeliciousSubResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		if (!StringUtils.hasText(info.getStoreName()) || !StringUtils.hasText(info.getFoodName())) {

			return new DeliciousSubResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		if (info.getPrice() <= 0 || info.getFoodReview() <= 0) {
			return new DeliciousSubResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}

		DeliciousMapSub res = deliciousMapSubDao.save(info);

		return new DeliciousSubResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);

	}

	// э繺翴嘿
	@Override
	// ň
	public DeliciousSubResponse updateFood(String oldName, String newName) {
		Optional<DeliciousMapSub> op = deliciousMapSubDao.findById(oldName);
		if (op == null) {
			return new DeliciousSubResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		int res = deliciousMapSubDao.updateFoodName(oldName, newName);
		DeliciousMapSub newFoodName = new DeliciousMapSub();
		newFoodName = op.get();
		newFoodName.setFoodName(newName);

		if (res == 1) {
			return new DeliciousSubResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), newFoodName);
		} else {
			return new DeliciousSubResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
	}

	// э繺翴蝶基
	@Override
	public UpdateFoodReviewResponse updateFoodReview(String foodName, int newReview) {
		// ň
		if (!StringUtils.hasText(foodName)) {
			return new UpdateFoodReviewResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		if (newReview <= 0 || newReview > 5) {
			UpdateFoodReviewResponse meg = new UpdateFoodReviewResponse();
			meg.setCode("蝶基程ぶ1聋琍,程5聋琍计翴程");
			return new UpdateFoodReviewResponse(RtnCode.DATA_ERROR.getCode(), meg.getMessage());
		}
		int res = deliciousMapSubDao.updateFoodReview(foodName, newReview);
		if (res == 1) {
			// 眔坝┍计秖
			Optional<DeliciousMapSub> op = deliciousMapSubDao.findById(foodName);
			if (op == null) {
				return new UpdateFoodReviewResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
			}
			DeliciousMapSub foodinfo = op.get();
			String storeName = foodinfo.getStoreName();
			List<DeliciousMapSub> storeNameList = deliciousMapSubDao.findByStoreName(storeName);
			storeNameList.size();
			// 穝繺翴蝶基
			foodinfo.setFoodReview(newReview);
			// 眔坝┍繺翴蝶基羆+繺芔蝶基
			int reviewSum = 0;
			for (DeliciousMapSub item : storeNameList) {
				int review = item.getFoodReview();
				reviewSum = review + reviewSum;
			}
			float floatReviewSum = (float) reviewSum;
			float floatStoreNameList = (float) storeNameList.size();
			float storeReview = floatReviewSum / floatStoreNameList;
			double floorStoreReview = Math.floor(storeReview*10)/10;
			// 盢繺芔蝶基穝
			Optional<DeliciousMapMain> container = deliciousMapMainDao.findById(storeName);
			DeliciousMapMain storeinfo = container.get();
			storeinfo.setStoreReview(floorStoreReview);
			deliciousMapMainDao.save(storeinfo);
			
			// 穝繺芔㎝繺翴蝶基
			return new UpdateFoodReviewResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
					storeinfo, foodinfo);
		} else {
			return new UpdateFoodReviewResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
	}

}
