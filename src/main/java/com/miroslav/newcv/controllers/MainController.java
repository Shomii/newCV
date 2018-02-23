package com.miroslav.newcv.controllers;

import com.miroslav.newcv.dao.InputDAO;
import com.miroslav.newcv.domain.Input;
import com.miroslav.newcv.model.InputModel;
import com.miroslav.newcv.service.InputService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import static org.hibernate.internal.util.io.StreamCopier.BUFFER_SIZE;

@Controller
public class MainController {

    @Autowired
    private InputService inputService;

    @Autowired
    private InputDAO inputDAO;

    @Autowired
    private ServletContext context;

    @RequestMapping(value = {"/", "index"})
    public String index() {

        return "index";
    }

    @RequestMapping(value = {"pdf1"})
    public String pdf1(@RequestParam Integer cvID, Model model) {
        List<InputModel> allInputModels = getInputService().allCVs();
        model.addAttribute("allInputModels", allInputModels);
        Input input = inputDAO.getCVId(cvID);
        model.addAttribute("inputCheck", input);
        model.addAttribute("pdf1", input.getPdf1());

        return "pdf1";
    }

    @RequestMapping(value = {"pdf2"})
    public String pdf2(@RequestParam Integer cvID, Model model) {
        List<InputModel> allInputModels = getInputService().allCVs();
        model.addAttribute("allInputModels", allInputModels);
        Input input = inputDAO.getCVId(cvID);
        model.addAttribute("inputCheck", input);
        model.addAttribute("pdf2", input.getPdf2());

        return "pdf2";
    }

    @RequestMapping(value = {"pdf3"})
    public String pdf3(@RequestParam Integer cvID, Model model) {
        List<InputModel> allInputModels = getInputService().allCVs();
        model.addAttribute("allInputModels", allInputModels);
        Input input = inputDAO.getCVId(cvID);
        model.addAttribute("inputCheck", input);
        model.addAttribute("pdf3", input.getPdf3());

        return "pdf3";
    }

    @RequestMapping(value = {"pdf4"})
    public String pdf4(@RequestParam Integer cvID, Model model) {
        List<InputModel> allInputModels = getInputService().allCVs();
        model.addAttribute("allInputModels", allInputModels);
        Input input = inputDAO.getCVId(cvID);
        model.addAttribute("inputCheck", input);
        model.addAttribute("pdf4", input.getPdf4());

        return "pdf4";
    }

