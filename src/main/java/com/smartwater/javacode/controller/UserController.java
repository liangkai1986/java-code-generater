package com.smartwater.javacode.controller;

import com.smartwater.javacode.entity.User;
import com.smartwater.javacode.service.UserService;

import java.util.List;

import cn.smartwatercloud.smartwater.common.controller.BaseController;
import cn.smartwatercloud.smartwater.common.controller.ResponseCode;
import cn.smartwatercloud.smartwater.common.entity.ResponseData;
import cn.smartwatercloud.smartwater.common.entity.TableData;

import com.github.pagehelper.PageInfo;

import lombok.AllArgsConstructor;

import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import tk.mybatis.mapper.entity.Example;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Author LiangKai
 * Date 2019-05-20
 */

@RestController
@EnableAutoConfiguration
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController extends BaseController<User, User>{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /***
    * 列表分页查询
    * @param query
    * @return
    */
    @ApiOperation(value="分页查询User列表信息", notes="根据User对象的属性查询User列表信息")
    @ApiImplicitParam(name = "User", value = "User对象", required = true, dataType = "User")
    @PostMapping("/page")
    @Override
    protected ResponseData<TableData<User>> queryRecord(@RequestBody User query){
        logger.debug("分页查询User数据列表");
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        //TODO 此处需要自己添加实际的查询条件
        //=============================Start=================================
        if (!StringUtils.isEmpty("实体类的查询参数")) {
            criteria.andLike("查询参数名称", "%" + "实体类的查询参数" + "%");
        }
        //=============================End===================================
        PageInfo<User> pageInfo = userService.selectByExampleList(example, query.getPageNum(), query.getPageSize());
        return getTableData(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), pageInfo);
    }

    /***
    * 添加实体对象
    * @param record
    * @return
    */
    @ApiOperation(value="保存User信息", notes="保存User信息")
    @ApiImplicitParam(name = "User", value = "User对象", required = true, dataType = "User")
    @PostMapping("/add")
    @Override
    protected ResponseData<User> addRecord(@RequestBody User record) {
        logger.debug("添加User数据");
        try {
            //TODO 将实体对象赋值主键
            //record.setID(uidGenerator.getUIDString());
            userService.insertSelective(record);
        } catch (Exception e) {
            logger.error("添加User数据失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    /***
    * 删除实体对象
    * @param record
    * @return
    */
    @ApiOperation(value="删除User信息", notes="根据List<User>列表删除User信息")
    @ApiImplicitParam(name = "User", value = "List<User>集合", required = true, dataType = "List<User>")
    @PostMapping("/delete")
    @Override
    protected ResponseData<User> deleteRecord(@RequestBody List<User> record) {
        logger.debug("删除User");
        try {
            userService.deleteBatchByPrimaryKey(record);
        } catch (Exception e) {
            logger.error("删除User失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    /***
    * 更新实体对象
    * @param record
    * @return
    */
    @ApiOperation(value="更新User信息", notes="根据User更新User信息")
    @ApiImplicitParam(name = "User", value = "User对象", required = true, dataType = "User")
    @PostMapping("/update")
    @Override
    protected ResponseData<User> updateRecord(@RequestBody User record){
        logger.debug("更新User");
        try {
            userService.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            logger.error("更新User失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

}
