package Simple;

public class TestData {
    // Массивы тестовых данных с использованием строковых ключей
    private static final String[] phoneNumbers = {
            "truePhoneNumber", "falsePhoneNumber", "otherPhoneNumber"
    };
    private static final String[] smsCodes = {
            "trueSmsCode", "falseSmsCode", "otherSmsCode"
    };

    // Метод для возвращения тестового номера телефона
    public static String getPhoneNumber(String key) {
        switch (key) {
            case "truePhoneNumber":
                return "9128887921";
            case "falsePhoneNumber":
                return "9139998542";
            case "otherPhoneNumber":
                return "9147772365";
            default:
                return "";
        }
    }

    // Метод для возвращения тестового кода SMS
    public static String getSmsCode(String key) {
        switch (key) {
            case "trueSmsCode":
                return "111111";
            case "falseSmsCode":
                return "222222";
            case "otherSmsCode":
                return "333333";
            default:
                return "";
        }
    }
}
