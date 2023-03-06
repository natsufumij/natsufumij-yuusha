package hut.natsufumij.yuusha.util.coder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class BaseCodeUtil {

    /**
     * 分割点位置 混淆字串分割点前部分 字符串  混淆字串分割点后部分
     * @return
     */
    private static String generate10(){
        Random random=new Random();
        char[] array = new char[10];
        for(int i=0;i<10;++i){
            int r=random.nextInt(52);
            if(r>26){
                array[i]= (char) ('A'+(r-26));
            }else{
                array[i]= (char) ('a'+r);
            }
        }
        return new String(array);
    }

    public static String encodeNum(String text){
        String fix = generate10();
        Random random = new Random();
        int index = random.nextInt(10);
        int last = text.length()+index;
        String hex = Integer.toHexString(last);
        if(hex.length()==1){
            hex="0"+hex;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(index);
        builder.append(hex);
        builder.append(fix.substring(0,index));
        builder.append(text);
        builder.append(fix.substring(index));
        String middle = builder.toString();
        String result = encode(middle);
        return result;
    }

    public static String encode(String text){
        byte[] encodes= Base64.getEncoder().encode(text.getBytes(StandardCharsets.UTF_8));
        return new String(encodes,StandardCharsets.UTF_8);
    }
    public static String decode(String word){
        byte[] decodes = Base64.getDecoder().decode(word.getBytes(StandardCharsets.UTF_8));
        return new String(decodes,StandardCharsets.UTF_8);
    }
    public static String decodeNum(String word){
        String middle = decode(word);
        char f = middle.charAt(0);
        String hex = middle.substring(1,3);
        int first = 3+f-'0';
        int end = 3+Integer.parseInt(hex,16);
        String t = middle.substring(first,end);
        return t;
    }
    public static boolean checkPass(String text1,String text2){
        String t1 = decodeNum(text1);
        String t2 = decodeNum(text2);
        return t1.equals(t2);
    }

    public static void main(String[] args) {
        String checkNum = encodeNum("1234");
        String checkNum2 = encode("moeyui0624");

        String passw = encodeNum(decode(checkNum2));
        boolean result = checkPass(checkNum,passw);
        System.out.println();
    }
}
