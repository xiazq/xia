//package com.example.demo2;
//
//import com.example.demo2.entity.Order;
//import com.example.demo2.entity.Users;
//import com.example.demo2.service.OrderService;
//import com.example.demo2.service.impl.UsersServiceImpl;
//import com.mongodb.DB;
//import com.mongodb.MongoClient;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import redis.clients.jedis.Jedis;
//
//import java.net.UnknownHostException;
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Demo2Application.class)
//class Demo2ApplicationTests {
//    @Autowired
//    UsersServiceImpl usersService;
//
//    @Autowired
//    OrderService orderService;
//    @Test
//    void contextLoads() {
//        Users users=new Users();
////        for (int i = 2; i < 100; i++) {
//            users.setName("夏志强"+99);
//            users.setAge(99);
//            users.setSex(1);
//            users.setId(99);
//            usersService.update(users);
////        }
//    }
//
//    @Test
//    void fenye(){
//        List<Users> fenye = usersService.fenye(5,5);
//        for (Users users : fenye) {
//            System.out.println(users.getId());
//        }
//    }
//
//
//    @Test
//    void selectByShang(){
//
//    }
//
//
//
//    @Test
//    void orderUpdate(){
//        Order order = new Order();
//        order.setUserName("66");
//        orderService.insert(order);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @Test
//    void first(){
//        Jedis jedis = new Jedis("192.168.8.167", 6379);
//        jedis.set("xiaomi","100");
//        System.out.println(jedis.get("xiaomi"));
//    }
//
//    @Test
//    void mongodb() throws UnknownHostException {
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        DB db = mongoClient.getDB("mydb");
//        String name = db.getName();
//        System.out.println(name);
//    }
//
//}
