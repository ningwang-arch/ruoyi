package com.ruoyi.flowable.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.Base64;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Component
public class OssUtils {
    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.bucketName}")
    private String bucketName;

    @Value("${oss.endPoint}")
    private String endPoint;

    public String upload(String objectName, String content) {
        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName,
                    new ByteArrayInputStream(content.getBytes()));
            ossClient.putObject(putObjectRequest);
            return "https://" + bucketName + "." + endPoint + "/" + objectName;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return null;
    }

    public String uploadBase64(String name, String base64) {
        if (base64 == null || base64.isEmpty()) {
            return "";
        }
        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
        try {
            byte[] decode = Base64.getDecoder().decode(base64);

            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, name,
                    new ByteArrayInputStream(decode));
            ossClient.putObject(putObjectRequest);
            return "https://" + bucketName + "." + endPoint + "/" + name + "?x-oss-process=image/resize,w_250,h_200";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return "";
    }

}
