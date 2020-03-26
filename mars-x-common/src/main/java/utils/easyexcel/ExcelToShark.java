package utils.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import utils.StringUtils;

import java.io.File;
import java.util.*;

/**
 * @author: sj.hu
 * @date: 2020/3/2 13:37
 **/
public class ExcelToShark {

    public static void main(String[] args) {
        String fileName = "D:\\Users\\sj.hu\\Desktop\\shark.xlsx";
        fileName = "D:\\Users\\sj.hu\\Desktop\\WorkFlow\\02-20_email_sc_header_footer\\shark\\ctrip_translationsNew.xlsx";

        EasyExcel.read(fileName, Data.class, new DataListener()).sheet().doRead();
    }

    static class DataListener extends AnalysisEventListener<Data> {

        List<Data> list = new ArrayList<>();
        Set<String> sharkLocales = new HashSet<>(Arrays.asList(
                ("en-US,ar-AE,ar-SA,ar-XX,de-DE,el-GR,en-AE,en-AU,en-GB,en-HK," +
                "en-ID,en-IL,en-JP,en-KR,en-MY,en-SA,en-SG,en-TH,es-ES,fr-FR," +
                "id-ID,it-IT,ja-JP,ko-KR,ms-MY,nl-NL,pl-PL,pt-BR,ru-RU,th-TH," +
                "tl-PH,tr-TR,vi-VN,zh-CN,zh-HK,zh-SG,zh-TW").split(",")));
        /**
         * <key, <locale, value>>
         * eg. <bookedOn, <en-US, Booked on>,<zh-CN, 预定于>>
         */
        Map<String, TreeMap<String, String>> result = new HashMap<>();


        @Override
        public void invoke(Data data, AnalysisContext analysisContext) {
            list.add(data);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            parseData2();
            saveDate();
        }

        private void parseData2() {
            result.put("extrabed", new TreeMap<>());
            result.put("guest", new TreeMap<>());
            result.put("qr21", new TreeMap<>());
            result.put("qr1", new TreeMap<>());

            for(Data data: list) {
                if (data != null && sharkLocales.contains(data.getLocale())) {
                    if(data.getKey().equalsIgnoreCase("HOTELS_BOOKING_CONFIRMED_EMAIL_Ctrip_extrabed")) {
                        result.get("extrabed").put(data.getLocale(), data.getTranslation().trim());
                    } else if(data.getKey().equalsIgnoreCase("HOTELS_BOOKING_CONFIRMED_EMAIL_Ctrip_guest")) {
                        result.get("guest").put(data.getLocale(), data.getTranslation().trim());
                    } else if(data.getKey().equalsIgnoreCase("HOTELS_BOOKING_CONFIRMED_EMAIL_Ctrip_QR2.1")) {
                        String[] trans = data.getTranslation().split("•|・|\n\n");
                        result.get("qr21").put(data.getLocale(), trans[1].trim());

                    } else if(data.getKey().equalsIgnoreCase("HOTELS_BOOKING_CONFIRMED_EMAIL_Ctrip_QR1")) {
                        result.get("qr1").put(data.getLocale(), data.getTranslation().trim());
                    }
                }
            }
        }

        private void parseData() {
            result.put("bookedOn", new TreeMap<>());
            result.put("downloadTitle", new TreeMap<>());
            result.put("downloadTip1", new TreeMap<>());
            result.put("downloadTip2", new TreeMap<>());
            result.put("contactTitle", new TreeMap<>());
            result.put("feedback", new TreeMap<>());

            for(Data data: list) {
                if(data != null && sharkLocales.contains(data.getLocale())) {
                    if(data.getKey().equalsIgnoreCase("HOTELS_BOOKING_CONFIRMED_EMAIL_Ctrip")) {
                        result.get("bookedOn").put(data.getLocale(), data.getTranslation().replaceAll("\\{provider}", "{0}").trim());
                    } else if(data.getKey().equalsIgnoreCase("HOTELS_BOOKING_CONFIRMED_EMAIL_Ctrip_appdownload")) {
                        String[] trans = data.getTranslation().split("•");
                        if(trans.length < 3) {
                            trans = data.getTranslation().split("・");
                        }
                        if(trans.length < 3) {
                            trans = data.getTranslation().split("\n\n");
                        }
                        result.get("downloadTitle").put(data.getLocale(), trans[0].trim());
                        result.get("downloadTip1").put(data.getLocale(), StringUtils.trimEnd(trans[1].trim(), "-"));
                        result.get("downloadTip2").put(data.getLocale(), StringUtils.trimEnd(trans[2].trim(), "-"));
                    } else if(data.getKey().equalsIgnoreCase("HOTELS_BOOKING_CONFIRMED_EMAIL_Ctrip_contact")) {
                        result.get("contactTitle").put(data.getLocale(), data.getTranslation().trim());
                    }  else if(data.getKey().equalsIgnoreCase("HOTELS_BOOKING_CONFIRMED_EMAIL_Ctrip_feedback")) {
                        result.get("feedback").put(data.getLocale(), data.getTranslation().trim());
                    }
                }
            }
        }

        private void saveDate() {
            String fileName = "D:\\Users\\sj.hu\\Desktop\\WorkFlow\\02-20_email_sc_header_footer\\shark\\sharkNew.xlsx";

            File file = new File(fileName);
            if (file.exists() && file.isFile()) {
                file.delete();
            }

            WriteSheet sheet = new WriteSheet();
            WriteTable table = new WriteTable();

            List<List<String>> headList = new ArrayList<>();
            for(Map.Entry<String, String> entry: result.get("extrabed").entrySet()) {
                List<String> head = new ArrayList<>();
                head.add(entry.getKey());
                headList.add(head);
            }
            EasyExcel.write(file).sheet("shark data").doWrite(headList);

            List<List<String>> dataList = new ArrayList<>();
            for(Map.Entry<String, TreeMap<String, String>> entry: result.entrySet()) {
                List<String> valueList = new ArrayList<>();
                for(Map.Entry<String, String> entry1: entry.getValue().entrySet()) {
                    valueList.add(entry1.getValue());
                }
                dataList.add(valueList);
            }

            EasyExcel.write(fileName)
                    // 这里放入动态头
                    .head(headList).sheet("模板")
                    // 当然这里数据也可以用 List<List<String>> 去传入
                    .doWrite(dataList);
        }
    }


    public static class Data {
        private String locale;
        private String key;
        private String translation;
        private String origin;

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getTranslation() {
            return translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
        }
    }
}
