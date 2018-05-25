package com.cat.utils;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.cat.service.user.IUserService;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.OpenSSHConfig;
import com.jcraft.jsch.Session;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;


/**
 * @author wangxiaoqiang
 * @since 2018/05/06
 **/
public class DubboUtil {
    public static void main(String[] args) throws Exception {
        JSch jsch = new JSch();
        jsch.setConfigRepository(OpenSSHConfig.parseFile("~/.ssh/config"));
        Session session = jsch.getSession("jhost");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        session.setPortForwardingL(InetAddress.getLocalHost().getHostAddress(), 1080, "10.171.220.198", 20880); //替换为服务提供方dubbo地址，可以通过dubbo管理控制台查找
        RpcContext.getContext().setAttachment("token", "hello_souche_token"); //默认是souche_http_token ，各服务提供方可能会自定义token，lease项目是:hello_souche_token

        ReferenceConfig<IUserService> ref1 = new ReferenceConfig<>();
        List<RegistryConfig> registryConfigList = new ArrayList<>();
        ref1.setRegistries(registryConfigList);
        ref1.setApplication(new ApplicationConfig("yy"));
        ref1.setInterface(IUserService.class);
        ref1.setVersion("1.1.0"); //服务的版本号
        ref1.setTimeout(100000);
        ref1.setUrl("dubbo://localhost:1080");
        IUserService userService = ref1.get();
        System.out.println(userService.findUserByProperty(null));
        ref1.destroy();
        session.disconnect();
        System.exit(0);


    }
}
