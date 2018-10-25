package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * 每个人都喜欢有令人难忘的电话号码。要想让电话号码变得令人难忘的一种方法是拼出一个令人难忘的单词或短语。
 * 例如，你可以拨打滑铁卢大学的电话，拨打令人难忘的电话号码TUT-GLOP。
 * <p>
 * 有时只有一部分号码被用来拼写一个单词，例如，你可以拨打310-gino从Gino's订购披萨。
 * <p>
 * 要使电话号码令人难忘的另一种方法是以一种令人难忘的方式对数字进行分组。你可以从比萨饼小屋中订购比萨饼，
 * 方法是拨打他们的“3个10”，即号码3-10-10-10。
 * <p>
 * 电话号码的标准格式是七位的十进制数字，第三和第四位之间包含连字符（例如888-1200）。电话的键盘提供字母到数字的映射，如下所示：
 * <p>
 * A, B, C映射到2
 * <p>
 * D, E, F映射到3
 * <p>
 * G, H, I映射到4
 * <p>
 * J, K, L映射到5
 * <p>
 * M, N, O映射到6
 * <p>
 * P, R, S映射到7
 * <p>
 * T, U, V映射到8
 * <p>
 * W, X, Y映射到9
 * <p>
 * Q和Z没有映射。连接符不拨号，必要时可加上或去除。TUT-GLOP的标准格式是888-4567，310-GINO的标准格式是310-4466，
 * 3-10-10-10的标准格式是310-1010。
 * <p>
 * 当两个电话号码有相同的标准格式时是等价的（拨同样的号码）。
 * <p>
 * 你的公司正在编制本地企业的电话号码目录，作为质量控制的一部分，你需要检查没有两个（或多个）企业具有相同的电话号码。
 * <p>
 * <p>
 * 【输入形式】
 * <p>
 * 输入包括一个案例。输入的第一行为一个正整数，指定目录中电话号码的数目(最多100，000)。其余的各行列出目录中的电话号码，
 * 每个号码单独占一行。每个电话号码都是一个由十进制数字、大写字母(不包括Q和z)和连字符组成的字符串。字符串中的七个字符或是数字或是字母。
 * <p>
 * 【输出形式】
 * <p>
 * 对于出现超过一次的每个号码，按照标准格式每个输出一行，然后是空格，接着输出出现的次数。只出现1次的电话号码不输出。
 * <p>
 * 【样例输入】
 * <p>
 * 12
 * 4873279
 * ITS-EASY
 * 888-4567
 * 3-10-10-10
 * 888-GLOP
 * TUT-GLOP
 * 967-11-11
 * 310-GINO
 * F101010
 * 888-1200
 * -4-8-7-3-2-7-9-
 * 487-3279
 * <p>
 * 【样例输出】
 * <p>
 * 310-1010 2
 * 487-3279 4
 * 888-4567 3
 */
public class Test32 {
    private static final boolean commit = true;
    private static Map<Character, Integer> dic = null;

    private static void initDic() {
        dic = new HashMap<>();
        int mapNum = 2, cnt = 3;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (ch == 'Q' || ch == 'Z')
                continue;
            if (cnt == 0) {
                cnt = 3;
                mapNum++;
            }
            dic.put(ch, mapNum);
            cnt--;
        }
    }

    //获取标准格式电话
    private static String getStandardPhone(String phone) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phone.length(); i++) {
            char ch = phone.charAt(i);
            if (Character.isAlphabetic(ch)) {
                sb.append(dic.get(ch));
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.insert(3, '-').toString();
    }

    //程序入口
    public static void main(String[] args) {
        InputStream inputStream = null;
        //从文件流读取输入
        if (!commit) {
            try {
                inputStream = new FileInputStream("F:\\in.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            inputStream = System.in;
        }
        //初始化字典
        initDic();
        Scanner scanner = new Scanner(inputStream);
        //输入数据
        int phoneNum = scanner.nextInt();
        Map<String, Integer> standardPhoneCntMap = new HashMap<>();
        for (int i = 0; i < phoneNum; i++) {
            //获取标准形式号码
            String standardPhone = getStandardPhone(scanner.next());
            //不存在该电话
            if (standardPhoneCntMap.containsKey(standardPhone)) {
                int cnt = standardPhoneCntMap.get(standardPhone);
                standardPhoneCntMap.put(standardPhone, cnt + 1);
            } else {
                standardPhoneCntMap.put(standardPhone, 1);
            }
        }
        //输出结果
        for (Map.Entry<String, Integer> phone : standardPhoneCntMap.entrySet()) {
            if (phone.getValue() > 1) {
                System.out.println(phone.getKey() + " " + phone.getValue());
            }
        }
    }
}
