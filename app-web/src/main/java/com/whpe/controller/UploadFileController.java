package com.whpe.controller;

import com.whpe.bean.Result;
import com.whpe.utils.Person;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/2/17.
 */
@Controller
public class UploadFileController extends CommonController{

    @RequestMapping(value = "/fileupload/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uploadFile(MultipartFile file) throws IOException {
        String webroot = System.getProperty("webapp.root");
        String randomFileName = UUID.randomUUID().toString();
        FileCopyUtils.copy(file.getBytes(), new FileOutputStream(webroot + "/imgs/" + randomFileName));
        Map<String, String> result = new HashMap<String, String>();
        result.put("fileName", randomFileName);

        return result;
    }

    @RequestMapping(value = "/fileupload/http", method = RequestMethod.POST)
    @ResponseBody
    public Result http(@RequestBody Person person){
        logger.info(person);
        return new Result(true, "请求成功！");
    }
}
