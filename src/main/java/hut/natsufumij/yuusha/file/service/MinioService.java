package hut.natsufumij.yuusha.file.service;

import lombok.Data;

import java.io.InputStream;
import java.util.List;

public interface MinioService {

    /**
     * 创建一个桶
     */
    void createBucket(String bucket) throws Exception;

    /**
     * 上传一个文件
     */
    void uploadFile(InputStream stream, String bucket, String objectName) throws Exception;

    /**
     * 列出所有的桶
     */
    List<String> listBuckets() throws Exception;

    /**
     * 列出一个桶中的所有文件和目录
     */
    List<Fileinfo> listFiles(String bucket) throws Exception;

    /**
     * 下载一个文件
     */
    InputStream download(String bucket, String objectName) throws Exception;

    /**
     * 删除一个桶
     */
    void deleteBucket(String bucket) throws Exception;

    /**
     * 删除一个对象
     */
    void deleteObject(String bucket, String objectName) throws Exception;
    @Data
    class Fileinfo{
        private String filename;
        private boolean directory;
    }
}
