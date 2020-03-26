package utils.qrcode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author: sj.hu
 * @date: 2020/3/17 18:54
 **/
public class QrcodeUtil {

    public static void generate(String qrContent, int qrWidth, double logoRatio, String logo, String outPath) throws IOException {
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
        qrcode.setQrcodeErrorCorrect('Q'); // 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
        qrcode.setQrcodeVersion(0);//版本,取值范围1-40，值越大尺寸越大，可存储的信息越大
        byte[] contentBytes = qrContent.getBytes("utf-8"); //设置编码
        BufferedImage bfimg = new BufferedImage(qrWidth, qrWidth, BufferedImage.TYPE_INT_RGB);
        Graphics2D grap=bfimg.createGraphics();
        grap.setBackground(Color.WHITE);//设置背景色
        grap.setColor(Color.BLACK);//设置二维码颜色
        grap.clearRect(0, 0, qrWidth, qrWidth);//清除下画板内容
        int pixoff = 2;// 设置偏移量，不设置可能导致解析出错
        if (contentBytes.length>0&&contentBytes.length<800) {
            boolean[][] codeout=qrcode.calQrcode(contentBytes);//让字符串生成二维码
            int rectWidth = (qrWidth-pixoff) / codeout.length;
            for (int i = 0; i < codeout.length; i++) {
                for (int j = 0; j < codeout.length; j++) {
                    if (codeout[i][j]) {
                        grap.fillRect(i*rectWidth+pixoff, j*rectWidth+pixoff, rectWidth, rectWidth);
                    }
                }
            }
        }
        /***带logo开始***/
        Image img = ImageIO.read(new File(logo));// 实例化一个Image对象。
        int x = (int)(qrWidth-qrWidth*logoRatio)/2;
        int y =x;
        int width = (int)(qrWidth*logoRatio);
        int height = width;
        grap.drawImage(img, x, y, width, height, null);// 70,70是距离grap两个边的距离，60,60是中间logo的大小
        /****logo结束******/
        grap.dispose();
        bfimg.flush();
        ImageIO.write(bfimg, "png", new File(outPath));
    }
}
