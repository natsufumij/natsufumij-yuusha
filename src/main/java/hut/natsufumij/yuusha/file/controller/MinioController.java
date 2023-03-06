package hut.natsufumij.yuusha.file.controller;

import hut.natsufumij.yuusha.file.service.MinioService;
import hut.natsufumij.yuusha.util.resp.RV;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class MinioController {

    private final MinioService minioService;

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public void fileupload(@RequestParam MultipartFile uploadfile, @RequestParam String bucket,
                               @RequestParam(required=false) String objectName) throws Exception {
        minioService.createBucket(bucket);
        if (objectName != null) {
            minioService.uploadFile(uploadfile.getInputStream(), bucket, objectName);
        } else {
            minioService.uploadFile(uploadfile.getInputStream(), bucket, uploadfile.getOriginalFilename());
        }
    }

    @RequestMapping(value = "/listBuckets", method = RequestMethod.GET)
    public RV<String> listBuckets() throws Exception {
        return RV.of(minioService.listBuckets());
    }

    @RequestMapping(value = "/listFiles", method = RequestMethod.GET)
    public RV<MinioService.Fileinfo> listFiles(@RequestParam String bucket) throws Exception {
        return RV.of(minioService.listFiles(bucket));
    }

    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    public void downloadFile(@RequestParam String bucket, @RequestParam String objectName,
                             HttpServletResponse response) throws Exception {
        InputStream stream = minioService.download(bucket, objectName);
        ServletOutputStream output = response.getOutputStream();
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(objectName.substring(objectName.lastIndexOf("/") + 1), "UTF-8"));
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
