package com.qqycc.enums;

/**
 * Author: qqy
 */
public enum Gender {
    FEMALE("女"),MALE("男");
    private String type;
    Gender(String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public String toString(){
        return  "性别："+this.getType()+" "+this.name().toLowerCase();
    }

    public static void main(String[] args) {
        try {
           Gender gender= Gender.valueOf(args[0].toUpperCase());
            System.out.println(gender);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("需要指定参数："+e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("指定对象的类型错误！");
        }
    }
}
