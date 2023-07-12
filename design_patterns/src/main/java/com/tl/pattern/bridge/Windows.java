package com.tl.pattern.bridge;

/**
 * 扩展抽象化角色（window操作系统）
 */
public class Windows extends OpratingSystem {

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
