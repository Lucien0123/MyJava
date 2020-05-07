package com.lucien.javacode.内部类;

import org.apache.commons.lang3.StringUtils;

public class ThePartInnerClass {

    public Destionation destionation(String str) {
        /* 1、定义在方法内：需要实现/继承自外面的一个接口/类，否则方法的返回值无法确定（作用域只在本方法内） */
        class PDestionation implements Destionation {
            private String label;

            private PDestionation(String whereTo) {
                this.label = whereTo;
            }

            public String readLabel() {
                return label;
            }
        }

        /* 2、定义在一个代码块中：作用域只在代码块中 */
        if (StringUtils.isNotBlank(str)) {
            class TrackingSlip {
                private String id;
                TrackingSlip(String a) {
                    this.id = a;
                }
                String getSlip() {
                    return id;
                }
            }
            TrackingSlip trackingSlip = new TrackingSlip(str);
            String trackStr = trackingSlip.getSlip();
        }

        return new PDestionation(str);
    }

    public static void main(String[] args) {
        ThePartInnerClass obj = new ThePartInnerClass();
        Destionation destionation = obj.destionation("huo");
    }
}

interface Destionation {

}
