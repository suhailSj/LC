package sol1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;

import static java.util.stream.Collectors.*;

public class Test {
    static class Employee{

        public int managerId;
        public  int employeeId;
        public  String name;
        public int salary;

        public Employee(int mID, int eid, String naame, int salary) {
            this.managerId = mID;
            this.employeeId = eid;
            this.name  = naame;
            this.salary = salary;
        }

        public int getManagerId(){
            return this.managerId;
        }
        public int getEmployeeId(){
            return this.employeeId;
        }
        public int getSalary(){
            return this.salary;
        }
        public String getName(){
            return this.name;
        }

    }
    public static void main(String... a) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, 101, "aa", 1000));
        list.add(new Employee(1, 102, "bb", 1111));
        list.add(new Employee(1, 103, "cc", 2222));
        list.add(new Employee(1, 104, "dd", 3333));
        list.add(new Employee(2, 101, "ee", 4444));

        //System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getManagerId, Collectors.mapping(Employee::getEmployeeId, Collectors.toList()) )));
//        System.out.println("normal"+list.stream()
//                .collect(groupingBy(Employee::getManagerId, Collectors.summingInt( ))));

    }



    public <T> T getNthElement (List<T> list, int position ) {
        return list.get(position);
    }


    }