    @RequestMapping(value = {"htmlForCV"})
    public String htmlForCV(@RequestParam Integer cvID, Model model) {

        List<InputModel> allInputModels = getInputService().allCVs();
        model.addAttribute("allInputModels", allInputModels);

        Input input = inputDAO.getCVId(cvID);
        model.addAttribute("inputCheck", input);
        model.addAttribute("name", input.getName());
        model.addAttribute("dateOfBirth", input.getDateOfBirth());
        model.addAttribute("placeOfBirth", input.getPlaceOfBirth());
        model.addAttribute("citizenship", input.getCitizenship());
        model.addAttribute("email", input.getEmail());
        model.addAttribute("phoneNumber", input.getPhoneNumber());
        model.addAttribute("adress", input.getAdress());
        model.addAttribute("city", input.getCity());
        model.addAttribute("language1", input.getLanguage1());
        model.addAttribute("language2", input.getLanguage2());
        model.addAttribute("language3", input.getLanguage3());
        model.addAttribute("language4", input.getLanguage4());
        model.addAttribute("languageLevel1", input.getLanguageLevel1());
        model.addAttribute("languageLevel2", input.getLanguageLevel2());
        model.addAttribute("languageLevel3", input.getLanguageLevel3());
        model.addAttribute("languageLevel4", input.getLanguageLevel4());
        model.addAttribute("somethingAboutMe", input.getSomethingAboutMe());
        model.addAttribute("firstDayJob1", input.getFirstDayJob1());
        model.addAttribute("firstDayJob2", input.getFirstDayJob2());
        model.addAttribute("firstDayJob3", input.getFirstDayJob3());
        model.addAttribute("firstDayJob4", input.getFirstDayJob4());
        model.addAttribute("lastDayJob1", input.getLastDayJob1());
        model.addAttribute("lastDayJob2", input.getLastDayJob2());
        model.addAttribute("lastDayJob3", input.getLastDayJob3());
        model.addAttribute("lastDayJob4", input.getLastDayJob4());
        model.addAttribute("workExperience1", input.getWorkExperience1());
        model.addAttribute("workExperience2", input.getWorkExperience2());
        model.addAttribute("workExperience3", input.getWorkExperience3());
        model.addAttribute("workExperience4", input.getWorkExperience4());
        model.addAttribute("firstDaySchool1", input.getFirstDaySchool1());
        model.addAttribute("firstDaySchool2", input.getFirstDaySchool2());
        model.addAttribute("firstDaySchool3", input.getFirstDaySchool3());
        model.addAttribute("firstDaySchool4", input.getFirstDaySchool4());
        model.addAttribute("lastDaySchool1", input.getLastDaySchool1());
        model.addAttribute("lastDaySchool2", input.getLastDaySchool2());
        model.addAttribute("lastDaySchool3", input.getLastDaySchool3());
        model.addAttribute("lastDaySchool4", input.getLastDaySchool4());
        model.addAttribute("education1", input.getEducation1());
        model.addAttribute("education2", input.getEducation2());
        model.addAttribute("education3", input.getEducation3());
        model.addAttribute("education4", input.getEducation4());
        model.addAttribute("pdf1", input.getPdf1());
        model.addAttribute("pdf2", input.getPdf2());
        model.addAttribute("pdf3", input.getPdf3());
        model.addAttribute("pdf4", input.getPdf4());
        model.addAttribute("courses1", input.getCourses1());
        model.addAttribute("courses2", input.getCourses2());
        model.addAttribute("courses3", input.getCourses3());
        model.addAttribute("courses4", input.getCourses4());
        model.addAttribute("skill1", input.getSkill1());
        model.addAttribute("skill2", input.getSkill2());
        model.addAttribute("skill3", input.getSkill3());
        model.addAttribute("skill4", input.getSkill4());
        model.addAttribute("skill5", input.getSkill5());
        model.addAttribute("skill6", input.getSkill6());
        model.addAttribute("skill7", input.getSkill7());
        model.addAttribute("skill8", input.getSkill8());
        model.addAttribute("skill9", input.getSkill9());
        model.addAttribute("image", input.getImage());

        return "htmlForCV";
    }

