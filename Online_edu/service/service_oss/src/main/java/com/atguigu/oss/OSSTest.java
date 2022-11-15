package com.atguigu.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import org.junit.Test;

public class OSSTest {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint = "oss-cn-hangzhou.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问

    String accessKeyId = "LTAI5tG9kuNgvhgmwUM1Ac2n";
    String accessKeySecret = "6bytO9P0IpgMJCe39czSUEs0OUtkYD";
    String bucketName = "online-edu-1010";

    @Test
    public void testCreateBucket() {
         // 创建OSSClient实例。
         OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

         // 创建存储空间。
         ossClient.createBucket(bucketName);

         // 关闭OSSClient。
         ossClient.shutdown();
     }
     @Test
    public void testExist() {
         // 创建OSSClient实例。
         OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
         boolean exists = ossClient.doesBucketExist(bucketName);
         System.out.println(exists);

         // 关闭OSSClient。
         ossClient.shutdown();

     }
     @Test
    public void testAccessControl() {

       // 创建OSSClient实例。
       OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

       // 设置存储空间的访问权限为：公共读。
       ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);

        // 关闭OSSClient。
        ossClient.shutdown();
        }

}
