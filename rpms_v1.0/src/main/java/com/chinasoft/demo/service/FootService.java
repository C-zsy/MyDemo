package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.FootMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootService {
    @Autowired
    private FootMapper footMapper;
}