    @RequestMapping(value = {"previewOfCV"})
    public String previewOfCV(@RequestParam Integer cvID, Model model) {

        List<InputModel> allInputModels = getInputService().allCVs();
        model.addAttribute("allInputModels", allInputModels);

        Input input = inputDAO.getCVId(cvID);
        model.addAttribute("inputCheck", input);
//        String name = input.getName();
        model.addAttribute("name", input.getName());
        model.addAttribute("dateOfBirth", input.getDateOfBirth());
        model.addAttribute("placeOfBirth", input.getPlaceOfBirth());
        model.addAttribute("citizenship", input.getCitizenship());
        model.addAttribute("email", input.getEmail());
        model.addAttribute("phoneNumber", input.getPhoneNumber());
        model.addAttribute("adress", input.getAdress());
        model.addAttribute("city", input.getCity());
        model.addAttribute("language1", input.getLanguage1());
        model.addAttribute("language2", input.getLanguage2());
        model.addAttribute("language3", input.getLanguage3());
        model.addAttribute("language4", input.getLanguage4());
        model.addAttribute("languageLevel1", input.getLanguageLevel1());
        model.addAttribute("languageLevel2", input.getLanguageLevel2());
        model.addAttribute("languageLevel3", input.getLanguageLevel3());
        model.addAttribute("languageLevel4", input.getLanguageLevel4());
        model.addAttribute("somethingAboutMe", input.getSomethingAboutMe());
        model.addAttribute("firstDayJob1", input.getFirstDayJob1());
        model.addAttribute("firstDayJob2", input.getFirstDayJob2());
        model.addAttribute("firstDayJob3", input.getFirstDayJob3());
        model.addAttribute("firstDayJob4", input.getFirstDayJob4());
        model.addAttribute("lastDayJob1", input.getLastDayJob1());
        model.addAttribute("lastDayJob2", input.getLastDayJob2());
        model.addAttribute("lastDayJob3", input.getLastDayJob3());
        model.addAttribute("lastDayJob4", input.getLastDayJob4());
        model.addAttribute("workExperience1", input.getWorkExperience1());
        model.addAttribute("workExperience2", input.getWorkExperience2());
        model.addAttribute("workExperience3", input.getWorkExperience3());
        model.addAttribute("workExperience4", input.getWorkExperience4());
        model.addAttribute("firstDaySchool1", input.getFirstDaySchool1());
        model.addAttribute("firstDaySchool2", input.getFirstDaySchool2());
        model.addAttribute("firstDaySchool3", input.getFirstDaySchool3());
        model.addAttribute("firstDaySchool4", input.getFirstDaySchool4());
        model.addAttribute("lastDaySchool1", input.getLastDaySchool1());
        model.addAttribute("lastDaySchool2", input.getLastDaySchool2());
        model.addAttribute("lastDaySchool3", input.getLastDaySchool3());
        model.addAttribute("lastDaySchool4", input.getLastDaySchool4());
        model.addAttribute("education1", input.getEducation1());
        model.addAttribute("education2", input.getEducation2());
        model.addAttribute("education3", input.getEducation3());
        model.addAttribute("education4", input.getEducation4());
        model.addAttribute("pdf1", input.getPdf1());
        model.addAttribute("pdf2", input.getPdf2());
        model.addAttribute("pdf3", input.getPdf3());
        model.addAttribute("pdf4", input.getPdf4());
        model.addAttribute("courses1", input.getCourses1());
        model.addAttribute("courses2", input.getCourses2());
        model.addAttribute("courses3", input.getCourses3());
        model.addAttribute("courses4", input.getCourses4());
        model.addAttribute("skill1", input.getSkill1());
        model.addAttribute("skill2", input.getSkill2());
        model.addAttribute("skill3", input.getSkill3());
        model.addAttribute("skill4", input.getSkill4());
        model.addAttribute("skill5", input.getSkill5());
        model.addAttribute("skill6", input.getSkill6());
        model.addAttribute("skill7", input.getSkill7());
        model.addAttribute("skill8", input.getSkill8());
        model.addAttribute("skill9", input.getSkill9());
        model.addAttribute("image", input.getImage());

        return "previewOfCV";
    }

    @RequestMapping("/newCV")
    public String getRegister(Model model) {
        model.addAttribute("newcV", new InputModel());
        model.addAttribute("datum", new SimpleDateFormat("dd.MM.yyyy").format(new Date()));

        return "newCV";
    }

    @RequestMapping(value = "/newCV", method = RequestMethod.POST)
    public String postRegister(@Valid @ModelAttribute("newcV") InputModel input, BindingResult result, Model model,
            @RequestParam("images") MultipartFile[] images,
            @RequestParam("pdfs1") MultipartFile[] pdfs1, @RequestParam("pdfs2") MultipartFile[] pdfs2,
            @RequestParam("pdfs3") MultipartFile[] pdfs3, @RequestParam("pdfs4") MultipartFile[] pdfs4 /*, HttpServletRequest request, Locale locale) throws MessagingException, IOException */) {

        if (result.hasErrors()) {
            return "greska";
        }
        getInputService().savingCV(input, images, pdfs1, pdfs2, pdfs3, pdfs4);

        return "redirect:/index";
    }

    @RequestMapping(value = {"/updateCV"})
    public String azuriranje(@RequestParam Integer cvID, Model model) {
        model.addAttribute("updatecV", getInputService().getInputModel(cvID));
        List<InputModel> allInputModels = getInputService().allCVs();
        model.addAttribute("allInputModels", allInputModels);
        Input input = inputDAO.getCVId(cvID);
        model.addAttribute("inputCheck", input);

        return "updateCV";
    }

