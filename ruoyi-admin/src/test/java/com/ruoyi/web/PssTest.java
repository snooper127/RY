package com.ruoyi.web;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.pill.domain.PillDrug;
import com.ruoyi.pill.domain.PillFactory;
import com.ruoyi.pill.service.IPillFactoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.ruoyi.common.utils.PageUtils.startPage;

@SpringBootTest
public class PssTest {

    @Autowired
    private IPillFactoryService iPillFactoryService;

    @Test
    public void testSelectFactory() {
        PillFactory pillFactory = new PillFactory();
        pillFactory.setFactoryName("");
//        pillFactory.setFactoryName("云");
//        pillFactory.setRemark("药");
        System.out.println("iPillFactoryService.selectPillFactoryList(pillFactory) = " + iPillFactoryService.selectPillFactoryList(pillFactory));

    }

    @Test
    public void testFactorylist() {
        PillFactory pillFactory = new PillFactory();
        pillFactory.setFactoryName("云");
        pillFactory.setRemark("药");
        startPage();
        List<PillFactory> pillFactoryList = iPillFactoryService.selectPillFactoryList(pillFactory);
        System.out.println("pillFactoryList = " + pillFactoryList);
    }

    @Test
    public void testPillFactoryByDrugId() {
        long myLongVariable = 1;

//        PillDrug pillDrug = new PillDrug();
//        pillDrug.setDrugId(myLongVariable);
        System.out.println("iPillFactoryService.selectPillFactoryByDrugId(\"1\") = " + iPillFactoryService.selectPillFactoryByDrugId(myLongVariable));

    }



}
