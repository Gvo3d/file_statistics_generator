package org.yakimovdenis.webserver.server;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.yakimovdenis.webserver.WebServerApplication;
import org.yakimovdenis.webserver.controllers.RestFileController;
import org.yakimovdenis.webserver.dbconfig.TestJpaConfig;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;
import org.yakimovdenis.webserver.models.LineStatisticsResultEntity;
import org.yakimovdenis.webserver.service.WebStatisticsService;
import org.yakimovdenis.webserver.service.WebStatisticsServiceImpl;

import java.util.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@ContextConfiguration(classes = {WebServerApplication.class})
@SpringBootTest
public class RestServerTest {
    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    private FileStatisticsEntity fileStatisticsEntity;

    @MockBean
    private WebStatisticsServiceImpl webStatisticsService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(
                applicationContext).build();

        fileStatisticsEntity = new FileStatisticsEntity();
        fileStatisticsEntity.setFilename("test_file");
        fileStatisticsEntity.setId(5);
        fileStatisticsEntity.setUploadDate(new Date(System.currentTimeMillis()));
        Set<LineStatisticsResultEntity> lineSet = new HashSet<>();
        LineStatisticsResultEntity entity = new LineStatisticsResultEntity();
        entity.setLine("template is a word");
        entity.setShortestWord("a");
        entity.setLongestWord("template");
        entity.setAverageWordLength(4.4f);
        lineSet.add(entity);
        entity = new LineStatisticsResultEntity();
        entity.setLine("my name is denis");
        entity.setShortestWord("is");
        entity.setLongestWord("denis");
        entity.setAverageWordLength(3.7f);
        lineSet.add(entity);
        fileStatisticsEntity.setLineStatistics(lineSet);
    }

    @Test
    public void getOne() throws Exception {
        given(webStatisticsService.getFileStatistics(5)).willReturn(fileStatisticsEntity);
        mockMvc.perform(get("/files/one?id=5")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(5))).andExpect(MockMvcResultMatchers.jsonPath("$.filename", Matchers.is("test_file")));
    }

    @Test
    public void getList() throws Exception {
        List<FileStatisticsEntity> list = new ArrayList<>();
        list.add(fileStatisticsEntity);
        Page<FileStatisticsEntity> page = new PageImpl(list);
        given(webStatisticsService.getFileStatisticsList(0, 10, "id", true)).willReturn(page);
        mockMvc.perform(get("/files/list?page=0&quantity=10&sort=id&ascend=true")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(5)));
    }
}