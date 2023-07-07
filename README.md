# Add java liberary without build tools in Visual Studio Code
Hai kawand-kawand kali ini kita akan membahas cara menambahkan liberary ke java project tampa menggunakan build tools seperti maven atau gradle, Langsungsaja tampa basabai.

# Create Project
Sebelum nya pastikan kalian telah menginstall extension java pack.
![java pack](https://github.com/alliano/add_lib/blob/master/imgs/java_pack.jpg)
Langkah pertama buatlah java project pada visual studio code, tampa menggunakan build tools atau dependency dengan cara :
* CTRL + SHIFT + P
* Setelah itu pilih Create Java Project
![langkah1](https://github.com/alliano/add_lib/blob/master/imgs/langkah1.jpg)
* Pilih No Build Tools
![langkah2](https://github.com/alliano/add_lib/blob/master/imgs/langkah2.jpg)
* Pilih tempat untuk mengenerate project java
* Berinama project java nya
![langkah3](https://github.com/alliano/add_lib/blob/master/imgs/langkah3.jpg)

# Download Jar File
Untuk menambahkan liberary, tentunya kita harus memiliki liberary yang kita kan gunkan, liberary tersebut biasanya berupa jar file(Java Archive File), Kalian bisa mencari dan mendownload liberary yang kalian ingin gunakan pada laman berikut ini :
* https://jar-download.com/

# Add java liberary to Java project
Untuk menambahkan Liberary pada java project, pindahkan jar file(liberary yang inign digunakan) pada folder lib pada project java teman-teman.  
![pindahkan_ke_lib](https://github.com/alliano/add_lib/blob/master/imgs/pindahkan_ke_lib.jpg)  
Setelah itu klik Java Project pada Sidebar Visual Studio Code.  
![java_project](https://github.com/alliano/add_lib/blob/master/imgs/klik_java_project.jpg)
Klik kanan JRE System Liberary.  
![JRE_System_lib](https://github.com/alliano/add_lib/blob/master/imgs/JRE_system_liberary.jpg)
Pilih Reveal in Exploler.  
Setelah itu arahkan pada folder lib yang ada pada project, dan klik Jar file yang akan digunakan.  
Dalam kasus ini saya ingin menggunakan liberary mysql connector.  
![mysql_connector](https://github.com/alliano/add_lib/blob/master/imgs/mysql_connector.jpg)  
Setelah itu jikalau kita ingin melihat apakah Liberary tersebut telah ditambahkan pada project ktia, kita dapat melihatnya dengan cara klik Referenced Liberaries.  
![references_lib](https://github.com/alliano/add_lib/blob/master/imgs/Reference_lib.jpg)

# Example Usage Lib
Setelah kita berhasil menambahkan liberary tersebut, saya akan mendemokan bagaimana cara mengkoneksikan java app dengan mysql menggunakan Liberary yang kita tambahkan pada java project.  
berikut ini adalah kode koneksi java ke mysql menggunakan Liberary yang ditambahkan  
``` java
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class Datasource {
    
    public static String JSBCURL = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Jakarta";
    public static String PASSWORD = "allia_azahra";
    public static String USERNAME = "root";

    public static Connection getConnection() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(JSBCURL, USERNAME, PASSWORD);
            System.out.println("success connect!");
            return connection;
        } catch (SQLException SQLEX) {
          System.out.println(SQLEX.getMessage());
          return null;
        }
    }
}
```
kelas Main
``` java
import java.sql.Connection;

import connection.Datasource;

public class App {
    public static void main(String[] args) throws Exception {
        Connection connection = Datasource.getConnection();

        connection.close();
    }
}
```
Jika kita berhasil mengkoneksikan maka akan menampilkan success connect pada terminal.  
![success_connect](https://github.com/alliano/add_lib/blob/master/imgs/success_connect.jpg)