package com.example.springbatchexample1.batch;

import com.example.springbatchexample1.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String,String> DEPT_NAMES =
            new HashMap<>();

    public Processor(){
        DEPT_NAMES.put("001","Technology");
        DEPT_NAMES.put("002","Operations");
        DEPT_NAMES.put("003","Accounts");
    }

    @Override
    public User process(User user) throws Exception {
        user.setDept(DEPT_NAMES.get(user.getDept()));
        System.out.println(String.format("Converted from [%s] to [%s]",user.getDept(),DEPT_NAMES.get(user.getDept())));
        return user;
    }
}
