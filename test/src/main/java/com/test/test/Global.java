package com.test.test;

import javax.swing.filechooser.FileSystemView;

public class Global {
    // 사진을 저장할 때 프로젝트 내부에 저장하면, 프로젝트가 무거워지는 단점이 존재하기에
    // 외부에 따로 파일을 만들어서 관리한다.
    // C:\Users\jinw8\Desktop/single
    public static String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
    public static String basePath = rootPath + "/" + "upload_files_with_server/springboot/";
}
