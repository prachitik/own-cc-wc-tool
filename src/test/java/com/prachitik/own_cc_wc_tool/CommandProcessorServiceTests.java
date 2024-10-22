//package com.prachitik.own_cc_wc_tool;
//
//import com.prachitik.own_cc_wc_tool.service.CommandProcessorService;
//import com.prachitik.own_cc_wc_tool.service.ccwcService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.io.ClassPathResource;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class CommandProcessorServiceTests {
//
//
//    @Mock
//    private ccwcService ccwcservice;
//
//    @InjectMocks
//    private CommandProcessorService commandProcessorService;
//
//    @Test
//    void testProcessCommandWithFile() throws Exception {
//        ClassPathResource resource = new ClassPathResource("test.txt");
//        String filePath = resource.getFile().getAbsolutePath();
//        commandProcessorService.setStandardInput(false);
//        //String filename = "test.txt";
//        String[] args = {"-l", "-w", filePath};
//
//        when(ccwcservice.getCountLines(filePath)).thenReturn(7145);
//        when(ccwcservice.getCountWords(filePath)).thenReturn(58164);
//
//        commandProcessorService.processCommand(args);
//
//        verify(ccwcservice).getCountLines(filePath);
//        verify(ccwcservice).getCountWords(filePath);
//    }
//}
