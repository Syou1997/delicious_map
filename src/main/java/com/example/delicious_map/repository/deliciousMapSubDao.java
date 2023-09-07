package com.example.delicious_map.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.delicious_map.entity.DeliciousMapSub;

@Repository
public interface DeliciousMapSubDao extends JpaRepository<DeliciousMapSub, String> {
	// JPA�ۭq��k
	// �u���o�S�w���a�����\�I
	public List<DeliciousMapSub> findByStoreName(String storeName);

	// JPQL
	// �ק��\�I�W��
	@Modifying
	@Transactional
	@Query(value = "update delicious_map_sub set food_name = :NewFoodName where food_name = :OldFoodName ", nativeQuery = true)
	public int updateFoodName(@Param("OldFoodName") String oldFoodName, @Param("NewFoodName") String foodNewName);

	// �ק��\�I����
	@Modifying
	@Transactional
	@Query(value = "update delicious_map_sub set food_review = :NewReview where food_name = :FoodName", nativeQuery = true)
	public int updateFoodReview(@Param("FoodName") String foodName, @Param("NewReview") int newReview);

}
