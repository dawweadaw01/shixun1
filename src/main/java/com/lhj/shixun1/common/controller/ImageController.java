package com.lhj.shixun1.common.controller;

import com.lhj.shixun1.common.service.ImageService;
import com.lhj.shixun1.common.vo.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/common")
public class ImageController {
    @Resource
    private ImageService imageService;

    /**
     * 127.0.0.1/api/common/image/PROFILE  --- post
     *
     */
    @PostMapping(value = "/image/{imageTypeName}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadImage(@RequestParam MultipartFile mf,
                                      @PathVariable String imageTypeName) {
        return imageService.uploadImage(mf, imageTypeName);
    }
}
