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

    public static void single() {
        Invoker invoker = new SingleInvoker.Builder()
                .setTableName("user_copy")
                .setClassName("UserCopy")
                .build();
        invoker.execute();
    }

}
