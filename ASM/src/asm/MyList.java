
package asm;

import java.util.Scanner;

public class MyList {
    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    // Kiểm tra xem danh sách có trống không?
    public boolean isEmpty() {
        return head == null; 
    }
    
    //Thêm id, name,mark từ bàn phím
    public void addStudentFromKeyBoard()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID student: ");
        int id = sc.nextInt();
        sc.nextLine(); // Bỏ khoảng trống
        System.out.println("Enter the name student: ");
        String name = sc.nextLine();
        System.out.println("Enter the mark student: ");
        double mark = sc.nextDouble();
        
        add(new Student(id, name, mark));
    }
    // Thêm student mới vào list
    public void add(Student s) {
        Node newNode = new Node(s);
        if (isEmpty() == true) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }  
    // Chỉnh sửa học sinh
    
    public void editStudent(int id, String newName, double newMark)
    {
        Node p = head;
        while (p != null)
        {
            if (p.student.getId() == id)
            {
                p.student = new Student(id, newName, newMark);
                System.out.println("The student with ID " + id + "has been update");
                break;
            }
            p = p.next;
        }
    }
    public void deleStudent(int id)
    {
        // Nếu xóa id đầu 
        if (head != null)
        {
            System.out.println("No student delete");
        }
        if (head.student.getId() == id)
        {
            head = head.next;  
            System.out.println("The student with ID " + id + " has been delete");
        }
        // Khởi tạo với node đầu
        Node p = head;
        while(p.next != null)
        {
            if (p.next.student.getId() == id)
            {
                p.next = p.next.next;
                System.out.println("The student with ID " + id + " has been delete");
                break;
            }
        }
    }
    
    //Sort Bubble
    public void bubbleSort(boolean ascending)
    {
        // Kiểm tra danh sách rỗng hoặc chỉ có một phần tử thì không cần sắp xếp
        if (head == null || head.next == null)
        {
            return;
        }
        
        // Lặp đến khi không còn sự hoán đổi nào xảy ra
        for (boolean swapped = true; swapped;)
        {
            swapped = false; // Mặc định sẽ không có sự hoán đổi nào cả
            Node p = head; // Bắt đầu từ danh sách
            
            while (p.next != null) // Duyệt qua các danh sách liên kết
            {
                boolean condition;
                if (ascending)
                {
                    // Nếuu sắp xếp tăng dần, kiểm tra nếu điểm hiện tại lớn hơn điểm kế tiếp
                    condition = p.student.getMark() > p.next.student.getMark();
                }else
                {
                    // Nếu sắp xếp giảm dần, kiểm tra nếu điểm hiện tại nhỏ hơn điểm kế tiếp
                    condition = p.student.getMark() < p.next.student.getMark();
                }
                if (condition)
                {
                    // Hoán đổi dữ liệu giữa 2 nút
                    Student temp = p.student;
                    p.student = p.next.student;
                    p.next.student = temp;
                    swapped = true; // đánh dấu rằng có sự hoán đổi xảy ra
                }
                p = p.next;
            }
        }
    }
    //Sort Quick
    // Phương thức Quick Sort
    public void quickSort(boolean ascending) {
        head = quickSortRec(head, ascending);
        // Cập nhật lại tail sau khi sắp xếp
        Node p = head;
        while (p != null && p.next != null) {
            p = p.next;
        }
        tail = p;
    }

    // Phương thức đệ quy để thực hiện Quick Sort
    private Node quickSortRec(Node start, boolean ascending) {
        if (start == null || start.next == null) {
            return start;
        }

        // Chọn pivot là phần tử đầu tiên
        Node pivot = start;
        Node less = null, greater = null;
        Node current = start.next;

        // Tách danh sách thành hai phần: nhỏ hơn pivot và lớn hơn pivot
        while (current != null) {
            Node next = current.next;
            if ((ascending && current.student.getMark() < pivot.student.getMark()) || (!ascending && current.student.getMark() > pivot.student.getMark())) {
                // Thêm vào danh sách "nhỏ hơn"
                current.next = less;
                less = current;
            } else {
                // Thêm vào danh sách "lớn hơn"
                current.next = greater;
                greater = current;
            }
            current = next;
        }

        // Đệ quy sắp xếp danh sách nhỏ hơn và lớn hơn
        less = quickSortRec(less, ascending);
        greater = quickSortRec(greater, ascending);

        // Nối danh sách "nhỏ hơn" -> pivot -> danh sách "lớn hơn"
        if (less == null) {
            pivot.next = greater;
            return pivot;
        } else {
            Node temp = less;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = pivot;
            pivot.next = greater;
            return less;
        }
    }
    //--Tìm Search--
    // Phương thức searchStudent sử dụng LinearSearch
    public int linearSearch(int id) {
        Node p = head;
        int index = 0;
        while (p != null) {
            if (p.student.getId() == id) {
                return index; // Trả về vị trí nếu tìm thấy
            }
            p = p.next;
            index++;
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }
    
    // Phương thức Search sử dụng BinarySearch
    public int binarySearch(int id) {
    // Sắp xếp danh sách trước khi thực hiện tìm kiếm nhị phân
    bubbleSort(true); 
    
    Node p = head;
    int low = 0, high = 0;

    // Tính tổng số phần tử trong danh sách liên kết để xác định 'high'
    while (p != null) {
        high++; 
        p = p.next;
    }
    high--; // Điều chỉnh lại 'high' vì biến đếm bắt đầu từ 1

    // Tiến hành tìm kiếm nhị phân
    while (low <= high) {
        int mid = (low + high) / 2; // Tìm vị trí giữa
        
        // Di chuyển con trỏ 'p' đến vị trí 'mid'
        p = head;
        for (int i = 0; i < mid; i++) {
            p = p.next;
        }

        // So sánh giá trị tại vị trí 'mid' với id cần tìm
        if (p.student.getId() == id) {
            return mid; // Trả về vị trí nếu tìm thấy
        } else if (p.student.getId() < id) {
            low = mid + 1; // Tìm kiếm ở nửa phải
        } else {
            high = mid - 1; // Tìm kiếm ở nửa trái
        }
    }
    return -1; // Trả về -1 nếu không tìm thấy
}
    
    // Duyệt danh sách liên kết và in ra học sinh
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.student.toString());
            p = p.next;
        }
    }
    // Push cho Stack
    public void pushStack(MyStack stack) {
        Node p = head;
        while (p != null) {
            stack.push(p.student);
            p = p.next;
        }
    }
}
