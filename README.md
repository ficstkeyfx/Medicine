
# Ứng dụng quản lý thuốc

Là ứng dụng sử dụng để thêm, sửa, xóa và thống kê thuốc trong nhà thuốc.


## 🧐 Tính năng
- Tra cứu và tìm kiếm thuốc trong nhà thuốc
- Thêm thuốc
- Sửa thông tin thuốc
- Xóa thuốc khỏi nhà thuốc
- Thống kê số lượng thuốc theo tháng

## 🛠️ Cài đặt

#### Cài đặt môi trường

* Cài đặt [jdk 17](https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe)

* Cài đặt [Apache Netbeans 16](https://netbeans.apache.org/download/nb16/)


 #### Tải mã nguồn project

* Link mã nguồn [Medicine](https://github.com/ficstkeyfx/Medicine)

* Clone project

```bash
  git clone https://github.com/ficstkeyfx/Medicine.git
```

#### Cài đặt project

Chạy với mã nguồn

* Mở project trong Apache Netbeans 16

* Chạy ứng dụng bằng cách chạy file Main.java

Chạy với file jar

```bash
  java -jar MedicineManage-jar-with-dependencies.jar
```

## 💻 Demo

#### Màn hình đăng nhập

![Login](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/LoginFrame.png?raw=true)

- Tài khoản đăng nhập mặc định cho ứng dụng là  và mật khẩu là 1
- Nếu nhập sai tài khoản mật khẩu, ứng dụng sẽ đưa ra thông báo tài khoản mật khẩu bị sai

![LoginFalse](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/LoginFalse.png?raw=true)

- Sau khi đăng nhập thành công, ứng dụng sẽ chuyển sang màn hình trang chủ DashBoard

#### Màn hình trang chủ

![Dash](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/DashFrame.png?raw=true)

- Nếu muốn đăng nhập lại có thể nhấn Logout ở góc trên bên phải màn hình để quay lại màn hình đăng nhập

- Trong màn hình của trang chủ bao gồm DashBoard, Home, Manage và Statistic

- Màn hình DashBoard bao gồm các chức năng hiện có của ứng dụng, ta có thể chuyển qua các màn hình khác trong trang chủ bằng cách nhấn vào Home, Manage và Statistic

- Màn hình Home gồm chức năng tìm kiếm, sắp xếp và hiển thị các thuốc hiện đang có trong nhà thuốc

![Home](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/HomePanel.png?raw=true)

- Ví dụ khi tìm thuốc có tên là "thuốc 2", ở đây có thể tìm kiếm theo các tiêu chí khác nhau như id, tên, nsx, hsd, nguồn nhập:

![SearchHome](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/HomeSearch.png?raw=true)

- Ví dụ khi sắp xếp các thuốc theo id, ở đây có thể sắp xếp theo các tiêu chí khác nhau như id, tên, nsx, hsd, nguồn nhập:

![SortHome](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/HomeSort.png?raw=true)

- Màn hình Manage gồm các chức năng tìm kiếm, thêm, xóa, sửa các thông tin của các thuốc ở trong nhà thuốc

![Manage](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/ManageFrame.png?raw=true)

- Ví dụ khi thêm một sản phẩm vào nhà thuốc

![Add](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/ManageAdd.png?raw=true)

- Ví dụ khi thay đổi một sản phẩm trong nhà thuốc

![Edit](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/HomeEdit.png?raw=true)

- Ví dụ khi xóa một sản phẩm trong nhà thuốc

![Delete](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/ManageDelete.png?raw=true)

- Màn hình Statistic là màn hình thuốc kê số lượng thuốc đang có trong nhà thuốc qua các tháng

![Stat](https://github.com/ficstkeyfx/Medicine/blob/main/readmeImage/Demo/Stat.png?raw=true)







## Các công nghệ được sử dụng

- miglayout 
- org-jdesktop-animation-timing
- jfreechart
- jaxb-impl
- commons-validator
## 🚀 Tác giả

- Github: [Phan Hải Đăng](https://github.com/ficstkeyfx)
- Facebook: [Phan Hải Đăng](https://www.facebook.com/profile.php?id=100026199068238)
- Twitter: [Hải Đăng Phan](https://twitter.com/im__dang)
