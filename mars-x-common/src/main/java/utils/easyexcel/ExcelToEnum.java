package utils.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.StringUtils;
import utils.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExcelToEnum {

    public static void main(String[] args) {
        // 有个很重要的点 DataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "D:\\Users\\sj.hu\\Desktop\\shark.xlsx";
        fileName = "D:\\Users\\sj.hu\\Desktop\\shark_default_value\\magiclink\\magiclink_shark.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, Data.class, new DataListener()).sheet().doRead();

        /*// 写法2：
        ExcelReader excelReader = EasyExcel.read(fileName, Data.class, new DataListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);

        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();*/
    }

    static class DataListener extends AnalysisEventListener<Data> {
        /**
         * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
         */
        private static final int BATCH_COUNT = 100;
        List<Data> list = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        List<String> emptyValueKeys = new ArrayList<>();

        /**
         * 这个每一条数据解析都会来调用
         * @param data one row value. Is is same as {@link AnalysisContext#readRowHolder()}
         * @param context
         */
        @Override
        public void invoke(Data data, AnalysisContext context) {
            list.add(data);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            parseData(OutputFileType.JSON);
            saveDate(OutputFileType.JSON);
        }

        private void parseData(OutputFileType type) {
            for (Data data : list) {
                StringBuffer result = new StringBuffer();
                String value = data.getValue();
                if(type == OutputFileType.TXT) {
                    //枚举
                    result.append(data.getKey().toUpperCase().replace(".","_"));
                    result.append("(\"");
                    result.append(data.getKey());
                    result.append("\", \"");
                    result.append(data.getValue()==null?"": data.getValue().replaceAll("\n", "").replaceAll("\"","\\\\\""));
                    result.append("\"),");
                } else if(type == OutputFileType.JSON) {
                    //qconfig json
                    result.append("{\"key\":\"");
                    result.append(data.getKey());
                    result.append("\",");
                    result.append("\"value\":\"");
                    if(StringUtils.isEmpty(value)) {
                        value = data.getOrigin();
                    }
                    result.append(value==null?"": value.replaceAll("\n", "").replaceAll("\"","\\\\\""));
                    result.append("\"},");
                }

                if(StringUtils.isEmpty(value)) {
                    emptyValueKeys.add(data.getKey());
                }

                resultList.add(result.toString());
            }
        }

        enum OutputFileType{
            TXT,
            JSON
        }

        private void saveDate(OutputFileType fileType) {
            String file = "D:\\Users\\sj.hu\\Desktop\\shark.txt";
            if(fileType.equals(OutputFileType.JSON)) {
                file = "D:\\Users\\sj.hu\\Desktop\\SharkDefaultValueConfig.json";
                file = "D:\\Users\\sj.hu\\Desktop\\shark_default_value\\magiclink\\SharkDefaultValueConfig.json";
            } else if(fileType.equals(OutputFileType.TXT)) {
                file = "D:\\Users\\sj.hu\\Desktop\\SharkDefaultValueConfig.txt";
            }

            File f = new File(file);
            if (f.exists() && f.isFile()) {
                f.delete();
            }

            if(fileType.equals(OutputFileType.JSON)) {
                FileUtil.write2(file, "{");
                FileUtil.write2(file, "\t\"sharkDefaultValues\":[");
            }

            for (int idx=0;idx<resultList.size();idx++) {
                String content = "\t\t"+resultList.get(idx);
                if(fileType.equals(OutputFileType.JSON) && idx == resultList.size()-1) {
                    content = content.substring(0, content.lastIndexOf(","));
                }
                FileUtil.write2(file, content);
            }
            if(fileType.equals(OutputFileType.JSON)) {
                FileUtil.write2(file, "\t]");
                FileUtil.write2(file, "}");
            }

            file = "D:\\Users\\sj.hu\\Desktop\\SharkDefaultValueConfig_emptyKeys.txt";
            file = "D:\\Users\\sj.hu\\Desktop\\shark_default_value\\magiclink\\SharkDefaultValueConfig_emptyKeys.txt";
            f = new File(file);
            if (f.exists() && f.isFile()) {
                f.delete();
            }
            for (String emptyValueKey : emptyValueKeys) {
                FileUtil.write2(file, emptyValueKey);
            }
        }

    }

    public static class Data {

        private String key;
        private String value;
        private String origin;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }
    }


}
