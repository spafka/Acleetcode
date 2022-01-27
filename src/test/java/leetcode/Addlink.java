package leetcode;

import io.github.spafka.flink.FileUtils;
import io.vavr.collection.Stream;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @link {https://www.baidu.com}
 */
public class Addlink {

    public static void main(String[] args) {

        File file = new File("./Acleetcode/src/main/leettop/topinterviewquestions");


        File[] files = file.listFiles();
        String[] list = file.list();




   Arrays.stream(files).map(x->x.getAbsolutePath()).forEach(x->{

       String[] s = new File(x).getName().replaceAll(".java", "").split("_");
       String question = s[s.length - 1];

       String s1 = "https://leetcode-cn.com/problems/Q/";
       try {
           String java = FileUtils.readFileUtf8(new File(x));

           String[] split = java.split("\n");

           List<String> import_ed = Stream.ofAll(Arrays.stream(split)).takeUntil(l -> l.contains("class")).toJavaList();

          List<String > body= Stream.ofAll(Arrays.stream(split)).dropUntil(l -> l.contains("class")).toJavaList();

          import_ed.addAll(addLink(s1.replace("Q",
                  humpToLine2(question).replaceFirst("-",""))));
          import_ed.addAll(body);

          FileUtils.deleteFileOrDirectory(new File(x));

          org.apache.commons.io.FileUtils.writeStringToFile(new File(x),import_ed.stream().collect(Collectors.joining("\n")));

           System.out.println();

       } catch (IOException e) {
           e.printStackTrace();
       }

       System.out.println();
   });

        System.out.println();


    }

    private static Pattern linePattern = Pattern.compile("_(\\w)");
    /** 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)}) */
    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "-$0").toLowerCase();
    }
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /** 驼峰转下划线,效率比上面高 */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "-" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static List<String> addLink(String link){

        return Arrays.stream(("/**\n" +
                " * @link {url}\n" +
                " */\n").replaceAll("url", link).split("\n")).collect(Collectors.toList());
    }
}
