package com.github.interview.draftkings;

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        ConsoleProcessor processor = new ConsoleProcessor();
        processor.processAllLines();
    }
}


class ConsoleProcessor {


    public OrgChart orgChart = new OrgChart();


    public void processAllLines() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer numLines = 0;

        try {
            numLines = Integer.valueOf(line.trim());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < numLines; i++) {
            processLine(in.nextLine());
        }

        in.close();
    }


    protected void processLine(String line) {
        String[] parsedCommand = line.split(",");

        // ignore empty lines
        if (parsedCommand.length == 0) {
            return;
        }

        switch (parsedCommand[0]) {
            case "add":
                orgChart.add(parsedCommand[1], parsedCommand[2], parsedCommand[3]);
                break;
            case "print":
                orgChart.print();
                break;
            case "remove":
                orgChart.remove(parsedCommand[1]);
                break;
            case "move":
                orgChart.move(parsedCommand[1], parsedCommand[2]);
                break;
            case "count":
                System.out.println(orgChart.count(parsedCommand[1]));
                break;
        }
    }
}

/**
 * chart of the organization of department
 */
class OrgChart {

    public static final String DOUBLE_SPACE = "  ";
    /**
     * key is id of employee, value is employee
     */
    Map<String, Employee> idEmployeeMap = new HashMap<>();

    /**
     * key is manager id, value is the list of the id of reporters
     */
    Map<String, List<String>> relationMap = new HashMap<>();

    /**
     * key is the id of employee, value is the id of manager
     */
    Map<String, String> parentMap = new HashMap<>();


    /**
     * a virtual id of the manager of the employee in the top level
     */
    public final static String VIRTUAL_MANAGER_ID = "-1";

    public final static String LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * a chartBuffer area to store the OrgChart when we print it
     */
    private StringBuilder chartBuffer = new StringBuilder();

    /**
     * @param id
     * @param name
     * @param managerId
     */
    public void add(String id, String name, String managerId)


    {
        if (idEmployeeMap.containsKey(id)) {
            return;
        } else {
            //if the employee's manager has not been added, set it has no manager
            if (!idEmployeeMap.containsKey(managerId)) {
                managerId = VIRTUAL_MANAGER_ID;
            }
            Employee employee = new Employee(id, name, managerId);
            idEmployeeMap.put(id, employee);
            //maintain the relation map
            List<String> subordinateList = relationMap.getOrDefault(managerId, new LinkedList<>());
            subordinateList.add(id);
            relationMap.put(managerId, subordinateList);
            //maintain the parent map
            parentMap.put(id, managerId);

        }
    }

    /**
     * print the chart
     */
    public void print()


    {
        //from up to down
        //no employees
        if (idEmployeeMap.isEmpty()) {
            return;
        } else {
            List<String> subordinateList = relationMap.getOrDefault(VIRTUAL_MANAGER_ID, new LinkedList<>());
            for (int i = 0; i < subordinateList.size(); i++) {
                helper(subordinateList.get(i), 0);
                if (i != subordinateList.size() - 1) {
                    chartBuffer.append(LINE_SEPARATOR);
                }
            }
            System.out.println(chartBuffer.toString());
        }

    }

    /**
     * append the employee to the output result recursively
     *
     * @param employeeId id of employee
     * @param level      level of employee
     */
    private void helper(String employeeId, int level) {
        chartBuffer.append(generatePrefix(level));
        chartBuffer.append(idEmployeeMap.get(employeeId).toString());
        List<String> subordinateList = relationMap.getOrDefault(employeeId, new LinkedList<>());
        if (!subordinateList.isEmpty()) {
            chartBuffer.append(LINE_SEPARATOR);
            for (int i = 0; i < subordinateList.size(); i++) {
                helper(subordinateList.get(i), level + 1);
                if (i != subordinateList.size() - 1) {
                    chartBuffer.append(LINE_SEPARATOR);
                }
            }
        } else {
            return;
        }

    }

    /**
     * generate 2 * count space
     *
     * @param count
     * @return
     */
    private String generatePrefix(int count) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < count; i++) {
            buffer.append(DOUBLE_SPACE);
        }
        return buffer.toString();
    }


    /**
     * @param employeeId
     */
    public void remove(String employeeId)


    {
        //no such employee
        if (!idEmployeeMap.containsKey(employeeId)) {
            return;
        } else {
            //get its current manager
            String parentId = parentMap.get(employeeId);
            //release the old relationship
            parentMap.remove(employeeId);
            relationMap.get(parentId).remove(employeeId);
            //its reporters add to its old manager
            relationMap.get(parentId).addAll(relationMap.getOrDefault(employeeId, new LinkedList<>()));
            //remove the relationship between the employee and his reporters
            relationMap.remove(employeeId);
            //remove the employee
            idEmployeeMap.remove(employeeId);
        }
    }

    /**
     * @param employeeId
     * @param newManagerId
     */
    public void move(String employeeId, String newManagerId)


    {
        //the reporter doesn't exist
        if (!idEmployeeMap.containsKey(employeeId)) {
            return;
        }
        //the newManager doesn't exist
        if (!idEmployeeMap.containsKey(newManagerId)) {
            return;
        } else {
            //release the relationship between the employee and its current manager
            String parentId = parentMap.get(employeeId);
            relationMap.get(parentId).remove(employeeId);

            //create the relationship between the employee and the new manager
            List<String> subordinateList = relationMap.getOrDefault(newManagerId, new LinkedList<>());
            subordinateList.add(employeeId);
            relationMap.put(newManagerId, subordinateList);
            parentMap.put(employeeId, newManagerId);
        }
    }

    /**
     * @param employeeId
     * @return
     */
    public int count(String employeeId)


    {
        if (!idEmployeeMap.containsKey(employeeId)) {
            return 0;
        } else {
            //get his descendants reports
            Queue<String> queue = new LinkedList<>();
            queue.add(employeeId);
            int count = 0;
            while (!queue.isEmpty()) {
                String curEmployeeId = queue.poll();
                count++;
                for (String descendant : relationMap.getOrDefault(curEmployeeId, new LinkedList<>())) {
                    queue.add(descendant);
                }
            }
            //minus the employee itself
            return count - 1;
        }
    }
}

/**
 * class of employee
 */
class Employee {
    /**
     * id of employee
     */
    private String id;
    /**
     * name of employee
     */
    private String name;
    /**
     * id of manager
     */
    private String managerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public Employee() {

    }

    public Employee(String id, String name, String managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return this.name + " " + "[" + this.id + "]";
    }
}

