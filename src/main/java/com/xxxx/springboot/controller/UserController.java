package com.xxxx.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.xxxx.springboot.exceptions.ParamsException;
import com.xxxx.springboot.model.ResultInfo;
import com.xxxx.springboot.query.UserQuery;
import com.xxxx.springboot.service.UserService;
import com.xxxx.springboot.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/*import javax.validation.Valid;*/

@RestController
@Api(tags = "用户模块管理")
public class UserController {

    @Resource
    private UserService userService;

  /*  @GetMapping("user/uname/{userName}")
    @ApiOperation(value = "用户模块-根据用户名查询用户记录")
    @ApiImplicitParam(name = "userName", value = "查询参数", required = true, paramType = "path")
    public User queryUserByUserName(@PathVariable String userName) {
        //System.out.println("查询参数:userName-->"+userName);
        return userService.queryUserByUserName(userName);
    }


    @GetMapping("user/{userId}")
    @ApiOperation(value = "用户模块-根据用户id 查询用户记录")
    @ApiImplicitParam(name = "userId", value = "查询参数", required = true, paramType = "path")
    public User queryUserByUserId(@PathVariable Integer userId) {
        return userService.queryUserByUserId(userId);
    }


    @GetMapping("user/list")
    @ApiOperation(value = "用户模块-用户列表查询")
    public PageInfo<User> queryUsersByParams(UserQuery userQuery) {
        return userService.queryUsersByParams(userQuery);
    }
*/

    @PutMapping("user")
    @ApiOperation(value = "用户模块-用户添加")

    public ResultInfo saveUser(@RequestBody User user) {
        //获取ResultInfo对象
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.saveUser(user);
        } catch (ParamsException e) {
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
            e.printStackTrace();
        } catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg("用户添加失败!");
            e.printStackTrace();
        }
        return resultInfo;
    }


    /*@PostMapping("user")
    @ApiOperation(value = "用户模块-用户更新")
    public ResultInfo updateUser(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.updateUser(user);
        } catch (ParamsException e) {
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
            e.printStackTrace();
        } catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg("用户更新失败!");
            e.printStackTrace();
        }
        return resultInfo;
    }

    @DeleteMapping("user/{userId}")
    @ApiOperation(value = "用户模块-用户删除")
    public ResultInfo delete(@PathVariable Integer userId) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            userService.delete(userId);
        } catch (ParamsException e) {
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
            e.printStackTrace();
        } catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg("用户删除失败!");
            e.printStackTrace();
        }
        return resultInfo;
    }


    @PutMapping("user02")
    @ApiOperation(value = "用户模块-用户添加")
    public ResultInfo saveUser02(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();
        userService.saveUser(user);
        return resultInfo;
    }


    @PostMapping("user03")
    @ApiOperation(value = "用户模块-用户添加")
    public ResultInfo saveUser03(@Valid User user) {
        ResultInfo resultInfo = new ResultInfo();
        userService.saveUser(user);
        return resultInfo;
    }
*/
}
