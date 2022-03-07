package by.itstep.parser;

import com.opencsv.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

/**
 * Class CsvParser для Записи данных из базы данных в файл
 * @author Andrey Yarosh "andreyarosh7@gmail.com"
 * @version 1.0
 */

@PropertySource("classpath:parser.properties")
@Component
public class CsvParser {

    Logger logger = LoggerFactory.getLogger(CsvParser.class);

    @Value("${parser.sql}")
   private String sql;
    @Value("${parser.url}")
   private String url;
    @Value("${parser.user}")
   private String user;
    @Value("${parser.password}")
   private String password;
    @Value("${parser.filePath}")
    String filePath;


    public void fromDataBaseToFile(MultipartFile file, String tableName) {

            Path myPath = Paths.get(filePath + file.getOriginalFilename());
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql + " " + tableName);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                try (CSVWriter writer = new CSVWriter(Files.newBufferedWriter(myPath,
                        StandardCharsets.UTF_8), CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END)) {
                    writer.writeAll(resultSet, true);
                }
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
                logger.error(ex.getMessage());
            }
    }
}
