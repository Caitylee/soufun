package com.qf.house.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author yangbo
 */
public  final class CommonUtil {


    private CommonUtil(){
        throw  new AssertionError();
    }


    /**
     * 生成随机字符串
     * @param len 字符长度
     * @return 随机字符串
     */
    public static String generateCode(int len){
        String str="1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder codeStr= new StringBuilder();
        for(int i=0;i<len;i++){
            codeStr.append(str.toCharArray()[(int) (Math.random() * str.length())]);
        }
        return codeStr.toString();
    }


    public static BufferedImage generateCodeImage(String code,int width,int height){
        BufferedImage bufferedImage=new BufferedImage(width,height,1);
        Graphics2D graphics2D= (Graphics2D) bufferedImage.getGraphics();
        graphics2D.setBackground(Color.pink);
        graphics2D.fillRect(0,0,width,height);
        graphics2D.setColor(Color.BLUE);
        int size=(width-10)/code.length();
        Random random=new Random();
        graphics2D.setFont(new Font("Arial",Font.BOLD,size));
        for (int i = 0; i <code.length() ; i++) {
            String currentChar=code.substring(i,i+1);
            graphics2D.drawString(currentChar, 5 + size * i, height / 2);
        }
        for (int i = 0; i < 40; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            graphics2D.drawLine(x, y, x + xl, y + yl);
        }
        return  bufferedImage;
    }
}

