package com.fantasybaby.normaltest.java8test.lambadatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fantasybaby.normaltest.lombok.UserBean;

/**
 * @author liuxi
 * @date2017年12月21日 16:43
 */
public class LambadaTest {
    List<UserBean> userBeans = new ArrayList<>();
    public LambadaTest(){
        UserBean u1 = new UserBean();
        u1.setId(1);
        u1.setAge(3);
        u1.setUserName("xixi");
        userBeans.add(u1);
        UserBean u2 = new UserBean();
        u2.setId(2);
        u2.setAge(4);
        u2.setUserName("hehe");
        userBeans.add(u2);
        UserBean u3 = new UserBean();
        u3.setId(3);
        u3.setAge(5);
        u3.setUserName("xixi");
        userBeans.add(u3);
        UserBean u4 = new UserBean();
        u4.setId(4);
        u4.setAge(4);
        u4.setUserName("hehe");
        userBeans.add(u4);
        userBeans.add(u3);
        UserBean u5 = new UserBean();
        u5.setId(5);
        u5.setAge(6);
        u5.setUserName("jiji");
        userBeans.add(u5);
    }

    /**
     * 通过stream()把一个集合的某一个属性变成key
     *
     */
    public void testGroupBy(){
        Map<String, List<UserBean>> collect = userBeans.stream().collect(
            Collectors.groupingBy(UserBean::getUserName));
        Set<String> strings = collect.keySet();
        for (String key:
            strings) {
            List<UserBean> userBeans1 = collect.get(key);
            System.out.println("userName:"+key);
            for (UserBean userBean:
                userBeans1) {
                System.out.println(userBean.getAge());
                System.out.println(userBean.getUserName());

            }
            System.out.println("-----------");
        }
    }

    /**
     * 通过stream()把一个集合的某一个属性变成key
     * 然后看是否会影响之前的list
     *
     */
    public void testGroupByChangeValue(){
        Map<Integer, List<UserBean>> collect = userBeans.stream().collect(
            Collectors.groupingBy(UserBean::getId));
        Set<Integer> strings = collect.keySet();
        for (Integer key:
            strings) {
            List<UserBean> userBeans1 = collect.get(key);
            UserBean userBean = userBeans1.get(0);
            userBean.setUserName("newName");

            System.out.println("-----------");
        }
        userBeans.stream().forEach(System.out::print);
    }

    /**
     * 通过stream()把集合的属性输出到一个List里面
     */
    public void testPutFiledInList(){
        userBeans.stream().map(UserBean::getUserName).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    public void testAnyMatch(){
        List<String> names = new ArrayList<>();
        names.add("jiji");
        names.add("hehe");
        List<UserBean> matchBeans = userBeans.stream().filter(
            userBean -> names.stream().anyMatch(name -> userBean.getUserName().equalsIgnoreCase(name)))
            .collect(Collectors.toList());
        for (UserBean matchBean:
        matchBeans) {
            System.out.println(matchBean);

        }

    }
    public void testStringArrayToLong(){
        String str = "1,2,3,4,5,6";
        List<Long> longArrays = Arrays.stream(str.split(",")).map(sowTaskId -> Long.valueOf(sowTaskId))
            .collect(Collectors.toList());
        longArrays.forEach( System.out::println);
    }

    public void testLambaArr(){
        List<UserBean> u1s = new ArrayList<>();
        List<UserBean> u2s = new ArrayList<>();
        u1s.stream().forEach(u1 ->u2s.stream().forEach(u2 ->{

            })
        );
    }
    public void testNotEmpty(){
        List<String> collect = userBeans.stream().map(user -> getValue()).filter(a-> a != null).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
    private static int a = 0;
    private String getValue(){
        a++;
        if(a == 3){
            return null;
        }else{
            return a+"";
        }
    }

    /**
     * jdk1.8排序练习
     */
    public  void testComparator(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, Comparator.reverseOrder());
        names.forEach(System.out::println);
    }

    /**
     * predicate使用
     */
    public void testPredicate(){
        Predicate<String> predicate  = (a)->a.substring(0,1).equals("a");
        boolean testAnser = predicate.test("ahello");

        System.out.println(testAnser);
    }

    /**
     * function接口测试
     */
    public void testFunction(){
        Function<String,Integer> function = Integer::valueOf;
        Integer applyValue = function.apply("123");
        System.out.println(applyValue);
        Function<Integer,String> function1 = (s)->s+"hehe";
        Function<String, String> functionNew = function.andThen(function1);
        System.out.println(functionNew.apply("1231"));
    }
    public static void main(String[] args) {
        LambadaTest lambadaTest = new LambadaTest();
        //lambadaTest.testGroupByChangeValue();
        //lambadaTest.testStringArrayToLong();
        //lambadaTest.testGroupBy();
        //lambadaTest.testPutFiledInList();
       //lambadaTest.testAnyMatch();
       // lambadaTest.testNotEmpty();
       // lambadaTest.testComparator();
       // lambadaTest.testPredicate();
        lambadaTest.testFunction();
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            System.out.println(r.nextInt(4));
        }
    }
}
