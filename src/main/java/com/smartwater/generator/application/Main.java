package com.smartwater.generator.application;

import com.smartwater.generator.invoker.SingleInvoker;
import com.smartwater.generator.invoker.base.Invoker;

/**
 *
 * Date   2019/05/16
 * Description 主函数 运行该类会自动按照配置生成java代码
 *
 */
public class Main {

    public static void main(String[] args) {
        single();
    }

//    public static void many2many() {
//        Invoker invoker = new Many2ManyInvoker.Builder()
//                .setTableName("user")
//                .setClassName("User")
//                .setParentTableName("role")
//                .setParentClassName("Role")
//                .setRelationTableName("user_role")
//                .setForeignKey("userId")
//                .setParentForeignKey("roleId")
//                .build();
//        invoker.execute();
//    }
//
//    public static void one2many() {
//        Invoker invoker = new One2ManyInvoker.Builder()
//                .setTableName("user")
//                .setClassName("User")
//                .setParentTableName("office")
//                .setParentClassName("Office")
//                .setForeignKey("officeId")
//                .build();
//        invoker.execute();
//    }

    public static void single() {
        Invoker invoker = new SingleInvoker.Builder()
                .setTableName("user")
                .setClassName("User")
                .build();
        invoker.execute();
    }

}