    @RequestMapping(value = {"/updateCV"}, method = RequestMethod.POST)
    public String azuriranjePost(@Valid @ModelAttribute("updatecV") InputModel inputModel, BindingResult result/*, HttpServletRequest request*/,
            @RequestParam("images") MultipartFile[] images, @RequestParam("pdfs1") MultipartFile[] pdfs1, @RequestParam("pdfs2") MultipartFile[] pdfs2,
            @RequestParam("pdfs3") MultipartFile[] pdfs3, @RequestParam("pdfs4") MultipartFile[] pdfs4) {
        if (result.hasErrors()) {
            return "greska";
        }
        getInputService().updateCV(inputModel, images, pdfs1, pdfs2, pdfs3, pdfs4);

        return "redirect:/index";
    }

    @RequestMapping(value = {"/archive"})
    public String kontakti(Model model, HttpServletRequest request) {

        List<Input> allCVs = inputDAO.allCVs();
        model.addAttribute("cvs", allCVs);

        return "archive";
    }

    @RequestMapping(value = {"/deleteCV"})
    public String deleteCVs(@RequestParam Integer cvID, Model model, HttpServletRequest request) {
        InputModel inputModel = getInputService().getInputModel(cvID);
        getInputService().deleteCV(inputModel);
        return "redirect:/archive";
    }

    @RequestMapping(value = {"/createPDF"})
    public String createPDF(@RequestParam Integer cvID, Model model, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, DocumentException, IOException {

        InputModel inputModel = getInputService().getInputModel(cvID);
        String pdf1 = inputModel.getPdf1();
        String pdf2 = inputModel.getPdf1();
        String pdf3 = inputModel.getPdf1();
        String pdf4 = inputModel.getPdf1();

        try {
            String s = Integer.toString(inputModel.getCvID());
            Integer ss = inputModel.getCvID();
            Document document = new Document();
            new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName()).mkdir();
            OutputStream file = new FileOutputStream(new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + inputModel.getName()/* + "-"+ generateUniqueFileNameDate()*/ + ".pdf"));
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
            InputStream attachment = new URL("http://localhost:8080/NewCV_6/pdf1?cvID=" + s).openStream();
            InputStream attachment2 = new URL("http://localhost:8080/NewCV_6/pdf2?cvID=" + s).openStream();
            InputStream attachment3 = new URL("http://localhost:8080/NewCV_6/pdf3?cvID=" + s).openStream();
            InputStream attachment4 = new URL("http://localhost:8080/NewCV_6/pdf4?cvID=" + s).openStream();
            InputStream is = new URL("http://localhost:8080/NewCV_6/htmlForCV?cvID=" + s).openStream();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);

            document.close();

