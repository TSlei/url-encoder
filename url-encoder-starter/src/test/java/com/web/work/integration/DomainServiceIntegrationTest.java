package com.web.work.integration;

import javax.annotation.Resource;

import com.web.work.service.DomainService;
import com.web.work.util.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class DomainServiceIntegrationTest {

    @Resource
    private DomainService domainService;

    private String fullUrl = "https://www.baidu.com/ass/1344";

    @Before
    public void setUp() {}

    @Test
    public void should_create_and_get_full_domain_successfully() {
        String shortUrl = domainService.createShortDomain(fullUrl);
        String fullDomain = domainService.getFullDomain(shortUrl);
        assertThat(fullDomain).isEqualTo(fullUrl);
    }

}
