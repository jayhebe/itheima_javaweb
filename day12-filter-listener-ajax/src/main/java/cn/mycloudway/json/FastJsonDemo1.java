package cn.mycloudway.json;

import com.alibaba.fastjson.JSON;

public class FastJsonDemo1 {
    public static void main(String[] args) {
        User user1 = new User(1, "zhangsan", "123");
        System.out.println(JSON.toJSONString(user1));

        User user2 = JSON.parseObject("{\"id\":2,\"password\":\"234\",\"username\":\"lisi\"}", User.class);
        System.out.println(user2);
    }
}
