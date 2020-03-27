package com.mars.x.utils.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: sj.hu
 * @date: 2020/3/17 18:08
 **/
public class GetOne {

    public static void main(String[] args) {
        System.out.println(getOne());
    }

    public static String getOne() {
        String json = "[\n" +
                "        {\n" +
                "            \"name\": \"en_us\",\n" +
                "            \"alias\": \"en_us,en-us,english,en,en-en,us-us,en_en,us_us,enen,enus\",\n" +
                "            \"language\": \"en\",\n" +
                "            \"site\": \"en\",\n" +
                "            \"standard\": \"en-US\",\n" +
                "            \"standard_aspnet\": \"en-US\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"ja_jp\",\n" +
                "            \"alias\": \"ja_jp,ja-jp,ja,jp,ja-ja,jp-jp,ja_ja,jp_jp,jajp,jpjp\",\n" +
                "            \"language\": \"jp\",\n" +
                "            \"site\": \"jp\",\n" +
                "            \"standard\": \"ja-JP\",\n" +
                "            \"standard_aspnet\": \"ja-JP\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"ko_kr\",\n" +
                "            \"alias\": \"ko_kr,ko-kr,ko,kr,ko-ko,kr-kr,ko_ko,kr_kr,kokr,krkr\",\n" +
                "            \"language\": \"kr\",\n" +
                "            \"site\": \"kr\",\n" +
                "            \"standard\": \"ko-KR\",\n" +
                "            \"standard_aspnet\": \"ko-KR\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"fr_fr\",\n" +
                "            \"alias\": \"fr_fr,fr-fr,fr,frfr\",\n" +
                "            \"language\": \"fr\",\n" +
                "            \"site\": \"fr\",\n" +
                "            \"standard\": \"fr-FR\",\n" +
                "            \"standard_aspnet\": \"fr-FR\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"de_de\",\n" +
                "            \"alias\": \"de_de,de-de,de,dede\",\n" +
                "            \"language\": \"de\",\n" +
                "            \"site\": \"de\",\n" +
                "            \"standard\": \"de-DE\",\n" +
                "            \"standard_aspnet\": \"de-DE\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"es_es\",\n" +
                "            \"alias\": \"es_es,es-es,es,eses\",\n" +
                "            \"language\": \"es\",\n" +
                "            \"site\": \"es\",\n" +
                "            \"standard\": \"es-ES\",\n" +
                "            \"standard_aspnet\": \"es-ES\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"ru_ru\",\n" +
                "            \"alias\": \"ru_ru,ru-ru,ru,ruru\",\n" +
                "            \"language\": \"ru\",\n" +
                "            \"site\": \"ru\",\n" +
                "            \"standard\": \"ru-RU\",\n" +
                "            \"standard_aspnet\": \"ru-RU\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"zh_hk\",\n" +
                "            \"alias\": \"zh_hk,zh-hk,hk,zh-zh,hk-hk,zh_zh,hk_hk,tc,zhhk,hkhk,gt\",\n" +
                "            \"language\": \"hk\",\n" +
                "            \"site\": \"hk\",\n" +
                "            \"standard\": \"zh-HK\",\n" +
                "            \"standard_aspnet\": \"zh-HK\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"zh_cn\",\n" +
                "            \"alias\": \"zh_cn,zh-cn,cn,zh,cn-cn,cn_cn,zhcn,cncn\",\n" +
                "            \"language\": \"cn\",\n" +
                "            \"site\": \"cn\",\n" +
                "            \"standard\": \"zh-CN\",\n" +
                "            \"standard_aspnet\": \"zh-CN\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"en_hk\",\n" +
                "            \"alias\": \"en_hk,en-hk,enhk,hken,en_hk,hk_en\",\n" +
                "            \"language\": \"en\",\n" +
                "            \"site\": \"hk\",\n" +
                "            \"standard\": \"en-HK\",\n" +
                "            \"standard_aspnet\": \"en-US\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"en_sg\",\n" +
                "            \"alias\": \"en_sg,en-sg,sg,sg-sg,sg_sg,ensg,sgsg\",\n" +
                "            \"language\": \"sg\",\n" +
                "            \"site\": \"sg\",\n" +
                "            \"standard\": \"en-SG\",\n" +
                "            \"standard_aspnet\": \"en-US\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"ms_my\",\n" +
                "            \"alias\": \"ms_my,ms-my,ms,my,ms-ms,my-my,ms_ms,my_my,msmy,mymy\",\n" +
                "            \"language\": \"my\",\n" +
                "            \"site\": \"my\",\n" +
                "            \"standard\": \"ms-MY\",\n" +
                "            \"standard_aspnet\": \"ms-MY\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"id_id\",\n" +
                "            \"alias\": \"id_id,id-id,id,idid\",\n" +
                "            \"language\": \"id\",\n" +
                "            \"site\": \"id\",\n" +
                "            \"standard\": \"id-ID\",\n" +
                "            \"standard_aspnet\": \"id-ID\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"th_th\",\n" +
                "            \"alias\": \"th_th,th-th,th,thth\",\n" +
                "            \"language\": \"th\",\n" +
                "            \"site\": \"th\",\n" +
                "            \"standard\": \"th-TH\",\n" +
                "            \"standard_aspnet\": \"th-TH\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"en_au\",\n" +
                "            \"alias\": \"en_au,en-au,au,en_au,enau,auau\",\n" +
                "            \"language\": \"en\",\n" +
                "            \"site\": \"au\",\n" +
                "            \"standard\": \"en-AU\",\n" +
                "            \"standard_aspnet\": \"en-US\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"vi_vn\",\n" +
                "            \"alias\": \"vi_vn,vi-vn,vi,vn,vivn,vnvn,vnvi,vivi\",\n" +
                "            \"language\": \"vn\",\n" +
                "            \"site\": \"vn\",\n" +
                "            \"standard\": \"vi-VN\",\n" +
                "            \"standard_aspnet\": \"vi-VN\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"tl_ph\",\n" +
                "            \"alias\": \"tl_ph,tl-ph,tl,ph,tlph,phph,phtl,tltl\",\n" +
                "            \"language\": \"tl\",\n" +
                "            \"site\": \"ph\",\n" +
                "            \"standard\": \"tl-PH\",\n" +
                "            \"standard_aspnet\": \"fil-PH\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"zh_tw\",\n" +
                "            \"alias\": \"zh_tw,zh-tw,tw-tw,tw_tw,tw,zhtw,twtw,twzh\",\n" +
                "            \"language\": \"tw\",\n" +
                "            \"site\": \"tw\",\n" +
                "            \"standard\": \"zh-TW\",\n" +
                "            \"standard_aspnet\": \"zh-TW\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"it_it\",\n" +
                "            \"alias\": \"it_it,it-it,it,itit\",\n" +
                "            \"language\": \"it\",\n" +
                "            \"site\": \"it\",\n" +
                "            \"standard\": \"it-IT\",\n" +
                "            \"standard_aspnet\": \"it-IT\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"en_gb\",\n" +
                "            \"alias\": \"en_gb,en-gb,engb,gbgb,gben\",\n" +
                "            \"language\": \"en\",\n" +
                "            \"site\": \"gb\",\n" +
                "            \"standard\": \"en-GB\",\n" +
                "            \"standard_aspnet\": \"en-GB\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"zh_sg\",\n" +
                "            \"alias\": \"zh_sg,zh-sg,zhsg,sgzh\",\n" +
                "            \"language\": \"zh\",\n" +
                "            \"site\": \"sg\",\n" +
                "            \"standard\": \"zh-SG\",\n" +
                "            \"standard_aspnet\": \"zh-HK\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"en_jp\",\n" +
                "            \"alias\": \"en_jp,en-jp,enjp,jpen\",\n" +
                "            \"language\": \"en\",\n" +
                "            \"site\": \"jp\",\n" +
                "            \"standard\": \"en-JP\",\n" +
                "            \"standard_aspnet\": \"en-US\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"en_kr\",\n" +
                "            \"alias\": \"en_kr,en-kr,enkr,kren\",\n" +
                "            \"language\": \"en\",\n" +
                "            \"site\": \"kr\",\n" +
                "            \"standard\": \"en-KR\",\n" +
                "            \"standard_aspnet\": \"en-US\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"en_my\",\n" +
                "            \"alias\": \"en_my,en-my,enmy,myen\",\n" +
                "            \"language\": \"en\",\n" +
                "            \"site\": \"my\",\n" +
                "            \"standard\": \"en-MY\",\n" +
                "            \"standard_aspnet\": \"en-MY\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"en_id\",\n" +
                "            \"alias\": \"en_id,en-id,enid,iden\",\n" +
                "            \"language\": \"en\",\n" +
                "            \"site\": \"id\",\n" +
                "            \"standard\": \"en-ID\",\n" +
                "            \"standard_aspnet\": \"en-US\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"en_th\",\n" +
                "            \"alias\": \"en_th,en-th,enth,then\",\n" +
                "            \"language\": \"en\",\n" +
                "            \"site\": \"th\",\n" +
                "            \"standard\": \"en-TH\",\n" +
                "            \"standard_aspnet\": \"en-US\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"pl_pl\",\n" +
                "            \"alias\": \"pl_pl,plpl,pl-pl\",\n" +
                "            \"language\": \"pl\",\n" +
                "            \"site\": \"pl\",\n" +
                "            \"standard\": \"pl-PL\",\n" +
                "            \"standard_aspnet\": \"pl-PL\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"tr_tr\",\n" +
                "            \"alias\": \"tr_tr,trtr,tr-tr\",\n" +
                "            \"language\": \"tr\",\n" +
                "            \"site\": \"tr\",\n" +
                "            \"standard\": \"tr-TR\",\n" +
                "            \"standard_aspnet\": \"tr-TR\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"pt_br\",\n" +
                "            \"alias\": \"pt_br,ptbr,pt-br,br_br,br-br\",\n" +
                "            \"language\": \"br\",\n" +
                "            \"site\": \"BR\",\n" +
                "            \"standard\": \"pt-BR\",\n" +
                "            \"standard_aspnet\": \"pt-BR\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"el_gr\",\n" +
                "            \"alias\": \"el_gr,elgr,el-gr,gr_gr,gr-gr\",\n" +
                "            \"language\": \"gr\",\n" +
                "            \"site\": \"GR\",\n" +
                "            \"standard\": \"el-GR\",\n" +
                "            \"standard_aspnet\": \"el-GR\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"nl_nl\",\n" +
                "            \"alias\": \"nl_nl,nlnl,nl-nl\",\n" +
                "            \"language\": \"nl\",\n" +
                "            \"site\": \"NL\",\n" +
                "            \"standard\": \"nl-NL\",\n" +
                "            \"standard_aspnet\": \"nl-NL\"\n" +
                "        }\n" +
                "    ]";

        JSONArray jsonArray = JSON.parseArray(json);
        StringBuffer result = new StringBuffer();
        for(int i=0;i<jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            result.append(jsonObject.getString("standard").toLowerCase()).append(",");
        }
        return result.toString();
    }

}
