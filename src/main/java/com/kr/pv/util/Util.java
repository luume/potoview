package com.kr.pv.util;

import java.io.File;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class Util {
	// 파일명 랜덤생성 메서드
    public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
        // uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
        UUID uuid = UUID.randomUUID();
        // 랜덤생성+파일이름 저장
        String savedName = uuid.toString()+"_"+originalName;
        File file = new File(uploadPath);
        if (!file.exists()) // 폴더 없으면 생성
        	file.mkdirs();
        
        File target = new File(uploadPath, savedName);
        
        // 임시디렉토리에 저장된 업로드된 파일을 지정된 디렉토리로 복사
        // FileCopyUtils.copy(바이트배열, 파일객체)
        FileCopyUtils.copy(fileData, target);
        return savedName;
    }
}
