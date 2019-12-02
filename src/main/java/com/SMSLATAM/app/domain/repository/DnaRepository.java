package com.SMSLATAM.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.SMSLATAM.app.domain.service.AdnApi;

public interface DnaRepository extends JpaRepository<AdnApi, Long>, JpaSpecificationExecutor<AdnApi>,
		PagingAndSortingRepository<AdnApi, Long> {

}
