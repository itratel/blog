package com.yinhao.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import static com.yinhao.constant.Constants.JPG;
import static com.yinhao.constant.Constants.VERIFY_CODE;
import static com.yinhao.util.StrUtil.wrapperInt;

/**
 * <p>验证码图片控制层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
@WebServlet(name = "img", urlPatterns = {"/servlet/img"})
public class ImgServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //图像缓冲区
        BufferedImage bufferedImage = new BufferedImage(68, 25, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        //画背景框
        Color color = new Color(200, 215, 250);
        g.setColor(color);
        g.fillRect(0, 0, 68, 30);
        //第一个数字
        Random r = new Random();
        int tmp1 = r.nextInt(20);
        //设置随机颜色
        g.setColor(new Color(r.nextInt(100), r.nextInt(100), r.nextInt(100)));
        g.drawString(wrapperInt(tmp1), 3, 18);
        //加号
        //设置随机颜色
        g.setColor(new Color(r.nextInt(100), r.nextInt(100), r.nextInt(100)));
        g.drawString("+", 18, 18);
        //第二个数字
        int tmp2 = r.nextInt(20);
        //设置随机颜色
        g.setColor(new Color(r.nextInt(100), r.nextInt(100), r.nextInt(100)));
        g.drawString(wrapperInt(tmp2), 33, 18);
        //等号
        //设置随机颜色
        g.setColor(new Color(r.nextInt(100), r.nextInt(100), r.nextInt(100)));
        g.drawString("=", 48, 18);
        //问号
        //设置随机颜色
        g.setColor(new Color(r.nextInt(100), r.nextInt(100), r.nextInt(100)));
        g.drawString("?", 57, 18);
        //保存到session
        int result = tmp1 + tmp2;
        request.getSession().setAttribute(VERIFY_CODE, wrapperInt(result));
        //写入response输出流
        ImageIO.write(bufferedImage, JPG, response.getOutputStream());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
