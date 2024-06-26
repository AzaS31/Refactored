public interface UserModifier<T extends User> {
    void changeName(int userId, String newName);
}
