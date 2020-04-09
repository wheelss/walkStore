package com.xzsd.pc.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.region.Region;

import java.io.File;

public class Download {
    public static void main(String[] args) {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKID0oMckcKXbOwGLBu36tPffz2oSt4DEXIn","MUMxIM9fwPbXBYe8TSAbojOBdpkmYAYg");
        // 2 设置bucket的区域, COS地域的简称请参照
        // https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket名需包含appid
        String bucketName = "demo-1301715174";
// 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = "1.png";
        File downFile = new File("src/main/resources/2.png");
        // 指定要下载的文件所在的 bucket 和对象键
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        try {
            ObjectMetadata downObjectMeta = cosclient.getObject(getObjectRequest, downFile);
            // putobjectResult会返回etag
            String etag = downObjectMeta.getETag();
            System.out.println(etag);
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        // 关闭客户端
        cosclient.shutdown();
    }
}