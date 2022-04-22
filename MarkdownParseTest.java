import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;


import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition(){
        assertEquals(2,1+1);
    }
    @Test
    public void readfiles() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-thing.html"), MarkdownParse.getLinks(content));
    }
    @Test
    public void readfiles2() throws IOException{
        Path fileName = Path.of("test_file_1.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://twitter.com"), MarkdownParse.getLinks(content));
    }

    @Test
    public void readfiles3() throws IOException{
        Path fileName = Path.of("testfile2.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("I love playing video games","I hate u","dog.png"), MarkdownParse.getLinks(content));
    }
    
}
