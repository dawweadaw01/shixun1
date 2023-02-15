package com.lhj.shixun1.common.service;

import com.lhj.shixun1.common.vo.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * image service
 */
public interface ImageService {
    Result<String> uploadImage(MultipartFile mf, String imageTypeName);
}
