package cn.edu.ncu.bbs.until;

import org.springframework.web.multipart.MultipartFile;

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
}
