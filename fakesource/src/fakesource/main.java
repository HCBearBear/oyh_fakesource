package fakesource;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class main {
    public static void main(String[] args) {
        String outputPath = System.getProperty("user.home") + "/test/fakesource/";
//        String fileName = outputPath + "HEALTH_PD_06_2018.txt";
//        String fileName = outputPath + "HEALTH_PP_06_2018.txt";
//        String fileName = outputPath + "HEALTH_LL_06_2018.txt";
//        String fileName = outputPath + "HEALTH_LD_06_2018.txt";
        String fileName = outputPath + "HEALTH_LT_06_2018.txt";
        
//        StringBuilder text = new StringBuilder();// 
//        StringBuilder text = new StringBuilder(233);// PD
//        StringBuilder text = new StringBuilder(197);// PP
//        StringBuilder text = new StringBuilder(214);// LL
//        StringBuilder text = new StringBuilder(191);// LD
        StringBuilder text = new StringBuilder(209);// LT
        
        //lt
        text.insert(0,"06"); // 公司代碼
        text.insert(2, rightPad("206311AA2K00021Z21D10000000",27,"")); // 保險商品編號 // 8,15,27
        text.insert(29, "1"); // 資料別
        text.insert(30, "000000000000000"); // 資料筆數
        text.insert(45, "000000000000000"); // 總計一
        text.insert(60, "000000000000000"); // 總計二
        text.insert(75, "000000000000000"); // 總計三
        text.insert(90, "00000000000001000000"); // 總計四
        text.insert(110, "00000000000100100000"); // 總計五
        text.insert(130, "2019"); // 填報年度
        text.insert(134, "000000000000000"); // 保留欄位1
        text.insert(149, "000000000000000"); // 保留欄位2
        text.insert(164, "000000000000000"); // 保留欄位3
        text.insert(179, "000000000000000"); // 保留欄位4
        text.insert(194, "000000000000000"); // 保留欄位5
        
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(text.toString());
            printWriter.close();
            System.out.println("成功寫入檔案。檔案位置：" + fileName);
        } catch (IOException e) {
            System.out.println("寫入檔案時發生錯誤：" + e.getMessage());
        }

    }
    
    public static String rightPad(String input, int length, String padStr) {

        if(input == null || padStr == null){
          return null;
        }

        if(input.length() >= length){
          return input;
        }

        int padLength = length - input.length();

        StringBuilder paddedString = new StringBuilder();
        paddedString.append(input);
        paddedString.append(StringUtils.rightPad("", padLength));

        return paddedString.toString();
      }

}
