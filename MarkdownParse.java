// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> ret = new ArrayList<>();
        String regex = "(?<!\\\\)\\[[a-zA-Z0-9_ ]+\\]\\((.*)\\)";
        
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(markdown);
        
        while (matcher.find()) {
            ret.add(matcher.group(3));
        }

        return ret;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
