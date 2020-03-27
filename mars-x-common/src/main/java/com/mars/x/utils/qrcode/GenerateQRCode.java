package com.mars.x.utils.qrcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mars.x.utils.EncryptUtils;
import com.mars.x.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sj.hu
 * @date: 2020/3/17 18:43
 **/
public class GenerateQRCode {

    public static void main(String[] args) {
        String outFold = "D:\\Users\\sj.hu\\Desktop\\WorkFlow\\02-20_email_sc_header_footer\\appDownloadLink\\qrcode\\";

        // trip app download
        String contentFilePath = "D:\\Users\\sj.hu\\Desktop\\WorkFlow\\02-20_email_sc_header_footer\\appDownloadLink\\localeDownloadUrl.json";
        String logoPath = "D:\\Users\\sj.hu\\Desktop\\WorkFlow\\02-20_email_sc_header_footer\\design\\Email2\\QAlogo\\QAlogo_trip@2x.png";
        //generate(contentFilePath, logoPath, outFold);

        // sc app download
        String scAppDownloadUrl = "https://www.skyscanner.net/mobile";
        String scLogoPath = "D:\\Users\\sj.hu\\Desktop\\WorkFlow\\02-20_email_sc_header_footer\\design\\Email2\\QAlogo\\QAlogo_skyscanner@2x.png";
        generateSc(scAppDownloadUrl, scLogoPath, outFold);
    }

    public static void generate(String contentFilePath, String logoPath, String outFold) {

        String fileString = FileUtil.readFile(contentFilePath);

        JSONArray jsonArray = JSON.parseArray(fileString);

        List<AppDownloadImg> appDownloadImgList = new ArrayList<>();

        for(int i=0;i<jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String locale = jsonObject.getString("locale");
            String downloadUrl = jsonObject.getString("downloadUrl");

            try {
                String random = EncryptUtils.encrypt(locale).substring(0, 8);
                String imgName = locale+".png";
                String outImgPath = outFold+imgName;

                String qrCodeUrl = "https://pages.c-ctrip.com/hotel_distribution/email/appdownload/qrcode/" + imgName;
                AppDownloadImg appDownloadImg = new AppDownloadImg();
                appDownloadImg.setLocale(locale);
                appDownloadImg.setQrCodeUrl(qrCodeUrl);
                appDownloadImgList.add(appDownloadImg);

                QrcodeUtil.generate(downloadUrl, 247, 0.3, logoPath, outImgPath);
            } catch (Throwable th) {
                System.out.println(th.fillInStackTrace());
            }
        }
        String str = JSON.toJSONString(appDownloadImgList);
        String configFile = "D:\\Users\\sj.hu\\Desktop\\WorkFlow\\02-20_email_sc_header_footer\\appDownloadLink\\appDownloadQRCode.json";
        FileUtil.write(configFile, str);
    }

    public static void generateSc(String downloadUrl, String logoPath, String outFold) {
        String imgName = "sc.png";
        String outImgPath = outFold+imgName;
        try {
            QrcodeUtil.generate(downloadUrl, 268, 0.3, logoPath, outImgPath);
        } catch (Throwable th) {
            System.out.println(th.fillInStackTrace());
        }
    }

    static class AppDownloadImg {
        private String locale;
        private String qrCodeUrl;

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getQrCodeUrl() {
            return qrCodeUrl;
        }

        public void setQrCodeUrl(String qrCodeUrl) {
            this.qrCodeUrl = qrCodeUrl;
        }
    }
}
