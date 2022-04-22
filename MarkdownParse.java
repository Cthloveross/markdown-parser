//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        if(markdown.length() == 0){
            toReturn = null;
        }
        else{
            int currentIndex = 0;
            // System.out.println(currentIndex);
            while(currentIndex < markdown.length()) {
                int openBracket = markdown.indexOf("[", currentIndex);
                int closeBracket = markdown.indexOf("]", openBracket);
                int openParen = markdown.indexOf("(", closeBracket);
                int closeParen = markdown.indexOf(")", openParen);
                
                 if(closeParen == -1){
                    System.out.println("invalid input");
                    break;
                }
                else if(closeBracket == -1){
                    System.out.println("invalid input");
                    break;
                }
                else if(openBracket == -1){
                    System.out.println("invalid input");
                    break;
                }
                else if(openParen == -1){
                    System.out.println("invalid input");
                    break;
                }
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
                // System.out.println(currentIndex);
            }
            if(toReturn.size() == 0){
                System.out.println("This file is empty");
            }

        }
       
        // System.out.println(currentIndex);

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