            if (!pdf1.isEmpty()) {
                String pdf1Name = inputModel.getPdf1();
                pdf1Name = pdf1Name.substring(0, pdf1Name.lastIndexOf('.'));
                Document document2 = new Document();
                OutputStream file2 = new FileOutputStream(new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + pdf1Name + ".pdf"));
                PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
                document2.open();
                XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, attachment);
                document2.close();
                file2.close();

                if (!pdf2.isEmpty()) {
                    String pdf2Name = inputModel.getPdf2();
                    pdf2Name = pdf2Name.substring(0, pdf2Name.lastIndexOf('.'));
                    Document document3 = new Document();
                    OutputStream file3 = new FileOutputStream(new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + pdf2Name + ".pdf"));
                    PdfWriter writer3 = PdfWriter.getInstance(document3, file3);
                    document3.open();
                    XMLWorkerHelper.getInstance().parseXHtml(writer3, document3, attachment2);
                    document3.close();
                    file3.close();

                    if (!pdf3.isEmpty()) {
                        String pdf3Name = inputModel.getPdf3();
                        pdf3Name = pdf3Name.substring(0, pdf3Name.lastIndexOf('.'));
                        Document document4 = new Document();
                        OutputStream file4 = new FileOutputStream(new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + pdf3Name + ".pdf"));
                        PdfWriter writer4 = PdfWriter.getInstance(document4, file4);
                        document4.open();
                        XMLWorkerHelper.getInstance().parseXHtml(writer4, document4, attachment3);
                        document4.close();
                        file4.close();

                        if (!pdf4.isEmpty()) {
                            String pdf4Name = inputModel.getPdf4();
                            pdf4Name = pdf4Name.substring(0, pdf4Name.lastIndexOf('.'));
                            Document document5 = new Document();
                            OutputStream file5 = new FileOutputStream(new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + pdf4Name + ".pdf"));
                            PdfWriter writer5 = PdfWriter.getInstance(document5, file5);
                            document5.open();
                            XMLWorkerHelper.getInstance().parseXHtml(writer5, document5, attachment4);
                            document5.close();
                            file5.close();
                        }
                    }
                }
            }

            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("PDF je napravljen !");

        return "redirect:/archive";
    }

    @RequestMapping(value = "/listForDownload", method = RequestMethod.GET)
    public String listForDownload(@RequestParam Integer cvID, Model model, HttpServletResponse response) {

        InputModel inputModel = getInputService().getInputModel(cvID);
        List<InputModel> allInputModels = getInputService().allCVs();
        model.addAttribute("allInputModels", allInputModels);
        Input input = inputDAO.getCVId(cvID);
        model.addAttribute("inputCheck", input);
        List<Input> allCVs = inputDAO.allCVs();
        model.addAttribute("cvs", allCVs);

        model.addAttribute("pdf1", inputModel.getPdf1());
        model.addAttribute("pdf2", inputModel.getPdf2());
        model.addAttribute("pdf3", inputModel.getPdf3());
        model.addAttribute("pdf4", inputModel.getPdf4());
        model.addAttribute("name", inputModel.getName());

        return "listForDownload";
    }

    @RequestMapping(value = "/fileDownloadCV", method = RequestMethod.GET)
    public void fileDownloadCV(@RequestParam Integer cvID, Model model, HttpServletResponse response) throws IOException {

        InputModel inputModel = getInputService().getInputModel(cvID);
        String fileName = inputModel.getName();
        File file = new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + fileName/*+ "ITAkademija.pdf"*/ + ".pdf");
        InputStream is = new FileInputStream(file);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + file.getName() + "\"");
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }

    @RequestMapping(value = "/fileDownload1", method = RequestMethod.GET)
    public void fileDownload1(@RequestParam Integer cvID, Model model, HttpServletResponse response) throws IOException {

        InputModel inputModel = getInputService().getInputModel(cvID);
        String fileName = inputModel.getPdf1();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        File file = new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + fileName/*+ "ITAkademija.pdf"*/ + ".pdf");
        InputStream is = new FileInputStream(file);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + file.getName() + "\"");
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }

    @RequestMapping(value = "/fileDownload2", method = RequestMethod.GET)
    public void fileDownload2(@RequestParam Integer cvID, Model model, HttpServletResponse response) throws IOException {

        InputModel inputModel = getInputService().getInputModel(cvID);
        String fileName = inputModel.getPdf2();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        File file = new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + fileName/*+ "ITAkademija.pdf"*/ + ".pdf");
        InputStream is = new FileInputStream(file);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + file.getName() + "\"");
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }

    @RequestMapping(value = "/fileDownload3", method = RequestMethod.GET)
    public void fileDownload3(@RequestParam Integer cvID, Model model, HttpServletResponse response) throws IOException {

        InputModel inputModel = getInputService().getInputModel(cvID);
        String fileName = inputModel.getPdf3();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        File file = new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + fileName/*+ "ITAkademija.pdf"*/ + ".pdf");
        InputStream is = new FileInputStream(file);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + file.getName() + "\"");
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }

    @RequestMapping(value = "/fileDownload4", method = RequestMethod.GET)
    public void fileDownload4(@RequestParam Integer cvID, Model model, HttpServletResponse response) throws IOException {

        InputModel inputModel = getInputService().getInputModel(cvID);
        String fileName = inputModel.getPdf4();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        File file = new File("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\NewCV_6\\src\\main\\webapp\\resources\\PDF\\" + inputModel.getCvName() + "\\" + fileName/*+ "ITAkademija.pdf"*/ + ".pdf");
        InputStream is = new FileInputStream(file);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + file.getName() + "\"");
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }

    @RequestMapping(value = "/download2", method = RequestMethod.GET)
    public void createPdf(@RequestParam Integer cvID/*, String file*/) throws IOException, DocumentException {

        InputModel inputModel = getInputService().getInputModel(cvID);
        String s = Integer.toString(inputModel.getCvID());
        final String DEST = "C:\\Users\\Korisnik\\Desktop\\pdfFromJAVA\\" + inputModel.getName() + "-" + generateUniqueFileNameDate() + ".pdf";
        InputStream HTML = new URL("http://localhost:8080/NewCV_6/htmlForCV?cvID=" + s).openStream();
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        Paragraph preface = new Paragraph();
        preface.setAlignment(Element.ALIGN_CENTER);
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        writer.setInitialLeading(12);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, HTML);

        document.close();
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void doDownload(@RequestParam Integer cvID, HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        InputModel inputModel = getInputService().getInputModel(cvID);
        String s = Integer.toString(inputModel.getCvID());
        InputStream is;
        Integer ss = inputModel.getCvID();
        System.out.println("id je" + s);
        System.out.println("id je" + ss);
        is = new URL("http://localhost:8080/NewCV_6/htmlForCV?cvID=" + s).openStream();
        OutputStream file = new FileOutputStream(new File("C:\\Users\\Korisnik\\Desktop\\pdfFromJAVA\\downloadCV2.pdf"));
        String stringFromHTML = IOUtils.toString(is, "UTF-8");
        String mimeType = context.getMimeType(stringFromHTML);
        if (mimeType == null) {
            mimeType = "application/pdf";
        }
        System.out.println("MIME type: " + mimeType);
        String headerKey = "Content-Disposition";
        response.addHeader("Content-Disposition", "attachment;filename=report.pdf");
        response.setContentType("application/pdf");
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        while ((bytesRead = is.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        is.close();
        outStream.close();
    }

    @RequestMapping(value = {"/createPDF2"})
    public String createPDF2(@RequestParam Integer cvID, Model model, HttpServletRequest request) throws FileNotFoundException, DocumentException, IOException {

        InputModel inputModel = getInputService().getInputModel(cvID);
        String s = Integer.toString(inputModel.getCvID());
        Integer ss = inputModel.getCvID();
        final String[] HTML = {
            "C:\\Users\\Korisnik\\Desktop\\pdfFromJAVA\\page1.html",
            "C:\\Users\\Korisnik\\Desktop\\pdfFromJAVA\\page2.html",
            "C:\\Users\\Korisnik\\Desktop\\pdfFromJAVA\\page3.html"
        };
        final String DEST = "C:\\Users\\Korisnik\\Desktop\\pdfFromJAVA\\" + inputModel.getName() + "-" + generateUniqueFileNameDate() + ".pdf";
        Document document = new Document();
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(DEST));
        document.open();
        PdfReader reader;
        for (String html : HTML) {
            reader = new PdfReader(parseHtml(html));
            reader.close();
        }
        document.close();

        return "redirect:/archive";
    }

    public byte[] parseHtml(String html) throws DocumentException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(html));
        document.close();

        return baos.toByteArray();
    }

    public InputService getInputService() {
        return inputService;
    }

    public void setInputService(InputService inputService) {
        this.inputService = inputService;
    }

    String generateUniqueFileName() {
        String filename = "";
        long millis = System.currentTimeMillis();
        String rndchars = RandomStringUtils.randomAlphanumeric(4);
        filename = rndchars + millis;

        return filename;
    }

    String generateUniqueFileNameDate() {
        String filename = "";

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        filename = dateFormat.format(date);

        return filename;
    }

}
