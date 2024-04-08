package enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Department {
  
  private static HashMap<String, ArrayList<String>> departmentMap;

  {
    departmentMap = new HashMap<>();

    // cong nghe thong tin
    ArrayList<String> cnttList = new ArrayList<>(Arrays.asList("Kĩ thuật phần mềm", "Công nghệ thông tin", "Khoa học dữ liệu"));
    departmentMap.put("Công nghệ thông tin", cnttList);

    // quan tri kinh doanh
    ArrayList<String> qtkdList = new ArrayList<>(Arrays.asList("Quản trị doanh nghiệp", "Quản trị tài chính", "Quản trị nhân sự", "Logictis"));
    departmentMap.put("Quản trị kinh doanh", qtkdList);

    // suw pham
    ArrayList<String> spList = new ArrayList<>(Arrays.asList("Sư phạm mầm non", "Sư phạm Toán", "Sư phạm Hóa", "Sư phạm Vật lý", "Sư phạm Khoa học tự nhiên"));
    departmentMap.put("Sư phạm", spList);

    //dien tu
    ArrayList<String> dtList = new ArrayList<>(Arrays.asList("Kĩ thuật điện", "Điện tử viễn thông", "IOT", "Robot", "Tương tác người-máy"));
    departmentMap.put("Điện tử", dtList);
  }

  public static HashMap<String, ArrayList<String>> getDepartment() {
    return departmentMap;
  }
}

