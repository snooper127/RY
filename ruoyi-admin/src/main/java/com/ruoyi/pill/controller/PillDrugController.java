package com.ruoyi.pill.controller;

import java.util.List;

import com.ruoyi.pill.domain.PillFactory;
import com.ruoyi.pill.service.IPillFactoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.pill.domain.PillDrug;
import com.ruoyi.pill.service.IPillDrugService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品库，保存所有药品的信息Controller
 * 
 * @author Snp
 * @date 2023-10-23
 */
@Controller
@RequestMapping("/pill/drug")
public class PillDrugController extends BaseController
{
    private String prefix = "pill/drug";

    @Autowired
    private IPillDrugService pillDrugService;

    @Autowired
    private IPillFactoryService pillFactoryService;

    @RequiresPermissions("pill:drug:view")
    @GetMapping()
    public String drug()
    {
        return prefix + "/drug";
    }

    /**
     * 查询药品库，保存所有药品的信息列表
     */
    @RequiresPermissions("pill:drug:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PillDrug pillDrug)
    {
        startPage();
        List<PillDrug> list = pillDrugService.selectPillDrugList(pillDrug);
        return getDataTable(list);
    }

    /**
     * 导出药品库，保存所有药品的信息列表
     */
    @RequiresPermissions("pill:drug:export")
    @Log(title = "药品库，保存所有药品的信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PillDrug pillDrug)
    {
        List<PillDrug> list = pillDrugService.selectPillDrugList(pillDrug);
        ExcelUtil<PillDrug> util = new ExcelUtil<PillDrug>(PillDrug.class);
        return util.exportExcel(list, "药品库，保存所有药品的信息数据");
    }

    /**
     * 新增药品库，保存所有药品的信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存药品库，保存所有药品的信息
     */
    @RequiresPermissions("pill:drug:add")
    @Log(title = "药品库，保存所有药品的信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PillDrug pillDrug)
    {
        return toAjax(pillDrugService.insertPillDrug(pillDrug));
    }

    /**
     * 修改药品库，保存所有药品的信息
     */
    @RequiresPermissions("pill:drug:edit")
    @GetMapping("/edit/{drugId}")
    public String edit(@PathVariable("drugId") Long drugId, ModelMap mmap)
    {
        PillDrug pillDrug = pillDrugService.selectPillDrugByDrugId(drugId);
        PillFactory pillFactory = new PillFactory();
        pillFactory.setFactoryName("");
//        List<PillFactory> pillFactoryList = pillFactoryService.selectPillFactoryList(pillFactory);
        mmap.put("pillDrug", pillDrug);
        mmap.put("Factory", pillFactoryService.selectPillFactoryByDrugId(drugId));
        mmap.put("pillFactoryList", pillFactoryService.selectPillFactoryList(pillFactory));
//        PillFactoryService.selectPillFactoryList()
        return prefix + "/edit";
    }

    /**
     * 修改保存药品库，保存所有药品的信息
     */
    @RequiresPermissions("pill:drug:edit")
    @Log(title = "药品库，保存所有药品的信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PillDrug pillDrug)
    {
        System.out.println("pillDrug = " + pillDrug);
        return toAjax(pillDrugService.updatePillDrug(pillDrug));
    }

    /**
     * 删除药品库，保存所有药品的信息
     */
    @RequiresPermissions("pill:drug:remove")
    @Log(title = "药品库，保存所有药品的信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pillDrugService.deletePillDrugByDrugIds(ids));
    }
}
