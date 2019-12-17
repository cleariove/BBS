package cn.edu.ncu.bbs.until;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil
{
    public static String uploadFile(MultipartFile file,String newName)
    {
        if(!file.isEmpty())
        {
            try
            {
                byte[] bytes = file.getBytes();
                String oldName = file.getOriginalFilename();
                int index = 0;
                String suffix = null;
                if (oldName != null)
                {
                    index = oldName.lastIndexOf('.');
                    suffix = oldName.substring(index);
                }
                Path path = Paths.get("src/main/resources/static/upload/"+newName+suffix);
                Files.write(path, bytes);
                return "../static/upload/"+newName+suffix;
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static BufferedImage changeFileToBufferedImage(MultipartFile file)
    {
        BufferedImage bufferedImage = null;
        try
        {
            FileInputStream in = (FileInputStream) file.getInputStream();
            bufferedImage = ImageIO.read(in);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    public static String ChangeToBase64(MultipartFile file)
    {
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        BufferedImage img = FileUtil.changeFileToBufferedImage(file);
        String oldName = file.getOriginalFilename();
        int index = 0;
        String suffix = null;
        if (oldName != null)
        {
            index = oldName.lastIndexOf('.');
            suffix = oldName.substring(index+1);
        }
        try
        {
            if (suffix != null)
            {
                System.out.println(suffix);
                ImageIO.write(img,suffix,bAOS);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        byte[] bytes = bAOS.toByteArray();//转换成字节
        BASE64Encoder encoder = new BASE64Encoder();
        String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
        return png_base64;
    }
}
