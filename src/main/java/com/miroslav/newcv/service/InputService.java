package com.miroslav.newcv.service;

import com.miroslav.newcv.model.InputModel;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface InputService {

    public void savingCV(InputModel inputModel, MultipartFile[] images, MultipartFile[] pdfs1, MultipartFile[] pdfs2, MultipartFile[] pdfs3, MultipartFile[] pdfs4);

    public void updateCV(InputModel inputModel, MultipartFile[] images, MultipartFile[] pdfs1, MultipartFile[] pdfs2, MultipartFile[] pdfs3, MultipartFile[] pdfs4);

    public InputModel getInputModel(Integer cvID);

    public List<InputModel> allCVs();

    public void deleteCV(InputModel inputModel);

}
