package com.github.interview.amazon;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 4/11/19 13:17
 * @Description:最小生成树
 */
public class CityConnection {
    /**
     * 全局Union编号
     */
    private static int unionNum = 0;

    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        //先把空的情形挡掉
        if (connections == null || connections.size() == 0) {
            return new ArrayList<>();
        }

        ArrayList<Connection> result = new ArrayList<>();
        //节点名为key,所属的Union编号为value
        Map<String, Integer> map = new HashMap<>();
        //这里把cost小的往前排。
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                return o1.cost - o2.cost;
            }
        });

        for (Connection c : connections) {
            String a = c.node1;
            String b = c.node2;
            //看城市是不是连过了，要是可以连，那么就在result里面加上
            if (union(map, a, b)) {
                result.add(c);
            }
        }
        //这里要检查一下,是不是所有的城市都属于同一个union
        String find = connections.get(0).node1;
        int union = map.get(find);
        for (String str : map.keySet()) {
            // 如果我们中出了一个叛徒，返回空表
            if (map.get(str) != union) {
                return new ArrayList<>();
            }
        }
        //这里最后要求按照城市的名字排序
        Collections.sort(result, (o1, o2) -> {
            if (o1.node1.equals(o2.node1)) {
                return o1.node2.compareTo(o2.node2);
            }
            return o1.node1.compareTo(o2.node1);
        });
        return result;
    }

    /**
     * 把边归类
     *
     * @param map
     * @param a
     * @param b
     * @return
     */
    private static boolean union(Map<String, Integer> map, String a, String b) {
        if (!map.containsKey(a) && !map.containsKey(b)) {
            map.put(a, unionNum);
            map.put(b, unionNum);
            //这里用了一个新的没用过的数字
            unionNum++;
            return true;
        }
        //只有一方落单,那就加入有组织的一方
        if (map.containsKey(a) && !map.containsKey(b)) {
            int aU = map.get(a);
            map.put(b, aU);
            return true;
        }
        if (!map.containsKey(a) && map.containsKey(b)) {
            int bU = map.get(b);
            map.put(a, bU);
            return true;
        }
        //两个人都有团伙的情况。
        int aU = map.get(a);
        int bU = map.get(b);
        //如果是自己人,那肯定要踢掉,否则成环了
        if (aU == bU) return false;
        //把所有对方的团伙都吃进来
        for (String s : map.keySet()) {
            if (map.get(s) == bU) map.put(s, aU);
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Connection> connections = new ArrayList<>();
        //下面的图是个苯环，中间加上了几根，如果想验证空表，去掉几根线就行。
        connections.add(new Connection("A", "B", 6));
        connections.add(new Connection("B", "C", 4));
        connections.add(new Connection("C", "D", 5));
        connections.add(new Connection("D", "E", 8));
        connections.add(new Connection("E", "F", 2));
        connections.add(new Connection("B", "F", 10));
        connections.add(new Connection("E", "C", 9));
        connections.add(new Connection("F", "C", 7));
        connections.add(new Connection("B", "E", 3));
        connections.add(new Connection("A", "F", 16));
        //这里就输出一下看看结果。
        ArrayList<Connection> res = getLowCost(connections);
        for (Connection c : res) {
            System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
        }
    }
}
