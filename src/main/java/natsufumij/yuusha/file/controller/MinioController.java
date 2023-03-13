package natsufumij.yuusha.file.controller;

import hut.natsufumij.common.resp.V;
import hut.natsufumij.yuusha.file.service.MinioService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class MinioController {

    private final MinioService minioService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public V<String> fileUpload(@RequestParam MultipartFile uploadFile, @RequestParam String bucket) throws Exception {
        minioService.createBucket(bucket);
        int index = Objects.requireNonNull(uploadFile.getOriginalFilename()).lastIndexOf(".");
        String fmt = uploadFile.getOriginalFilename().substring(index);
        String uuid = UUID.randomUUID().toString();
        String fName = uuid + fmt;
        minioService.uploadFile(uploadFile.getInputStream(), bucket, fName);
        return V.yes(fName);
    }

    @RequestMapping(value = "/listBuckets", method = RequestMethod.GET)
    public V<String> listBuckets() throws Exception {
        return V.yes(minioService.listBuckets());
    }

    @RequestMapping(value = "/listFiles", method = RequestMethod.GET)
    public V<MinioService.Fileinfo> listFiles(@RequestParam String bucket) throws Exception {
        return V.yes(minioService.listFiles(bucket));
    }

    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    public void downloadFile(@RequestParam String bucket, @RequestParam String objectName,
                             @RequestParam String fileName,
                             HttpServletResponse response) throws Exception {
        InputStream stream = minioService.download(bucket, objectName);
        ServletOutputStream output = response.getOutputStream();
        String fmt=objectName.substring(objectName.lastIndexOf("."));
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(fileName+fmt, StandardCharsets.UTF_8));
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        IOUtils.copy(stream, output);
    }

    @RequestMapping(value = "/deleteFile", method = RequestMethod.GET)
    public void deleteFile(@RequestParam String bucket, @RequestParam String objectName) throws Exception {
        minioService.deleteObject(bucket, objectName);
    }

    @RequestMapping(value = "/deleteBucket", method = RequestMethod.GET)
    public void deleteBucket(@RequestParam String bucket) throws Exception {
        minioService.deleteBucket(bucket);
    }
}
