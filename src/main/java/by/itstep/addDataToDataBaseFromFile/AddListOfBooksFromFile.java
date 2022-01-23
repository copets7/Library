package by.itstep.addDataToDataBaseFromFile;

import by.itstep.config.DataBaseConfig;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Configuration
@PropertySource("classpath:database.properties")
@PropertySource("classpath:booksFromFile.properties")
@Component
public class AddListOfBooksFromFile {

    @Value("${database.url}")
    private String jdbcUrl;
    @Value("${database.username}")
    private String userName;
    @Value("${database.password}")
    private String password;
    @Value("${insert.sql}")
    private String sql;
    @Value("${filePath}")
    private String filePath;

    Logger logger = LoggerFactory.getLogger(AddListOfBooksFromFile.class);

    @Bean
    public void BooksFromFile() {

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String text = null;
            reader.readLine();

            while ((text = reader.readLine()) != null) {

                String[] data = text.split(",");

                String bookName = data[0];
                String author = data[1];
                String ISBN = data[2];
                String genreId = data[3];

                statement.setString(1, bookName);
                statement.setString(2, author);
                statement.setString(3, ISBN);
                statement.setInt(4, Integer.parseInt(genreId));
                statement.addBatch();
            }
            reader.close();
            statement.executeBatch();
            connection.commit();
            connection.close();
            logger.info("Data has been inserted successfully ");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(String.valueOf(e));
        }
    }


//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AddListOfBooksFromFile.class);
//        context.getAutowireCapableBeanFactory();
//    }


}
