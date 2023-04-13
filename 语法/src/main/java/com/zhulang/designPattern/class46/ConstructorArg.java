package com.zhulang.designPattern.class46;

import java.util.Objects;

/**
 * 在下面的 ConstructorArg 类中，
 * 当 isRef 为 true 的时候，
 * arg 表示 String 类型的 refBeanId，
 * type 不需要设置；
 * 当 isRef 为 false 的时候，
 * arg、type 都需要设置。
 * 请根据这个需求，完善 ConstructorArg 类。
 * @Author zhulang
 * @Date 2023-04-07
 **/
public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;
    // TODO: 待完善...
    private ConstructorArg(Builder builder) {
        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;
    }

    public static class Builder {
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArg build() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (isRef && !(arg instanceof String)) {
                throw new IllegalArgumentException("需要为字符串");
            }
            if (!isRef && (Objects.isNull(type) || Objects.isNull(arg))) {
                throw new IllegalArgumentException("缺少参数");
            }
            return new ConstructorArg(this);
        }

        public Builder setIsRef(boolean isRef) {
            this.isRef = isRef;
            return this;
        }

        public Builder setArg(Object arg) {
            this.arg = arg;
            return this;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

    }

    public static void main(String[] args) {
        // 这段代码会抛出IllegalArgumentException，因为minIdle>maxIdle
        ConstructorArg arg = new ConstructorArg.Builder()
                .setIsRef(true)
                .setArg("16")
//                .setType(String.class)
                .build();
        System.out.println(arg);
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
