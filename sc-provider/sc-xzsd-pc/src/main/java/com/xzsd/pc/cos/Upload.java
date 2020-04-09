package com.xzsd.pc.cos;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.net.URL;
import java.util.Date;

public class Upload {
    public static void main(String[] args) {
        // 1 初始化用户身份信息API密钥(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKID0oMckcKXbOwGLBu36tPffz2oSt4DEXIn", "MUMxIM9fwPbXBYe8TSAbojOBdpkmYAYg");
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // 存储桶bucket名需包含appid
        String bucketName = "demo-1301715174";
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = "2.png";
        File localFile = new File("src/main/resources/picture/2.png");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        try {
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
            Date date = new Date();
            Date expiration = new Date( date.getTime() + 5 * 60 * 10000);
            URL url = cosclient.generatePresignedUrl(bucketName, key, expiration);
            System.out.println("图片在COS服务器上的url:"+url);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();

        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        // 关闭客户端
        cosclient.shutdown();
    }

}
