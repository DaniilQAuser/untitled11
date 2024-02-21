package Simple;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SaveResponseToJsonFile {

    public static void main(String[] args) {
        try {
            // Создание команды для выполнения cURL запроса
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "curl",
                    "--location",
                    "https://test-basket.fullstack.vkusvill.ru/api/v1/cart?new=1",
                    "--header", "user-agent: vkusvill/3.0.22 (Android; 30)",
                    "--header", "authorization: Basic dmt1c3ZpbGw6NjckI2hqZGZAQA==",
                    "--header", "x-vkusvill-device: xiaomi",
                    "--header", "x-vkusvill-source: 4",
                    "--header", "x-vkusvill-version: 3.0.22 (300022)",
                    "--header", "x-vkusvill-token: eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJjYXJkIjoiRzkxNjE0NyIsInZlcnNpb24iOjJ9.gfZCLsOyXFiMcbpQvLJ6O1uOeIm08sPwyOJZHl7vLYDGptdkB_8-02EwUS-yVHkGNp8Mnb3oi4lHbnRbYKtfRVUD23HrH82j82mPU4Ok_I1hlozm6aucZKJbIzIwqAlyEXTBz9FBVGmXJuJhqvzzgtbzp1lj0IfQtNqU6vu1XK4",
                    "--header", "x-vkusvill-model: Xiaomi Redmi Note 8 Pro",
                    "--header", "x-vkusvill-number: G916147"
            );

            // Установка перенаправления стандартного вывода и стандартной ошибки в потоки Java
            processBuilder.redirectErrorStream(true);

            // Запуск команды
            Process process = processBuilder.start();

            // Получение вывода команды
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Ожидание завершения выполнения команды
            int exitCode = process.waitFor();
            System.out.println("Выполнение cURL запроса завершено. Код завершения: " + exitCode);

            // Преобразование тела ответа в объект JSON
            String responseBody = response.toString();
            JSONObject jsonResponse = new JSONObject(responseBody);

            // Вывод тела ответа в консоль
            JSONObject data = jsonResponse.getJSONObject("data");
            System.out.println(data.toString(4)); // Форматированный вывод с отступами

        } catch (IOException | InterruptedException | JSONException e) {
            e.printStackTrace();
        }
    }
}