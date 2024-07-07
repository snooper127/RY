package com.ruoyi.pill.controller;

import java.util.List;
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
import com.ruoyi.pill.domain.PillFactory;
import com.ruoyi.pill.service.IPillFactoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 保存所有厂商的信息Controller
 * 
 * @author Snp
 * @date 2023-10-23
 */
@Controller
@RequestMapping("/pill/factory")
public class PillFactoryController extends BaseController
{
    private String prefix = "pill/factory";

    @Autowired
    private IPillFactoryService pillFactoryService;

    @RequiresPermissions("pill:factory:view")
    @GetMapping()
    public String factory()
    {
        System.out.println("prefix + \"/factory\" = " + prefix + "/factory");
        return prefix + "/factory";
    }

    /**
     * 查询保存所有厂商的信息列表
     */
    @RequiresPermissions("pill:factory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PillFactory pillFactory)
    {
        startPage();
        List<PillFactory> list = pillFactoryService.selectPillFactoryList(pillFactory);
        System.out.println("list = " + list);
        return getDataTable(list);
    }

    /**
     * 导出保存所有厂商的信息列表
     */
    @RequiresPermissions("pill:factory:export")
    @Log(title = "保存所有厂商的信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PillFactory pillFactory)
    {
        List<PillFactory> list = pillFactoryService.selectPillFactoryList(pillFactory);
        ExcelUtil<PillFactory> util = new ExcelUtil<PillFactory>(PillFactory.class);
        return util.exportExcel(list, "保存所有厂商的信息数据");
    }

    /**
     * 新增保存所有厂商的信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存保存所有厂商的信息
     */
    @RequiresPermissions("pill:factory:add")
    @Log(title = "保存所有厂商的信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PillFactory pillFactory)
    {
        return toAjax(pillFactoryService.insertPillFactory(pillFactory));
    }

    /**
     * 修改保存所有厂商的信息
     */
    @RequiresPermissions("pill:factory:edit")
    @GetMapping("/edit/{factoryId}")
    public String edit(@PathVariable("factoryId") Long factoryId, ModelMap mmap)
    {
        PillFactory pillFactory = pillFactoryService.selectPillFactoryByFactoryId(factoryId);
        mmap.put("pillFactory", pillFactory);
        return prefix + "/edit";
    }

    /**
     * 修改保存保存所有厂商的信息
     */
    @RequiresPermissions("pill:factory:edit")
    @Log(title = "保存所有厂商的信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PillFactory pillFactory)
    {
        return toAjax(pillFactoryService.updatePillFactory(pillFactory));
    }

    /**
     * 删除保存所有厂商的信息
     */
    @RequiresPermissions("pill:factory:remove")
    @Log(title = "保存所有厂商的信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pillFactoryService.deletePillFactoryByFactoryIds(ids));
    }
}
