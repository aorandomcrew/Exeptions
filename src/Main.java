public class Main {
    public static void main(String[] args) {
        try {
            loginMenu("asjdiadhaysugdau", "asdghasgdkjashd", "asdghasgdkjashd");
        } catch (WrongLoginException | WrongPasswordException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            System.out.println("работа метода законеча");
        }
    }

    private static final String REGEX = "^[a-zA-Z0-9]*$";

    public static void loginMenu(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("неправильный реестр символов");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("в лоигне должно быть меньше 20 символов");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException("Неправильный реестр символов");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("в пароле должно быть меньше 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("пароли не совпадают");
        }
    }
}