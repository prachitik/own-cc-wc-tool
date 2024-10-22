//package com.prachitik.own_cc_wc_tool;
//
//import com.prachitik.own_cc_wc_tool.service.CommandProcessorService;
//import com.prachitik.own_cc_wc_tool.service.ccwcService;
//import org.junit.jupiter.api.*;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import static org.mockito.Mockito.*;
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//class OwnCcWcToolApplicationTests {
//
//    @Mock
//    private ccwcService ccwcservice;
//
//    @Mock
//    private CommandProcessorService commandProcessorService;
//
//    //@InjectMocks
//    //private OwnCcWcToolApplication ownCcWcToolApplication;
//
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        //Mockito.doNothing().when(ownCcWcToolApplication).run(Mockito.any());
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @AfterEach
//    public void tearDown(){
//        System.setOut(originalOut);
//    }
//
////        @Test
////	void contextLoads() {
////	}
////    @Disabled
////    @Test
////    @DisplayName("Should process standard input correctly")
////    void testRunWithStandardInput() throws Exception {
////        String[] args = {"-l", "-w"};
////        String input = "Hello World\nThis is a test\nEOF\n";
////
////        System.setIn(new ByteArrayInputStream(input.getBytes()));
////
////        when(ccwcservice.getCountLinesStdInput(anyString())).thenReturn(2);
////        when(ccwcservice.getCountWordsStdInput(anyString())).thenReturn(5);
////
////        ownCcWcToolApplication.run(args);
////
////        verify(ccwcservice).getCountLinesStdInput(anyString());
////        verify(ccwcservice).getCountWordsStdInput(anyString());
////        assertEquals("Hello, Welcome to ccwc tool!\nEnter your input now.. and please end your input with \"EOF\" on new line\n 2 5", outContent.toString().trim());
////    }
//
//    @Test
//    void testProcessCommandWithFile() throws IOException {
//        CommandProcessorService commandProcessorService = new CommandProcessorService(false, null);
//        ClassPathResource resource = new ClassPathResource("test.txt");
//        String filePath = resource.getFile().getAbsolutePath();
//        String[] args = {"-l", filePath};
//
//        // Mock the service methods
//        when(ccwcservice.getCountLines(filePath)).thenReturn(7145);
//        when(ccwcservice.getCountWords(filePath)).thenReturn(58164);
//        when(ccwcservice.getCountBytes(filePath)).thenReturn(342190);
//        when(ccwcservice.getCountChars(filePath)).thenReturn(339292);
//
//        commandProcessorService.processCommand(args);
//
//        verify(ccwcservice).getCountLines(filePath);
//        verify(ccwcservice, never()).getCountWords(filePath);
//        verify(ccwcservice, never()).getCountBytes(filePath);
//        verify(ccwcservice, never()).getCountChars(filePath);
//    }
//
////    @Disabled("This test requires user input and is disabled to avoid blocking the build")
////    @Test
////    void testProcessCommandWithStandardInput() throws IOException {
////        String[] args = {"-l", "-w", "-c"};
////        String input = "Hello World\nThis is a test\nEOF\n";
////        // Simulate user input
////        System.setIn(new ByteArrayInputStream(input.getBytes()));
////
////        // Mock the service methods
////        when(ccwcservice.getCountLinesStdInput(anyString())).thenReturn(2);
////        when(ccwcservice.getCountWordsStdInput(anyString())).thenReturn(5);
////        when(ccwcservice.getCountBytesStdInput(anyString())).thenReturn(25);
////        when(ccwcservice.getCountCharsStdInput(anyString())).thenReturn(24);
////
////        ownCcWcToolApplication.processCommand(true, null, args);
////
////        verify(ccwcservice).getCountLinesStdInput(anyString());
////        verify(ccwcservice).getCountWordsStdInput(anyString());
////        verify(ccwcservice).getCountBytesStdInput(anyString());
////        verify(ccwcservice).getCountCharsStdInput(anyString());
////    }
//
////    @Disabled("This test requires user input and is disabled to avoid blocking the build")
////    @Test
////    void testReadFromFileWithOptions() throws IOException {
////        CommandOptions commandOptions = new CommandOptions();
////        commandOptions.getOptions().add(ccwcCommandOption.fromStringToOption("-l"));
////        commandOptions.getOptions().add(ccwcCommandOption.fromStringToOption("-w"));
////
////        ClassPathResource resource = new ClassPathResource("test-data.json");
////        String filePath = resource.getFile().getAbsolutePath();
////
////        // Mock the service methods
////        when(ccwcservice.getCountLines(filePath)).thenReturn(7145);
////        when(ccwcservice.getCountWords(filePath)).thenReturn(58164);
////
////        ownCcWcToolApplication.readFromFileWithOptions(commandOptions, filePath);
////
////        String expectedOutput = "7145   58164 " + filePath + "\n";
////
////        assertEquals(expectedOutput, outContent.toString().trim());
////    }
//
//}
