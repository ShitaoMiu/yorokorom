package com.service.com.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.com.repository.MainRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MainService {
	private final MainRepository mainRepository;

	public void insertCommon() {
		
	}

}
