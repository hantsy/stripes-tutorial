/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;
import tutorial.dao.Users;
import tutorial.model.User;

/**
 *
 * @author hantsy
 */
public class ListUserActionBean extends BaseActionBean {

    private ResultList users;
    private String sort = "id";
    private String dir = "asc";
    private int page = 1;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public ResultList getUsers() {
        return users;
    }

    public void setUsers(ResultList users) {
        this.users = users;
    }

    @DefaultHandler
    public Resolution listUsers() {
        users = new ResultList();
        return new ForwardResolution("/userList.jsp");
    }

    class FirstnameComparator implements Comparator<User> {

        public int compare(User o1, User o2) {
            return o1.getFirstname().compareTo(o2.getFirstname());
        }
    }

    class LastnameComparator implements Comparator<User> {

        public int compare(User o1, User o2) {
            return o1.getLastname().compareTo(o2.getLastname());
        }
    }

    class ResultList implements PaginatedList {

        public List getList() {
            List<User> list = Users.subList((getPageNumber() - 1) * getObjectsPerPage(), getObjectsPerPage());

            if (getSortCriterion().equals("firstname")) {
                Collections.sort(list, new FirstnameComparator());
            } else if (getSortCriterion().equals("lastname")) {
                Collections.sort(list, new LastnameComparator());
            }
            if (getSortDirection() == SortOrderEnum.DESCENDING) {
                Collections.reverse(list);
            }

            return list;
        }

        public int getPageNumber() {
            return page;
        }

        public int getObjectsPerPage() {
            return 5;
        }

        public int getFullListSize() {
            return Users.getUserList().size();
        }

        public String getSortCriterion() {
            return sort;
        }

        public SortOrderEnum getSortDirection() {
            if (dir.equals("desc")) {
                return SortOrderEnum.DESCENDING;
            }
            return SortOrderEnum.ASCENDING;
        }

        public String getSearchId() {
            return null;
        }
    }
}
