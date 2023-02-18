package com.lhj.shixun1.common.service.Impl;

import com.lhj.shixun1.common.service.ImageService;
import com.lhj.shixun1.common.vo.ImageType;
import com.lhj.shixun1.common.vo.Result;
import com.lhj.shixun1.config.ResourceBean;
import com.lhj.shixun1.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    @Resource
    private ResourceBean resourceBean;

    @Override
    public Result<String> uploadImage(MultipartFile mf, String imageTypeName) throws FileNotFoundException {
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

        String path1 = ResourceUtils.getURL("classpath:").getPath()+"static/"+it.name;
        String realPath = path1.replace('/', '\\').substring(1,path1.length());
        //用于查看路径是否正确
        System.out.println(realPath);
        File distFolderFile = new File(destFolder);
        //String path = "./src/main/resources/static/"+it.name;
        //String path = "classpath:static/"+it.name;
        //String pathFile = new File(path).getAbsolutePath();
        File pathFile1 = new File(realPath);
        if (!pathFile1.exists()) {
            pathFile1.mkdirs();
        }

        //获取文件名
        String fileName = String.format("%s.%s", System.currentTimeMillis(),
                FileUtil.getFileType(mf.getOriginalFilename()));

        //文件写入路径
        String transferPath = realPath+"/"+fileName;

//        //文件写入路径
//        String destFile = String.format("%s/%s", destFolder, fileName);
//        File df = new File(destFile);

        //获取文件访问路径
        String relatedPath = String.format("/%s/%s", it.name, fileName);
        //写文件
        try {
            mf.transferTo(new File(transferPath));
        } catch (IOException e) {
            System.out.println("文件写入失败");
            throw new RuntimeException(e);
        }
        return Result.ok(relatedPath);
    }
}
