package photoBalans.controllers;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import photoBalans.models.DataPhoto;
import photoBalans.service.BeeService;
import photoBalans.service.ValuesPhotoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/valuesPhoto")
public class ValuesPhotoController {
    private ValuesPhotoService valuesPhotoService;
    private BeeService beeService;

    @Autowired
    public ValuesPhotoController(ValuesPhotoService valuesPhotoService, BeeService beeService) {
        this.valuesPhotoService = valuesPhotoService;
        this.beeService = beeService;
    }

    @GetMapping()
    public String valuesPhoto(@RequestParam("selectFind") String selectFind,
                              @RequestParam("find") String find, Model model) {
        model.addAttribute("beeFList", beeService.findDeviceBeef(selectFind, find.trim()));
        model.addAttribute("dataPhotoList", beeService.findDeviceDataPhoto(selectFind, find.trim()));
        return "redidect:/find";
    }

    @PostMapping(value = "/saveValues")
    public String savePhoto(@ModelAttribute DataPhoto dataPhoto,
                            @RequestParam("photoValues") MultipartFile file){

        valuesPhotoService.saveDataPhoto(dataPhoto, file);
        return "redirect:/";
    }

    @GetMapping(value = "/download/{nameFile:.+}")
    public void downloadFile(@PathVariable String nameFile, HttpServletResponse response) {
        InputStream inputStream = valuesPhotoService.downloadFile(nameFile);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", FilenameUtils.getExtension(nameFile) +  ";filename=\"" + nameFile +"\"");
        try {
            response.setContentLength(inputStream.available());
            FileCopyUtils.copy(inputStream,response.getOutputStream());
            inputStream.close();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
