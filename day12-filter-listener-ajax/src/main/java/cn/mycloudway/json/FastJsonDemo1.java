package cn.mycloudway.json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class FastJsonDemo1 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "zhangsan", "123");
        User user2 = new User(2, "lisi", "234");

        users.add(user1);
        users.add(user2);

        System.out.println(JSON.toJSONString(users));

        User user3 = JSON.parseObject("{\"id\":2,\"password\":\"234\",\"username\":\"lisi\"}", User.class);
        System.out.println(user3);
    }
}
