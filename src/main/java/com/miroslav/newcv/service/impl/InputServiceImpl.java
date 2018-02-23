package com.miroslav.newcv.service.impl;

import com.miroslav.newcv.dao.InputDAO;
import com.miroslav.newcv.domain.Input;
import com.miroslav.newcv.model.InputModel;
import com.miroslav.newcv.service.InputService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import org.apache.commons.lang3.RandomStringUtils;

@Service
public class InputServiceImpl implements InputService {

    @Autowired
    private InputDAO inputDAO;

    @Autowired
    private ServletContext context;

    @Override
    public void savingCV(InputModel inputModel, MultipartFile[] images, MultipartFile[] pdfs1, MultipartFile[] pdfs2, MultipartFile[] pdfs3, MultipartFile[] pdfs4) {

        Input input = new Input();

        input.setCvName(inputModel.getCvName());
        input.setName(inputModel.getName());
        input.setImage(inputModel.getImage());
        input.setDateOfBirth(inputModel.getDateOfBirth());
        input.setPlaceOfBirth(inputModel.getPlaceOfBirth());
        input.setCitizenship(inputModel.getCitizenship());
        input.setEmail(inputModel.getEmail());
        input.setPhoneNumber(inputModel.getPhoneNumber());
        input.setAdress(inputModel.getAdress());
        input.setCity(inputModel.getCity());
        input.setLanguage1(inputModel.getLanguage1());
        input.setLanguage2(inputModel.getLanguage2());
        input.setLanguage3(inputModel.getLanguage3());
        input.setLanguage4(inputModel.getLanguage4());
        input.setLanguageLevel1(inputModel.getLanguageLevel1());
        input.setLanguageLevel2(inputModel.getLanguageLevel2());
        input.setLanguageLevel3(inputModel.getLanguageLevel3());
        input.setLanguageLevel4(inputModel.getLanguageLevel4());
        input.setSomethingAboutMe(inputModel.getSomethingAboutMe());
        input.setFirstDayJob1(inputModel.getFirstDayJob1());
        input.setFirstDayJob2(inputModel.getFirstDayJob2());
        input.setFirstDayJob3(inputModel.getFirstDayJob3());
        input.setFirstDayJob4(inputModel.getFirstDayJob4());
        input.setLastDayJob1(inputModel.getLastDayJob1());
        input.setLastDayJob2(inputModel.getLastDayJob2());
        input.setLastDayJob3(inputModel.getLastDayJob3());
        input.setLastDayJob4(inputModel.getLastDayJob4());
        input.setWorkExperience1(inputModel.getWorkExperience1());
        input.setWorkExperience2(inputModel.getWorkExperience2());
        input.setWorkExperience3(inputModel.getWorkExperience3());
        input.setWorkExperience4(inputModel.getWorkExperience4());
        input.setFirstDaySchool1(inputModel.getFirstDaySchool1());
        input.setFirstDaySchool2(inputModel.getFirstDaySchool2());
        input.setFirstDaySchool3(inputModel.getFirstDaySchool3());
        input.setFirstDaySchool4(inputModel.getFirstDaySchool4());
        input.setLastDaySchool1(inputModel.getLastDaySchool1());
        input.setLastDaySchool2(inputModel.getLastDaySchool2());
        input.setLastDaySchool3(inputModel.getLastDaySchool3());
        input.setLastDaySchool4(inputModel.getLastDaySchool4());
        input.setEducation1(inputModel.getEducation1());
        input.setEducation2(inputModel.getEducation2());
        input.setEducation3(inputModel.getEducation3());
        input.setEducation4(inputModel.getEducation4());
        input.setPdf1(inputModel.getPdf1());
        input.setPdf2(inputModel.getPdf2());
        input.setPdf3(inputModel.getPdf3());
        input.setPdf4(inputModel.getPdf4());
        input.setCourses1(inputModel.getCourses1());
        input.setCourses2(inputModel.getCourses2());
        input.setCourses3(inputModel.getCourses3());
        input.setCourses4(inputModel.getCourses4());
        input.setSkill1(inputModel.getSkill1());
        input.setSkill2(inputModel.getSkill2());
        input.setSkill3(inputModel.getSkill3());
        input.setSkill4(inputModel.getSkill4());
        input.setSkill5(inputModel.getSkill5());
        input.setSkill6(inputModel.getSkill6());
        input.setSkill7(inputModel.getSkill7());
        input.setSkill8(inputModel.getSkill8());
        input.setSkill9(inputModel.getSkill9());

        MultipartFile image = images[0];

        if (!image.isEmpty()) {
            try {

                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\imagess";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = image.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                    String imageName = generateUniqueFileName() + "." + extension;
                    String filename = filepath + "\\" + imageName;
                    fos = new FileOutputStream(filename);
                    fos.write(image.getBytes());
                    fos.close();
                    System.out.println(imageName);
                    System.out.println(filename);
                    input.setImage(imageName);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        MultipartFile pdf1 = pdfs1[0];
        if (!pdf1.isEmpty()) {
            try {
                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = pdf1.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("pdf") || extension.equals("jpg")) {
                    String pdf1Name = pdf1.getOriginalFilename();
                    String filename = filepath + "\\" + pdf1Name;
                    fos = new FileOutputStream(filename);
                    fos.write(pdf1.getBytes());
                    fos.close();
                    System.out.println(pdf1Name);
                    System.out.println(filename);
                    input.setPdf1(pdf1Name);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        MultipartFile pdf2 = pdfs2[0];
        if (!pdf2.isEmpty()) {
            try {
                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = pdf2.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("pdf") || extension.equals("jpg")) {
                    String pdf2Name = pdf2.getOriginalFilename();
                    String filename = filepath + "\\" + pdf2Name;
                    fos = new FileOutputStream(filename);
                    fos.write(pdf2.getBytes());
                    fos.close();
                    System.out.println(pdf2Name);
                    System.out.println(filename);
                    input.setPdf2(pdf2Name);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        MultipartFile pdf3 = pdfs3[0];
        if (!pdf3.isEmpty()) {
            try {
                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = pdf3.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("pdf") || extension.equals("jpg")) {
                    String pdf3Name = pdf3.getOriginalFilename();
                    String filename = filepath + "\\" + pdf3Name;
                    fos = new FileOutputStream(filename);
                    fos.write(pdf3.getBytes());
                    fos.close();
                    System.out.println(pdf3Name);
                    System.out.println(filename);
                    input.setPdf3(pdf3Name);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        MultipartFile pdf4 = pdfs4[0];
        if (!pdf4.isEmpty()) {
            try {
                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = pdf4.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("pdf") || extension.equals("jpg")) {
                    String pdf4Name = pdf4.getOriginalFilename();
                    String filename = filepath + "\\" + pdf4Name;
                    fos = new FileOutputStream(filename);
                    fos.write(pdf4.getBytes());
                    fos.close();
                    System.out.println(pdf4Name);
                    System.out.println(filename);
                    input.setPdf4(pdf4Name);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        getInputDAO().savingCV(input);
    }

    @Override
    public void updateCV(InputModel inputModel, MultipartFile[] images, MultipartFile[] pdfs1, MultipartFile[] pdfs2, MultipartFile[] pdfs3, MultipartFile[] pdfs4) {

        Input input = new Input();

        input.setCvName(inputModel.getCvName());
        input.setCvID(inputModel.getCvID());
        input.setName(inputModel.getName());
        //input.setImage(inputModel.getImage());
        input.setDateOfBirth(inputModel.getDateOfBirth());
        input.setPlaceOfBirth(inputModel.getPlaceOfBirth());
        input.setCitizenship(inputModel.getCitizenship());
        input.setEmail(inputModel.getEmail());
        input.setPhoneNumber(inputModel.getPhoneNumber());
        input.setAdress(inputModel.getAdress());
        input.setCity(inputModel.getCity());
        input.setLanguage1(inputModel.getLanguage1());
        input.setLanguage2(inputModel.getLanguage2());
        input.setLanguage3(inputModel.getLanguage3());
        input.setLanguage4(inputModel.getLanguage4());
        input.setLanguageLevel1(inputModel.getLanguageLevel1());
        input.setLanguageLevel2(inputModel.getLanguageLevel2());
        input.setLanguageLevel3(inputModel.getLanguageLevel3());
        input.setLanguageLevel4(inputModel.getLanguageLevel4());
        input.setSomethingAboutMe(inputModel.getSomethingAboutMe());
        input.setFirstDayJob1(inputModel.getFirstDayJob1());
        input.setFirstDayJob2(inputModel.getFirstDayJob2());
        input.setFirstDayJob3(inputModel.getFirstDayJob3());
        input.setFirstDayJob4(inputModel.getFirstDayJob4());
        input.setLastDayJob1(inputModel.getLastDayJob1());
        input.setLastDayJob2(inputModel.getLastDayJob2());
        input.setLastDayJob3(inputModel.getLastDayJob3());
        input.setLastDayJob4(inputModel.getLastDayJob4());
        input.setWorkExperience1(inputModel.getWorkExperience1());
        input.setWorkExperience2(inputModel.getWorkExperience2());
        input.setWorkExperience3(inputModel.getWorkExperience3());
        input.setWorkExperience4(inputModel.getWorkExperience4());
        input.setFirstDaySchool1(inputModel.getFirstDaySchool1());
        input.setFirstDaySchool2(inputModel.getFirstDaySchool2());
        input.setFirstDaySchool3(inputModel.getFirstDaySchool3());
        input.setFirstDaySchool4(inputModel.getFirstDaySchool4());
        input.setLastDaySchool1(inputModel.getLastDaySchool1());
        input.setLastDaySchool2(inputModel.getLastDaySchool2());
        input.setLastDaySchool3(inputModel.getLastDaySchool3());
        input.setLastDaySchool4(inputModel.getLastDaySchool4());
        input.setEducation1(inputModel.getEducation1());
        input.setEducation2(inputModel.getEducation2());
        input.setEducation3(inputModel.getEducation3());
        input.setEducation4(inputModel.getEducation4());
        input.setPdf1(inputModel.getPdf1());
        input.setPdf2(inputModel.getPdf2());
        input.setPdf3(inputModel.getPdf3());
        input.setPdf4(inputModel.getPdf4());
        input.setCourses1(inputModel.getCourses1());
        input.setCourses2(inputModel.getCourses2());
        input.setCourses3(inputModel.getCourses3());
        input.setCourses4(inputModel.getCourses4());
        input.setSkill1(inputModel.getSkill1());
        input.setSkill2(inputModel.getSkill2());
        input.setSkill3(inputModel.getSkill3());
        input.setSkill4(inputModel.getSkill4());
        input.setSkill5(inputModel.getSkill5());
        input.setSkill6(inputModel.getSkill6());
        input.setSkill7(inputModel.getSkill7());
        input.setSkill8(inputModel.getSkill8());
        input.setSkill9(inputModel.getSkill9());

        MultipartFile image = images[0];
        Input input2 = inputDAO.getCVId(input.getCvID());
        if (input2.getImage() == null) {
            try {
                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\imagess";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = image.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                    String imageName = generateUniqueFileName() + "." + extension;
                    String filename = filepath + "\\" + imageName;
                    fos = new FileOutputStream(filename);
                    fos.write(image.getBytes());
                    fos.close();
                    System.out.println(imageName);
                    System.out.println(filename);
                    input.setImage(imageName);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("!!!! USAO U ELSE !!!!");
            if (input2.getImage() == null) {
                System.out.println("Greska, nema slike da prosledim u bazu");
            } else if (inputModel.getImage() != input2.getImage()) {
                try {
                    String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\imagess";
                    System.out.println(filepath);
                    FileOutputStream fos;
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    String[] multipartParts = image.getOriginalFilename().split("\\.");
                    String extension = multipartParts[multipartParts.length - 1];
                    if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                        String imageName = generateUniqueFileName() + "." + extension;
                        String filename = filepath + "\\" + imageName;
                        fos = new FileOutputStream(filename);
                        fos.write(image.getBytes());
                        fos.close();
                        System.out.println(imageName);
                        System.out.println(filename);
                        input.setImage(imageName);
                    } else {
                        input.setImage(input2.getImage());
                        System.out.println("input2: " + input2.getImage());
                        System.out.println("input: " + input.getImage());
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                input.setImage(input2.getImage());
                System.out.println("input2: " + input2.getImage());
            }
        }

        MultipartFile pdf1 = pdfs1[0];
        Input input3 = inputDAO.getCVId(input.getCvID());
        if (input3.getPdf1() == null) {
            try {
                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = pdf1.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                    String pdf1Name = pdf1.getOriginalFilename();
                    String filename = filepath + "\\" + pdf1Name;
                    fos = new FileOutputStream(filename);
                    fos.write(pdf1.getBytes());
                    fos.close();
                    System.out.println(pdf1Name);
                    System.out.println(filename);
                    input.setPdf1(pdf1Name);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("!!!! USAO U ELSE !!!!");
            if (input3.getPdf1() == null) {
                System.out.println("Greska, nema slike da prosledim u bazu");
            } else if (inputModel.getPdf1() != input3.getPdf1()) {
                try {
                    String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                    System.out.println(filepath);
                    FileOutputStream fos;
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    String[] multipartParts = pdf1.getOriginalFilename().split("\\.");
                    String extension = multipartParts[multipartParts.length - 1];
                    if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                        String pdf1Name = pdf1.getOriginalFilename();
                        String filename = filepath + "\\" + pdf1Name;
                        fos = new FileOutputStream(filename);
                        fos.write(pdf1.getBytes());
                        fos.close();
                        System.out.println(pdf1Name);
                        System.out.println(filename);
                        input.setPdf1(pdf1Name);
                    } else {
                        input.setPdf1(input3.getPdf1());
                        System.out.println("input3: " + input3.getPdf1());
                        System.out.println("input: " + input.getPdf1());
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                input.setPdf1(input3.getPdf1());
                System.out.println("input3: " + input3.getPdf1());
            }
        }

        MultipartFile pdf2 = pdfs2[0];
        Input input4 = inputDAO.getCVId(input.getCvID());
        if (input4.getPdf2() == null) {
            try {
                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = pdf2.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                    String pdf2Name = pdf2.getOriginalFilename();
                    String filename = filepath + "\\" + pdf2Name;
                    fos = new FileOutputStream(filename);
                    fos.write(pdf2.getBytes());
                    fos.close();
                    System.out.println(pdf2Name);
                    System.out.println(filename);
                    input.setPdf2(pdf2Name);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("!!!! USAO U ELSE !!!!");
            if (input4.getPdf2() == null) {
                System.out.println("Greska, nema slike da prosledim u bazu");
            } else if (inputModel.getPdf2() != input4.getPdf2()) {

                try {
                    String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                    System.out.println(filepath);
                    FileOutputStream fos;
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    String[] multipartParts = pdf2.getOriginalFilename().split("\\.");
                    String extension = multipartParts[multipartParts.length - 1];
                    if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                        String pdf2Name = pdf2.getOriginalFilename();
                        String filename = filepath + "\\" + pdf2Name;
                        fos = new FileOutputStream(filename);
                        fos.write(pdf2.getBytes());
                        fos.close();
                        System.out.println(pdf2Name);
                        System.out.println(filename);
                        input.setPdf2(pdf2Name);
                    } else {
                        input.setPdf2(input4.getPdf2());
                        System.out.println("input4: " + input4.getPdf2());
                        System.out.println("input: " + input.getPdf2());
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                input.setPdf2(input4.getPdf2());
                System.out.println("input4: " + input4.getPdf2());
            }
        }

        MultipartFile pdf3 = pdfs3[0];
        Input input5 = inputDAO.getCVId(input.getCvID());
        if (input5.getPdf3() == null) {
            try {
                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = pdf3.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                    String pdf3Name = pdf3.getOriginalFilename();
                    String filename = filepath + "\\" + pdf3Name;
                    fos = new FileOutputStream(filename);
                    fos.write(pdf3.getBytes());
                    fos.close();
                    System.out.println(pdf3Name);
                    System.out.println(filename);
                    input.setPdf3(pdf3Name);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("!!!! USAO U ELSE !!!!");
            if (input5.getPdf3() == null) {
                System.out.println("Greska, nema slike da prosledim u bazu");
            } else if (inputModel.getPdf3() != input5.getPdf3()) {
                try {
                    String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                    System.out.println(filepath);
                    FileOutputStream fos;
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    String[] multipartParts = pdf3.getOriginalFilename().split("\\.");
                    String extension = multipartParts[multipartParts.length - 1];
                    if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                        String pdf3Name = pdf3.getOriginalFilename() /*generateUniqueFileName() + "." + extension*/;
                        String filename = filepath + "\\" + pdf3Name;
                        fos = new FileOutputStream(filename);
                        fos.write(pdf3.getBytes());
                        fos.close();
                        System.out.println(pdf3Name);
                        System.out.println(filename);
                        input.setPdf3(pdf3Name);
                    } else {
                        input.setPdf3(input5.getPdf3());
                        System.out.println("input5: " + input5.getPdf3());
                        System.out.println("input: " + input.getPdf3());
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                input.setPdf3(input5.getPdf3());
                System.out.println("input5: " + input5.getPdf3());
            }
        }

        MultipartFile pdf4 = pdfs4[0];
        Input input6 = inputDAO.getCVId(input.getCvID());

        if (input6.getPdf4() == null) {
            try {
                String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                System.out.println(filepath);
                FileOutputStream fos;
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                String[] multipartParts = pdf4.getOriginalFilename().split("\\.");
                String extension = multipartParts[multipartParts.length - 1];
                if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                    String pdf4Name = pdf4.getOriginalFilename();
                    String filename = filepath + "\\" + pdf4Name;
                    fos = new FileOutputStream(filename);
                    fos.write(pdf4.getBytes());
                    fos.close();
                    System.out.println(pdf4Name);
                    System.out.println(filename);
                    input.setPdf4(pdf4Name);
                } else {
                    System.out.println("nije dobra extenzija");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("!!!! USAO U ELSE !!!!");
            if (input6.getPdf4() == null) {
                System.out.println("Greska, nema slike da prosledim u bazu");
            } else if (inputModel.getPdf4() != input6.getPdf4()) {
                try {
                    String filepath = "C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\uploadedFiles";
                    System.out.println(filepath);
                    FileOutputStream fos;
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    String[] multipartParts = pdf4.getOriginalFilename().split("\\.");
                    String extension = multipartParts[multipartParts.length - 1];
                    if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("JPG") || extension.equals("bmp")) {
                        String pdf4Name = pdf4.getOriginalFilename();
                        String filename = filepath + "\\" + pdf4Name;
                        fos = new FileOutputStream(filename);
                        fos.write(pdf4.getBytes());
                        fos.close();
                        System.out.println(pdf4Name);
                        System.out.println(filename);
                        input.setPdf4(pdf4Name);
                    } else {
                        input.setPdf4(input6.getPdf4());
                        System.out.println("input6: " + input6.getPdf4());
                        System.out.println("input: " + input.getPdf4());
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(InputServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                input.setPdf4(input6.getPdf4());
                System.out.println("input6: " + input6.getPdf4());
            }
        }

        getInputDAO().updateCV(input);

    }

    @Override
    public InputModel getInputModel(Integer cvID) {

        InputModel inputModel = new InputModel();

        Input input = getInputDAO().getCVId(cvID);
        if (input == null) {
            return new InputModel();
        }

        inputModel.setCvID(input.getCvID());
        inputModel.setCvName(input.getCvName());
        inputModel.setName(input.getName());
        inputModel.setImage(input.getImage());
        inputModel.setDateOfBirth(input.getDateOfBirth());
        inputModel.setPlaceOfBirth(input.getPlaceOfBirth());
        inputModel.setCitizenship(input.getCitizenship());
        inputModel.setEmail(input.getEmail());
        inputModel.setPhoneNumber(input.getPhoneNumber());
        inputModel.setAdress(input.getAdress());
        inputModel.setCity(input.getCity());
        inputModel.setLanguage1(input.getLanguage1());
        inputModel.setLanguage2(input.getLanguage2());
        inputModel.setLanguage3(input.getLanguage3());
        inputModel.setLanguage4(input.getLanguage4());
        inputModel.setLanguageLevel1(input.getLanguageLevel1());
        inputModel.setLanguageLevel2(input.getLanguageLevel2());
        inputModel.setLanguageLevel3(input.getLanguageLevel3());
        inputModel.setLanguageLevel4(input.getLanguageLevel4());
        inputModel.setSomethingAboutMe(input.getSomethingAboutMe());
        inputModel.setFirstDayJob1(input.getFirstDayJob1());
        inputModel.setFirstDayJob2(input.getFirstDayJob2());
        inputModel.setFirstDayJob3(input.getFirstDayJob3());
        inputModel.setFirstDayJob4(input.getFirstDayJob4());
        inputModel.setLastDayJob1(input.getLastDayJob1());
        inputModel.setLastDayJob2(input.getLastDayJob2());
        inputModel.setLastDayJob3(input.getLastDayJob3());
        inputModel.setLastDayJob4(input.getLastDayJob4());
        inputModel.setWorkExperience1(input.getWorkExperience1());
        inputModel.setWorkExperience2(input.getWorkExperience2());
        inputModel.setWorkExperience3(input.getWorkExperience3());
        inputModel.setWorkExperience4(input.getWorkExperience4());
        inputModel.setFirstDaySchool1(input.getFirstDaySchool1());
        inputModel.setFirstDaySchool2(input.getFirstDaySchool2());
        inputModel.setFirstDaySchool3(input.getFirstDaySchool3());
        inputModel.setFirstDaySchool4(input.getFirstDaySchool4());
        inputModel.setLastDaySchool1(input.getLastDaySchool1());
        inputModel.setLastDaySchool2(input.getLastDaySchool2());
        inputModel.setLastDaySchool3(input.getLastDaySchool3());
        inputModel.setLastDaySchool4(input.getLastDaySchool4());
        inputModel.setEducation1(input.getEducation1());
        inputModel.setEducation2(input.getEducation2());
        inputModel.setEducation3(input.getEducation3());
        inputModel.setEducation4(input.getEducation4());
        inputModel.setPdf1(input.getPdf1());
        inputModel.setPdf2(input.getPdf2());
        inputModel.setPdf3(input.getPdf3());
        inputModel.setPdf4(input.getPdf4());
        inputModel.setCourses1(input.getCourses1());
        inputModel.setCourses2(input.getCourses2());
        inputModel.setCourses3(input.getCourses3());
        inputModel.setCourses4(input.getCourses4());
        inputModel.setSkill1(input.getSkill1());
        inputModel.setSkill2(input.getSkill2());
        inputModel.setSkill3(input.getSkill3());
        inputModel.setSkill4(input.getSkill4());
        inputModel.setSkill5(input.getSkill5());
        inputModel.setSkill6(input.getSkill6());
        inputModel.setSkill7(input.getSkill7());
        inputModel.setSkill8(input.getSkill8());
        inputModel.setSkill9(input.getSkill9());

        return inputModel;
    }

    @Override
    public List<InputModel> allCVs() {

        List<InputModel> allCVs = new ArrayList<>();
        List<Input> allCvs = getInputDAO().allCVs();
        InputModel inputModel = null;

        for (Input input : allCvs) {
            allCVs.add(modelDoDomena(input));
        }

        return allCVs;

    }

    public InputModel modelDoDomena(Input input) {

        InputModel inputModel = new InputModel();

        inputModel.setCvID(input.getCvID());
        inputModel.setName(input.getName());
        inputModel.setImage(input.getImage());
        inputModel.setDateOfBirth(input.getDateOfBirth());
        inputModel.setPlaceOfBirth(input.getPlaceOfBirth());
        inputModel.setCitizenship(input.getCitizenship());
        inputModel.setEmail(input.getEmail());
        inputModel.setPhoneNumber(input.getPhoneNumber());
        inputModel.setAdress(input.getAdress());
        inputModel.setCity(input.getCity());
        inputModel.setLanguage1(input.getLanguage1());
        inputModel.setLanguage2(input.getLanguage2());
        inputModel.setLanguage3(input.getLanguage3());
        inputModel.setLanguage4(input.getLanguage4());
        inputModel.setLanguageLevel1(input.getLanguageLevel1());
        inputModel.setLanguageLevel2(input.getLanguageLevel2());
        inputModel.setLanguageLevel3(input.getLanguageLevel3());
        inputModel.setLanguageLevel4(input.getLanguageLevel4());
        inputModel.setSomethingAboutMe(input.getSomethingAboutMe());
        inputModel.setFirstDayJob1(input.getFirstDayJob1());
        inputModel.setFirstDayJob2(input.getFirstDayJob2());
        inputModel.setFirstDayJob3(input.getFirstDayJob3());
        inputModel.setFirstDayJob4(input.getFirstDayJob4());
        inputModel.setLastDayJob1(input.getLastDayJob1());
        inputModel.setLastDayJob2(input.getLastDayJob2());
        inputModel.setLastDayJob3(input.getLastDayJob3());
        inputModel.setLastDayJob4(input.getLastDayJob4());
        inputModel.setWorkExperience1(input.getWorkExperience1());
        inputModel.setWorkExperience2(input.getWorkExperience2());
        inputModel.setWorkExperience3(input.getWorkExperience3());
        inputModel.setWorkExperience4(input.getWorkExperience4());
        inputModel.setFirstDaySchool1(input.getFirstDaySchool1());
        inputModel.setFirstDaySchool2(input.getFirstDaySchool2());
        inputModel.setFirstDaySchool3(input.getFirstDaySchool3());
        inputModel.setFirstDaySchool4(input.getFirstDaySchool4());
        inputModel.setLastDaySchool1(input.getLastDaySchool1());
        inputModel.setLastDaySchool2(input.getLastDaySchool2());
        inputModel.setLastDaySchool3(input.getLastDaySchool3());
        inputModel.setLastDaySchool4(input.getLastDaySchool4());
        inputModel.setEducation1(input.getEducation1());
        inputModel.setEducation2(input.getEducation2());
        inputModel.setEducation3(input.getEducation3());
        inputModel.setEducation4(input.getEducation4());
        inputModel.setPdf1(input.getPdf1());
        inputModel.setPdf2(input.getPdf2());
        inputModel.setPdf3(input.getPdf3());
        inputModel.setPdf4(input.getPdf4());
        inputModel.setCourses1(input.getCourses1());
        inputModel.setCourses2(input.getCourses2());
        inputModel.setCourses3(input.getCourses3());
        inputModel.setCourses4(input.getCourses4());
        inputModel.setSkill1(input.getSkill1());
        inputModel.setSkill2(input.getSkill2());
        inputModel.setSkill3(input.getSkill3());
        inputModel.setSkill4(input.getSkill4());
        inputModel.setSkill5(input.getSkill5());
        inputModel.setSkill6(input.getSkill6());
        inputModel.setSkill7(input.getSkill7());
        inputModel.setSkill8(input.getSkill8());
        inputModel.setSkill9(input.getSkill9());

        return inputModel;
    }

    @Override
    public void deleteCV(InputModel inputModel) {

        Input input = new Input();
        input.setCvID(inputModel.getCvID());
        getInputDAO().deleteCV(input);

    }

    public InputDAO getInputDAO() {
        return inputDAO;
    }

    public void setInputDAO(InputDAO inputDAO) {
        this.inputDAO = inputDAO;
    }

    String generateUniqueFileName() {
        String filename = "";
        long millis = System.currentTimeMillis();
        String rndchars = RandomStringUtils.randomAlphanumeric(8);
        filename = rndchars + millis;
        return filename;
    }

}
