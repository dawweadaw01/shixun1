package com.lhj.shixun1.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *ImageType
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ImageType {
    PROFILE("profile", 300, 300, 1024),
    TEST("test", 300, 300, 1024)

    ;
    public String name;
    public int width;
    public int height;
    public int size;

    ImageType(String name, int width, int height, int size) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.size = size;
    }
}