package com.lhj.shixun1.common.service.Impl;

import com.lhj.shixun1.common.service.ImageService;
import com.lhj.shixun1.common.vo.ImageType;
import com.lhj.shixun1.common.vo.Result;
import com.lhj.shixun1.config.ResourceBean;
import com.lhj.shixun1.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    @Resource
    private ResourceBean resourceBean;

    @Override
    public Result<String> uploadImage(MultipartFile mf, String imageTypeName) {
        if (mf.isEmpty()) {
            return Result.failed("图片为空");
        }

        //  判断图片是否合法
        if (!FileUtil.isImage(mf)) {
            return Result.failed("请上传图片。");
        }

        //获取图片类型
        ImageType it = ImageType.getImageTypeByName(imageTypeName);
        if (it == null) {
            return Result.failed("图片类型不存在");
        }

        //TODO: 限制图片大小

        //获取文件夹
        String os = System.getProperty("os.name");
        String destFolder = String.format("%s%s",
                os.toLowerCase().startsWith("win") ? resourceBean.
                        getWindowLocation() : resourceBean.getLinuxLocation(),
                it.name);
        File distFolderFile = new File(destFolder);
        if (!distFolderFile.exists()) {
            distFolderFile.mkdirs();
        }

        //获取文件名
        String fileName = String.format("%s.%s", System.currentTimeMillis(),
                FileUtil.getFileType(mf.getOriginalFilename()));

        //文件写入路径
        String destFile = String.format("%s/%s", destFolder, fileName);
        File df = new File(destFile);

        //获取文件访问路径
        String relatedPath = String.format("%s%s/%s",
                resourceBean.getPath(),
                it.name, fileName);

        //写文件
        try {
            mf.transferTo(df);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.ok(relatedPath);
    }
}
