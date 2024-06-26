import java.util.List;

public interface UserSorter<T extends User> {
    List<T> getSortedUserGroup();
    List<T> getSortedUserGroupByFIO();
}
