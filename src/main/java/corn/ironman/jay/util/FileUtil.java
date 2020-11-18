package corn.ironman.jay.util;


import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**工具类 上传文件**/
public class FileUtil {

    //限制头像大小最大为20M
    private static final int MAX_SIZE = 20971520;
    //项目下存储头像的目录,为便于引用需放在静态资源static目录下
    public static final String uploadPath = "/static/upload/friend_portrait/";
    //指定上传文件的类型
    private static final String[] suffixes = new String[]{".png", ".PNG", ".jpg", ".JPG", ".jpeg", ".JPEG",
            ".gif", ".GIF", ".bmp", ".BMP"};


    /**校验所上传图片的大小及格式等信息**/
    private static Map<String, Object> uploadPhoto(MultipartFile photo, String path) {
        //若存储文件的目录路径不存在,则创建该目录
        var filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        //限制上传文件的大小
        if (photo.getSize() > MAX_SIZE) {
            return ResultUtil.error("上传的图片大小不能超过20M哟!");
        }
        //限制上传的文件类型
        var suffixFileFilter = new SuffixFileFilter(suffixes);
        if (!suffixFileFilter.accept(new File(path + photo.getOriginalFilename()))) {
            return ResultUtil.error("禁止上传此类型文件! 请上传图片哟!");
        }
        return null;
    }


    /**校验所上传图片的大小及格式等信息**/
    public static Map<String, Object> getUploadResult(MultipartFile photo, String dirPath, String uploadPath) {

        if (!photo.isEmpty() && photo.getSize() > 0) {
            //效验图片大小及格式等信息
            var error_result = uploadPhoto(photo, dirPath);
            if (error_result != null) {
                return error_result;
            }
            //使用UUID重命名图片名称:uuid__原始图片名称
            var newPhotoName = UUID.randomUUID() + "__" + photo.getOriginalFilename();
            //将上传的图片保存到目标目录下
            try {
                photo.transferTo(new File(dirPath + newPhotoName));
                //将存储头像的目录路径返回给页面
                return ResultUtil.successWithPath(uploadPath + newPhotoName);
            } catch (IOException e) {
                e.printStackTrace();
                return ResultUtil.error("上传文件失败! 服务器端发生异常!");
            }

        } else {
            return ResultUtil.error("头像上传失败! 未找到指定图片!");
        }
    }
}
