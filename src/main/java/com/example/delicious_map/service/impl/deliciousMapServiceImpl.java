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

	// �s�W�ө�
	@Override
	public DeliciousMapResponse addStore(DeliciousMapMain info) {
		// ���b
		if (info == null) {
			return new DeliciousMapResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		if (!StringUtils.hasText(info.getStoreName()) || !StringUtils.hasText(info.getStoreCity())) {

			return new DeliciousMapResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}

		DeliciousMapMain res = deliciousMapMainDao.save(info);

		return new DeliciousMapResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	// �s�W�\�I
	@Override
	public DeliciousSubResponse addFood(DeliciousMapSub info) {
		// ���b
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

	// �ק��\�I�W��
	@Override
	// ���b
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

	// �ק��\�I����
	@Override
	public UpdateFoodReviewResponse updateFoodReview(String foodName, int newReview) {
		// ���b
		if (!StringUtils.hasText(foodName)) {
			return new UpdateFoodReviewResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		if (newReview <= 0 || newReview > 5) {
			UpdateFoodReviewResponse meg = new UpdateFoodReviewResponse();
			meg.setCode("�����̤�1���P,�̦h5���P�A�p���I�̦h�@��");
			return new UpdateFoodReviewResponse(RtnCode.DATA_ERROR.getCode(), meg.getMessage());
		}
		int res = deliciousMapSubDao.updateFoodReview(foodName, newReview);
		if (res == 1) {
			// ���o�ө����ƶq
			Optional<DeliciousMapSub> op = deliciousMapSubDao.findById(foodName);
			if (op == null) {
				return new UpdateFoodReviewResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
			}
			DeliciousMapSub foodinfo = op.get();
			String storeName = foodinfo.getStoreName();
			List<DeliciousMapSub> storeNameList = deliciousMapSubDao.findByStoreName(storeName);
			storeNameList.size();
			// ��s�\�I����
			foodinfo.setFoodReview(newReview);
			// ���o�ө��\�I�������[�`+�\�U����
			int reviewSum = 0;
			for (DeliciousMapSub item : storeNameList) {
				int review = item.getFoodReview();
				reviewSum = review + reviewSum;
			}
			float floatReviewSum = (float) reviewSum;
			float floatStoreNameList = (float) storeNameList.size();
			float storeReview = floatReviewSum / floatStoreNameList;
			double floorStoreReview = Math.floor(storeReview*10)/10;
			// �N�\�U������s
			Optional<DeliciousMapMain> container = deliciousMapMainDao.findById(storeName);
			DeliciousMapMain storeinfo = container.get();
			storeinfo.setStoreReview(floorStoreReview);
			deliciousMapMainDao.save(storeinfo);
			
			// �L�X��s�᪺�\�U�M�\�I����
			return new UpdateFoodReviewResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
					storeinfo, foodinfo);
		} else {
			return new UpdateFoodReviewResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
	}

}
